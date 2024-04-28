package com.spootify.backend_spootify.Service;

import java.util.List;

import com.spootify.backend_spootify.Dtos.usuarioSeguiDto;

public interface Usuarios_Service {

    public String validarUsuario(String correo, String cotrasenia);

    public void seguirUsuario(int idSeguidor, int idSeguido);

    public void dejarSeguir(int idSeguidor, int idSeguido);

    public int numeroSeguidos(int idUsuario);

    public int numeroSeguidores(int idUsuario);

    public List<usuarioSeguiDto> traerSeguidores(int idUsuario);

    public List<usuarioSeguiDto> traerSeguidos(int idUsuario);

}
