package com.spootify.backend_spootify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Dtos.pagoDto;
import com.spootify.backend_spootify.Dtos.usuarioEstandarDto;
import com.spootify.backend_spootify.Service.Impl.Usuario_Estandar_Service_Impl;

@RestController
@RequestMapping("/usuarioEstandar")
public class Usuario_Estandar_Controller {
    
    @Autowired
    Usuario_Estandar_Service_Impl uesi;

    @PostMapping("/crear")
    public boolean crearUsuario(@RequestBody usuarioEstandarDto usario){
        return this.uesi.crearUsuario(usario);
    }

    @PostMapping("/crearLista")
    public int crearLista(@RequestParam String nombre,@RequestParam String portada,@RequestParam int idUsuario,@RequestParam int idTipoLista,@RequestParam String descripcion){
        return this.uesi.crearListaReproduccion(nombre, portada, idUsuario, idTipoLista, descripcion);
    }

    @GetMapping("/contarListas")
    public int contarListas(@RequestParam int id){
        return this.uesi.cantidadListas(id);
    }

    @GetMapping("/obtenerNombreListas")
    public List<String> obtenerNombreListas(@RequestParam int id){
        return this.uesi.obtenerNombreListas(id);
    }

    @PostMapping("/cambiarPlan")
    public Boolean cambiarPlan(@RequestBody pagoDto pago){
        return this.uesi.cambiarPlan(pago);
    }
}
