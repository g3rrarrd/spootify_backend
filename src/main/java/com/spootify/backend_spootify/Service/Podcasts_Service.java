package com.spootify.backend_spootify.Service;

import com.spootify.backend_spootify.Dtos.podcastDto;

public interface Podcasts_Service {
    
    public podcastDto traerPodcast(int idPodcast, int idUsuario);

    public Boolean seguirPodcast(int idPodcast, int idUsuario);

    public Boolean dejarSeguirPocast(int idPodcast, int idUsuario);

}
