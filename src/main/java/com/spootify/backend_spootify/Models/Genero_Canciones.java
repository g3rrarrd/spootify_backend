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
@Table(name = "TBL_GENEROS_CANCIONES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Genero_Canciones {
    
    @Id
    @Column(name = "id_media")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int idMedia;

    private int id_genero;

}
