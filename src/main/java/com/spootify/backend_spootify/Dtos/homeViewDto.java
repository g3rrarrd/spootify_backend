package com.spootify.backend_spootify.Dtos;

import java.util.List;

import lombok.Data;

@Data
public class homeViewDto {

    private String fotoPerfil;

    private List<caratulaPlaylistDto> cancionesRecientes;

    private List<caratulaPlaylistDto> mixSeguidos;

    private List<caratulaPlaylistDto> tops;

    private List<caratulaPlaylistDto> podcasts;
    
}
