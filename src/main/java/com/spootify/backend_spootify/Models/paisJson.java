package com.spootify.backend_spootify.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class paisJson {

    private String nombre_pais;

    private String abreviacion_pais;

    private String url_pais;

    private int idioma;
}
