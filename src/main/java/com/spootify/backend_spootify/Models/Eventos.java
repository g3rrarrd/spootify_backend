package com.spootify.backend_spootify.Models;

import java.sql.Clob;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_EVENTOS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Eventos {

    @Id
    @Column(name = "id_evento")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int idEvento;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Artistas artistas;

    private int id_lugar;

    private String nombre_evento;

    private Date fecha_evento;

    private Clob url_ticket;

}
