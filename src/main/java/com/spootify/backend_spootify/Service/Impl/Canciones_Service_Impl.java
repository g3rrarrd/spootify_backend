package com.spootify.backend_spootify.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.ArtistaDtoMin;
import com.spootify.backend_spootify.Dtos.CancionVistaDto;
import com.spootify.backend_spootify.Dtos.CreditosDto;
import com.spootify.backend_spootify.Repositories.Canciones_Repository;
import com.spootify.backend_spootify.Repositories.Usuario_Repository;
import com.spootify.backend_spootify.Service.Canciones_Service;

@Service
public class Canciones_Service_Impl implements Canciones_Service{

    @Autowired
    Canciones_Repository canciones_Repository;

    @Autowired
    Usuario_Repository usuario_Repository;

    @Override
    public CancionVistaDto traerCancion(int idCancion, int idUsuario) {
        try {
            
            if (usuario_Repository.existsById(idUsuario) && canciones_Repository.existsById(idCancion)) {

                CancionVistaDto cancion = new CancionVistaDto();

                cancion.setNombre(canciones_Repository.obtenerNombreCancion(idCancion));
                cancion.setPortada(canciones_Repository.obtenerPortada(idCancion));
                cancion.setColor(canciones_Repository.obtenerColor(idCancion));
                cancion.setArtista(traerArtistaCancion(idCancion));
                cancion.setIdAlbum(canciones_Repository.obtenerAlbum(idCancion));
                cancion.setSeguido(canciones_Repository.seSigue(idCancion,idUsuario));
                cancion.setDuracion(canciones_Repository.obtenerDuracion(idCancion));
                cancion.setCreditos(traerInformacionCreditos(idCancion));

                return cancion;
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    private ArtistaDtoMin traerArtistaCancion(int id) {
        try {
            
                String[] parteArtista = this.canciones_Repository.obtenerArtista(id).split(",");
                ArtistaDtoMin artista = new ArtistaDtoMin();

                artista.setIdArtista(parteArtista[0]);
                artista.setNombreArtista(parteArtista[1]);
                artista.setFotoArtista(parteArtista[2]);

                return artista;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private CreditosDto traerInformacionCreditos(int idCancion) {
       try {
            String[] parteCreditos = this.canciones_Repository.obtenerInfoCreditos(idCancion).split(",");
            List<String> escritores = this.canciones_Repository.obtenerEscritores(idCancion);
            List<String> productores = this.canciones_Repository.obtenerProductores(idCancion);
            CreditosDto credito = new CreditosDto();

            credito.setIdCredito(parteCreditos[0]);
            credito.setFirmaDiscografica(parteCreditos[1]);
            credito.setArtista(parteCreditos[2]);
            credito.setEscritores(escritores);
            credito.setProductores(productores);
            

            return credito;

       } catch (Exception e) {
        e.printStackTrace();
        return null;
       }
    }
    
}
