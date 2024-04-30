package com.spootify.backend_spootify.Dtos;

import java.util.List;

import lombok.Data;

@Data
public class bibliotecaDto {
    String fotoUsuario;

    List<caratulaPlaylistDto> playlists;

    List<caratulaPlaylistDto> podcasts;
}
