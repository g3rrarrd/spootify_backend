package com.spootify.backend_spootify.Service.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.CancionDtoMin;
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
            PreparedStatement psHistorialC = conn.prepareStatement("select distinct to_char(fecha_reproduccion,'fmdy, dd mon yyyy') \r\n" + //
                                "as fecha_reproduccion, a.fecha_reproduccion from tbl_historial_media a \r\n" + //
                                "inner join tbl_usuario_estandar b \r\n" + //
                                "on(a.id_historial_reproduccion = b.id_historial_de_reproduccion) \r\n" + //
                                "where id_usuario =?\r\n" + //
                                "order by a.fecha_reproduccion desc");
            psHistorialC.setInt(1, id);
            ResultSet rsHistorialC = psHistorialC.executeQuery();
            List<historialCancionDto> listHistorialCanciones = new LinkedList<>();

            while (rsHistorialC.next()) {
                historialCancionDto historialCancion = new historialCancionDto();
                historialCancion.setFechaEscuchada(rsHistorialC.getString(1));
                historialCancion.setMedia(this.traerCanciones(rsHistorialC.getString(1), id));

                listHistorialCanciones.add(historialCancion);
            }
            
            return listHistorialCanciones;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private List<CancionDtoMin> traerCanciones(String fecha, int idUsuario){
        try {
            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            PreparedStatement psMedia = conn.prepareStatement("select id_media, nombre_media, nombre_usuario, portada, tipo_media from (" +
            "select a.id_media, c.nombre_media, d.nombre_usuario, e.portada, a.fecha_reproduccion, f.id_usuario, 1 as tipo_media " +
            "from tbl_historial_media a " +
            "inner join tbl_canciones b on (a.id_media = b.id_cancion) " +
            "inner join tbl_media c on (b.id_cancion = c.id_media) " +
            "inner join tbl_usuarios d on (b.id_artista = d.id_usuario) " +
            "inner join tbl_albumes e on (b.id_album = e.id_album) " +
            "inner join tbl_usuario_estandar f on (a.id_historial_reproduccion = f.id_historial_de_reproduccion) " +
            "union all " +
            "select a.id_media, c.nombre_media, d.nombre_usuario, p.url_portada_podcast, a.fecha_reproduccion , f.id_usuario, 2 as tipo_media " +
            "from tbl_historial_media a " +
            "inner join tbl_episodio b on (a.id_media = b.id_episodio) " +
            "inner join tbl_media c on (b.id_episodio = c.id_media) " +
            "inner join tbl_podcasts p on(b.id_podcast = p.id_podcast) " +
            "inner join tbl_usuarios d on (p.id_podcaster = d.id_usuario) " +
            "inner join tbl_usuario_estandar f on (a.id_historial_reproduccion = f.id_historial_de_reproduccion) " +
            ") where trunc(fecha_reproduccion) = to_date(?,'fmdy, dd mon yyyy') and id_usuario=? order by fecha_reproduccion desc");
            psMedia.setString(1, fecha);
            psMedia.setInt(2, idUsuario);

            ResultSet rsMedia = psMedia.executeQuery();

            List<CancionDtoMin> listaCanciones = new LinkedList<>();

            while (rsMedia.next()) {

                CancionDtoMin cancion = new CancionDtoMin();

                cancion.setId(rsMedia.getString(1));
                cancion.setNombre(rsMedia.getString(2));
                cancion.setArtistaCancion(rsMedia.getString(3));;
                cancion.setPortada(rsMedia.getString(4));
                cancion.setTipoObjeto(rsMedia.getInt(5));

                listaCanciones.add(cancion);
            }

            return listaCanciones;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
}
