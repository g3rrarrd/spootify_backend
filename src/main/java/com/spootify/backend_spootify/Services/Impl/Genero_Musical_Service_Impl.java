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
        try {
            return this.genero_Musical_Repository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    @Transactional
    public void insertargeneromusical(String genero_Musical) {

        try {
            Genero_Musical genero = new Genero_Musical();

            if(!this.genero_Musical_Repository.findAll().isEmpty()){
                if(!genero_Musical.isEmpty()){    
                    genero.setIdGeneroMusical(this.genero_Musical_Repository.findAll().size() + 1);
                }
                
            }else{
                genero.setIdGeneroMusical(1);
            }
    
            if(genero_Musical.length() > 0){
                genero.setNombreGeneroMusical(genero_Musical);
                this.genero_Musical_Repository.save(genero);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String obtenergeneromusical(int id) {
        
        if(id >= 0){
         try {
            return this.genero_Musical_Repository.findById(id).get().getNombreGeneroMusical();
         } catch (Exception e) {
            return String.format("Hubo un problema: %s", e.getMessage());

         }
        }

    return null;

    }

    @Override
    public void actualizargeneromusical(int id, String genero) {
        try {
            if(this.genero_Musical_Repository.findById(id).isPresent()){
                Genero_Musical genero_Musical = this.genero_Musical_Repository.findById(id).get();
                genero_Musical.setNombreGeneroMusical(genero);
                this.genero_Musical_Repository.save(genero_Musical);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void eliminargeneromusical(int id) {
        try {
            this.genero_Musical_Repository.deleteById(id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


}
