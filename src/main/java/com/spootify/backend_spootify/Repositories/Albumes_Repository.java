package com.spootify.backend_spootify.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spootify.backend_spootify.Models.Albumes;

public interface Albumes_Repository extends JpaRepository<Albumes, Integer>{
    
    @Query(value = "Select portada from tbl_albumes where id_album = :id", nativeQuery = true)
    String obtenerPortada(@Param("id")int id);

    @Query(value = "Select nombre_album from tbl_albumes where id_album = :id", nativeQuery = true)
    String obtenerNombre(@Param("id")int id);

    @Query(value = "select Nombre_usuario, url_foto_perfil from tbl_artistas a inner join tbl_usuarios b on b.id_usuario = a.id_usuario where b.id_usuario = :id", nativeQuery = true)
    String obtenerNombreFotoArtista(@Param("id")int id);

    @Query(value = "select to_char(fecha_lanzamiento, 'fmMonth dd, YYYY') from tbl_albumes where id_album = :id", nativeQuery = true)
    String obtenerFechaLanzamiento(@Param("id")int id);

    @Query(value = "select count(1) from tbl_canciones where id_album = :id", nativeQuery = true)
    int contarCanciones(@Param("id") int id);

    @Query(value = "update tbl_albumes set cantidad_canciones = :canciones where id_album = :id", nativeQuery = true)
    void actualizarCantidadCanciones(@Param("canciones") int canciones, @Param("id") int id);

    @Query(value = "SELECT A.id_cancion, B.nombre_media FROM tbl_canciones A INNER JOIN tbl_media B ON(A.id_cancion = B.id_media) WHERE A.id_album = :id", nativeQuery = true)
    List<Object[]> obtenerCanciones(@Param("id")int id);

    @Query(value = "select duracion from tbl_albumes where id_album = :id", nativeQuery = true)
    int obtenerDuracion(@Param("id")int id);

    @Query(value = "select color from tbl_albumes where id_album = :id", nativeQuery = true)
    String obtenerColor(@Param("id")int id);

    @Query(value = "select b.nombre_lanzamiento from tbl_albumes a inner join tbl_tipo_lanzamiento b on (a.id_tipo_lanzamiento = b.id_tipo_lanzamiento) where a.id_album = :id", nativeQuery = true)
    String obtenerTipoLanzamiento(@Param("id")int id);

}
