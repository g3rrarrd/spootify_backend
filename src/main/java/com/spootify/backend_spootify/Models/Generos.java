package com.spootify.backend_spootify.Models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_GENEROS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Generos {
    
    @Id
    @Column(name = "id_genero")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGenero;

    private String nombre_genero;

    @ManyToMany
    @JoinTable(name = "TBL_GENEROS_CANCIONES", joinColumns = @JoinColumn(name = "id_genero"), inverseJoinColumns = @JoinColumn(name = "id_media"))
    private List<Canciones> canciones;
}
