package com.spootify.backend_spootify.Services;

import java.util.List;

import com.spootify.backend_spootify.Models.Tallas;

public interface Tallas_Service {
    
    public List<Tallas> obtenerTallas();

    public void insertarTallas(String talla);

    public String buscarTalla(int id);

    public void actualizarTalla(int id, String nombre);

    public void eliminarTalla(int id);
}
