package com.spootify.backend_spootify.Service;

import com.spootify.backend_spootify.Dtos.podcastDto;

public interface Podcasts_Service {
    
    public podcastDto traerPodcast(int idPodcast, int idUsuario);

}
