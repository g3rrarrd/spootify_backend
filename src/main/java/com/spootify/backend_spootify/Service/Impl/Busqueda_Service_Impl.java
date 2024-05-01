package com.spootify.backend_spootify.Service.Impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.CancionDtoMin;
import com.spootify.backend_spootify.Repositories.Busquedas_Repository;
import com.spootify.backend_spootify.Service.Busqueda_Service;

@Service
public class Busqueda_Service_Impl implements Busqueda_Service{

    @Autowired
    Busquedas_Repository busquedas_Repository;

    @Override
    public List<CancionDtoMin> buscar(String query) {
        try {

            List<Object[]> albumes = busquedas_Repository.buscarEnAlbumes(query);
            List<Object[]> canciones = busquedas_Repository.buscarEnCanciones(query);
            List<Object[]> artistas = busquedas_Repository.buscarEnArtistas(query);

            List<CancionDtoMin> resultados = new LinkedList<CancionDtoMin>();

            for (Object[] album : albumes) {
                CancionDtoMin albumResult = new CancionDtoMin();
                albumResult.setId(album[0].toString());
                albumResult.setNombre(album[1].toString());
                albumResult.setPortada(album[2].toString());
                albumResult.setArtistaCancion(album[3].toString());
                albumResult.setTipoObjeto(1);
                resultados.add(albumResult);
            }
            
            for (Object[] cancion : canciones) {
                CancionDtoMin cancionResult = new CancionDtoMin();
                cancionResult.setId(cancion[0].toString());
                cancionResult.setNombre(cancion[1].toString());
                cancionResult.setPortada(cancion[3].toString());
                cancionResult.setArtistaCancion(cancion[2].toString());
                cancionResult.setTipoObjeto(2);
                resultados.add(cancionResult);
            }

            for (Object[] artista : artistas) {
                CancionDtoMin artistaResult = new CancionDtoMin();
                artistaResult.setId(artista[0].toString());
                artistaResult.setNombre(artista[1].toString());
                artistaResult.setPortada(artista[2].toString());
                artistaResult.setTipoObjeto(3);
                resultados.add(artistaResult);
            }

            return resultados;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    
}
