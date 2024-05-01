package com.spootify.backend_spootify.Service.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.episodiosDto;
import com.spootify.backend_spootify.Dtos.generoPodcastsDto;
import com.spootify.backend_spootify.Dtos.podcastDto;
import com.spootify.backend_spootify.Objects.Funciones;
import com.spootify.backend_spootify.OracleData.oraData;
import com.spootify.backend_spootify.Repositories.Podcasts_Repository;
import com.spootify.backend_spootify.Repositories.Usuario_Repository;
import com.spootify.backend_spootify.Service.Podcasts_Service;

@Service
public class Podcasts_Service_Impl implements Podcasts_Service{

    @Autowired
    Podcasts_Repository pr;

    @Autowired
    Usuario_Repository usuario_Repository;

    @Override
    public podcastDto traerPodcast(int idPodcast, int idUsuario) {
        try {
            
            podcastDto podcast = new podcastDto();

            podcast = this.infoBasica(idPodcast);
            podcast.setSeguido(this.pr.validarSeguimiento(idPodcast, idUsuario));
            if (podcast.getSeguido() == null) {
                podcast.setSeguido(0);
            }
            podcast.setEpisodios(this.traerEpisodios(idPodcast));
            podcast.setGeneros(this.traerGeneroPodcasts(idPodcast));
            podcast.setSugerenciasPodcasts(this.traerSugerencias(idPodcast));

            return podcast;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private podcastDto infoBasica(int id){
        try {
            
            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            PreparedStatement psInfo = conn.prepareStatement("select nombre_podcast, nombre_usuario, a.descripcion_podcast, c.valor_hexadecimal as color, url_portada_podcast from tbl_podcasts a inner join tbl_usuarios b on a.id_podcaster = b.id_usuario inner join tbl_colores c on a.id_color = c.id_color where a.id_podcast = ?");
            psInfo.setInt(1, id);
            ResultSet rsInfo = psInfo.executeQuery();
            podcastDto podcast = new podcastDto();

            if(rsInfo.next()){
                podcast.setNombrePodcast(rsInfo.getString(1));
                podcast.setAutor(rsInfo.getString(2));
                podcast.setDescripcion(rsInfo.getString(3));
                podcast.setColor(rsInfo.getString(4));
                podcast.setPortada(rsInfo.getString(5));
            }

            return podcast;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private List<episodiosDto> traerEpisodios(int id){
        try {
            
            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            PreparedStatement psEpi = conn.prepareStatement("select  id_episodio, a.id_podcast, c.nombre_media, descripcion_episodio, url_portada, to_char(c.fecha_publicacion, 'd FMMonth FMYY'), c.duracion_media from tbl_episodio a inner join tbl_podcasts b on a.id_podcast = b.id_podcast inner join tbl_media c on a.id_episodio = c.id_media where a.id_podcast = ?");
            psEpi.setInt(1, id);
            ResultSet rsEpi = psEpi.executeQuery();
            List<episodiosDto> listEpisodios = new LinkedList<>();

            while (rsEpi.next()) {
                episodiosDto episodio = new episodiosDto();
                episodio.setId(rsEpi.getInt(1));
                episodio.setNombre(rsEpi.getString(3));
                episodio.setDescripcion(rsEpi.getString(4));
                episodio.setPortada(rsEpi.getString(5));
                episodio.setFecha_publicacion(rsEpi.getString(6));
                episodio.setDuracion(Funciones.convertirDuracion(rsEpi.getInt(7)));

                listEpisodios.add(episodio);
            }

            return listEpisodios;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    private List<generoPodcastsDto> traerGeneroPodcasts(int id){
        try {
            
            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            PreparedStatement psGen = conn.prepareStatement("select  a.id_podcast, c.genero_podcast from tbl_podcast_x_generos a inner join tbl_podcasts b on a.id_podcast = b.id_podcast inner join tbl_genero_podcast c on a.id_genero_podcast = c.id_genero_podcast where a.id_podcast = ?");
            psGen.setInt(1, id);
            ResultSet rsGen = psGen.executeQuery();
            List<generoPodcastsDto> listGeneros = new LinkedList<>();


            while (rsGen.next()) {
                
                generoPodcastsDto genero = new generoPodcastsDto();
                genero.setIdGenero(rsGen.getInt(1));
                genero.setNombreGenero(rsGen.getString(2));

                listGeneros.add(genero);
            }

            return listGeneros;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private List<podcastDto> traerSugerencias(int id){
        try {
            
            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            PreparedStatement psPod = conn.prepareStatement("with tipo_genero as ( select  b.id_genero_podcast, b.id_podcast from tbl_podcasts a inner join tbl_podcast_x_generos b on a.id_podcast = b.id_podcast where a.id_podcast = ?) select  b.id_podcast,nombre_podcast, descripcion_podcast, url_portada_podcast, count(1) from tipo_genero a inner join tbl_podcast_x_generos b on a.id_genero_podcast = b.id_genero_podcast inner join tbl_podcasts c on b.id_podcast = c.id_podcast where b.id_podcast <> a.id_podcast group by b.id_podcast,nombre_podcast, descripcion_podcast, url_portada_podcast fetch first 4 rows only");
            psPod.setInt(1, id);
            ResultSet rsPod = psPod.executeQuery();
            List<podcastDto> listPodcast = new LinkedList<>();

            while (rsPod.next()) {
                podcastDto podcasts = new podcastDto();

                podcasts.setId(rsPod.getInt(1));
                podcasts.setNombrePodcast(rsPod.getString(2));
                podcasts.setDescripcion(rsPod.getString(3));
                podcasts.setPortada(rsPod.getString(4));

                listPodcast.add(podcasts);
            }

            return listPodcast;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean seguirPodcast(int idPodcast, int idUsuario) {
        try {
            java.sql.Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            conn.setAutoCommit(false);
            if(pr.existsById(idPodcast) && usuario_Repository.existsById(idUsuario)){
                PreparedStatement psSeguirAlbumes = conn.prepareStatement("insert into tbl_seguidores values(?,?,sysdate)");
                
                int idPodcaster = pr.findById(idPodcast).get().getPodcaster().getIdUsuario();

                psSeguirAlbumes.setInt(1, idUsuario);
                psSeguirAlbumes.setInt(2, idPodcaster);

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
    public Boolean dejarSeguirPocast(int idPodcast, int idUsuario) {
        try {
            java.sql.Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            conn.setAutoCommit(false);
            if(pr.existsById(idPodcast) && usuario_Repository.existsById(idUsuario)){
                PreparedStatement psDejarSeguirAlbumes = conn.prepareStatement("delete from tbl_seguidores where id_usuario_seguidor=? and id_usuario_seguido=?");
                
                int idPodcaster = pr.findById(idPodcast).get().getPodcaster().getIdUsuario();
                
                psDejarSeguirAlbumes.setInt(1, idUsuario);
                psDejarSeguirAlbumes.setInt(2, idPodcaster);

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

    
}
