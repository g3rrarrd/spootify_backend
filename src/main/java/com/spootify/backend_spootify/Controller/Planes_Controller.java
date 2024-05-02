package com.spootify.backend_spootify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Models.Plan;
import com.spootify.backend_spootify.Service.Impl.Planes_Service_impl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/planes")
public class Planes_Controller {

    @Autowired
    Planes_Service_impl planes_Service_impl;

    @GetMapping("/obtener")
    public List<Plan> obtenerPlanes() {
        return planes_Service_impl.obtenerPlanes();
    }
    
    
}
