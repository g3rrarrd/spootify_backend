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
    @ManyToOne
    @JoinColumn(name = "id_historial_repr")
    private Historial_reproduccion historial_reproduccion;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_media")
    private Canciones canciones;

    private Date fecha_reproduccion;

}