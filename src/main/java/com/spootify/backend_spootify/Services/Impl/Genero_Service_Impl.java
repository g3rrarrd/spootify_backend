package com.spootify.backend_spootify.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Models.Genero;
import com.spootify.backend_spootify.Repositories.Genero_Repository;
import com.spootify.backend_spootify.Services.Genero_Service;

@Service
public class Genero_Service_Impl implements Genero_Service{

    @Autowired
    private Genero_Repository genero_Repository;

    @Override
    public List<Genero> obtenerGeneros() {
        try {
            if(!this.genero_Repository.findAll().isEmpty()){
                return this.genero_Repository.findAll();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Genero buscarGenero(int id) {
        try {
            if(this.genero_Repository.findById(id).isPresent()){
                return this.genero_Repository.findById(id).get();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void insertarGenero(Genero genero) {
        try {
            if (genero.getNombre_genero().length() > 0) {
                if (this.genero_Repository.findAll().size() > 0) {
                    genero.setIdGenero(this.genero_Repository.findAll().size() + 1);
                }else{
                    genero.setIdGenero(1);
                }
                this.genero_Repository.save(genero);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarGenero(int id) {
        try {
            if(this.genero_Repository.findById(id).isPresent()){
                this.genero_Repository.deleteById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
