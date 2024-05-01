package com.spootify.backend_spootify.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spootify.backend_spootify.Models.Canciones;


@Repository
public interface Busquedas_Repository extends JpaRepository<Canciones, Integer>{

    @Query(value = "SELECT a.id_usuario, a.nombre_usuario, a.url_foto_perfil " +
    "FROM tbl_usuarios a " +
    "INNER JOIN tbl_artistas b ON (a.id_usuario = b.id_usuario) " +
    "WHERE LOWER(a.nombre_usuario) LIKE LOWER(:query) || '%'", nativeQuery = true)
    List<Object[]> buscarEnArtistas(@Param("query") String query);

    @Query(value = "select a.id_album, a.nombre_album, a.portada, b.nombre_usuario " +
    "from tbl_albumes a " +
    "inner join tbl_usuarios b on (a.id_usuario = b.id_usuario) " +
    "where LOWER(a.nombre_album) like LOWER(:query) || '%'", nativeQuery = true)
    List<Object[]> buscarEnAlbumes(@Param("query") String query);

    @Query(value = "select a.id_media, a.nombre_media, c.nombre_usuario, d.portada " +
    "from tbl_media a " +
    "inner join tbl_canciones b on (a.id_media = b.id_cancion) " +
    "inner join tbl_usuarios c on(b.id_artista=c.id_usuario) " +
    "inner join tbl_albumes d on(b.id_album=d.id_album) " +
    "where LOWER(a.nombre_media) like LOWER(:query) || '%'", nativeQuery = true)
    List<Object[]> buscarEnCanciones(@Param("query") String query);

}
