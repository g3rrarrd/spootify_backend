package com.spootify.backend_spootify.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/obtenerAlbumes")
    public List<Albumes> obtenerAlbumes(){
        return this.asi.obtenerAlbumes();
    }

    @GetMapping("/buscarAlbumes")
    public Albumes buscarAlbum(@RequestParam int id){
        return this.asi.buscarAlbumes(id);
    }

    @GetMapping("/buscarPortada")
    public String traerPortadaAlbum(@RequestParam int id){
        return this.asi.traerPortadaAlbum(id);
    }

    @GetMapping("/buscarNombre")
    public String traerNombreAlbum(@RequestParam int id){
        return this.asi.traerNombteAlbum(id);
    }

    @GetMapping("/buscarArtista")
    public albumesDto traerArtistaFoto(@RequestParam int id){
        return this.asi.traerArtistaFoto(id);
    }

    @GetMapping("/buscarFecha")
    public String traerLanzamientoAnio(@RequestParam int id){
        return this.asi.traerLanzamientoAnio(id);
    }

    @GetMapping("/buscarCanciones")
    public List<albumesDto> trearCancionesAlbumm(@RequestParam int id){
        return this.asi.traerCancionesAlbum(id);
    }

    @GetMapping("/buscarFechaPublicacion")
    public Date traerFechaLanzamiento(@RequestParam int id){
        return this.asi.traerFechaPublicacion(id);
    }

    @GetMapping("/buscarDuracion")
    public String traerDuracionAlbum(@RequestParam int id){
        return this.asi.traerDuracionAlbum(id);
    }

    @GetMapping("buscarCantidadCanciones")
    public int traerCantidadCancionesAlbum(@RequestParam int id){
        return this.asi.traerCantidadCacionesAlbum(id);
    }

}
