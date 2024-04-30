package com.spootify.backend_spootify.Service;

import com.spootify.backend_spootify.Dtos.CancionVistaDto;

public interface Canciones_Service {

    public CancionVistaDto traerCancion(int idCancion, int idUsuario);

}
