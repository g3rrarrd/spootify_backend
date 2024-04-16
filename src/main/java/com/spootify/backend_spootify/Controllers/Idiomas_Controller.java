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

import com.spootify.backend_spootify.Models.Idiomas;
import com.spootify.backend_spootify.Services.Impl.Idiomas_Service_Impl;

@RestController
@RequestMapping("/idiomas")
public class Idiomas_Controller {
    
    @Autowired
    private Idiomas_Service_Impl idiomas_Service_Impl;

    @GetMapping("/obtener")
    public List<Idiomas> obtenerIdiomas(){
        return this.idiomas_Service_Impl.obtenerIdiomas();
    }

    @PostMapping("/insertar")
    public void insertarIdioma(@RequestParam(name = "idioma") String idioma){
        this.idiomas_Service_Impl.insertarIdioma(idioma);
    }

    @GetMapping("/buscar")
    public Idiomas buscarIdioma(@RequestParam(name = "id") int id){
        return this.idiomas_Service_Impl.buscarIdioma(id);
    }

    @PutMapping("/actualizar")
    public void actualizarIdioma(@RequestParam(name = "id")int id, @RequestParam(name = "nombre")String idioma ){
        this.idiomas_Service_Impl.actualizarIdioma(id, idioma);
    }

    @DeleteMapping("/eliminar")
    public void eliminarIdioma(@RequestParam(name = "id")int id){
        this.idiomas_Service_Impl.eliminarIdioma(id);
    }

}
