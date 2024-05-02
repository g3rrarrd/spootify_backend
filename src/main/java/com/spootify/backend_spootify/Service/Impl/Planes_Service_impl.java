package com.spootify.backend_spootify.Service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Models.Plan;
import com.spootify.backend_spootify.Repositories.Planes_Repository;
import com.spootify.backend_spootify.Service.Planes_Service;

@Service
public class Planes_Service_impl implements Planes_Service{

    @Autowired
    Planes_Repository pRepository;

    @Override
    public List<Plan> obtenerPlanes() {
        return pRepository.findAll();
    }

    @Override
    public Plan buscarPlan(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPlan'");
    }

    @Override
    public int obtenerIdPlan(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerIdPlan'");
    }

    @Override
    public Map<String, String> obtenerDatosPlan(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerDatosPlan'");
    }
    
}
