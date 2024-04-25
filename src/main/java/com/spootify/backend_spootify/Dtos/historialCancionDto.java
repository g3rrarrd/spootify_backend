package com.spootify.backend_spootify.Dtos;

import lombok.Data;

@Data
public class historialCancionDto {

    private cancionDto cancion;

    private String fechaEscuchada;

}
