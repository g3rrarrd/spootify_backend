package com.spootify.backend_spootify.Models;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "TBL_ALBUMES_SEGUIDOS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Albumes_Seguidos {

    @Id
    @Column(name = "id_usuario")
    private int idUsuario;

    @Id
    @Column(name = "id_album")
    private int idAlbum;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @JsonIgnore
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "id_album", referencedColumnName = "id_album", insertable = false, updatable = false)
    @JsonIgnore
    private Albumes albumes;

    
}
