package com.spootify.backend_spootify.Service;

import java.util.Date;
import java.util.List;

import com.spootify.backend_spootify.Dtos.albumesDto;
import com.spootify.backend_spootify.Models.Albumes;

public interface Albumes_Service {

    public List<Albumes> obtenerAlbumes();

    public albumesDto traerInfoAlbum(int idAlbum, int idUsuario);

    public Albumes buscarAlbumes(int id);

    public boolean seguirAlbum(int idAlbum, int idUsuario);

    public boolean dejarSeguirAlbum(int idAlbum, int idUsuario);

    public List<albumesDto> traerCancionesAlbum(int id);

}
