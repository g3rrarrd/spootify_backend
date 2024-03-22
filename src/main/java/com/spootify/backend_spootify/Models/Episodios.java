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
@Table(name = "TBL_EPISODIO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Episodios {
    
    @Id
    @Column(name = "id_media")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int idMedia;

    @Id
    @Column(name = "id_podcast")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int idPodcast;

    private Clob descripcion_episodio;

}
