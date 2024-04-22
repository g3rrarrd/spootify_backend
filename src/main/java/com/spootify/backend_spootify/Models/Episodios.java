package com.spootify.backend_spootify.Models;

import java.sql.Clob;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_EPISODIO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Episodios {
    
    @Id
    private int id_episodio;

    @OneToOne
    @JoinColumn(name = "id_episodio", referencedColumnName = "id_media", insertable = false, updatable = false)
    @JsonIgnore
    private Media media;

    private String descripcion_episodio;

    @ManyToOne
    @JoinColumn(name = "id_podcast")
    private Podcasts podcast;

}
