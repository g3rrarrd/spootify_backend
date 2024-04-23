package com.spootify.backend_spootify.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "TBL_CANCIONES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Canciones {

    @Id
    private int id_cancion;

    @OneToOne
    @JoinColumn(name = "id_media", referencedColumnName = "id_media", insertable = false, updatable = false)
    @JsonIgnore
    private Media media;

    private String letra_cancion;

    @ManyToOne
    @JoinColumn(name = "id_genero_musical")
    @JsonIgnore
    private Genero_Musical genero_musical;

    @ManyToOne
    @JoinColumn(name = "id_album")
    @JsonIgnore
    private Albumes id_album;

    @ManyToOne
    @JoinColumn(name = "id_artista")
    @JsonIgnore
    private Artistas artistas;

    @ManyToOne
    @JoinColumn(name = "id_idioma")
    @JsonIgnore
    private Idiomas idiomas;

    @OneToMany(mappedBy = "canciones")
    @JsonIgnore
    private List<Canciones_Artista> canciones_Artista;
 
    @OneToMany(mappedBy = "canciones")
    @JsonIgnore
    private List<Historial_Canciones> historial_canciones;

    @OneToMany(mappedBy = "canciones")
    @JsonIgnore
    private List<Listas_Canciones> listas_Canciones;
    
}
