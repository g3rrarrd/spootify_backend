package com.spootify.backend_spootify.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CancionDtoMin {

    private String id;
    
    private String nombre;

    private String artistaCancion;

    private String portada;
    
    private int tipoObjeto;
}
