package com.spootify.backend_spootify.Models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_ALBUMES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Albumes {

    @Id
    @Column(name = "id_album")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlbum;

    private String nombre_album;

    private String portada;

    private Integer duracion;

    private Date fecha_lanzamiento;

    private Integer cantidad_canciones;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Artistas artistas;

    @OneToMany(mappedBy = "id_album")
    private List<Canciones> canciones;


}
