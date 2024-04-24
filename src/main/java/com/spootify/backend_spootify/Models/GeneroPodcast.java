package com.spootify.backend_spootify.Models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "TBL_GENERO_PODCAST")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneroPodcast {
    
    @Id
    @Column(name = "id_genero_podcast")
    private int idGeneroPodcast;

    private String genero_podcast;

    @OneToMany(mappedBy = "generoPodcast")
    private List<Podcasts_Generos> podcasts;

}
