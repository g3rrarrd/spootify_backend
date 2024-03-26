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

import com.spootify.backend_spootify.Models.Genero_Musical;
import com.spootify.backend_spootify.Services.Impl.Genero_Musical_Service_Impl;

@RestController
@RequestMapping("/generomusical")
public class Genero_Musical_Controller {
    
    @Autowired
    private Genero_Musical_Service_Impl genero_Musical_Service_Impl;

    @GetMapping("/obtener")
    public List<Genero_Musical> obtenergenerosmusicales(){
        return this.genero_Musical_Service_Impl.obtenerGenerosMusicales();
    }

    @PostMapping("/colocar")
    public void colocargeneromusical(@RequestParam(name = "Genero_Musical") String Genero_Musical){
        this.genero_Musical_Service_Impl.insertargeneromusical(Genero_Musical);
    }

    @GetMapping("/obtenervalor")
    public String obtenergeneromusical(@RequestParam(name = "id_genero_musical") int id){
        return this.genero_Musical_Service_Impl.obtenergeneromusical(id);
    }

    @PutMapping("/actualizar")
    public void actualizargeneromusical(@RequestParam(name = "id")int id, @RequestParam(name = "nombre")String genero){
        this.genero_Musical_Service_Impl.actualizargeneromusical(id, genero);
    }

    @DeleteMapping("/eliminar")
    public void eliminargeneromusical(@RequestParam(name = "id")int id){
        this.genero_Musical_Service_Impl.eliminargeneromusical(id);
    }
}
