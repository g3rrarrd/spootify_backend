package com.spootify.backend_spootify.Models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_FACTURAS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Facturas {

    @Id
    @Column(name = "id_factura")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFactura;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario_Estandar usuario_estandar;

    @ManyToOne
    @JoinColumn(name = "id_plan")
    private Plan plan;

    private Date fecha_cobro;

    private float monto_cobrado;
    
}
