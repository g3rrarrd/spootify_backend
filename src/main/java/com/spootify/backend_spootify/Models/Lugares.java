package com.spootify.backend_spootify.Models;

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
@Table(name = "TBL_LUGARES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Lugares {
    
    @Id
    @Column(name = "id_lugar")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int idLugar;

    private String nombre_lugar;

    private float latitud;

    private float longitud;

    @OneToMany(mappedBy = "lugares")
    private List<Eventos> eventos;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Paises paises;
}
