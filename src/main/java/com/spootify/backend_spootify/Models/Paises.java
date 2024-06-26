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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.sql.BLOB;

@Entity
@Table(name = "TBL_PAISES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Paises {
    
    @Id
    @Column(name = "id_pais")
    private int idPais;

    private String nombre_pais;

    private String abreviacion_pais;

    private String icono_pais;

    @ManyToOne
    @JoinColumn(name = "id_idioma")
    @JsonIgnore
    private Idiomas idiomas;

    @OneToMany(mappedBy = "paises")
    @JsonIgnore
    private List<Lugares> lugares;

    @OneToMany(mappedBy = "pais")
    @JsonIgnore
    private List<Usuarios> usuarios;

}
