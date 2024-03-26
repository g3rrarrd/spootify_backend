package com.spootify.backend_spootify.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Models.Tallas;
import com.spootify.backend_spootify.Repositories.Tallas_Repository;
import com.spootify.backend_spootify.Services.Tallas_Service;

@Service
public class Tallas_Service_Impl implements Tallas_Service{

    @Autowired
    private Tallas_Repository tallas_Repository;

    @Override
    public List<Tallas> obtenerTallas() {
        
        try {
            return this.tallas_Repository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void insertarTallas(String talla) {
        try {
            Tallas tallas = new Tallas();
            if (!this.tallas_Repository.findAll().isEmpty()) {
                tallas.setIdTalla(this.tallas_Repository.findAll().size() + 1);
            }
            else{
                tallas.setIdTalla(1);
            }
            if(talla.length() > 0){
                tallas.setNombre_talla(talla);
                this.tallas_Repository.save(tallas);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String buscarTalla(int id) {
        
        try {
            return this.tallas_Repository.findById(id).get().getNombre_talla();
        } catch (Exception e) {
            return String.format("Hubo un problema: %s", e.getMessage());
        }

    }

    @Override
    public void actualizarTalla(int id, String nombre) {
        try {
            if(this.tallas_Repository.findById(id).isPresent()){
                Tallas tallas = this.tallas_Repository.findById(id).get();
                tallas.setNombre_talla(nombre);
                this.tallas_Repository.save(tallas);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void eliminarTalla(int id) {
        try {
            this.tallas_Repository.deleteById(id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
