package com.spootify.backend_spootify.Service.Impl;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.ArtistaDtoMin;
import com.spootify.backend_spootify.Dtos.MerchDto;
import com.spootify.backend_spootify.Dtos.artistViewDto;
import com.spootify.backend_spootify.Dtos.caratulaCancionDto;
import com.spootify.backend_spootify.Dtos.caratulaPlaylistDto;
import com.spootify.backend_spootify.Dtos.playlistDto;
import com.spootify.backend_spootify.Repositories.Artistas_Repository;
import com.spootify.backend_spootify.Service.Artistas_Service;

@Service
public class Artistas_Service_Impl implements Artistas_Service{

    @Autowired
    Artistas_Repository aRepository;

    @Override
    public void crearArtista(int idUsuario) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Map<String, String> obtenerDataArtista(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ArtistaDtoMin> obtenerTodosRegister() {
        try {
            if (aRepository.obtenerArtistasRegister()!=null) {
                
                List<Object[]> artistasObject = aRepository.obtenerArtistasRegister();
                List<ArtistaDtoMin> artistasEnviar = new LinkedList<ArtistaDtoMin>();

                for (Object[] artista : artistasObject) {
                    ArtistaDtoMin artistaRegister = new ArtistaDtoMin();
                    artistaRegister.setIdArtista(artista[0].toString());
                    artistaRegister.setNombreArtista(artista[1].toString());
                    artistaRegister.setFotoArtista(artista[2].toString());
                    artistasEnviar.add(artistaRegister);
                }

                return artistasEnviar;
            }

            return null;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public artistViewDto getArtist(int idUsuario, int id) {

        artistViewDto artista = new artistViewDto();
        Object[] infoArtist = aRepository.getArtist(id);
        for (Object obj : infoArtist) {
            Object[] songInfo = (Object[]) obj; // Convertir el objeto en un array de objetos

            BigDecimal id_artista = (BigDecimal) songInfo[0];
            artista.setIdArtista(id_artista);
            artista.setNombre((String) songInfo[1]);
            artista.setFoto((String) songInfo[2]);
            artista.setBiografia((String) songInfo[3]);
            BigDecimal oyentes = (BigDecimal) songInfo[5];
            artista.setOyentesMensuales(oyentes);
            artista.setColor((String) songInfo[4]);
        }

        //Metodo para Obtener Canciones mas populares
        List<caratulaCancionDto> canciones = new LinkedList<>();
        List<Object[]> songs = aRepository.getPopularSongs(id);
        for (Object obj : songs) {
            Object[] songInfo = (Object[]) obj; 
            caratulaCancionDto cancion = new caratulaCancionDto();
            BigDecimal id_cancion = (BigDecimal) songInfo[0];
            cancion.setId_cancion(id_cancion);
            cancion.setNombreCancion((String) songInfo[2]);
            cancion.setPortadaCancion((String) songInfo[3]);
            BigDecimal reproducciones = (BigDecimal) songInfo[4];
            String idArtistaStr = reproducciones.toString();
            cancion.setArtistaCancion(idArtistaStr);

            canciones.add(cancion);
            
        }
        artista.setCancionesPopulares(canciones);

        //Metodo para Obtener el ultimo lanzamiento
        Object[] ultimoLanzamiento = aRepository.getLastPost(id);
        caratulaPlaylistDto last = new caratulaPlaylistDto();
        for (Object obj : ultimoLanzamiento) {
            Object[] songInfo = (Object[]) obj; 

            BigDecimal id_playlist = (BigDecimal) songInfo[0];
            last.setId_Playlist(id_playlist);
            last.setNombrePlaylist((String) songInfo[1]);
            last.setPortadaPlaylist((String) songInfo[2]); 
            last.setDescripcion((String) songInfo[3]);
            last.setTipoLanzamiento((String) songInfo[4]);
        }
        //Obtiene los lanzamientos mas populares
        List<Object[]> lanzamientos = aRepository.getPopularPost(id);
        List<caratulaPlaylistDto> playlists = new LinkedList<>();
        for (Object obj : lanzamientos) {
            Object[] songInfo = (Object[]) obj; 
            
            caratulaPlaylistDto playlist = new caratulaPlaylistDto();
            BigDecimal id_playlist = (BigDecimal) songInfo[0];
            playlist.setId_Playlist(id_playlist);
            playlist.setNombrePlaylist((String) songInfo[1]);
            playlist.setPortadaPlaylist((String) songInfo[2]); 
            playlist.setDescripcion((String) songInfo[3]);
            playlist.setTipoLanzamiento((String) songInfo[4]);

            playlists.add(playlist);
        }

        List<Object[]> merchList = aRepository.getMerch(id);
        List<MerchDto> merchEnviar = new LinkedList<MerchDto>();

        for (Object[] merch : merchList) {
            MerchDto merchItem = new MerchDto();
            merchItem.setId(merch[0].toString()); 
            merchItem.setNombre(merch[1].toString());
            merchItem.setDescripcion(merch[2].toString());
            merchItem.setPrecio(merch[3].toString());
            merchItem.setImagen(merch[4].toString());
            merchEnviar.add(merchItem);
        }

         //Obtiene las playlist donde aparece el artista
        List<Object[]> playlistArtist = aRepository.getPlaylistArtist(id);
        List<caratulaPlaylistDto> playlistOfArtist = new LinkedList<>();
        for (Object obj : playlistArtist) {
            Object[] songInfo = (Object[]) obj; 
            
            caratulaPlaylistDto playlist = new caratulaPlaylistDto();
            BigDecimal id_playlist = (BigDecimal) songInfo[0];
            playlist.setId_Playlist(id_playlist);
            playlist.setNombrePlaylist((String) songInfo[2]);
            playlist.setPortadaPlaylist((String) songInfo[3]); 
            playlist.setDescripcion((String) songInfo[4]);

            playlistOfArtist.add(playlist);
        }

        artista.setMerch(merchEnviar);
        artista.setUltimoLanzamiento(last);
        artista.setLanzamientosPopulares(playlists);
        artista.setPlaylistArtista(playlistOfArtist);

        return artista;

    }
    
}
