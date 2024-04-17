package com.spootify.backend_spootify.Service;

import java.util.List;

import com.spootify.backend_spootify.Models.Genero;

public interface Genero_Service {
    
    public List<Genero> obtenerGeneros();

    public Genero buscarGenero(int id);

}
