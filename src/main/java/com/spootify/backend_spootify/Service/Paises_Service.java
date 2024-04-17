package com.spootify.backend_spootify.Service;

import java.util.List;
import java.util.Map;

import com.spootify.backend_spootify.Models.Paises;

public interface Paises_Service {
    
    public List<Paises> obtenerPaises();

    public Paises buscarPais(int id);

    public Map<String, String> obtenerDatos();

}
