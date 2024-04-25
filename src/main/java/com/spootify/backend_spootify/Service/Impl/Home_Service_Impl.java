package com.spootify.backend_spootify.Service.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.artistaDto;
import com.spootify.backend_spootify.Dtos.cancionDto;
import com.spootify.backend_spootify.Dtos.episodiosDto;
import com.spootify.backend_spootify.Dtos.homeDto;
import com.spootify.backend_spootify.Dtos.listaReproduccionDto;
import com.spootify.backend_spootify.Dtos.podcasterDto;
import com.spootify.backend_spootify.OracleData.oraData;
import com.spootify.backend_spootify.Repositories.Canciones_Repository;
import com.spootify.backend_spootify.Repositories.Usuario_Repository;
import com.spootify.backend_spootify.Service.Home_Service;

@Service
public class Home_Service_Impl implements Home_Service{

    @Autowired
    Canciones_Repository cr;

    @Autowired
    Usuario_Repository ur;

    @Override
    public homeDto traerHome(int id) {
        try {

            homeDto home = new homeDto();
           
            home.setFotoPerfil(ur.urlFotoPerfil(id));
            home.setCanciones(traerCanciones(id));
            home.setMixSeguidos(traerMixes());
            home.setPlaylistUsuario(traerPlaylist(id));
            home.setPodcaster(traerPodcasters(id));

            return home;


        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private List<cancionDto> traerCanciones(int id){
        try {
            
            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            PreparedStatement psCanciones = conn.prepareStatement("select  f.nombre_usuario, f.url_foto_perfil, id_cancion, nombre_idioma, nombre_genero_musical, nvl(letra_cancion, 'lo que sea') letra_cancion, nombre_media, duracion_media, reproducciones_media from tbl_historial_canciones a inner join tbl_canciones b on a.id_media = b.id_cancion inner join tbl_media c on a.id_media = c.id_media inner join tbl_generos_musicales d on b.id_genero_musical = d.id_genero_musical inner join tbl_idiomas e on b.id_idioma = e.id_idioma inner join tbl_usuarios f on b.id_artista = f.id_usuario inner join tbl_usuario_estandar g on a.id_historial_reproduccion = g.id_historial_de_reproduccion where g.id_usuario = ? order by fecha_reproduccion desc fetch first 10 rows only");
            psCanciones.setInt(1, id);
            ResultSet rsCanciones = psCanciones.executeQuery();
            List<cancionDto> listCanciones = new LinkedList<>();
    
            while(rsCanciones.next()){
                cancionDto cancion = new cancionDto();
                artistaDto artista = new artistaDto();
    
                artista.setNombre(rsCanciones.getString(1));
                artista.setFoto(rsCanciones.getString(2));
                cancion.setArtista(artista);
                cancion.setIdCancion(rsCanciones.getInt(3));
                cancion.setIdioma(rsCanciones.getString(4));
                cancion.setGeneroMusical(rsCanciones.getString(5));
                cancion.setLetraCancion(rsCanciones.getString(6));
                cancion.setNombreCancion(rsCanciones.getString(7));
                cancion.setDuracionMedia(rsCanciones.getInt(8));
                cancion.setReproduccionesMedia(rsCanciones.getInt(9));
    
                listCanciones.add(cancion);
            }
    
            conn.close();

            return listCanciones;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private List<listaReproduccionDto> traerMixes(){
        try {
            
            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            PreparedStatement psMixes = conn.prepareStatement("select  a.id_lista_reproduccion, a.id_usuario_propietario, a.nombre_lista_reproduccion, a.url_portada_lista, c.nombre_tipo_lista, a.descripcion, count(distinct b.id_usuario) usuarios_seguidos from tbl_listas_reproduccion a left join tbl_listas_seguidas b on a.id_lista_reproduccion = b.id_lista_reproduccion inner join tbl_tipos_listas c on a.id_tipo_lista = c.id_tipo_lista where a.id_tipo_lista = 2 group by a.id_lista_reproduccion, a.id_usuario_propietario, a.nombre_lista_reproduccion, a.url_portada_lista, c.nombre_tipo_lista, a.descripcion order by usuarios_seguidos desc fetch first 10 rows only");
            ResultSet rsMixes = psMixes.executeQuery();
            List<listaReproduccionDto> listRepro = new LinkedList<>();

            while(rsMixes.next()){
                listaReproduccionDto listaRepro = new listaReproduccionDto();
                listaRepro.setIdLista(rsMixes.getInt(1));
                listaRepro.setIdUsuarioPropietario(rsMixes.getInt(2));
                listaRepro.setNombreLista(rsMixes.getString(3));
                listaRepro.setPortadaLista(rsMixes.getString(4));
                listaRepro.setTipoLista(rsMixes.getString(5));
                listaRepro.setDescripcionLista(rsMixes.getString(6));

                listRepro.add(listaRepro);
            }

            return listRepro;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private List<listaReproduccionDto> traerPlaylist(int id){
        try {

            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            PreparedStatement psPlay = conn.prepareStatement("select a.id_lista_reproduccion, a.id_usuario_propietario, a.nombre_lista_reproduccion, a.url_portada_lista, b.nombre_tipo_lista, a.descripcion from tbl_listas_reproduccion a inner join tbl_tipos_listas b on a.id_tipo_lista = b.id_tipo_lista where id_usuario_propietario = ?");
            psPlay.setInt(1, id);
            ResultSet rsPlay = psPlay.executeQuery();
            List<listaReproduccionDto> listRepro = new LinkedList<>();

            while (rsPlay.next()){
                listaReproduccionDto listaRepro = new listaReproduccionDto();
                listaRepro.setIdLista(rsPlay.getInt(1));
                listaRepro.setIdUsuarioPropietario(rsPlay.getInt(2));
                listaRepro.setNombreLista(rsPlay.getString(3));
                listaRepro.setPortadaLista(rsPlay.getString(4));
                listaRepro.setTipoLista(rsPlay.getString(5));
                listaRepro.setDescripcionLista(rsPlay.getString(6));

                listRepro.add(listaRepro);
            }

            return listRepro;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }        
    }

    private List<podcasterDto> traerPodcasters(int id){

        try {
            
            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            PreparedStatement psPod = conn.prepareStatement("select  b.id_usuario, b.nombre_usuario, b.url_foto_perfil from tbl_seguidores a inner join tbl_usuarios b on a.id_usuario_seguido = b.id_usuario where b.id_tipo_usuario = 3 and  id_usuario_seguidor = ?");
            psPod.setInt(1, id);
            ResultSet rsPod = psPod.executeQuery();
            List<podcasterDto> listPodcasters = new LinkedList<>();

            while(rsPod.next()){
                podcasterDto usuario = new podcasterDto();

                usuario.setId(rsPod.getInt(1));
                usuario.setNombre(rsPod.getString(2));
                usuario.setFoto(rsPod.getString(3));

                usuario.setEpisodios(traerEpisodios(usuario.getId()));

                listPodcasters.add(usuario);

            }

            return listPodcasters;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }

    }

    private List<episodiosDto> traerEpisodios(int id){
        try {
            
            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            PreparedStatement psEpi = conn.prepareStatement("select  a.id_episodio, b.nombre_podcast, a.descripcion_episodio, a.url_portada from tbl_episodio a inner join tbl_podcasts b on a.id_podcast = b.id_podcast inner join tbl_media c on a.id_episodio = c.id_media where b.id_podcaster = ? order by c.fecha_publicacion desc FETCH first 5 rows only");
            psEpi.setInt(1, id);
            ResultSet rsEpi = psEpi.executeQuery();
            List<episodiosDto> listEpisodios = new LinkedList<>();

            while(rsEpi.next()){
                episodiosDto episodios = new episodiosDto();
                episodios.setId(rsEpi.getInt(1));
                episodios.setNombre(rsEpi.getString(2));
                episodios.setDescripcion(rsEpi.getString(3));
                episodios.setPortada(rsEpi.getString(4));

                listEpisodios.add(episodios);
            }

            return listEpisodios;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
}
