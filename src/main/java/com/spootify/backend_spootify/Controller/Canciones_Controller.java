package com.spootify.backend_spootify.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Service.Impl.Canciones_Service_Impl;

@RestController
@RequestMapping("/canciones")
public class Canciones_Controller {
    
    @Autowired
    Canciones_Service_Impl csi;

    @GetMapping("/traerPortada")
    public String traerPortada(@RequestParam int id){
        return this.csi.traerPortada(id);
    }

    @GetMapping("/traerNombre")
    public String traerNombreCancion(@RequestParam int id){
        return this.csi.traerNombreCancion(id);
    }

    @GetMapping("/traerArtista")
    public Map<String,String> traerArtistaCancion(@RequestParam int id){
        return this.csi.traerArtistaCancion(id);
    }

    @GetMapping("/traerCreditos")
    public Map<String, String> traerInformacionCreditos(@RequestParam int id){
        return this.csi.traerInformacionCreditos(id);
    }

}
