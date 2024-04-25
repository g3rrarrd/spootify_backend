package com.spootify.backend_spootify.Dtos;

import java.util.List;

import lombok.Data;

@Data
public class podcastDto {
    
    private int id;

    private String nombrePodcast;

    private String autor;

    private List<generoPodcastsDto> generos;

    private Integer seguido;

    private List<episodiosDto> episodios;

    private String descripcion;

    private List<podcastDto> sugerenciasPodcasts;

    private String color;

    private String portada;

}
