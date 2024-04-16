package com.spootify.backend_spootify.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Models.Idiomas;
import com.spootify.backend_spootify.Repositories.Idiomas_Repository;
import com.spootify.backend_spootify.Services.Idiomas_Service;

@Service
public class Idiomas_Service_Impl implements Idiomas_Service{

    @Autowired
    private Idiomas_Repository idiomaReposiory;

    @Override
    public List<Idiomas> obtenerIdiomas() {
        
        try {
            return this.idiomaReposiory.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public void insertarIdioma(String idioma) {
        
            try {
                Idiomas idiomas = new Idiomas();
                
                if (!this.idiomaReposiory.findAll().isEmpty()) {
                    idiomas.setIdIdioma(this.idiomaReposiory.findAll().size() + 1);
                }else{
                    idiomas.setIdIdioma(1);
                }

                if (idioma.length() > 0) {
                    idiomas.setNombre_idioma(idioma);
                    this.idiomaReposiory.save(idiomas);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

    }

    @Override
    public Idiomas buscarIdioma(int id) {
        
        try {    
            return this.idiomaReposiory.findById(id).get();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public void actualizarIdioma(int id, String idioma) {
        try {
            if(this.idiomaReposiory.findById(id).isPresent()){
                Idiomas idiomas = this.idiomaReposiory.findById(id).get();
                idiomas.setNombre_idioma(idioma);
                this.idiomaReposiory.save(idiomas);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void eliminarIdioma(int id) {
        try {
            this.idiomaReposiory.deleteById(id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
