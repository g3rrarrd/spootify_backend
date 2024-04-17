package com.spootify.backend_spootify.Service;

import java.util.List;
import java.util.Map;

import com.spootify.backend_spootify.Models.Tipo_red_social;

public interface Tipo_red_social_Service {
    
    public List<Tipo_red_social> obtenerRedSocial();

    public Tipo_red_social buscarRedSocial(int id);

    public Map<String, String> obtenerDatosRedSocial(int id);

    public int obtenerIdRedSocial(String nombre);
}
