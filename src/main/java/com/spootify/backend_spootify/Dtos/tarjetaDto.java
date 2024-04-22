package com.spootify.backend_spootify.Dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class tarjetaDto {

    private int id;

    private String numerTarjeta;

    private Date fehcaExpiracion;

    private int cvv;

    private String titular;
    
}
