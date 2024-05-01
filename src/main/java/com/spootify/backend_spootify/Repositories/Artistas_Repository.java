package com.spootify.backend_spootify.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spootify.backend_spootify.Models.Artistas;

@Repository
public interface Artistas_Repository extends JpaRepository<Artistas, Integer>{

    @Query(value = "select b.id_usuario,a.nombre_usuario, a.url_foto_perfil  from tbl_usuarios a inner join tbl_artistas b on (a.id_usuario=b.id_usuario)", nativeQuery = true)
    List<Object[]> obtenerArtistasRegister();


}
