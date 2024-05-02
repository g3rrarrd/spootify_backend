package com.spootify.backend_spootify.Service.Impl;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.ArtistaDtoMin;
import com.spootify.backend_spootify.Dtos.CancionDtoMin;
import com.spootify.backend_spootify.Dtos.CancionVistaDto;
import com.spootify.backend_spootify.Dtos.CreditosDto;
import com.spootify.backend_spootify.OracleData.oraData;
import com.spootify.backend_spootify.Repositories.Albumes_Repository;
import com.spootify.backend_spootify.Repositories.Canciones_Repository;
import com.spootify.backend_spootify.Repositories.Media_Repository;
import com.spootify.backend_spootify.Repositories.Usuario_Repository;
import com.spootify.backend_spootify.Repositories.Usuario_estandar_Repository;
import com.spootify.backend_spootify.Service.Canciones_Service;
import com.spootify.backend_spootify.OracleData.oraData;

@Service
public class Canciones_Service_Impl implements Canciones_Service{

    @Autowired
    Canciones_Repository canciones_Repository;

    @Autowired
    Media_Repository media_Repository;

    @Autowired
    Usuario_Repository usuario_Repository;

    @Autowired
    Usuario_estandar_Repository usuario_Estandar_Rep;

    @Override
    public CancionVistaDto traerCancion(int idCancion, int idUsuario) {
        try {
            
            if (usuario_Repository.existsById(idUsuario) && canciones_Repository.existsById(idCancion)) {

                CancionVistaDto cancion = new CancionVistaDto();

                cancion.setNombre(canciones_Repository.obtenerNombreCancion(idCancion));
                cancion.setPortada(canciones_Repository.obtenerPortada(idCancion));
                cancion.setColor(canciones_Repository.obtenerColor(idCancion));
                cancion.setArtista(traerArtistaCancion(idCancion));
                cancion.setIdAlbum(canciones_Repository.obtenerAlbum(idCancion));
                cancion.setSeguido(canciones_Repository.seSigue(idCancion,idUsuario));
                cancion.setDuracion(canciones_Repository.obtenerDuracion(idCancion));
                cancion.setCreditos(traerInformacionCreditos(idCancion));

                return cancion;
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean seguirCancion(int idCancion, int idUsuario) {
        try {
            java.sql.Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            conn.setAutoCommit(false);
            if(canciones_Repository.existsById(idCancion) && usuario_Repository.existsById(idUsuario)){
                PreparedStatement psSeguirCanciones = conn.prepareStatement("insert into tbl_listas_y_canciones values (?,?)");
                
                int idLikedPlaylist = usuario_Estandar_Rep.obtenerIdLikedPlaylist(idUsuario);

                psSeguirCanciones.setInt(1, idLikedPlaylist);
                psSeguirCanciones.setInt(2, idCancion);

                psSeguirCanciones.executeUpdate() ;
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
    public Boolean dejarSeguirCancion(int idCancion, int idUsuario) {
        try {
            java.sql.Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            conn.setAutoCommit(false);
            if(canciones_Repository.existsById(idCancion) && usuario_Repository.existsById(idUsuario)){
                PreparedStatement psSeguirCanciones = conn.prepareStatement("delete from tbl_listas_y_canciones where id_lista_reproduccion=? and id_cancion=?");
                
                int idLikedPlaylist = usuario_Estandar_Rep.obtenerIdLikedPlaylist(idUsuario);

                psSeguirCanciones.setInt(1, idLikedPlaylist);
                psSeguirCanciones.setInt(2, idCancion);

                psSeguirCanciones.executeUpdate() ;
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


    private ArtistaDtoMin traerArtistaCancion(int id) {
        try {
            
                String[] parteArtista = this.canciones_Repository.obtenerArtista(id).split(",");
                ArtistaDtoMin artista = new ArtistaDtoMin();

                artista.setIdArtista(parteArtista[0]);
                artista.setNombreArtista(parteArtista[1]);
                artista.setFotoArtista(parteArtista[2]);

                return artista;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private CreditosDto traerInformacionCreditos(int idCancion) {
       try {
            String[] parteCreditos = this.canciones_Repository.obtenerInfoCreditos(idCancion).split(",");
            List<String> escritores = this.canciones_Repository.obtenerEscritores(idCancion);
            List<String> productores = this.canciones_Repository.obtenerProductores(idCancion);
            CreditosDto credito = new CreditosDto();

            credito.setIdCredito(parteCreditos[0]);
            credito.setFirmaDiscografica(parteCreditos[1]);
            credito.setArtista(parteCreditos[2]);
            credito.setEscritores(escritores);
            credito.setProductores(productores);
            

            return credito;

       } catch (Exception e) {
        e.printStackTrace();
        return null;
       }
    }

    
    @Override
    public List<CancionDtoMin> traerCancionesParaAgregar(int idPlaylist) {
        try {

            List<Object[]> cancionesTraidas = canciones_Repository.obtenerCancionesNotInPlaylist(idPlaylist);

            List<CancionDtoMin> cancionesEnviar = new LinkedList<CancionDtoMin>();

            for (Object[] cancion : cancionesTraidas) {
                CancionDtoMin cancionDto = new CancionDtoMin();
                cancionDto.setId(cancion[0].toString());
                cancionDto.setNombre(cancion[1].toString());
                cancionDto.setArtistaCancion(cancion[2].toString());
                cancionDto.setPortada(cancion[3].toString());
                cancionesEnviar.add(cancionDto);
            }

            return cancionesEnviar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean playMedia(int idUsuario, int idMedia) {
         try {
            java.sql.Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            conn.setAutoCommit(false);
            if(media_Repository.existsById(idMedia) && usuario_Repository.existsById(idUsuario)){
                
                int historial = canciones_Repository.getHistorial(idUsuario);

                PreparedStatement playSong = conn.prepareStatement("INSERT INTO tbl_historial_media (id_historial_reproduccion, id_media, fecha_reproduccion) VALUES (?, ?, SYSDATE)");
                
                playSong.setInt(1, historial);
                playSong.setInt(2, idMedia);

                playSong.executeUpdate() ;
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



}
