package com.spootify.backend_spootify.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CancionVistaDto {

    private String nombre;

    private String portada;

    private String color;

    private ArtistaDtoMin artista;

    private String idAlbum;

    private int seguido;// 0 no seguido, 1 seguido

    private float duracion;

    private CreditosDto creditos;

    private String letra;

}
