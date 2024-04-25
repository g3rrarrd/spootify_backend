package com.spootify.backend_spootify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Dtos.playlistDto;
import com.spootify.backend_spootify.Dtos.caratulaPlaylistDto;
import com.spootify.backend_spootify.Service.Impl.Listas_Reproduccion_Impl;

@RestController
@RequestMapping("/listas")
public class Listas_Reproduccion_Controller {
    

    @Autowired
    Listas_Reproduccion_Impl lri;

    @GetMapping("/playlist")
    public playlistDto obtenerPlaylist(){
        return this.lri.obtenerPlaylistsTopGlobal();
    }

    @GetMapping("/playlistsByUserId")
    public List<caratulaPlaylistDto> traerNombreAlbum(@RequestParam int id){
        return this.lri.obtenerPlaylistCreadas(id);
    }

    @GetMapping("/playlistsByid")
    public playlistDto getPlaylistViewById(@RequestParam int id){
        return this.lri.getPlaylistById(id);
    }
}
