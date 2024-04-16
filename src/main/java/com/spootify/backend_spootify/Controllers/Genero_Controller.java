package com.spootify.backend_spootify.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Models.Genero;
import com.spootify.backend_spootify.Services.Impl.Genero_Service_Impl;

@RestController
@RequestMapping("/genero")
public class Genero_Controller {

    @Autowired
    private Genero_Service_Impl genero_Service_Impl;
    
    @GetMapping("/obtener")
    public List<Genero> obtenerGeneros(){
        return this.genero_Service_Impl.obtenerGeneros();
    }

    @GetMapping("/buscar")
    public Genero buscarGenero(@Param("id")int id){
        return this.genero_Service_Impl.buscarGenero(id);
    }

    @PostMapping("/insertar")
    public void insertarGenero(@RequestBody Genero genero){
        this.genero_Service_Impl.insertarGenero(genero);
    }

    @DeleteMapping("/eliminar")
    public void eliminarGenero(@Param("id") int id){
        this.genero_Service_Impl.eliminarGenero(id);
    }

}
