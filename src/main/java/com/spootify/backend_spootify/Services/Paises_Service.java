package com.spootify.backend_spootify.Services;

import java.util.List;
import java.util.Map;

import com.spootify.backend_spootify.Models.Paises;
import com.spootify.backend_spootify.Models.paisJson;

public interface Paises_Service {
    
    public void insertarPais(paisJson pais);

    public void eliminarPais(int id);

    public List<Paises> obtenerPaises();

    public Map<String, String[]> buscarPaises(int id);

    public List<String> nombrePaises();

}
