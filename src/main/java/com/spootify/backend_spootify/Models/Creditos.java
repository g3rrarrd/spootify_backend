package com.spootify.backend_spootify.Models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_CREDITOS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Creditos {
   
    @Id
    @Column(name = "id_creditos_musicales")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCreditos;

    private String firma_discografica;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Artistas artistas;

    private int id_escritor;

    @OneToMany(mappedBy = "creditos")
    private List<Canciones> canciones;

    @ManyToOne
    @JoinColumn(name = "id_productor")
    private Productores productores;

    @ManyToMany(mappedBy = "creditos")
    private List<Escritores> escritores;
}
