package com.spootify.backend_spootify.Service;

import java.util.List;
import java.util.Map;

import com.spootify.backend_spootify.Dtos.ArtistaRegisterDto;

public interface Artistas_Service {
    
    public void crearArtista(int idUsuario);

    //oyentes, biografia
    public Map<String, String> obtenerDataArtista(int id);
    
    public List<ArtistaRegisterDto> obtenerTodosRegister();
}
