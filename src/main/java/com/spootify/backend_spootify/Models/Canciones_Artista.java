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
@Table(name = "TBL_CANCIONES_ARTISTAS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Canciones_Artista {
    
    @Id
    @Column(name = "id_usuario")
    private int idUsuario;

    @Id
    @Column(name = "id_media")
    private int idCanciones;

    @ManyToOne
    @JoinColumn(name = "id_media", referencedColumnName = "id_media", insertable = false, updatable = false)
    @JsonIgnore
    private Canciones canciones;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @JsonIgnore
    private Artistas artistas;

}
