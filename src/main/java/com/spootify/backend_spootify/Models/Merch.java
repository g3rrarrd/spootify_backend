package com.spootify.backend_spootify.Models;

import java.sql.Clob;

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

    private int id_talla;

    private String nombre_merch;

    private Clob descripcion_merch;

    private Number precio_merch;

    private Number stock_merch;

}
