package com.spootify.backend_spootify.Service.Impl;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.usuarioEstandarDto;
import com.spootify.backend_spootify.OracleData.oraData;
import com.spootify.backend_spootify.Repositories.Genero_Repository;
import com.spootify.backend_spootify.Repositories.Paises_Repository;
import com.spootify.backend_spootify.Repositories.Tipo_usuario_Repository;
import com.spootify.backend_spootify.Repositories.Usuario_estandar_Repository;
import com.spootify.backend_spootify.Service.Usuario_estandar_Service;

@Service
public class Usuario_Estandar_Service_Impl implements Usuario_estandar_Service{

    @Autowired
    Usuario_estandar_Repository uer;

    @Autowired
    Genero_Repository gr;

    @Autowired
    Tipo_usuario_Repository tur;

    @Autowired
    Paises_Repository pr;

    @Override
    public boolean crearUsuario(usuarioEstandarDto usuarioE) {
        try {
            
            int idUsuario = this.uer.contarUsuarios() + 1;
                    
            return crearUsuarioEstandar(idUsuario, usuarioE, this.uer.contarHisotrialRep() + 1, this.uer.contarPagoPlanes() + 1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } 
    }

    @Override
    public void eliminarUsuario(int id) {
        try {
            this.uer.eliminarUsuario(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public usuarioEstandarDto validarUsuario(String correo, String cotrasenia) {
        
        try {

            if(correo.matches("[(A-z)|(0-9)|(&|*|\\-)]*@{1}([A-z]+)\\.((com)|(edu))\\.?(hn)?")){
                String[] infoUsuario = this.uer.validarUsuario(correo, cotrasenia).split(",");
                usuarioEstandarDto usuarioEstandarDto = new usuarioEstandarDto();

                /** 
                usuarioEstandarDto.setNombre(infoUsuario[0]);
                usuarioEstandarDto.setFoto(infoUsuario[1]);
                usuarioEstandarDto.setPlanTipo(infoUsuario[2]);
                usuarioEstandarDto.setCorreo(correo);
                usuarioEstandarDto.setGeneroTipo(infoUsuario[4]);
                usuarioEstandarDto.setTipoUsuario(infoUsuario[5]);
                usuarioEstandarDto.setId(Integer.parseInt(infoUsuario[7]));
                */
                return usuarioEstandarDto;

            }            
            
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public int cantidadListas(int id) {
        try {
            
            return this.uer.contarListas(id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public List<String> obtenerNombreListas(int id) {
        try {
            return this.uer.nombreListas(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    @Override
    public void crearListaReproduccion(String nombre, int idUsuario) {
        try {

                java.sql.Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
                conn.setAutoCommit(false); 

                PreparedStatement ps = conn.prepareStatement("insert into tbl_listas_reproduccion values(?,?,?,?)");
                ps.setInt(1, this.uer.contarListas(idUsuario) + 1);
                ps.setInt(2, idUsuario);
                ps.setString(3, nombre);
                ps.setInt(4, 0);
                ps.executeUpdate();

                conn.commit();
                conn.close();
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean crearUsuarioEstandar(int idUsuario, usuarioEstandarDto usuarioE, int idHistorialRe, int idPagoPlan){
        try {
            java.sql.Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            conn.setAutoCommit(false); 
        
            PreparedStatement psUsuarios = conn.prepareStatement("INSERT INTO tbl_usuarios VALUES (?, ?, 2, ?, ?, ?, ?, ?, ?, ?)");
            psUsuarios.setInt(1, idUsuario);
            psUsuarios.setString(2, usuarioE.getIdGenero());
            psUsuarios.setString(3, usuarioE.getCorreo());
            psUsuarios.setString(4, usuarioE.getNombre());
            psUsuarios.setDate(5, usuarioE.getFecha_nacimiento());
            psUsuarios.setDate(6, Date.valueOf(LocalDate.now()));
            psUsuarios.setString(7, usuarioE.getFoto());
            psUsuarios.setString(8, usuarioE.getContrasenia());
            psUsuarios.setString(9, usuarioE.getIdPais());
            psUsuarios.executeUpdate();
            psUsuarios.close();

            PreparedStatement psHistorial = conn.prepareStatement("INSERT INTO tbl_historial_de_reproduccion VALUES (?)");
            psHistorial.setInt(1, idHistorialRe);
            psHistorial.executeUpdate();
            psHistorial.close();

            List<Integer> artistasSeguidos = usuarioE.getIdArtistaSeguidos();

            for (Integer idArtista : artistasSeguidos) {
                PreparedStatement psArtistas = conn.prepareStatement("INSERT INTO tbl_seguidores VALUES (?,?,sysdate)");
                psArtistas.setInt(1, idUsuario);
                psArtistas.setInt(2, idArtista);
                psArtistas.executeUpdate();
                psArtistas.close();
            }

            PreparedStatement psUsuarioEstandar = conn.prepareStatement("INSERT INTO tbl_usuario_estandar VALUES (?, ?)");
            psUsuarioEstandar.setInt(1, idUsuario);
            psUsuarioEstandar.setInt(2, idHistorialRe);
            psUsuarioEstandar.executeUpdate();
            psUsuarioEstandar.close();
        
           if(!usuarioE.getIdPlan().equals("4")){
                PreparedStatement psTarjeta = conn.prepareStatement("insert into tbl_tarjetas values (?, ?, ?, ?, ?)");
                psTarjeta.setInt(1, this.uer.contarTarjetas() +1);
                psTarjeta.setString(2, usuarioE.getTarjeta().getNumerTarjeta());
                psTarjeta.setDate(3, usuarioE.getTarjeta().getFehcaExpiracion());
                psTarjeta.setInt(4, usuarioE.getTarjeta().getCvv());
                psTarjeta.setString(5, usuarioE.getTarjeta().getTitular());
                psTarjeta.executeUpdate();
                psTarjeta.close();

                PreparedStatement psPagoPlanes = conn.prepareStatement("INSERT INTO tbl_pago_planes(id_plan_pago, id_plan, id_usuario, id_tarjeta, fecha_inicio_plan, fecha_fin_plan) VALUES (?, ?, ?, ?, ?, ?)");
                psPagoPlanes.setInt(1, idPagoPlan);
                psPagoPlanes.setString(2, usuarioE.getIdPlan());
                psPagoPlanes.setInt(3, idUsuario);
                psPagoPlanes.setInt(4, this.uer.contarTarjetas() + 1);
                psPagoPlanes.setDate(5, Date.valueOf(LocalDate.now()));
                psPagoPlanes.setDate(6, Date.valueOf(LocalDate.now().plusMonths(1)));
                psPagoPlanes.executeUpdate();
                psPagoPlanes.close();
           }else{
                PreparedStatement psPagoPlanes = conn.prepareStatement("INSERT INTO tbl_pago_planes(id_plan_pago, id_plan, id_usuario, fecha_inicio_plan, fecha_fin_plan) VALUES (?, ?, ?, ?, ?)");
                psPagoPlanes.setInt(1, idPagoPlan);
                psPagoPlanes.setString(2, usuarioE.getIdPlan());
                psPagoPlanes.setInt(3, idUsuario);
                psPagoPlanes.setDate(4, Date.valueOf(LocalDate.now()));
                psPagoPlanes.setDate(5, Date.valueOf(LocalDate.now().plusMonths(1)));
                psPagoPlanes.executeUpdate();
                psPagoPlanes.close();
           }


            conn.commit(); 
            conn.close();

            return true;
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta SQL: " + e.getMessage());
            return false;
        }
        
    }
}
