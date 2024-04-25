package com.spootify.backend_spootify.Service;

import java.util.List;

import com.spootify.backend_spootify.Dtos.historialCancionDto;

public interface Historial_Canciones_Service {
    
    public List<historialCancionDto> traerHistorialCanciones(int id);

}
