package com.spootify.backend_spootify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Dtos.usuarioEstandarDto;
import com.spootify.backend_spootify.Service.Impl.Usuario_Estandar_Service_Impl;

@RestController
@RequestMapping("usuarioEst")
public class Usuario_Estandar_Controller {
    
    @Autowired
    Usuario_Estandar_Service_Impl uesi;

    @PostMapping("/crear")
    public void crearUsuario(@RequestBody usuarioEstandarDto usario){
        this.uesi.crearUsuario(usario);
    }

    @GetMapping("/validar")
    public usuarioEstandarDto validarUsuario(@RequestParam String correo, @RequestParam String contrasenia){
        return this.uesi.validarUsuario(correo,contrasenia);
    }

    @PostMapping("/crearLista")
    public void crearLista(@RequestParam String nombre,@RequestParam int id){
        this.uesi.crearListaReproduccion(nombre, id);
    }

    @GetMapping("/contarListas")
    public int contarListas(@RequestParam int id){
        return this.uesi.cantidadListas(id);
    }

    @GetMapping("/obtenerNombreListas")
    public List<String> obtenerNombreListas(@RequestParam int id){
        return this.uesi.obtenerNombreListas(id);
    }
}
