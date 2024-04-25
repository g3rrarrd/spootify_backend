package com.spootify.backend_spootify.Models;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private int idAlbum;

    private String nombre_album;

    private String portada;

    private Date fecha_lanzamiento;

    private String color;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private Artistas artistas;

    @OneToMany(mappedBy = "id_album")
    @JsonIgnore
    private List<Canciones> canciones;

    @OneToMany(mappedBy = "idAlbum")
    @JsonIgnore
    private List<Albumes_Seguidos> albumesSeguidos;

}
