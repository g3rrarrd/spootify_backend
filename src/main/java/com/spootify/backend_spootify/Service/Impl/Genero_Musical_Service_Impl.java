package com.spootify.backend_spootify.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Models.Genero_Musical;
import com.spootify.backend_spootify.Repositories.Genero_Musical_Repository;
import com.spootify.backend_spootify.Service.Genero_Musical_Service;

@Service
public class Genero_Musical_Service_Impl implements Genero_Musical_Service{

    @Autowired
    Genero_Musical_Repository gmr;

    @Override
    public List<Genero_Musical> obtenerGeneros() {
        try {
            return this.gmr.findAll();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Genero_Musical buscarGenero(int id) {
        try {
            return this.gmr.findById(id).get();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
}
