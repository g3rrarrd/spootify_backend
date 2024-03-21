package com.spootify.backend_spootify.Models;

import java.util.Date;

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
@Table(name = "TBL_LISTAS_SEGUIDAS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Listas_seguidas {
    
    @Id
    @Column(name = "id_lista_reproduccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idListaRepr;

    private Date fecha_seguimiento;

    private int id_usuario;

    private int id_rol;

}
