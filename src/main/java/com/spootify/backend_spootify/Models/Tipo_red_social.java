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
@Table(name = "TBL_TIPO_REDES_SOCIALES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Tipo_red_social {
    
    @Id
    @Column(name = "id_red_social")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRedSocial;

    private String nombre_red_social;

    private Clob icono_red_social;
}
