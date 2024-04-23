package com.spootify.backend_spootify.Models;

import java.sql.Clob;
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
@Table(name = "TBL_MERCH")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Merch {
    
    @Id
    @Column(name = "id_merch")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMerch;

    private String nombre_merch;

    private String descripcion_merch;

    private float precio_merch;

    private int stock_merch;

    private int id_artista;

    @ManyToOne
    @JoinColumn(name = "id_artista", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    private Artistas artistas;

    @ManyToOne
    @JoinColumn(name = "id_talla")
    private Tallas tallas;

}
