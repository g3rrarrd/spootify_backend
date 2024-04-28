package com.spootify.backend_spootify.Service.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.episodiosDto;
import com.spootify.backend_spootify.Dtos.usuarioEstandarDto;
import com.spootify.backend_spootify.Objects.Funciones;
import com.spootify.backend_spootify.OracleData.oraData;
import com.spootify.backend_spootify.Service.Episodios_Service;

@Service
public class Episodio_Service_Impl implements Episodios_Service{

    
    @Override
    public episodiosDto traerEpisodio(int idEpisodio) {
        try {
            return this.traerEpisodios(idEpisodio);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private episodiosDto traerEpisodios(int id){
        try {
            
            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            PreparedStatement psEpi = conn.prepareStatement("select  c.url_portada_podcast,\r\n" + //
                                "        b.nombre_media,\r\n" + //
                                "        c.id_podcast,\r\n" + //
                                "        c.nombre_podcast,\r\n" + //
                                "        to_char(fecha_publicacion, 'd FMMonth FMYY'),\r\n" + //
                                "        b.duracion_media ,\r\n" + //
                                "        descripcion_episodio\r\n" + //
                                "from tbl_episodio a\r\n" + //
                                "inner join tbl_media b\r\n" + //
                                "on a.id_episodio = b.id_media\r\n" + //
                                "inner join tbl_podcasts c\r\n" + //
                                "on a.id_podcast = c.id_podcast\r\n" + //
                                "where a.id_episodio = ?");
            psEpi.setInt(1, id);
            ResultSet rsEpi = psEpi.executeQuery();
            episodiosDto episodio = new episodiosDto();

            if(rsEpi.next()){
                episodio.setPortada(rsEpi.getString(1));
                episodio.setNombre(rsEpi.getString(2));
                episodio.setIdPodcast(rsEpi.getInt(3));
                episodio.setNombrePodcast(rsEpi.getString(4));
                episodio.setFecha_publicacion(rsEpi.getString(5));
                episodio.setDuracion(Funciones.convertirDuracion(rsEpi.getInt(6)));
                episodio.setDescripcion(rsEpi.getString(7));
            }

            return episodio;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
}
