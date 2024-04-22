package com.spootify.backend_spootify.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class artistaDto {
    
    private String Nombre;

    private String Foto;

    private String Biografia;

    private String FechaNacimiento;

}
