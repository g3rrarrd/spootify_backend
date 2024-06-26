package com.spootify.backend_spootify.Models;

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

    @ManyToOne
    @JoinColumn(name = "id_usuario_propietario")
    private Usuario_Estandar usuario_estandar;

    private String nombre_lista_reproduccion;

    private String descripcion;

    @OneToMany(mappedBy = "listas_reproduccion")
    private List<Listas_Canciones> listas_Canciones;

    @OneToMany(mappedBy = "lista_reproduccion")
    private List<Listas_seguidas> listas_seguidas;

}
