package com.spootify.backend_spootify.Service;

import java.util.List;
import java.util.Map;

import com.spootify.backend_spootify.Dtos.ArtistaDtoMin;
import com.spootify.backend_spootify.Dtos.artistViewDto;

public interface Artistas_Service {
    
    public void crearArtista(int idUsuario);

    //oyentes, biografia
    public Map<String, String> obtenerDataArtista(int id);
    
    public List<ArtistaDtoMin> obtenerTodosRegister();

    public artistViewDto getArtist(int idUsuario, int id);
}
