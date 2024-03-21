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
@Table(name = "TBL_HISTORiAL_REPRODUCCION")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Historial_reproduccion {
    
    @Id
    @Column(name = "id_historial_de_reproduccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_HistorialRepr;


}
