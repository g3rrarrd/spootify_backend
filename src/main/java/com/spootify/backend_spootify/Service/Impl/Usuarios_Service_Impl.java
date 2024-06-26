package com.spootify.backend_spootify.Service.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.listaReproduccionDto;
import com.spootify.backend_spootify.Dtos.perfilDto;
import com.spootify.backend_spootify.Dtos.usuarioSeguiDto;
import com.spootify.backend_spootify.Models.Listas_reproduccion;
import com.spootify.backend_spootify.Models.Usuarios;
import com.spootify.backend_spootify.OracleData.oraData;
import com.spootify.backend_spootify.Repositories.Usuario_Repository;
import com.spootify.backend_spootify.Service.Usuarios_Service;

@Service
public class Usuarios_Service_Impl implements Usuarios_Service{

    @Autowired
    Usuario_Repository ur;

    @Override
    public String validarUsuario(String correo, String cotrasenia) {
        Integer success = 0;
        String message = "El usuario no existe";
        try {

            String user = ur.obtenerPorCorreo(correo);

        if (user!=null) { //Si usuario existe

            String[] usuario = user.split(",");

            if (usuario[2].equals(cotrasenia)) {
                success = Integer.parseInt(usuario[0]);
                message = "Usuario validado";
                return String.format("{\"success\":%s,\"message\":\"%s\"}",success,message);
            }else{
                message = "La contraseña no coincide con el correo";
                return String.format("{\"success\":%s,\"message\":\"%s\"}",success.toString(),message);
            }
        }  
        return String.format("{\"success\":%s,\"message\":\"%s\"}",success,message);
        } catch (Exception e) {
            e.printStackTrace();
            return String.format(success.toString(),"{\"success\":%s,\"message\":\"Algo ha fallado, intentalo de nuevo\"}");
        }
    }


    @Override
    public void seguirUsuario(int idSeguidor, int idSeguido) {
        
        try {
            
           if(this.ur.seSiguen(idSeguido, idSeguidor) == 0){
                Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
                PreparedStatement ps = conn.prepareStatement("insert into tbl_seguidores values(?, ?, ?)");
                conn.setAutoCommit(false);

                ps.setInt(1, idSeguidor);
                ps.setInt(2, idSeguido);
                ps.setDate(3, Date.valueOf(LocalDate.now()));
                ps.executeUpdate();

                conn.commit();
                conn.close();
           }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void dejarSeguir(int idSeguidor, int idSeguido) {
       
        try {

            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            PreparedStatement ps = conn.prepareStatement("delete from tbl_seguidores where id_usuario_seguido = ? and id_usuario_seguidor = ?");
            conn.setAutoCommit(false);

            ps.setInt(1, idSeguido);
            ps.setInt(2, idSeguidor);
            ps.executeUpdate();

            conn.commit();
            conn.close();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public int numeroSeguidos(int idUsuario) {
        try {
            return this.ur.numeroSeguidos(idUsuario);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public int numeroSeguidores(int idUsuario) {
        try {
            
            return this.ur.numeroSeguidores(idUsuario);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public List<usuarioSeguiDto> traerSeguidores(int idUsuario) {
        try {

            List<String> seguidores = this.ur.nombreSeguidores(idUsuario);   

            List<usuarioSeguiDto> listUsuarios = new LinkedList<>();

            
            for (String usuario : seguidores) {
                usuarioSeguiDto usuarioDto = new usuarioSeguiDto();  
                String[] parteUsuario = usuario.split(",");

                usuarioDto.setNombre(parteUsuario[0]);
                usuarioDto.setFoto(parteUsuario[1]);

                listUsuarios.add(usuarioDto);
            }

            return listUsuarios;

        } catch (Exception e) {
            System.err.println(e.getMessage());

            return null;
        }
    }

    @Override
    public List<usuarioSeguiDto> traerSeguidos(int idUsuario) {
        
        try {
            
            List<String> seguidos = this.ur.nombreSeguidos(idUsuario);   

            List<usuarioSeguiDto> listUsuarios = new LinkedList<>();

            
            for (String usuario : seguidos) {
                usuarioSeguiDto usuarioDto = new usuarioSeguiDto();  
                String[] parteUsuario = usuario.split(",");

                usuarioDto.setNombre(parteUsuario[0]);
                usuarioDto.setFoto(parteUsuario[1]);

                listUsuarios.add(usuarioDto);
            }

            return listUsuarios;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }

    }


    @Override
    public perfilDto traerPerfil(int idUsuario) {
        try {
            perfilDto perfil = new perfilDto();

            perfil.setNombre(this.ur.obtenerNombre(idUsuario));
            perfil.setUrl_foto_perfil(this.ur.urlFotoPerfil(idUsuario));
            perfil.setCantidadSeguidores(this.ur.numeroSeguidores(idUsuario));
            perfil.setCantidadSeguidos(this.ur.numeroSeguidos(idUsuario));
            perfil.setPlaylistCreadas(this.traerListas(idUsuario));
            perfil.setIdTipoPlan(this.ur.obtenerPlanUsuario(idUsuario));
            
            return perfil;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private List<listaReproduccionDto> traerListas(int idUsuario){
        try {

            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            PreparedStatement psListaRe = conn.prepareStatement("select id_lista_reproduccion, nombre_lista_reproduccion, url_portada_lista, b.nombre_tipo_lista, descripcion from tbl_listas_reproduccion a inner join tbl_tipos_listas b on a.id_tipo_lista = b.id_tipo_lista where id_usuario_propietario = ?");
            psListaRe.setInt(1, idUsuario);
            ResultSet rsListaRep = psListaRe.executeQuery();

            
            List<listaReproduccionDto> listaReproduccionDtos = new LinkedList<>();

            while(rsListaRep.next()){
                listaReproduccionDto listasReproduccion = new listaReproduccionDto();
                listasReproduccion.setIdLista(rsListaRep.getInt(1));
                listasReproduccion.setNombreLista(rsListaRep.getString(2));
                listasReproduccion.setPortadaLista(rsListaRep.getString(3));
                listasReproduccion.setTipoLista(rsListaRep.getString(4));
                listasReproduccion.setDescripcionLista(rsListaRep.getString(5));
                
                listaReproduccionDtos.add(listasReproduccion);
            }

            return listaReproduccionDtos;
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    
}
