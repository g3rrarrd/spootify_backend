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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_PAGO_PLANES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Pago_Planes {
    
    @Id
    @Column(name = "id_plan_pagado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlanPagado;

    private Date fecha_inicio_plan;

    private Date fecha_fin_plan;

    private String referencia_bancaria;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario_Estandar usuario_estandar;

    @OneToMany(mappedBy = "pago_planesmany")
    private List<Usuario_Estandar> usuario_estandarmany;

    @ManyToOne
    @JoinColumn(name = "id_plan")
    private Plan plan;

}
