package com.spootify.backend_spootify.Dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class cancionesDto {
    
    public String productor;

    public String artista;

    public String firmaDiscografica;

    public List<String> escritores;

}
