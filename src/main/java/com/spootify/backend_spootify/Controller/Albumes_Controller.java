package com.spootify.backend_spootify.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spootify.backend_spootify.Dtos.albumesDto;
import com.spootify.backend_spootify.Models.Albumes;
import com.spootify.backend_spootify.Service.Impl.Albumes_Service_Impl;

@RestController
@RequestMapping("/albumes")
public class Albumes_Controller {
    
    @Autowired
    Albumes_Service_Impl asi;

    @GetMapping("/obtenerInfoAlbum")
    public albumesDto obtenerInfoAlbum(@RequestParam int idAlbum, @RequestParam int idUsuario){
        return this.asi.traerInfoAlbum(idAlbum, idUsuario);
    }

    @PostMapping("/followAlbum")
    public boolean seguirAlbum(@RequestParam int idAlbum, @RequestParam int idUsuario){
        return this.asi.seguirAlbum(idAlbum, idUsuario);
    }

    @PostMapping("/unfollowAlbum")
    public boolean dejarSeguirAlbum(@RequestParam int idAlbum, @RequestParam int idUsuario){
        return this.asi.dejarSeguirAlbum(idAlbum, idUsuario);
    }

    @GetMapping("/obtenerAlbumes")
    public List<Albumes> obtenerAlbumes(){
        return this.asi.obtenerAlbumes();
    }

    @GetMapping("/buscarAlbumes")
    public Albumes buscarAlbum(@RequestParam int id){
        return this.asi.buscarAlbumes(id);
    }

    @GetMapping("/buscarCanciones")
    public List<albumesDto> trearCancionesAlbumm(@RequestParam int id){
        return this.asi.traerCancionesAlbum(id);
    }

}
