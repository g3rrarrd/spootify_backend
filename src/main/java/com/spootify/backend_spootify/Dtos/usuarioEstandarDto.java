package com.spootify.backend_spootify.Dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class usuarioEstandarDto {
    
    private int id;

    private int genero;

    private int idPlan;

    private String correo;

    private String nombre;

    private Date fecha_nacimiento;

    private Date fecha_registro;

    private String foto;

    private String contrasenia;

    private int pais;

    private tarjetaDto tarjeta;

    private String paisNombre;
    
    private String planTipo;

    private String tipoUsuario;

    private String generoTipo;

    private String referenciaBancaria;

}
