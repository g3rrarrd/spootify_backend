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
@Table(name = "TBL_CREDITOS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Creditos {
   
    @Id
    @Column(name = "id_creditos_musicales")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCreditos;

    private String firma_discografica;

    private int id_artista;

    private int id_escritor;

    private int id_productor;

}
