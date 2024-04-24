package com.spootify.backend_spootify.Dtos;

import java.util.List;

public class playlistDto {
    
    String portadaPlaylist;

    String nombrePlaylist;

    String fotoUsuario;

    String nombreUsuario;

    Boolean guardado;

    int guardados;

    String duracion;

    List<cancionDto> canciones;
}
