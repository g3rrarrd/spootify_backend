package com.spootify.backend_spootify.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Dtos.episodiosDto;
import com.spootify.backend_spootify.Service.Impl.Episodio_Service_Impl;

@RestController
@RequestMapping("/episodio")
public class Episodios_Controller {
    
    @Autowired
    Episodio_Service_Impl esi;

    @GetMapping("/buscar")
    public episodiosDto traerEpisodio(@RequestParam int id){
        return this.esi.traerEpisodio(id);
    }

}
