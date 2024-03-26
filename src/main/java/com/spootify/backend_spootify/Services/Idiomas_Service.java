package com.spootify.backend_spootify.Services;

import java.util.List;

import com.spootify.backend_spootify.Models.Idiomas;

public interface Idiomas_Service {
    
    public List<Idiomas> obtenerIdiomas();

    public void insertarIdioma(String idioma);

    public String buscarIdioma(int id);

    public void actualizarIdioma(int id, String idioma);

    public void eliminarIdioma(int id);

}
