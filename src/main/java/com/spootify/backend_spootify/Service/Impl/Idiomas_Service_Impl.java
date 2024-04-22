package com.spootify.backend_spootify.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Models.Idiomas;
import com.spootify.backend_spootify.Repositories.Idiomas_Repository;
import com.spootify.backend_spootify.Service.Idiomas_Service;

@Service
public class Idiomas_Service_Impl implements Idiomas_Service{


    @Autowired
    Idiomas_Repository ir;

    @Override
    public List<Idiomas> obtenerIdiomas() {
        try {
            return this.ir.findAll();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Idiomas buscarIdioma(int id) {
        try {
            return this.ir.findById(id).get();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
}
