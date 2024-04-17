package com.spootify.backend_spootify.Service;

import java.util.List;
import java.util.Map;

import com.spootify.backend_spootify.Models.Albumes;
import com.spootify.backend_spootify.Models.Canciones;
import com.spootify.backend_spootify.Models.Eventos;

public interface Artistas_Service {
    
    public void crearArtista(int idUsuario);

    //oyentes, biografia
    public Map<String, String> obtenerDataArtista(int id);
    
    public List<Albumes> obtenerAlbumesArtista(int id);

    public List<Eventos> obtenerEventoArtista(int id);

    public List<Canciones> obtenerCancionesArtistas(int id);
}
