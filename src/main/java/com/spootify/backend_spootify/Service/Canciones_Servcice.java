package com.spootify.backend_spootify.Service;

import com.spootify.backend_spootify.Dtos.artistaDto;
import com.spootify.backend_spootify.Dtos.cancionesDto;

public interface Canciones_Servcice {
    
    public String traerPortada(int id);

    public String traerNombreCancion(int id);

    public String traerColor(int id);

    public artistaDto traerArtistaCancion(int id);

    public cancionesDto traerInformacionCreditos(int id);

}
