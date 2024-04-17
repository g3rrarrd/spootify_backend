package com.spootify.backend_spootify.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spootify.backend_spootify.Models.Artistas;
import com.spootify.backend_spootify.Models.ArtistasId;
import com.spootify.backend_spootify.Models.Usuarios;

@Repository
public interface Artistas_Repository extends JpaRepository<Artistas, ArtistasId>{

   
}
