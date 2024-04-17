package com.spootify.backend_spootify.Service;

import java.util.List;
import java.util.Map;

import com.spootify.backend_spootify.Models.Plan;

public interface Planes_Service {
    
    public List<Plan> obtenerPlanes();

    public Plan buscarPlan(int id);

    public int obtenerIdPlan(String nombre);

    public Map<String, String> obtenerDatosPlan(int id);

    

}
