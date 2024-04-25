package com.spootify.backend_spootify.Dtos;

import java.util.List;

import lombok.Data;

@Data
public class podcasterDto {

    private int id;

    private String nombre;

    private String foto;

    private List<episodiosDto> episodios;
}
