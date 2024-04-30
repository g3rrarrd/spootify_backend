package com.spootify.backend_spootify.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Dtos.perfilDto;
import com.spootify.backend_spootify.Dtos.usuarioSeguiDto;
import com.spootify.backend_spootify.Service.Impl.Usuarios_Service_Impl;

@RestController
@RequestMapping("/usuario")
public class Usuario_Controler {
    
    @Autowired
    Usuarios_Service_Impl usi;

    @GetMapping("/validar")
    public String seguirUsuario(@RequestParam String correo, @RequestParam String contrasenia){
        return this.usi.validarUsuario(correo, contrasenia);
    }

    @PostMapping("/seguir")
    public void seguirUsuario(@RequestParam int idSeguidor, @RequestParam int idSeguido){
        this.usi.seguirUsuario(idSeguidor, idSeguido);
    }

    @DeleteMapping("/dejarSeguir")
    public void dejarSeguirUsuario(@RequestParam int idSeguidor, @RequestParam int idSeguido){
        this.usi.dejarSeguir(idSeguidor, idSeguido);
    }

    @GetMapping("/seguidos")
    public int seguidos(@RequestParam int id){
        return this.usi.numeroSeguidos(id);
    }

    @GetMapping("/seguidores")
    public int seguidores(@RequestParam int id){
        return this.usi.numeroSeguidores(id);
    }

    @GetMapping("/nombreSeguidores")
    public List<usuarioSeguiDto> nombreSeguidores(@RequestParam int id){
        return this.usi.traerSeguidores(id);
    }

    @GetMapping("/nombreSeguidos")
    public List<usuarioSeguiDto> nombreSeguidos(@RequestParam int id){
        return this.usi.traerSeguidos(id);
    }

    @GetMapping("/perfil")
    public perfilDto traerPerefil(@RequestParam int id){
        return this.usi.traerPerfil(id);
    }

}
