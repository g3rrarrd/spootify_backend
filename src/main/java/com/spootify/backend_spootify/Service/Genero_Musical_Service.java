package com.spootify.backend_spootify.Service;

import java.util.List;

import com.spootify.backend_spootify.Models.Genero_Musical;

public interface Genero_Musical_Service {
    
    public List<Genero_Musical> obtenerGeneros();

    public Genero_Musical buscarGenero(int id);

}
