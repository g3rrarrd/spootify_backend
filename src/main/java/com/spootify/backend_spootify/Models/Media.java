package com.spootify.backend_spootify.Models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
    private int idMedia;

    @Column(name = "nombre_media")
    private String nombreMedia;

    @Column(name = "duracion_media")
    private Integer duracionMedia;

    @Column(name = "reproducciones_media")
    private Integer ReproduccionMedia;

    @Column(name = "fecha_publicacion")
    private Date fechaPublicacion;

    @OneToOne(mappedBy = "media")
    private Canciones canciones;

    @OneToOne(mappedBy = "media")
    private Episodios episodios;

    @ManyToOne
    @JoinColumn(name = "id_tipo_media")
    private Tipo_Media tipo_media;

}
