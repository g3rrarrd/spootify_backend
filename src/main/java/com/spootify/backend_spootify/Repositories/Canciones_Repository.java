package com.spootify.backend_spootify.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spootify.backend_spootify.Models.Canciones;

public interface Canciones_Repository extends JpaRepository<Canciones, Integer>{
    
    @Query(value = "select nombre_media from tbl_canciones a inner join tbl_media b on a.id_cancion = b.id_media where a.id_cancion = :id", nativeQuery = true)
    String obtenerNombreCancion(@Param("id")int id);

    @Query(value = "Select portada from tbl_albumes a left join tbl_canciones b on(a.id_album=b.id_album) where b.id_cancion = :id", nativeQuery = true)
    String obtenerPortada(@Param("id")int id);

    @Query(value = "Select c.valor_hexadecimal from tbl_albumes a left join tbl_canciones b on(a.id_album=b.id_album) left join tbl_colores c on(a.id_color=c.id_color) where b.id_cancion = :id", nativeQuery = true)
    String obtenerColor(int id);

    @Query(value = "select b.id_usuario, b.nombre_usuario, b.url_foto_perfil from tbl_canciones a left join tbl_usuarios b on a.id_artista = b.id_usuario where a.id_cancion = :id", nativeQuery = true)
    String obtenerArtista(@Param("id")int id);
    
    @Query(value = "Select a.id_album from tbl_albumes a left join tbl_canciones b on(a.id_album=b.id_album) where b.id_cancion = :id", nativeQuery = true)
    String obtenerAlbum(@Param("id")int id);

    @Query(value = "select count(1) as seguido from tbl_canciones a inner join tbl_listas_y_canciones b on(a.id_cancion=b.id_cancion) inner join tbl_listas_reproduccion c on(b.id_lista_reproduccion=c.id_lista_reproduccion) inner join tbl_usuarios d on(c.id_usuario_propietario=d.id_usuario) where a.id_cancion=:idCancion and id_tipo_lista=5 and id_usuario_propietario=:idUsuario", nativeQuery = true)
    int seSigue(@Param("idCancion")int idCancion, @Param("idUsuario")int idUsuario);

    @Query(value = "select round(b.duracion_media/60,2) as duracion from tbl_canciones a inner join tbl_media b on(a.id_cancion = b.id_media) where id_cancion=:id", nativeQuery = true)
    float obtenerDuracion(@Param("id")int id);

    @Query(value = "select a.id_credito, a.firma_discografica, b.nombre_usuario from tbl_creditos a left join tbl_usuarios b on(a.id_artista = b.id_usuario) where a.id_cancion = :id", nativeQuery = true)
    String obtenerInfoCreditos(@Param("id")int id);

    @Query(value = "select a.primer_nombre ||' '|| a.segundo_nombre ||' '||a.apellido as nombre_escritor from tbl_escritores a left join tbl_creditos b on(a.id_credito = b.id_credito) where b.id_cancion=:id", nativeQuery = true)
    List<String> obtenerEscritores(@Param("id")int id);

    @Query(value = "select a.primer_nombre ||' '|| a.segundo_nombre ||' '||a.apellido as nombre_escritor from tbl_productores a left join tbl_creditos b on(a.id_credito = b.id_credito) where b.id_cancion=:id", nativeQuery = true)
    List<String> obtenerProductores(@Param("id")int id);

    @Query(value = "SELECT a.id_cancion, c.nombre_media, d.nombre_usuario, e.portada FROM tbl_canciones a " +
    "INNER JOIN tbl_media c ON (a.id_cancion = c.id_media) " +
    "INNER JOIN tbl_usuarios d ON (a.id_artista = d.id_usuario) " + 
    "INNER JOIN tbl_albumes e ON (a.id_album = e.id_album) " +
    "WHERE a.id_cancion NOT IN (SELECT a.id_cancion FROM tbl_listas_y_canciones a " +
    "INNER JOIN tbl_canciones b ON (a.id_cancion = b.id_cancion) " +
    "INNER JOIN tbl_media c ON (b.id_cancion = c.id_media) " +
    "INNER JOIN tbl_usuarios d ON (b.id_artista = d.id_usuario) " +
    "INNER JOIN tbl_albumes e ON (b.id_album = e.id_album) " +
    "WHERE id_lista_reproduccion = :idPlaylist)", nativeQuery = true)
    List<Object[]> obtenerCancionesNotInPlaylist(@Param("idPlaylist") int idPlaylist);

    @Query(value = "SELECT ID_HISTORIAL_DE_REPRODUCCION \r\n" + //
                "FROM TBL_USUARIO_ESTANDAR\r\n" + //
                "WHERE (ID_USUARIO = :id)", 
                nativeQuery = true)
    int getHistorial(@Param("id")int id);

}
