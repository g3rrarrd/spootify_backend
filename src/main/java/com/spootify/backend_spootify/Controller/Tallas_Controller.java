package com.spootify.backend_spootify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Models.Tallas;
import com.spootify.backend_spootify.Service.Impl.Tallas_Service_Impl;

@RestController
@RequestMapping("/tallas")
public class Tallas_Controller {
    
    @Autowired
    Tallas_Service_Impl tsi;

    @GetMapping("/obtener")
    public List<Tallas> obtenerTallas(){
        return this.tsi.obtenerTallas();
    }

    @GetMapping("/buscar")
    public Tallas buscarTallas(@RequestParam int id){
        return this.tsi.buscarTalla(id);
    }

}
