package com.spootify.backend_spootify.Models;

import java.sql.Date;

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
@Data
@Table(name = "TBL_SEGUIDORES")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seguidores {
    
    @Id
    private int id_usuario_seguidor;

    @Id
    private int id_usuario_seguido;

    private Date fecha_seguimiento;

    @ManyToOne
    @JoinColumn(name = "id_usuario_seguidor", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    private Usuarios usuarios1;

    @ManyToOne
    @JoinColumn(name = "id_usuario_seguido", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    private Usuarios usuarios2;
}
