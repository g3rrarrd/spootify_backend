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
@Table(name = "TBL_ARTISTAS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Artistas {
    
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArtista;

    private int id_merch;

    private int oyentes_mensuales;

    private Clob biografia;

}
