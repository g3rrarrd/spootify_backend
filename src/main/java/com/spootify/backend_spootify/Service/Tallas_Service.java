package com.spootify.backend_spootify.Service;

import java.util.List;

import com.spootify.backend_spootify.Models.Tallas;

public interface Tallas_Service {
    
    public List<Tallas> obtenerTallas();

    public Tallas buscarTalla(int id);

}
