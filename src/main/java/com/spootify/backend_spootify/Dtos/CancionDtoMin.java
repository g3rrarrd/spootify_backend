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

    private String idCancion;
    
    private String nombreCancion;

    private String artistaCancion;

    private String portada;
    
}
