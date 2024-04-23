package com.spootify.backend_spootify.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "TBL_LISTAS_Y_CANCIONES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Listas_Canciones {
    
    @Id
    @Column(name = "id_lista_reproduccion")
    private int idListaRepr;

    @Id
    @Column(name = "id_cancion")
    private int idCanciones;

    @ManyToOne
    @JoinColumn(name = "id_cancion", referencedColumnName = "id_cancion", insertable = false, updatable = false)
    @JsonIgnore
    private Canciones canciones;

    @ManyToOne
    @JoinColumn(name = "id_lista_reproduccion", referencedColumnName = "id_lista_reproduccion", insertable = false, updatable = false)
    @JsonIgnore
    private Listas_reproduccion listas_reproduccion;

}
