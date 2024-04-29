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
@Table(name = "TBL_PRODUCTORES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Productores {
    
    @Id
    @Column(name = "id_productor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProductor;

    private String primer_nombre;

    private String segundo_nombre;

    private String apellido;

    @ManyToOne
    @JoinColumn(name = "id_credito")
    private Creditos credito;
}
