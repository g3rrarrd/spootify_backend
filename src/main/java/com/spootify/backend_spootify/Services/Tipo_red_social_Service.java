package com.spootify.backend_spootify.Services;

import java.util.List;
import java.util.Map;

import com.spootify.backend_spootify.Models.Tipo_red_social;
import com.spootify.backend_spootify.Models.red_social;

public interface Tipo_red_social_Service {
    
    public void insertarRedSocial(red_social red_social);

    public  Map<String, String> obtenerRedSocial (int id);

    public Map<String, String> obtenerRedesSociales ();

    public void eliminarRedSocial(int id);

    public void actualizarRedSocial(int id, red_social red_social);

}
