package com.spootify.backend_spootify.Service;

import java.util.List;

import com.spootify.backend_spootify.Dtos.usuarioEstandarDto;

public interface Usuario_estandar_Service {

    public boolean crearUsuario(usuarioEstandarDto usuarioE);

    public void eliminarUsuario(int id);

    public int cantidadListas(int id);

    public List<String> obtenerNombreListas(int id);

    public void crearListaReproduccion(String nombre, String portada, int idUsuario, int idTipoLista, String descripcion);
    
}
