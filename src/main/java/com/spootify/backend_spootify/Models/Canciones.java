package com.spootify.backend_spootify.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "TBL_CANCIONES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Canciones {
    
    @Id
    @Column(name = "id_media")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCanciones;

    private String letra_cancion;

    private int id_album;

    private int id_genero_musical;

    private int id_creditos_musicales;

    private int id_usuario;

    private int id_idioma;
    
}
