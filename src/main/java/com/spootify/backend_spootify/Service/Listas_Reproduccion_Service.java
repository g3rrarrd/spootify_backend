package com.spootify.backend_spootify.Service;

import java.util.List;

import com.spootify.backend_spootify.Dtos.caratulaPlaylistDto;
import com.spootify.backend_spootify.Dtos.playlistDto;

public interface Listas_Reproduccion_Service {
    
    public playlistDto obtenerPlaylistsTopGlobal();

    public playlistDto obtenerPlaylistsTopPais();

    public List<caratulaPlaylistDto> obtenerPlaylistCreadas(int id);

    public playlistDto obtenerDailyMix();

    public List<playlistDto> obtenerHitsMasEscuchados();

    public Boolean crarPlaylist(String nombrePlaylist, String descripcion);

    public playlistDto getPlaylistById(int id);

    public Boolean addSongToPlaylist(int idCancion, int idPlaylist);
}