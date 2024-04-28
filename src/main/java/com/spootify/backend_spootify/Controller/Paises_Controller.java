package com.spootify.backend_spootify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.spootify.backend_spootify.Models.Paises;
import com.spootify.backend_spootify.Service.Impl.Paises_Service_Impl;


@RestController
@RequestMapping("/paises")
public class Paises_Controller {
    
    @Autowired
    Paises_Service_Impl pImpl;

    @GetMapping("/obtener")
    public List<Paises> obtenerPaises() {
        return this.pImpl.obtenerPaises();
    }
    
}
