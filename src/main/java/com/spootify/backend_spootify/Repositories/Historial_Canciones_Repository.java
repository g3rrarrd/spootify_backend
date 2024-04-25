package com.spootify.backend_spootify.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spootify.backend_spootify.IdClass.HistorialCancionesId;
import com.spootify.backend_spootify.Models.Historial_Canciones;

public interface Historial_Canciones_Repository extends JpaRepository<Historial_Canciones, HistorialCancionesId>{
    
}
