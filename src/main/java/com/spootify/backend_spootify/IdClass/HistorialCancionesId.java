package com.spootify.backend_spootify.IdClass;

import java.io.Serializable;

import lombok.Data;

@Data
public class HistorialCancionesId implements Serializable {
    
    private int id_historial_reproduccion;

    private int id_media;

}
