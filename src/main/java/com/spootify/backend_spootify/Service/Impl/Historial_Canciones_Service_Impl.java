package com.spootify.backend_spootify.Service.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.artistaDto;
import com.spootify.backend_spootify.Dtos.cancionDto;
import com.spootify.backend_spootify.Dtos.historialCancionDto;
import com.spootify.backend_spootify.OracleData.oraData;
import com.spootify.backend_spootify.Service.Historial_Canciones_Service;

@Service
public class Historial_Canciones_Service_Impl implements Historial_Canciones_Service{

    @Override
    public List<historialCancionDto> traerHistorialCanciones(int id) {
        
        return traerHistorial(id);

    }

    private List<historialCancionDto> traerHistorial(int id){
        try {
            
            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            PreparedStatement psHistorialC = conn.prepareStatement("select  a.id_historial_reproduccion, b.id_media, e.nombre_usuario, e.url_foto_perfil, f.biografia, e.fecha_nacimiento, b.nombre_media, g.portada, TO_CHAR(a.fecha_reproduccion, 'dd-MON-yy') fecha_reproduccion from tbl_historial_canciones a inner join tbl_media b on a.id_media = b.id_media inner join tbl_usuario_estandar c on a.id_historial_reproduccion = c.id_historial_de_reproduccion inner join tbl_canciones d on b.id_media = d.id_cancion inner join tbl_usuarios e on d.id_artista = e.id_usuario inner join tbl_artistas f on d.id_artista = f.id_usuario inner join tbl_albumes g on d.id_album = g.id_album where c.id_usuario = ?");
            psHistorialC.setInt(1, id);
            ResultSet rsHistorialC = psHistorialC.executeQuery();
            List<historialCancionDto> listHistorialCanciones = new LinkedList<>();

            while (rsHistorialC.next()) {
                historialCancionDto historialCancion = new historialCancionDto();
                cancionDto cancion = new cancionDto();
                artistaDto aritsta = new artistaDto();

                cancion.setIdCancion(rsHistorialC.getInt(2));
                aritsta.setNombre(rsHistorialC.getString(3));
                aritsta.setFoto(rsHistorialC.getString(4));
                aritsta.setBiografia(rsHistorialC.getString(5));
                aritsta.setFechaNacimiento(rsHistorialC.getString(6));
                historialCancion.setFechaEscuchada(rsHistorialC.getString(9));
                historialCancion.setCancion(this.traerCanciones(historialCancion.getFechaEscuchada()));

                listHistorialCanciones.add(historialCancion);
            }
            
            return listHistorialCanciones;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private List<cancionDto> traerCanciones(String fecha){
        try {
            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            PreparedStatement psCanciones = conn.prepareStatement("select  d.id_media, nombre_usuario, url_foto_perfil, d.nombre_media, e.nombre_genero_musical, letra_cancion, d.duracion_media, d.reproducciones_media, f.nombre_idioma from tbl_historial_canciones a  inner join tbl_canciones b  on a.id_media = b.id_cancion  left join tbl_usuarios c on b.id_artista = c.id_usuario left join tbl_media d on b.id_cancion = d.id_media left join tbl_generos_musicales e on b.id_genero_musical = e.id_genero_musical inner join tbl_idiomas f\r\n" + //
                                "on b.id_idioma = f.id_idioma where fecha_reproduccion = ?");
            psCanciones.setString(1, fecha);
            ResultSet rsCanciones = psCanciones.executeQuery();

            List<cancionDto> listaCanciones = new LinkedList<>();

            while (rsCanciones.next()) {
                cancionDto cancion = new cancionDto();
                artistaDto artista = new artistaDto();

                cancion.setIdCancion(rsCanciones.getInt(1));
                artista.setNombre(rsCanciones.getString(2));
                artista.setFoto(rsCanciones.getString(3));
                cancion.setArtista(artista);
                cancion.setNombreCancion(rsCanciones.getString(4));
                cancion.setGeneroMusical(rsCanciones.getString(5));
                cancion.setLetraCancion(rsCanciones.getString(6));
                cancion.setDuracionMedia(rsCanciones.getInt(7));
                cancion.setReproduccionesMedia(rsCanciones.getInt(8));
                cancion.setIdioma(rsCanciones.getString(8));

                listaCanciones.add(cancion);
            }

            return listaCanciones;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
}
