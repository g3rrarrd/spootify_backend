package com.spootify.backend_spootify.Models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_GENERO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Genero {
    
    @Id
    @Column(name = "id_genero")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int idGenero;

    private String nombre_genero;

    @OneToMany(mappedBy = "genero")
    private List<Usuarios> usuarios;

}
