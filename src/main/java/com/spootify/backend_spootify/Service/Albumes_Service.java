package com.spootify.backend_spootify.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.spootify.backend_spootify.Models.Albumes;
import com.spootify.backend_spootify.Models.Canciones;

public interface Albumes_Service {

    public List<Albumes> obtenerAlbumes();

    public Albumes buscarAlbumes(int id);

    public String traerPortadaAlbum(int id);

    public String traerNombteAlbum(int id);
    
    public Map<String, String> traerArtistaFoto(int id);

    public String traerLanzamientoAnio(int id);

    public List<Map<String,String>> traerCancionesAlbum(int id);

    public Date traerFechaPublicacion(int id);

    public String traerDuracionAlbum(int id);

    public int traerCantidadCacionesAlbum(int id);

}
