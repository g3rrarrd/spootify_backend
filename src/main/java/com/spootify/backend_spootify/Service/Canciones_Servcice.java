package com.spootify.backend_spootify.Service;

import java.util.Map;

public interface Canciones_Servcice {
    
    public String traerPortada(int id);

    public String traerNombreCancion(int id);

    public Map<String, String> traerArtistaCancion(int id);

    public Map<String, String> traerInformacionCreditos(int id);

}
