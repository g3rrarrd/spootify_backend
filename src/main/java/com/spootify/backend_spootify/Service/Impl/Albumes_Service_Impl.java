package com.spootify.backend_spootify.Service.Impl;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.CancionDtoMin;
import com.spootify.backend_spootify.Dtos.albumesDto;
import com.spootify.backend_spootify.Models.Albumes;
import com.spootify.backend_spootify.OracleData.oraData;
import com.spootify.backend_spootify.Repositories.Albumes_Repository;
import com.spootify.backend_spootify.Repositories.Canciones_Repository;
import com.spootify.backend_spootify.Repositories.Usuario_estandar_Repository;
import com.spootify.backend_spootify.Service.Albumes_Service;

@Service
public class Albumes_Service_Impl implements Albumes_Service{

    @Autowired
    Albumes_Repository albumes_Repository;

    @Autowired
    Usuario_estandar_Repository usuario_Repository;

    @Autowired
    Canciones_Repository canciones_Repository;

    @Override
    public albumesDto traerInfoAlbum(int idAlbum, int idUsuario) {
        try {
            if (this.albumes_Repository.findById(idAlbum).isPresent()) {

                albumesDto album = new albumesDto();
                

                album.setNombreAlbum(albumes_Repository.obtenerNombre(idAlbum));
                album.setPortadaAlbum(albumes_Repository.obtenerPortada(idAlbum));
                album.setColor(albumes_Repository.obtenerColor(idAlbum));
                album.setNombreArtista(albumes_Repository.obtenerNombreArtista(idAlbum));
                album.setFotoArtista(albumes_Repository.urlFotoPerfil(idAlbum));
                album.setTipoLanzamiento(albumes_Repository.obtenerTipoLanzamiento(idAlbum));
                album.setFechaLanzamiento(albumes_Repository.obtenerFechaLanzamiento(idAlbum));
                album.setCantidadCanciones(albumes_Repository.contarCanciones(idAlbum));
                album.setDuracionAlbum(albumes_Repository.obtenerDuracion(idAlbum));
                album.setFollow(albumes_Repository.seSigue(idUsuario, idAlbum));

                List<Object[]> cancionesTraidas = albumes_Repository.obtenerCanciones(idAlbum);

                List<CancionDtoMin> cancionesEnviar = new LinkedList<CancionDtoMin>();

                for (Object[] cancion : cancionesTraidas) {
                    CancionDtoMin cancionDto = new CancionDtoMin();
                    cancionDto.setIdCancion(cancion[0].toString());
                    cancionDto.setNombreCancion(cancion[1].toString());
                    cancionesEnviar.add(cancionDto);
                }
                album.setCanciones(cancionesEnviar);
                
                return album;
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean seguirAlbum(int idAlbum, int idUsuario) {
        try {
            java.sql.Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            conn.setAutoCommit(false);
            if(albumes_Repository.existsById(idAlbum) && usuario_Repository.existsById(idUsuario)){
                PreparedStatement psSeguirAlbumes = conn.prepareStatement("insert into tbl_albumes_seguidos values(?,?,sysdate)");
                
                psSeguirAlbumes.setInt(1, idUsuario);
                psSeguirAlbumes.setInt(2, idAlbum);

                psSeguirAlbumes.executeUpdate() ;
                conn.commit();
                conn.close();
                return true;
            }
            conn.close();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean dejarSeguirAlbum(int idAlbum, int idUsuario) {
        try {
            java.sql.Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            conn.setAutoCommit(false);
            if(albumes_Repository.existsById(idAlbum) && usuario_Repository.existsById(idUsuario)){
                PreparedStatement psDejarSeguirAlbumes = conn.prepareStatement("delete from tbl_albumes_seguidos where id_usuario=? and id_album=?");
                
                psDejarSeguirAlbumes.setInt(1, idUsuario);
                psDejarSeguirAlbumes.setInt(2, idAlbum);

                psDejarSeguirAlbumes.executeUpdate() ;
                conn.commit();
                conn.close();
                return true;
            }
            conn.close();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Albumes> obtenerAlbumes() {
       try {
        
            if(!this.albumes_Repository.findAll().isEmpty()){
                return this.albumes_Repository.findAll();
            }

            return null;

       } catch (Exception e) {
        e.printStackTrace();
        return null;
       }
    }

    @Override
    public Albumes buscarAlbumes(int id) {
        
        try {
            
            if(this.albumes_Repository.findById(id).isPresent()){
                return this.albumes_Repository.findById(id).get();
            }

            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<albumesDto> traerCancionesAlbum(int id) {
       
        try {

            if(this.albumes_Repository.contarCanciones(id) > 0){
                List<Object[]> cancionesList = this.albumes_Repository.obtenerCanciones(id);
                System.out.println(cancionesList.get(0)[1]);
                List<albumesDto> canciones = new LinkedList<>();

                /*for (String cancion : cancionesList) {
                    String[] partesCancion = cancion.split(",");
                    albumesDto album = new albumesDto();
                    album.setNombreCancion(partesCancion[0]);
                    album.setDuracion(partesCancion[1]);
                    album.setLetra(partesCancion[2]);
                    album.setColor(partesCancion[3]);

                    canciones.add(album);
                }*/

                return canciones;
            }
            
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


}
