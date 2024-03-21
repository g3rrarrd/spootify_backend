package com.spootify.backend_spootify.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_GENEROS_MUSICALES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Genero_Musical {


    @Id
    @Column(name = "id_genero_musical")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGeneroMusical;

    @Column(name = "nombre_genero_musical")
    private String nombreGeneroMusical;

  

    
}
