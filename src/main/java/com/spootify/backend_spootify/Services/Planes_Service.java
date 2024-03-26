package com.spootify.backend_spootify.Services;

import java.util.List;

import com.spootify.backend_spootify.Models.Plan;

public interface Planes_Service {
    
    public List<Plan> obtenerPlanes();

    public void insertarPlan(Plan plan);

    public Plan buscarPlan(int id);

    public void actualizarPlan(int id, String plan, float precio);

    public void eliminarPlan(int id);
}
