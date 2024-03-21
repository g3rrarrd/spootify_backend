package com.spootify.backend_spootify.Services;

import java.util.List;

import com.spootify.backend_spootify.Models.Genero_Musical;

import jakarta.transaction.Transactional;

public interface Genero_Musical_Service {
    
    public List<Genero_Musical> obtenerGenerosMusicales();

    public void insertargeneromusical(String Genero_Musical);

    public String obtenergeneromusical(int id);

}
