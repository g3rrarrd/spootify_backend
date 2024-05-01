package com.spootify.backend_spootify.Service;

import java.util.List;

import com.spootify.backend_spootify.Dtos.CancionDtoMin;
import com.spootify.backend_spootify.Dtos.CancionVistaDto;

public interface Canciones_Service {

    public CancionVistaDto traerCancion(int idCancion, int idUsuario);

    public List<CancionDtoMin> traerCancionesParaAgregar(int idPlaylist);

    public Boolean seguirCancion(int idCancion, int idUsuario);

    public Boolean dejarSeguirCancion(int idCancion, int idUsuario);

}
