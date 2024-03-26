package com.spootify.backend_spootify.Models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEscritor;

    private String primer_nombre;

    private String segundo_nombre;

    private String apellido;

    @ManyToMany
    @JoinTable(name = "TBL_ESCRITORES_CANCIONES", joinColumns = @JoinColumn(name = "id_escritor"), inverseJoinColumns = @JoinColumn(name = "id_creditos_musicales"))
    private List<Creditos> creditos;

}
