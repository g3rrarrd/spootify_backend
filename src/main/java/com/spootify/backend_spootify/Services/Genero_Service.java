package com.spootify.backend_spootify.Services;

import java.util.List;

import com.spootify.backend_spootify.Models.Genero;

public interface Genero_Service {
    
    public List<Genero> obtenerGeneros();

    public Genero buscarGenero(int id);

    public void insertarGenero(Genero genero);

    public void eliminarGenero(int id);

}
