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
@Table(name = "TBL_TALLAS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Tallas {
    
    @Id
    @Column(name = "id_talla")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTalla;

    private String nombre_talla;

}
