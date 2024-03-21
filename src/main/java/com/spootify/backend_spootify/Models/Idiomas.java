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
@Table(name = "TBL_IDIOMAS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Idiomas {
    
    @Id
    @Column(name = "id_idioma")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIdioma;

    private String nombre_idioma;

}
