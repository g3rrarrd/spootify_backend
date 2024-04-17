package com.spootify.backend_spootify.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spootify.backend_spootify.Models.Canciones;
import com.spootify.backend_spootify.Models.cancionesId;

public interface Canciones_Repository extends JpaRepository<Canciones, cancionesId>{
    
    @Query(value = "select nombre_media from tbl_canciones a inner join tbl_media b on a.id_media = b.id_media where a.id_media = :id", nativeQuery = true)
    String obtenerNombreCancion(@Param("id")int id);

    @Query(value = "with cancion_artista as (select b.id_usuario, biografia from tbl_canciones a inner join tbl_artistas b on a.id_usuario = b.id_usuario where a.id_canciones = :id) select nombre_usuario, url_foto_perfil, biografia, fecha_nacimiento from cancion_artista a inner join tbl_usuarios b on a.id_usuario = b.id_usuario", nativeQuery = true)
    String obtenerArtista(@Param("id")int id);

    @Query(value = "with credito_cancion as (select id_artista, id_productor, id_escritor, firma_discografica from tbl_canciones a inner join tbl_creditos b on a.id_creditos_musicales = b.id_creditos_musicales where a.id_canciones = :id) select b.primer_nombre || ' ' || b.segundo_nombre || ' ' || b.apellido as Nombre_Productor, c.primer_nombre || ' ' || c.segundo_nombre || ' ' || c.apellido as Nombre_Escritor, d.nombre_usuario, a.firma_discografica  from credito_cancion a, tbl_productores b, tbl_escritores c, tbl_usuarios d where a.id_escritor = c.id_escritor and a.id_artista = d.id_usuario and a.id_productor = b.id_productor", nativeQuery = true)
    String obtenerInfoCredito(@Param("id")int id);

    @Query(value = "Select portada from tbl_canciones where id_media = :id", nativeQuery = true)
    String obtenerPortada(@Param("id")int id);

}
