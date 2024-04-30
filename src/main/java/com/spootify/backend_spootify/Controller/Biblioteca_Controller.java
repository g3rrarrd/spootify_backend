package com.spootify.backend_spootify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Dtos.bibliotecaDto;
import com.spootify.backend_spootify.Service.Impl.Biblioteca_Service_Impl;


@RestController
@RequestMapping("/biblioteca")
public class Biblioteca_Controller {
    @Autowired
    Biblioteca_Service_Impl lri;

    @GetMapping("/libraryByUser")
    public bibliotecaDto getPlaylistsView(@RequestParam int idUsuario){
        return this.lri.getLibreryView(idUsuario);
    }
}
