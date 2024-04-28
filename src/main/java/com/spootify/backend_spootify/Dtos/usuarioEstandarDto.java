package com.spootify.backend_spootify.Dtos;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class usuarioEstandarDto {
    
    private String correo;

    private String contrasenia;

    private String nombre;

    private String idGenero;

    private String idPlan;
    
    private Date fecha_nacimiento;

    private String foto;

    private String idPais;

    private tarjetaDto tarjeta;

    private List<Integer> idArtistaSeguidos;
}
