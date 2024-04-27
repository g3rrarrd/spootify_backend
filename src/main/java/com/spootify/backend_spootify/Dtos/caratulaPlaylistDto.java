package com.spootify.backend_spootify.Dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class caratulaPlaylistDto {
    
    BigDecimal id_Playlist;

    String nombrePlaylist;

    String portadaPlaylist;
    
    String Descripcion;

}
