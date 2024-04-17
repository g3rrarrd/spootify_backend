package com.spootify.backend_spootify.Service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Models.Albumes;
import com.spootify.backend_spootify.Models.Artistas;
import com.spootify.backend_spootify.Models.Canciones;
import com.spootify.backend_spootify.Repositories.Albumes_Repository;
import com.spootify.backend_spootify.Repositories.Artistas_Repository;
import com.spootify.backend_spootify.Repositories.Canciones_Repository;
import com.spootify.backend_spootify.Service.Albumes_Service;

@Service
public class Albumes_Service_Impl implements Albumes_Service{

    @Autowired
    Albumes_Repository albumes_Repository;

    @Autowired
    Artistas_Repository artistas_Repository;

    @Autowired
    Canciones_Repository canciones_Repository;

    @Override
    public List<Albumes> obtenerAlbumes() {
       try {
        
            if(!this.albumes_Repository.findAll().isEmpty()){
                return this.albumes_Repository.findAll();
            }

            return null;

       } catch (Exception e) {
        e.printStackTrace();
        return null;
       }
    }

    @Override
    public Albumes buscarAlbumes(int id) {
        
        try {
            
            if(this.albumes_Repository.findById(id).isPresent()){
                return this.albumes_Repository.findById(id).get();
            }

            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public String traerPortadaAlbum(int id) {
        
        try {
            
            if(this.albumes_Repository.findById(id).isPresent()){
                return this.albumes_Repository.obtenerPortada(id);
            }

            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public String traerNombteAlbum(int id) {
       
        try {
            
            if(this.albumes_Repository.findById(id).isPresent()){
                return this.albumes_Repository.obtenerNombre(id);
            }

            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, String> traerArtistaFoto(int id) {
        
        try {
            
            if(this.albumes_Repository.findById(id).isPresent()){
            
                Map<String, String> map = new HashMap<String, String>();
                String[] artistas = this.albumes_Repository.obtenerNombreFotoArtista(id).split(",");

                map.put("Nombre", artistas[0]);
                map.put("Foto", artistas[1]);

                return map;

            }

            return null;

        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }

    }

    @Override
    public String traerLanzamientoAnio(int id) {
       
        try {
       
            if(this.albumes_Repository.findById(id).isPresent()){
                
                return this.albumes_Repository.obtenerFechaLanzamiento(id);
                
            }

            return null;

       } catch (Exception e) {
        e.printStackTrace();
        return null;
       }

    }

    @Override
    public List<Map<String,String>> traerCancionesAlbum(int id) {
       
        try {

            if(this.albumes_Repository.contarCanciones(id) > 0){
                List<String> cancionesList = this.albumes_Repository.obtenerCanciones(id);
                List<Map<String, String>> canciones = new ArrayList<Map<String, String>>();

                for (String cancion : cancionesList) {
                    String[] partesCancion = cancion.split(",");
                    Map<String, String> cancionMap = new HashMap<String, String>();
                    cancionMap.put("Nombre", partesCancion[0]);
                    cancionMap.put("Duracion", partesCancion[1]);
                    cancionMap.put("reproducciones", partesCancion[2]);
                    cancionMap.put("letra", partesCancion[3]);
                    canciones.add(cancionMap);
                }

                return canciones;
            }
            
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Date traerFechaPublicacion(int id) {
        try{
           
            if(this.albumes_Repository.findById(id).isPresent()){
                return this.albumes_Repository.findById(id).get().getFecha_lanzamiento();
            }

            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String traerDuracionAlbum(int id) {
        
        try {
            
            if(this.albumes_Repository.findById(id).isPresent()){
                return this.albumes_Repository.obtenerDuracion(id);
            }

            return null;

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }

    }

    @Override
    public int traerCantidadCacionesAlbum(int id) {
       
        try {
            return this.albumes_Repository.contarCanciones(id);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }
    
}
