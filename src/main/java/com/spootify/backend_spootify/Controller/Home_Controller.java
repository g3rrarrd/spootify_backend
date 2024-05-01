package com.spootify.backend_spootify.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Dtos.homeDto;
import com.spootify.backend_spootify.Dtos.homeViewDto;
import com.spootify.backend_spootify.Models.Albumes;
import com.spootify.backend_spootify.Service.Impl.Home_Service_Impl;

@RestController
@RequestMapping("/home")
public class Home_Controller {
    
    @Autowired
    Home_Service_Impl hsi;

    @GetMapping("/buscar")
    public homeDto traerHome(@RequestParam int idUsuario){
        return this.hsi.traerHome(idUsuario);
    }

    @GetMapping("/inicio")
    public homeViewDto buscarAlbum(@RequestParam int id){
        return this.hsi.getHome(id);
    }

}
