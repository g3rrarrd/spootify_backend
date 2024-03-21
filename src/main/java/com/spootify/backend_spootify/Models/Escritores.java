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
@Table(name = "TBL_MEDIA")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Escritores {
    
    @Id
    @Column(name = "TBL_ESCRITORES")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEscritor;

    private String primer_nombre;

    private String segundo_nombre;

    private String apellido;

}
