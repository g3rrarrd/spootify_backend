package com.spootify.backend_spootify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Dtos.ArtistaDtoMin;
import com.spootify.backend_spootify.Dtos.artistViewDto;
import com.spootify.backend_spootify.Dtos.bibliotecaDto;
import com.spootify.backend_spootify.Service.Impl.Artistas_Service_Impl;

@RestController
@RequestMapping("/artistas")
public class Artistas_Controller {
    
    @Autowired
    Artistas_Service_Impl asi;

    @GetMapping("/toregister")
    public List<ArtistaDtoMin> obtenerArtistasRegister(){
        return asi.obtenerTodosRegister();
    }

    @GetMapping("/get")
    public artistViewDto getArtistView(@RequestParam int idUsuario, @RequestParam int idArtist){
        return this.asi.getArtist(idUsuario, idArtist);
    }

}
