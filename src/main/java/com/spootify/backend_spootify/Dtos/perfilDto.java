package com.spootify.backend_spootify.Dtos;

import java.util.List;

import lombok.Data;

@Data
public class perfilDto {
    
    private String nombre;

    private String url_foto_perfil;

    private int cantidadSeguidores;

    private int CantidadSeguidos;

    private int idTipoPlan;

    private List<listaReproduccionDto> PlaylistCreadas;

}
