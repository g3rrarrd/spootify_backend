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
@Table(name = "TBL_MEDIA")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Media {
    
    @Id
    @Column(name = "id_media")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMedia;

    @Column(name = "nombre_media")
    private String nombreMedia;

    @Column(name = "duracion_media")
    private Integer duracionMedia;

    @Column(name = "reproduccion_media")
    private Integer ReproduccionMedia;

    @Column(name = "fecha_publicacion")
    private Date fechaPublicacion;


}
