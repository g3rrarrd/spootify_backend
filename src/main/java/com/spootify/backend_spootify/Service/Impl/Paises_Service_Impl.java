package com.spootify.backend_spootify.Service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Models.Paises;
import com.spootify.backend_spootify.Repositories.Paises_Repository;
import com.spootify.backend_spootify.Service.Paises_Service;

@Service
public class Paises_Service_Impl implements Paises_Service{

    @Autowired
    Paises_Repository pRepository;

    @Override
    public Paises buscarPais(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, String> obtenerDatos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Paises> obtenerPaises() {
        try {
            return pRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
