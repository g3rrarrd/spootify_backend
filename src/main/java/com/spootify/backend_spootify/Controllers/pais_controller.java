package com.spootify.backend_spootify.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Models.Paises;
import com.spootify.backend_spootify.Models.paisJson;
import com.spootify.backend_spootify.Services.Impl.Paises_Service_Impl;

@RestController
@RequestMapping("/paises")
public class pais_controller {

    @Autowired
    private Paises_Service_Impl paises_Service_Impl;

    @PostMapping("/insertar")
    @ResponseBody
    public void insertarPais(@RequestBody paisJson pais){
        this.paises_Service_Impl.insertarPais(pais);
    }

    @GetMapping("/obtener")
    @ResponseBody
    public List<Paises> obtenerPaises(){
        return this.paises_Service_Impl.obtenerPaises();
    }

    @GetMapping("/buscar")
    @ResponseBody
    public Map<String, String[]> buscarPaises(@Param("id") int id){
        return this.paises_Service_Impl.buscarPaises(id);
    }

    @DeleteMapping("/eliminar")
    public void eliminarPais(@Param("id")int id){
        this.paises_Service_Impl.eliminarPais(id);
    }

    @GetMapping("/nombres")
    public List<String> buscarNombres(){
        return this.paises_Service_Impl.nombrePaises();
    }
}
