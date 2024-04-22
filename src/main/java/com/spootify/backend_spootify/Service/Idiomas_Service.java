package com.spootify.backend_spootify.Service;

import java.util.List;

import com.spootify.backend_spootify.Models.Idiomas;

public interface Idiomas_Service {
    
    public List<Idiomas> obtenerIdiomas();

    public Idiomas buscarIdioma(int id);

}
