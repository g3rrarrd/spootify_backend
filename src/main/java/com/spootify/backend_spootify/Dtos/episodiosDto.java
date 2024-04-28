package com.spootify.backend_spootify.Dtos;

import java.util.Date;

import lombok.Data;

@Data
public class episodiosDto {
    
    private int id;

    private String nombre;

    private String descripcion;

    private String portada;

    private String fecha_publicacion;

    private String duracion;

    private String nombrePodcast;

    private int idPodcast;
}
