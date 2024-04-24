package com.spootify.backend_spootify.Dtos;

import lombok.Data;

@Data
public class albumesDto {

    private String portadaAlbum;
    
    private String nombreAlbum;
    
    private String nombreArtista;

    private String fotoArtista;

    private String tipoLanzamiento;

    private String fechaLanzamiento;

    private int cantidadCanciones;

    private int duracionAlbum;

    private String color;

    private boolean follow;
    
}
