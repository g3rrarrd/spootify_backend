package com.spootify.backend_spootify.Models;

import java.util.Date;

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
@Table(name = "TBL_HISTORIAL_CANCIONES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Historial_Canciones {
    
    @Id
    @Column(name = "id_historial_de_reproduccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistorialRepr;

    private int id_media;

    private Date fecha_reproduccion;

}
