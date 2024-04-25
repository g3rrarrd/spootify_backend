package com.spootify.backend_spootify.Models;

import java.util.Date;

import com.spootify.backend_spootify.IdClass.HistorialCancionesId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
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
@IdClass(HistorialCancionesId.class)
public class Historial_Canciones {
    
    @Id
    private int id_historial_reproduccion;

    @Id
    private int id_media;

    @ManyToOne
    @JoinColumn(name = "id_historial_reproduccion", referencedColumnName = "id_historial_reproduccion", insertable = false, updatable = false)
    private Historial_reproduccion historial_reproduccion;

    @ManyToOne
    @JoinColumn(name = "id_media", referencedColumnName = "id_cancion", insertable = false, updatable = false)
    private Canciones canciones;

    private Date fecha_reproduccion;

}
