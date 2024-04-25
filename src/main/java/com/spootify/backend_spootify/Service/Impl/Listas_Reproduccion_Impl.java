package com.spootify.backend_spootify.Service.Impl;

    import java.util.List;

import org.hibernate.annotations.TimeZoneStorage;
import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.caratulaPlaylistDto;
import com.spootify.backend_spootify.Dtos.playlistDto;
import com.spootify.backend_spootify.Repositories.Listas_Reproduccion_Repository;
import com.spootify.backend_spootify.Service.Listas_Reproduccion_Service;
    
    
    @Service
public class Listas_Reproduccion_Impl implements Listas_Reproduccion_Service {
    @Autowired
    Listas_Reproduccion_Repository listas;


    

    @Override
    public List<caratulaPlaylistDto> obtenerPlaylistsTopPais() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPlaylistsTopPais'");
    }


    @Override
    public List<caratulaPlaylistDto> obtenerPlaylistCreadas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPlaylistCreadas'");
    }


    @Override
    public List<caratulaPlaylistDto> obtenerDailyMix() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerDailyMix'");
    }


    @Override
    public List<caratulaPlaylistDto> obtenerHitsMasEscuchados() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerHitsMasEscuchados'");
    }


    @Override
    public Boolean crarPlaylist(String nombrePlaylist, String descripcion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crarPlaylist'");
    }


    @Override
    public playlistDto obtenerPlaylist() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPlaylist'");
    }


    @Override
    public List<caratulaPlaylistDto> obtenerPlaylistsTopGlobal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPlaylistsTopGlobal'");
    }
    
      
}
