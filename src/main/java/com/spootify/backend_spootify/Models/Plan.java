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
@Table(name = "TBL_PLANES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Plan {
    
    @Id
    @Column(name = "id_plan")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlan;

    private String nombre_plan;

    private float precio;

    private int usuarios_admitidos;

    private int duracion_plan;

}
