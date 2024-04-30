package com.spootify.backend_spootify.Dtos;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class historialCancionDto {

    private String fechaEscuchada;

    private List<CancionDtoMin> canciones;

}
