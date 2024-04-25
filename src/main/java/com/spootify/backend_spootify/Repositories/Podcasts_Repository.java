package com.spootify.backend_spootify.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.spootify.backend_spootify.Models.Podcasts;

public interface Podcasts_Repository extends JpaRepository<Podcasts, Integer>{
    
    @Query(value = "select count(1) validador from tbl_seguidores a inner join tbl_podcasts b on a.id_usuario_seguido = b.id_podcaster where b.id_podcast = :id and a.id_usuario_seguidor = :idSeguidor group by id_podcast", nativeQuery = true)
    Integer validarSeguimiento( int id,  int idSeguidor);

}
