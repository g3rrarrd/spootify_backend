package com.spootify.backend_spootify.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private int idCreditos;

    private String firma_discografica;

    @ManyToOne
    @JoinColumn(name = "id_artista", referencedColumnName = "id_usuario", insertable =  false, updatable = false)
    private Artistas artistas;

    @OneToMany(mappedBy = "creditos")
    private List<Canciones> canciones;

    @ManyToOne
    @JoinColumn(name = "id_productor")
    private Productores productores;

    @OneToMany(mappedBy = "creditos")
    @JsonIgnore
    private List<Escritores_Canciones> escritores_Canciones;
}
