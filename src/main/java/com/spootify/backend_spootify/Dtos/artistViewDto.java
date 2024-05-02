package com.spootify.backend_spootify.Dtos;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class artistViewDto {

    private BigDecimal idArtista;

    private String Nombre;

    private String Foto;

    private String Biografia;

    private BigDecimal oyentesMensuales;

    private List<caratulaCancionDto> cancionesPopulares;

    private caratulaPlaylistDto ultimoLanzamiento;

    private List<caratulaPlaylistDto> lanzamientosPopulares;

    private List<caratulaPlaylistDto> playlistArtista;

    private Boolean seguido;

    private String color;

}
