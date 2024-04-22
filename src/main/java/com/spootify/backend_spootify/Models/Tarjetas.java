package com.spootify.backend_spootify.Models;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "TBL_TARJETAS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tarjetas {
    
    @Id
    @Column(name = "id_tarjeta")
    private int idTarjeta;

    private String numero_tarjeta;

    private Date fecha_expiracion;

    private int cvv;

    private String titular_tarjeta;

    @OneToMany(mappedBy = "tarjetas")
    private List<Pago_Planes> pago_Planes;
}
