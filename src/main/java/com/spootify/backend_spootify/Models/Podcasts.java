package com.spootify.backend_spootify.Models;

import java.sql.Clob;

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
@Table(name = "TBL_PODCASTS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Podcasts {
    
    @Id
    @Column(name = "id_podcast")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPodcast;

    private String url_portada_podcast;

    private Clob descripcion_podcast;

    private int id_idioma;

}
