package com.spootify.backend_spootify.Dtos;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class historialCanciones {
    
    private Date fecha;

    private List<listaReproduccionDto> canciones;

}
