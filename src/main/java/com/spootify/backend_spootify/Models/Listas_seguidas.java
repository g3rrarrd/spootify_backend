package com.spootify.backend_spootify.Models;

import java.util.Date;

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
@Table(name = "TBL_LISTAS_SEGUIDAS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Listas_seguidas {
    
    @Id
    private int id_lista_reproduccion;

    private Date fecha_seguimiento;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario_Estandar usuario_estandar;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol_lista rol;

    @ManyToOne
    @JoinColumn(name = "id_lista_reproduccion", referencedColumnName = "id_lista_reproduccion", insertable = false, updatable = false)
    private Listas_reproduccion lista_reproduccion;
}
