package com.spootify.backend_spootify.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_LISTAS_REPRODUCCION")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Listas_reproduccion {
    
    @Id
    @Column(name = "id_lista_reproduccion")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int idListaRepr;

    private int id_usuario_propietario;

    private String nombre_lista_reproduccion;

    private Integer cantidad_canciones;

    private Integer duracion_lista_reproduccion;

}
