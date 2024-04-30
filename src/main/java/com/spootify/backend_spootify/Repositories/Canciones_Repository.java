package com.spootify.backend_spootify.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spootify.backend_spootify.Models.Canciones;

public interface Canciones_Repository extends JpaRepository<Canciones, Integer>{
    
    @Query(value = "select nombre_media from tbl_canciones a inner join tbl_media b on a.id_media = b.id_media where a.id_media = :id", nativeQuery = true)
    String obtenerNombreCancion(@Param("id")int id);

    @Query(value = "with cancion_artista as (select b.id_usuario, biografia from tbl_canciones a inner join tbl_artistas b on a.id_usuario = b.id_usuario where a.id_media = :id) select nombre_usuario, url_foto_perfil, biografia, fecha_nacimiento from cancion_artista a inner join tbl_usuarios b on a.id_usuario = b.id_usuario", nativeQuery = true)
    String obtenerArtista(@Param("id")int id);

    @Query(value = "with creditos_canciones as (select b.id_creditos_musicales, firma_discografica, id_artista, id_productor from tbl_canciones a inner join tbl_creditos b on a.id_creditos_musicales = b.id_creditos_musicales where a.id_media = :id) select c.primer_nombre || ' ' || c.segundo_nombre || ' ' || c.apellido as nombre_productor, b.nombre_usuario, a.firma_discografica from creditos_canciones a, tbl_usuarios b, tbl_productores c where a.id_artista = b.id_usuario and a.id_productor = c.id_productor", nativeQuery = true)
    String obtenerInfoCreditoProductoresArtista(@Param("id")int id);

    @Query(value = "with credito_escritores as( select a.id_creditos_musicales, b.primer_nombre || ' ' || b.segundo_nombre || ' ' || b.apellido as nombre_escritor from tbl_escritores_y_canciones a inner join tbl_escritores b on a.id_escritor = b.id_escritor) select nombre_escritor from tbl_canciones a inner join credito_escritores b on a.id_creditos_musicales = b.id_creditos_musicales where a.id_media = :id", nativeQuery = true)
    List<String> obtenerEscritores(@Param("id")int id);

    @Query(value = "Select portada from tbl_canciones where id_media = :id", nativeQuery = true)
    String obtenerPortada(@Param("id")int id);

    @Query(value = "Select color from tbl_canciones where id_media = :id", nativeQuery = true)
    String traerColor(int id);
 
}
