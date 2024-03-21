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
@Table(name = "TBL_PODCASTERS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Podcaster {
    
    @Id
    @Column(name = "id_podcaster")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPodcaster;

    private String nombre;

    private String apellido;

    private int id_podcast;
}
