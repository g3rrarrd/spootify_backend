package com.spootify.backend_spootify.Models;

import java.sql.Clob;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_PODCASTS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Podcasts {
    
    @Id
    @Column(name = "id_podcast")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPodcast;

    private String url_portada_podcast;

    private String descripcion_podcast;

    private String color;

    @OneToMany(mappedBy = "podcast")
    private List<Episodios> episodios;

    @ManyToOne
    @JoinColumn(name = "id_idioma")
    private Idiomas idiomas;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Podcaster podcasters;

    @ManyToOne
    @JoinColumn(name = "id_genero_podcast")
    private Genero_Podcast genero_podcast;
}
