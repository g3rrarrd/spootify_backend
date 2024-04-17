package com.spootify.backend_spootify.Service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Repositories.Canciones_Repository;
import com.spootify.backend_spootify.Service.Canciones_Servcice;

@Service
public class Canciones_Service_Impl implements Canciones_Servcice{

    @Autowired
    Canciones_Repository canciones_Repository;

    @Override
    public String traerPortada(int id) {
        try {
            return this.canciones_Repository.obtenerPortada(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String traerNombreCancion(int id) {
        try {
            return this.canciones_Repository.obtenerNombreCancion(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, String> traerArtistaCancion(int id) {
        try {
            
                String[] parteArtista = this.canciones_Repository.obtenerArtista(id).split(",");
                String[] partes = {"Nombre", "Foto", "Biografia", "FechaNacimiento"};
                Map<String, String> artista = new HashMap<String, String>();

                int i = 0;

                for (String artistaInfo : parteArtista) {
                        artista.put(partes[i], artistaInfo);
                        i++;
                }

                return artista;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, String> traerInformacionCreditos(int id) {
       try {
            String[] parteCreditos = this.canciones_Repository.obtenerInfoCredito(id).split(",");
            String[] partes = {"NombreProducto", "NombreEscritor", "NombreArtista", "FirmaDiscografica"};
            Map<String, String> creditos = new HashMap<String, String>();

            int i = 0;

            for (String infoCredito : parteCreditos) {
                creditos.put(partes[i], infoCredito);
                i++;
            }

            return creditos;

       } catch (Exception e) {
        return null;
       }
    }
    
}
