package com.spootify.backend_spootify.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Models.Tallas;
import com.spootify.backend_spootify.Services.Impl.Tallas_Service_Impl;

@RestController
@RequestMapping("/tallas")
public class Tallas_Controller {
    
    @Autowired
    private Tallas_Service_Impl tallas_Service_Impl;

    @GetMapping("/obtener")
    public List<Tallas> obtenerTallas(){
        return this.tallas_Service_Impl.obtenerTallas();
    }

    @PostMapping("/insertar")
    public void insertarTallas(@RequestParam(name = "talla") String talla){
        this.tallas_Service_Impl.insertarTallas(talla);
    }

    @GetMapping("/buscar")
    public String buscarTalla(@RequestParam(name = "id") int id){
        return this.tallas_Service_Impl.buscarTalla(id);
    }

    @PutMapping("/actualizar")
    public void actualizarTalla(@RequestParam(name = "id")int id, @RequestParam(name = "nombre")String nombre){
        this.tallas_Service_Impl.actualizarTalla(id, nombre);
    }

    @DeleteMapping("eliminar")
    public void eliminarTalla(@RequestParam(name = "id")int id){
        this.tallas_Service_Impl.eliminarTalla(id);
    }

}
