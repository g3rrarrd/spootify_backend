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

    private String nombre_luagr;

    private float latitud;

    private float longitud;

    private int id_pais;
}
