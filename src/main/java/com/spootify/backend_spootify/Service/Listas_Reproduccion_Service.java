package com.spootify.backend_spootify.Service;

import java.util.List;

import com.spootify.backend_spootify.Dtos.caratulaPlaylistDto;
import com.spootify.backend_spootify.Dtos.playlistDto;

public interface Listas_Reproduccion_Service {
    
    public List<caratulaPlaylistDto> obtenerPlaylistsTopGlobal();

    public List<caratulaPlaylistDto> obtenerPlaylistsTopPais();

    public List<caratulaPlaylistDto> obtenerPlaylistCreadas();

    public List<caratulaPlaylistDto> obtenerDailyMix();

    public List<caratulaPlaylistDto> obtenerHitsMasEscuchados();

    public Boolean crarPlaylist(String nombrePlaylist, String descripcion);

    public playlistDto obtenerPlaylist();
}