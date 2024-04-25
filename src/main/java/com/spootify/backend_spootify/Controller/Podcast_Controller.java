package com.spootify.backend_spootify.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Dtos.podcastDto;
import com.spootify.backend_spootify.Service.Impl.Podcasts_Service_Impl;

@RestController
@RequestMapping("/podcast")
public class Podcast_Controller {
    
    @Autowired 
    Podcasts_Service_Impl psi;

    @GetMapping("/buscar")
    public podcastDto buscarPodcast(@RequestParam int idPodcast,@RequestParam int idUsuario){
        return this.psi.traerPodcast(idPodcast, idUsuario);
    }

}
