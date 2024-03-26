package com.spootify.backend_spootify.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Models.Plan;
import com.spootify.backend_spootify.Repositories.Planes_Repository;
import com.spootify.backend_spootify.Services.Planes_Service;

@Service
public class Planes_Service_Impl implements Planes_Service{

    @Autowired
    private Planes_Repository planes_Repository;

    @Override
    public List<Plan> obtenerPlanes() {
        try {
            return this.planes_Repository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void insertarPlan(Plan plan) {
        try {
            Plan planes = new Plan();

            if (!this.planes_Repository.findAll().isEmpty()) {
                planes.setIdPlan(this.planes_Repository.findAll().size() + 1);
            }else{
                planes.setIdPlan(1);
            }
            if (plan.getNombre_plan().length() > 0 && plan.getPrecio() > 0 && plan.getDuracion_plan() > 0 && plan.getUsuarios_admitidos() > 0) {
                planes.setNombre_plan(plan.getNombre_plan());
                planes.setPrecio(plan.getPrecio());
                planes.setDuracion_plan(plan.getDuracion_plan());
                planes.setUsuarios_admitidos(plan.getUsuarios_admitidos());
                this.planes_Repository.save(planes);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Plan buscarPlan(int id) {
        try {
            return this.planes_Repository.findById(id).get();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void actualizarPlan(int id, String plan, float precio) {
        try {
            Plan planes = this.planes_Repository.findById(id).get();
            if (plan.length() > 0) {
                planes.setNombre_plan(plan);
            }if (precio != planes.getPrecio()) {
                planes.setPrecio(precio);
            }
            this.planes_Repository.save(planes);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminarPlan(int id) {
       try {
         this.planes_Repository.deleteById(id);
       } catch (Exception e) {
        System.err.println(e.getMessage());
       }
    }
    
}
