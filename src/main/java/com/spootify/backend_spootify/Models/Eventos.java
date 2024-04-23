package com.spootify.backend_spootify.Models;
import java.util.Date;

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
@Table(name = "TBL_EVENTOS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Eventos {

    @Id
    @Column(name = "id_evento")
    private int idEvento;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Artistas artistas;

    @ManyToOne
    @JoinColumn(name = "id_lugar")
    private Lugares lugares;

    private String nombre_evento;

    private Date fecha_evento;

    private String url_tickets;

}
