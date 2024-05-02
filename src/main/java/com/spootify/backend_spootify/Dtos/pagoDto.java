package com.spootify.backend_spootify.Dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class pagoDto {
    
    int idUsuario;

    int idPlan;

    String titular;

    String tarjeta;

    int cvv;

    Date fechaExpiracion; 

}
