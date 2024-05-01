package com.spootify.backend_spootify.Service;

import java.util.List;

import com.spootify.backend_spootify.Dtos.CancionDtoMin;

public interface Busqueda_Service {
    
    public List<CancionDtoMin> buscar(String query);

}
