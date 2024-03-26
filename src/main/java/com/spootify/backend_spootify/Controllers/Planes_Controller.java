package com.spootify.backend_spootify.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Models.Plan;
import com.spootify.backend_spootify.Services.Impl.Planes_Service_Impl;

@RestController
@RequestMapping("/planes")
public class Planes_Controller {
    
    @Autowired
    private Planes_Service_Impl planes_Service_Impl;

    @GetMapping("/obtener")
    public List<Plan> obtenerPlanes(){
        return this.planes_Service_Impl.obtenerPlanes();
    }

    @PostMapping("/insertar")
    public void insertarPlan(@RequestBody Plan plan){
        this.planes_Service_Impl.insertarPlan(plan);
    }

    @GetMapping("/buscar")
    public Plan buscarPlan(@RequestParam(name = "id") int id){
        return this.planes_Service_Impl.buscarPlan(id);
    }

    @PutMapping("/actualizar")
    public void actualizarPlan(@RequestParam(name = "id") int id, @RequestParam(name = "nombre") String nombre, @RequestParam(name = "precio") float precio){
        this.planes_Service_Impl.actualizarPlan(id, nombre, precio);
    }

    @DeleteMapping("/eliminar")
    public void eliminarPlan(@RequestParam(name = "id")int id){
        this.planes_Service_Impl.eliminarPlan(id);
    }
}
