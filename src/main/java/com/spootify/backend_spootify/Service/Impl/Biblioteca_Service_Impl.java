package com.spootify.backend_spootify.Service.Impl;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.bibliotecaDto;
import com.spootify.backend_spootify.Dtos.caratulaPlaylistDto;
import com.spootify.backend_spootify.Dtos.playlistDto;
import com.spootify.backend_spootify.Repositories.Biblioteca_Repository;
import com.spootify.backend_spootify.Repositories.Listas_Reproduccion_Repository;
import com.spootify.backend_spootify.Service.Bilblioteca_Service;

@Service
public class Biblioteca_Service_Impl implements Bilblioteca_Service {

    @Autowired
    Listas_Reproduccion_Repository listas;

    @Autowired
    Biblioteca_Repository library;

    @Override
    public bibliotecaDto getLibreryView(int idUser) {
        List<Object[]> listas = library.getPlaylistByIdUsuario(idUser);
        //Metodo para Obtener las playlist del usuario
        List<caratulaPlaylistDto> playlists = new LinkedList<>();
        for (Object obj : listas) {
            Object[] songInfo = (Object[]) obj; 
            
            caratulaPlaylistDto playlist = new caratulaPlaylistDto();
            BigDecimal id_playlist = (BigDecimal) songInfo[0];
            playlist.setId_Playlist(id_playlist);
            playlist.setNombrePlaylist((String) songInfo[1]);
            playlist.setPortadaPlaylist((String) songInfo[2]); 
            playlist.setDescripcion((String) songInfo[3]);
            BigDecimal songsCount = (BigDecimal) songInfo[4];
            playlist.setCantidadCanciones(songsCount);

            playlists.add(playlist);
        }

        List<Object[]> podcasts = library.getPodcastsByIdUser(idUser);
        List<caratulaPlaylistDto> podcast = new LinkedList<>();
        for (Object obj : podcasts) {
            Object[] songInfo = (Object[]) obj; 
            
            caratulaPlaylistDto playlist = new caratulaPlaylistDto();
            BigDecimal id_playlist = (BigDecimal) songInfo[0];
            playlist.setId_Playlist(id_playlist);
            playlist.setNombrePlaylist((String) songInfo[1]);
            playlist.setPortadaPlaylist((String) songInfo[2]); 
            playlist.setDescripcion((String) songInfo[3]);

            podcast.add(playlist);
        }
        
        Object[] user = library.getUserByid(idUser);
        bibliotecaDto biblioteca = new bibliotecaDto();
        for (Object obj : user) {
            Object[] songInfo = (Object[]) obj; 
            
            biblioteca.setFotoUsuario((String) songInfo[2]);
        }
        biblioteca.setPlaylists(playlists);
        biblioteca.setPodcasts(podcast);
        return biblioteca;
    }
    
}
