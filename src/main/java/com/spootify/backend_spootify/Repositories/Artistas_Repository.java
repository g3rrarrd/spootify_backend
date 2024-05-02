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

    @Query(value = "SELECT A.ID_ARTISTA, C.NOMBRE_USUARIO, C.URL_FOTO_PERFIL, D.BIOGRAFIA, D.COLOR, \r\n" + //
                "        AVG(A.REPRODUCCIONES) OYENTES_MENSUALES\r\n" + //
                "FROM (SELECT A.ID_MEDIA, B.ID_ARTISTA, TO_CHAR(FECHA_REPRODUCCION, 'MONTH') MES, \r\n" + //
                "        COUNT(A.ID_HISTORIAL_REPRODUCCION) REPRODUCCIONES\r\n" + //
                "        FROM TBL_HISTORIAL_MEDIA A\r\n" + //
                "        INNER JOIN TBL_CANCIONES B\r\n" + //
                "        ON(A.ID_MEDIA = B.ID_CANCION)\r\n" + //
                "        WHERE ID_ARTISTA = :id\r\n" + //
                "        GROUP BY A.ID_MEDIA, B.ID_ARTISTA, TO_CHAR(FECHA_REPRODUCCION, 'MONTH')) A\r\n" + //
                "INNER JOIN TBL_USUARIOS C\r\n" + //
                "ON(A.ID_ARTISTA = C.ID_USUARIO)\r\n" + //
                "INNER JOIN TBL_ARTISTAS D\r\n" + //
                "ON(D.ID_USUARIO = C.ID_USUARIO)\r\n" + //
                "GROUP BY ID_ARTISTA, C.NOMBRE_USUARIO, C.URL_FOTO_PERFIL, D.BIOGRAFIA, D.COLOR", nativeQuery = true)
    Object[] getArtist(@Param("id")int id);

    @Query(value = "SELECT A.ID_MEDIA, B.ID_ARTISTA, C.NOMBRE_MEDIA, D.PORTADA, COUNT(A.ID_HISTORIAL_REPRODUCCION) REPRODUCCIONES\r\n" + //
                "FROM TBL_HISTORIAL_MEDIA A\r\n" + //
                "INNER JOIN TBL_CANCIONES B\r\n" + //
                "ON(A.ID_MEDIA = B.ID_CANCION)\r\n" + //
                "INNER JOIN TBL_MEDIA C\r\n" + //
                "ON(A.ID_MEDIA = C.ID_MEDIA)\r\n" + //
                "INNER JOIN TBL_ALBUMES D\r\n" + //
                "ON(B.ID_ALBUM = D.ID_ALBUM)\r\n" + //
                "WHERE ID_ARTISTA = :id\r\n" + //
                "GROUP BY A.ID_MEDIA, B.ID_ARTISTA, C.NOMBRE_MEDIA, D.PORTADA\r\n" + //
                "ORDER BY REPRODUCCIONES DESC\r\n" + //
                "FETCH FIRST 5 ROWS ONLY", nativeQuery = true)
    List<Object[]> getPopularSongs(@Param("id")int id);

    @Query(value = "SELECT C.ID_ALBUM, C.NOMBRE_ALBUM, C.PORTADA, TO_CHAR(C.FECHA_LANZAMIENTO, 'YYYY') FECHA\r\n" + //
                "FROM TBL_ALBUMES C\r\n" + //
                "WHERE ID_USUARIO = :id\r\n" + //
                "ORDER BY FECHA DESC\r\n" + //
                "fetch first 1 rows only", nativeQuery = true)
    Object[] getLastPost(@Param("id")int id);

    @Query(value = "select  a.id_lista_reproduccion,\r\n" + //
                "        a.id_usuario_propietario,\r\n" + //
                "        nombre_lista_reproduccion,\r\n" + //
                "        url_portada_lista,\r\n" + //
                "        descripcion,\r\n" + //
                "        count(1) canciones_lista\r\n" + //
                "from tbl_listas_reproduccion a\r\n" + //
                "inner join tbl_listas_y_canciones b\r\n" + //
                "on a.id_lista_reproduccion = b.id_lista_reproduccion\r\n" + //
                "left join tbl_canciones c\r\n" + //
                "on b.id_cancion = c.id_cancion\r\n" + //
                "left join tbl_media d\r\n" + //
                "on c.id_cancion = d.id_media\r\n" + //
                "where c.id_artista = :id and id_usuario_propietario = 100\r\n" + //
                "group by    a.id_lista_reproduccion,\r\n" + //
                "            a.id_usuario_propietario,\r\n" + //
                "            nombre_lista_reproduccion,\r\n" + //
                "            url_portada_lista,\r\n" + //
                "            descripcion\r\n" + //
                "order by canciones_lista desc\r\n" + //
                "fetch first 4 rows only", nativeQuery = true)
    List<Object[]> getPlaylistArtist(@Param("id")int id);

    @Query(value = "SELECT ID_ALBUM, NOMBRE_ALBUM, PORTADA, FECHA\r\n" + //
                "FROM (\r\n" + //
                "    SELECT B.ID_ARTISTA, B.ID_ALBUM, C.NOMBRE_ALBUM, C.PORTADA, TO_CHAR(C.FECHA_LANZAMIENTO, 'YYYY') FECHA,\r\n" + //
                "            COUNT(A.ID_HISTORIAL_REPRODUCCION) REPRODUCCIONES\r\n" + //
                "    FROM TBL_HISTORIAL_MEDIA A\r\n" + //
                "    INNER JOIN TBL_CANCIONES B\r\n" + //
                "    ON (A.ID_MEDIA = B.ID_CANCION)\r\n" + //
                "    INNER JOIN TBL_ALBUMES C\r\n" + //
                "    ON (B.ID_ALBUM = C.ID_ALBUM)\r\n" + //
                "    WHERE ID_ARTISTA = 1\r\n" + //
                "    GROUP BY B.ID_ARTISTA, B.ID_ALBUM, C.NOMBRE_ALBUM, C.PORTADA, C.FECHA_LANZAMIENTO\r\n" + //
                "    ORDER BY REPRODUCCIONES DESC\r\n" + //
                "    )\r\n" + //
                "MINUS\r\n" + //
                "SELECT ID_ALBUM, NOMBRE_ALBUM, PORTADA, TO_CHAR(FECHA_LANZAMIENTO, 'YYYY') AS FECHA\r\n" + //
                "FROM TBL_ALBUMES\r\n" + //
                "WHERE ID_USUARIO = 1 AND FECHA_LANZaMIENTO = (SELECT MAX(FECHA_LANZAMIENTO) \r\n" + //
                "                                            FROM TBL_ALBUMES\r\n" + //
                "                                            WHERE(ID_USUARIO = 1))", nativeQuery = true)
    List<Object[]> getPopularPost(@Param("id")int id);


}
