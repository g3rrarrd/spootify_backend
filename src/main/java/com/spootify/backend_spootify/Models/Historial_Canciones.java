package com.spootify.backend_spootify.Models;

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
@Table(name = "TBL_HISTORIAL_CANCIONES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Historial_Canciones {
    
    @Id
    private int id_historial_reproduccion;

    @ManyToOne
    @JoinColumn(name = "id_historial_reproduccion", referencedColumnName = "id_historial_reproduccion", insertable = false, updatable = false)
    private Historial_reproduccion historial_reproduccion;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_cancion")
    private Canciones canciones;

    private Date fecha_reproduccion;

}
