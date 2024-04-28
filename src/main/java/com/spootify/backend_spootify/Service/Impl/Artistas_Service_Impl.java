package com.spootify.backend_spootify.Service.Impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.ArtistaRegisterDto;
import com.spootify.backend_spootify.Repositories.Artistas_Repository;
import com.spootify.backend_spootify.Service.Artistas_Service;

@Service
public class Artistas_Service_Impl implements Artistas_Service{

    @Autowired
    Artistas_Repository aRepository;

    @Override
    public void crearArtista(int idUsuario) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Map<String, String> obtenerDataArtista(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ArtistaRegisterDto> obtenerTodosRegister() {
        try {
            if (aRepository.obtenerArtistasRegister()!=null) {
                
                List<Object[]> artistasObject = aRepository.obtenerArtistasRegister();
                List<ArtistaRegisterDto> artistasEnviar = new LinkedList<ArtistaRegisterDto>();

                for (Object[] artista : artistasObject) {
                    ArtistaRegisterDto artistaRegister = new ArtistaRegisterDto();
                    artistaRegister.setIdArtista(artista[0].toString());
                    artistaRegister.setNombreArtista(artista[1].toString());
                    artistaRegister.setFotoArtista(artista[2].toString());
                    artistasEnviar.add(artistaRegister);
                }

                return artistasEnviar;
            }

            return null;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
