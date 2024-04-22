package com.spootify.backend_spootify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Models.Genero;
import com.spootify.backend_spootify.Service.Impl.Genero_Service_Impl;

@RestController
@RequestMapping("/genero")
public class Genero_Controller {

    @Autowired
    Genero_Service_Impl gri;

    @GetMapping("/obtener")
    public List<Genero> obtenerGenero(){
        return this.gri.obtenerGeneros();
    }

    @GetMapping("/buscar")
    public Genero buscarGenero(@RequestParam int id){
        return this.gri.buscarGenero(id);
    }
    
}