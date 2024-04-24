package com.spootify.backend_spootify.Dtos;

import lombok.Data;

@Data
public class listaReproduccionDto {

    private int idLista;

    private int idUsuarioPropietario;

    private String nombreLista;

    private String portadaLista;

    private String tipoLista;

    private String descripcionLista;
    
}
