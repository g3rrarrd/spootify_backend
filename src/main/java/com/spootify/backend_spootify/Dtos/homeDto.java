
package com.spootify.backend_spootify.Dtos;

import java.util.List;

import com.spootify.backend_spootify.Models.Canciones;
import com.spootify.backend_spootify.Models.Episodios;
import com.spootify.backend_spootify.Models.Listas_reproduccion;
import com.spootify.backend_spootify.Models.Usuarios;

import lombok.Data;

@Data
public class homeDto {

    private String fotoPerfil;

    private List<cancionDto> canciones;

    private List<listaReproduccionDto> mixSeguidos;

    private List<listaReproduccionDto> playlistUsuario;

    private List<podcasterDto> podcaster;
    
}