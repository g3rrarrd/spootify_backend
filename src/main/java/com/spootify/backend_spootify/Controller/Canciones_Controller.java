package com.spootify.backend_spootify.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Dtos.CancionVistaDto;
import com.spootify.backend_spootify.Service.Impl.Canciones_Service_Impl;

@RestController
@RequestMapping("/canciones")
public class Canciones_Controller {
    
    @Autowired
    Canciones_Service_Impl csi;

    @GetMapping("/obtener")
    public CancionVistaDto obtenerCancion(@RequestParam int idCancion, @RequestParam int idUsuario) {
        return csi.traerCancion(idCancion, idUsuario);
    }
    
    @PostMapping("/play")
    public boolean playSong(@RequestParam int idUsuario, @RequestParam int idMedia){
        return this.csi.playSong(idUsuario, idMedia);
    }

}
