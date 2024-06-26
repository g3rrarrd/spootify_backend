package com.spootify.backend_spootify.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArtistaDtoMin {
    
    private String idArtista;
    
    private String nombreArtista;

    private String fotoArtista;

}
