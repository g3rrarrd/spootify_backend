package com.spootify.backend_spootify.Dtos;

import lombok.Data;

@Data
public class cancionDto {

    private int idCancion;

    private artistaDto artista;

    private String nombreCancion;

    private String idioma;

    private String generoMusical;

    private String letraCancion;

    private int duracionMedia;

    private Integer reproduccionesMedia;

    private String portada;
    
}