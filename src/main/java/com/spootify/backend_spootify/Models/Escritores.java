package com.spootify.backend_spootify.Models;

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
@Table(name = "TBL_ESCRITORES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Escritores {
    
    @Id
    @Column(name = "id_escritor")
    private int idEscritor;

    private String primer_nombre;

    private String segundo_nombre;

    private String apellido;

    @ManyToOne
    @JoinColumn(name = "id_credito")
    private Creditos credito;

}
