package com.spootify.backend_spootify.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Models.Tallas;
import com.spootify.backend_spootify.Repositories.Tallas_Repository;
import com.spootify.backend_spootify.Service.Tallas_Service;

@Service
public class Tallas_Service_Impl implements Tallas_Service{
    
    @Autowired
    Tallas_Repository tr;

    @Override
    public List<Tallas> obtenerTallas() {
        try {
            return this.tr.findAll();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tallas buscarTalla(int id) {
        try {
            return this.tr.findById(id).get();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    
}
