package com.spootify.backend_spootify.Models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_USUARIO_ESTANDAR")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Usuario_Estandar {
    
    @Id
    private int id_usuario;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "id_historial_de_reproduccion")
    private Historial_reproduccion hisotrial_reproduccion;

    @OneToMany(mappedBy = "usuario_estandar")
    private List<Facturas> facturas;

    @OneToMany(mappedBy = "usuario_estandar")
    private List<Listas_reproduccion> listas_reproduccions;

    @OneToOne (mappedBy = "usuario_estandar")
    private Pago_Planes pago_planes;

    @OneToMany(mappedBy = "usuario_estandar")
    private List<Listas_seguidas> listas_seguidas;

}
