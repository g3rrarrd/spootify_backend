package com.spootify.backend_spootify.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_PODCAST_x_GENEROS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Podcasts_Generos {
    
    @Id
    @Column(name = "id_podcast")
    private int idPodcast;

    @Id
    @Column(name = "id_genero_podcast")
    private int idGeneroPodcast;

    @ManyToOne
    @JoinColumn(name = "id_podcast", referencedColumnName = "id_podcast", insertable = false, updatable = false)
    @JsonIgnore
    private Podcasts podcast;

    @ManyToOne
    @JoinColumn(name = "id_genero_podcast", referencedColumnName = "id_genero_podcast", insertable = false, updatable = false)
    @JsonIgnore
    private GeneroPodcast generoPodcast;


}
