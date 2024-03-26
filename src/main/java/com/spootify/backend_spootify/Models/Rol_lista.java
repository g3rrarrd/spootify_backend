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
@Table(name = "TBL_ROL_LISTA_R")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Rol_lista {
    
    @Id
    @Column(name = "id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    private String nombre_rol;

    @OneToMany(mappedBy = "rol")
    private List<Listas_seguidas> listas_seguidas;
}
