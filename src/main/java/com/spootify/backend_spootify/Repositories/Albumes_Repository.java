package com.spootify.backend_spootify.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spootify.backend_spootify.Models.Albumes;
import com.spootify.backend_spootify.Models.Artistas;
import com.spootify.backend_spootify.Models.Canciones;

public interface Albumes_Repository extends JpaRepository<Albumes, Integer>{
    
    @Query(value = "Select portada from tbl_albumes where id_album = :id", nativeQuery = true)
    String obtenerPortada(@Param("id")int id);

    @Query(value = "Select nombre_album from tbl_albumes where id_album = :id", nativeQuery = true)
    String obtenerNombre(@Param("id")int id);

    @Query(value = "select Nombre_usuario, url_foto_perfil from tbl_artistas a inner join tbl_usuarios b on b.id_usuario = a.id_usuario where b.id_usuario = :id", nativeQuery = true)
    String obtenerNombreFotoArtista(@Param("id")int id);

    @Query(value = "select fecha_lanzamiento from tbl_albumes where id_album = :id", nativeQuery = true)
    String obtenerFechaLanzamiento(@Param("id")int id);

    @Query(value = "select count(1) from tbl_canciones where id_album = :id", nativeQuery = true)
    int contarCanciones(@Param("id") int id);

    @Query(value = "update tbl_albumes set cantidad_canciones = :canciones where id_album = :id", nativeQuery = true)
    void actualizarCantidadCanciones(@Param("canciones") int canciones, @Param("id") int id);

    @Query(value = "select nombre_media, duracion_media, letra_cancion, color from tbl_canciones a inner join tbl_media b on a.id_media = b.id_media where id_album = :id", nativeQuery = true)
    List<String> obtenerCanciones(@Param("id")int id);

    @Query(value = "select duracion from tbl_albumes where id_album = :id", nativeQuery = true)
    String obtenerDuracion(@Param("id")int id);

}
