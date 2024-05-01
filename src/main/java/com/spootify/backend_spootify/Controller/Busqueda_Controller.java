package com.spootify.backend_spootify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Dtos.CancionDtoMin;
import com.spootify.backend_spootify.Service.Impl.Busqueda_Service_Impl;

@RestController
@RequestMapping("/buscador")
public class Busqueda_Controller {
    
    @Autowired
    Busqueda_Service_Impl Bsi;

    @GetMapping("/buscar")
    public List<CancionDtoMin> getPlaylistsView(@RequestParam String query){
        return this.Bsi.buscar(query);
    }
    
}
