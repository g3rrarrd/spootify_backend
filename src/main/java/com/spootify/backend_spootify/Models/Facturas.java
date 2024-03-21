package com.spootify.backend_spootify.Models;

import java.util.Date;

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
@Table(name = "TBL_FACURAS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Facturas {

    @Id
    @Column(name = "id_factura")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFactura;

    private int id_usuario;

    private int id_plan;

    private Date fecha_cobro;

    private float monto_cobrado;
    
}
