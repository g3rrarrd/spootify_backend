package com.spootify.backend_spootify.Dtos;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class playlistDto {
    
    BigDecimal id_playlist; 

    String portadaPlaylist;

    String nombrePlaylist;

    String fotoUsuario;

    String nombreUsuario;

    Boolean guardado;

    BigDecimal guardados;

    String duracion;

    List<caratulaCancionDto> canciones;

    String descripcion;
}
