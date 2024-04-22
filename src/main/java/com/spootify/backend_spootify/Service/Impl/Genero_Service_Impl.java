package com.spootify.backend_spootify.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Models.Genero;
import com.spootify.backend_spootify.Repositories.Genero_Repository;
import com.spootify.backend_spootify.Service.Genero_Service;

@Service
public class Genero_Service_Impl implements Genero_Service{

    @Autowired
    Genero_Repository gr;

    @Override
    public List<Genero> obtenerGeneros() {
        try {
            return this.gr.findAll();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Genero buscarGenero(int id) {
        try {
            return this.gr.findById(id).get();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
}
