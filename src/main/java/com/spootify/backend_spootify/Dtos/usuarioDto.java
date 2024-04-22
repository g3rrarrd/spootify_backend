package com.spootify.backend_spootify.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class usuarioDto {
    
    private String fotoPerfil;

    private String nombreUsuario;

    private int cantidadSeguidores;

    private int cantidadSeguidos;

    private int playlistCreadas;

}
