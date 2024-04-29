package com.spootify.backend_spootify.Dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class caratulaCancionDto {

    BigDecimal id_cancion;

    String portadaCancion;

    String nombreCancion;

    String artistaCancion;

    String color;
}
