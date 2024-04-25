package com.spootify.backend_spootify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Dtos.historialCancionDto;
import com.spootify.backend_spootify.Service.Impl.Historial_Canciones_Service_Impl;

@RestController
@RequestMapping("/historialCanciones")
public class Historial_Canciones_Controller {
    
    @Autowired
    Historial_Canciones_Service_Impl hcsi;

    @GetMapping("/buscar")
    public List<historialCancionDto> traerHistorialCanciones(@RequestParam int idUsuario){
        return this.hcsi.traerHistorialCanciones(idUsuario);
    }

}
