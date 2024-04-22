package com.spootify.backend_spootify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Models.Genero_Musical;
import com.spootify.backend_spootify.Service.Impl.Genero_Musical_Service_Impl;

@RestController
@RequestMapping("/generoMusical")
public class Genero_Musical_Controller {
    
    @Autowired
    Genero_Musical_Service_Impl gmsi;

    @GetMapping("/obtener")
    public List<Genero_Musical> obtenerGeneroM(){
        return this.gmsi.obtenerGeneros();
    }

    @GetMapping("/buscar")
    public Genero_Musical buscarGeneroM(@RequestParam int id){
        return this.gmsi.buscarGenero(id);
    }

}
