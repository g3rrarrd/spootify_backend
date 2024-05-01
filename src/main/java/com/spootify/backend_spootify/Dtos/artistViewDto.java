package com.spootify.backend_spootify.Dtos;

import java.util.List;

import lombok.Data;

@Data
public class artistViewDto {

    private String Nombre;

    private String Foto;

    private String Biografia;

    private String oyentesMensuales;

    private List<caratulaCancionDto> cancionesPopulares;

    private List<caratulaPlaylistDto> lanzamientosPopulares;

    private List<caratulaPlaylistDto> playlistArtista;

    private Boolean seguido;

}
