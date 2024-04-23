package com.spootify.backend_spootify.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.artistaDto;
import com.spootify.backend_spootify.Dtos.cancionesDto;
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
    public artistaDto traerArtistaCancion(int id) {
        try {
            
                String[] parteArtista = this.canciones_Repository.obtenerArtista(id).split(",");
                artistaDto artista = new artistaDto();

                artista.setNombre(parteArtista[0]);
                artista.setFoto(parteArtista[1]);
                artista.setBiografia(parteArtista[2]);
                artista.setFechaNacimiento(parteArtista[3]);

                return artista;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public cancionesDto traerInformacionCreditos(int id) {
       try {
            String[] parteCreditos = this.canciones_Repository.obtenerInfoCreditoProductoresArtista(id).split(",");
            List<String> partesEscritores = this.canciones_Repository.obtenerEscritores(id);
            cancionesDto cancionesDto = new cancionesDto();

            cancionesDto.setProductor(parteCreditos[0]);
            cancionesDto.setArtista(parteCreditos[1]);
            cancionesDto.setFirmaDiscografica(parteCreditos[2]);
            cancionesDto.setEscritores(partesEscritores);

            return cancionesDto;

       } catch (Exception e) {
        e.printStackTrace();
        return null;
       }
    }

    @Override
    public String traerColor(int id) {
        try {
           return this.canciones_Repository.traerColor(id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
}
