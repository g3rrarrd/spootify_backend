package com.spootify.backend_spootify.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.spootify.backend_spootify.Models.Albumes;

public interface Albumes_Repository extends JpaRepository<Albumes, Integer>{

    @Query(value = "Select portada from tbl_albumes where id_album = :id", nativeQuery = true)
    String obtenerPortada(@Param("id")int id);

    @Query(value = "Select nombre_album from tbl_albumes where id_album = :id", nativeQuery = true)
    String obtenerNombre(@Param("id")int id);

    @Query(value = "select to_char(fecha_lanzamiento, 'fmMonth dd, YYYY') from tbl_albumes where id_album = :id", nativeQuery = true)
    String obtenerFechaLanzamiento(@Param("id")int id);

    @Query(value = "select count(1) from tbl_canciones where id_album = :id", nativeQuery = true)
    int contarCanciones(@Param("id") int id);

    @Query(value = "SELECT A.id_cancion, B.nombre_media FROM tbl_canciones A INNER JOIN tbl_media B ON(A.id_cancion = B.id_media) WHERE A.id_album = :id", nativeQuery = true)
    List<Object[]> obtenerCanciones(@Param("id")int id);

    @Query(value = "select sum(b.duracion_media) as duracion_album from tbl_canciones a inner join tbl_media b on(a.id_cancion = b.id_media) where a.id_album = :id", nativeQuery = true)
    int obtenerDuracion(@Param("id")int id);

    @Query(value = "select b.valor_hexadecimal as color from tbl_albumes a inner join tbl_colores b on(a.id_color = b.id_color) where id_album = :id", nativeQuery = true)
    String obtenerColor(@Param("id")int id);

    @Query(value = "select b.nombre_lanzamiento from tbl_albumes a inner join tbl_tipo_lanzamiento b on (a.id_tipo_lanzamiento = b.id_tipo_lanzamiento) where a.id_album = :id", nativeQuery = true)
    String obtenerTipoLanzamiento(@Param("id")int id);

    @Query(value = "SELECT COUNT(1) AS seguido FROM tbl_usuarios A INNER JOIN tbl_albumes_seguidos B ON(A.id_usuario = B.id_usuario) WHERE A.id_usuario = :idUsuario AND B.id_album= :idAlbum", nativeQuery = true)
    int seSigue(@Param("idUsuario")int idUsuario, @Param("idAlbum")int idAlbum);

    @Query(value = "select a.nombre_usuario from tbl_usuarios a inner join tbl_albumes b on(a.id_usuario=b.id_usuario) where b.id_album = :idAlbum", nativeQuery = true)
    String obtenerNombreArtista(@RequestParam int idAlbum);

    //Trae la foto del perfil del artista solo con el idAlbum
    @Query(value = "select a.url_foto_perfil from tbl_usuarios a inner join tbl_albumes b on(a.id_usuario=b.id_usuario) where b.id_album = :idAlbum", nativeQuery = true)
    String urlFotoPerfil(@RequestParam int idAlbum);
}
