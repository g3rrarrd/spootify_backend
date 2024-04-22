package com.spootify.backend_spootify.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_ESCRITORES_Y_CANCIONES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Escritores_Canciones {
    
    @Id
    @Column(name = "id_escritor")
    private int idEscritor;

    @Id
    @Column(name = "id_creditos_musicales")
    private int idCreditos;

    @ManyToOne
    @JoinColumn(name = "id_escritor", referencedColumnName = "id_escritor", insertable = false, updatable = false)
    @JsonIgnore
    private Escritores escritores;

    @ManyToOne
    @JoinColumn(name = "id_escritor", referencedColumnName = "id_creditos_musicales", insertable = false, updatable = false)
    @JsonIgnore
    private Creditos creditos;
}
