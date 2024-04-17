package com.spootify.backend_spootify.Models;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class albumJson {
    
    private String nombre_album;

    private String portada;

    private Integer duracion;

    private Date fecha_lanzamiento;

    private Integer cantidad_canciones;

    private int idArtista;

}
