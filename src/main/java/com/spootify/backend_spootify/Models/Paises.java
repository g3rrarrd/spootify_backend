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
@Table(name = "TBL_PAISES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Paises {
    
    @Id
    @Column(name = "id_pais")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPais;

    private String nombre_pais;

    private String abreviacion_pais;

    private Clob icono_pais;

    @ManyToOne
    @JoinColumn(name = "id_idioma")
    private Idiomas idiomas;

    @OneToMany(mappedBy = "paises")
    private List<Lugares> lugares;

    @OneToMany(mappedBy = "pais")
    private List<Usuarios> usuarios;

}
