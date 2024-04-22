package com.spootify.backend_spootify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Models.Idiomas;
import com.spootify.backend_spootify.Service.Impl.Idiomas_Service_Impl;

@RestController
@RequestMapping("/idiomas")
public class Idiomas_Controller {
    
    @Autowired
    Idiomas_Service_Impl isi;

    @GetMapping("/obtener")
    public List<Idiomas> obtenerIdiomas(){
        return this.isi.obtenerIdiomas();
    }

    @GetMapping("/buscar")
    public Idiomas buscarIdiomas(@RequestParam int id){
        return this.isi.buscarIdioma(id);
    }

}
