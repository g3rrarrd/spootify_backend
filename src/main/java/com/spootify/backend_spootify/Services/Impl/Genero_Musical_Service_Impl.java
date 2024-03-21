package com.spootify.backend_spootify.Services.Impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Models.Genero_Musical;
import com.spootify.backend_spootify.Repositories.Genero_Musical_Repository;
import com.spootify.backend_spootify.Services.Genero_Musical_Service;

import jakarta.transaction.Transactional;

@Service
public class Genero_Musical_Service_Impl implements Genero_Musical_Service{
    
    @Autowired
    private Genero_Musical_Repository genero_Musical_Repository;

    @Override
    public List<Genero_Musical> obtenerGenerosMusicales() {
        return this.genero_Musical_Repository.findAll();
    }

    @Override
    @Transactional
    public void insertargeneromusical(String Genero_Musical) {

        Genero_Musical genero = new Genero_Musical();

        if(!Genero_Musical.isEmpty()){
            genero.setNombreGeneroMusical(Genero_Musical);
            this.genero_Musical_Repository.save(genero);
        }

        List<Genero_Musical> generos = this.genero_Musical_Repository.findAll();
    }

    @Override
    public String obtenergeneromusical(int id) {
        
        if(id >= 0){
         return this.genero_Musical_Repository.findById(id).get().getNombreGeneroMusical();
        }

    return null;

    }


}
