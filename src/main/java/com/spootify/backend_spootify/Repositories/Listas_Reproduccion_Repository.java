package com.spootify.backend_spootify.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spootify.backend_spootify.Models.Listas_reproduccion;

public interface Listas_Reproduccion_Repository extends JpaRepository<Listas_reproduccion, Integer>{
        @Query(
                
        value = "SELECT ID_CANCION, PORTADA, NOMBRE_MEDIA, NOMBRE_USUARIO, REPRODUCCIONES, FECHA_REPRODUCCION\r\n" + //
                                "FROM (\r\n" + //
                                "    SELECT A.ID_CANCION, B.PORTADA, D.NOMBRE_MEDIA, E.NOMBRE_USUARIO, C.REPRODUCCIONES, C.FECHA_REPRODUCCION,\r\n" + //
                                "           ROW_NUMBER() OVER(PARTITION BY A.ID_CANCION ORDER BY C.FECHA_REPRODUCCION DESC) AS rn\r\n" + //
                                "    FROM TBL_CANCIONES A\r\n" + //
                                "    INNER JOIN TBL_ALBUMES B ON A.ID_ALBUM = B.ID_ALBUM\r\n" + //
                                "    INNER JOIN TBL_MEDIA D ON A.ID_CANCION = D.ID_MEDIA\r\n" + //
                                "    INNER JOIN TBL_USUARIOS E ON A.ID_ARTISTA = E.ID_USUARIO\r\n" + //
                                "    INNER JOIN (\r\n" + //
                                "        SELECT ID_MEDIA, COUNT(ID_HISTORIAL_REPRODUCCION) REPRODUCCIONES, FECHA_REPRODUCCION\r\n" + //
                                "        FROM TBL_HISTORIAL_MEDIA\r\n" + //
                                "        GROUP BY ID_MEDIA, FECHA_REPRODUCCION\r\n" + //
                                "    ) C ON A.ID_CANCION = C.ID_MEDIA\r\n" + //
                                "    WHERE TRUNC(C.FECHA_REPRODUCCION) = TRUNC(SYSDATE) - 1\r\n" + //
                                ")\r\n" + //
                                "WHERE rn = 1\r\n" + //
                                "ORDER BY REPRODUCCIONES DESC\r\n" + //
                                "FETCH FIRST 50 ROWS ONLY",
        nativeQuery = true)
List<Object[]> getCancionesMasEscuchadas();

@Query(
        value = "SELECT A.ID_LISTA_REPRODUCCION, A.NOMBRE_LISTA_REPRODUCCION, " +
                "A.URL_PORTADA_LISTA, A.DESCRIPCION " +
                "FROM TBL_LISTAS_REPRODUCCION A " +
                "INNER JOIN TBL_USUARIOS B " +
                "ON(A.ID_USUARIO_PROPIETARIO = B.ID_USUARIO) " +
                "WHERE B.ID_USUARIO=:id", 
        nativeQuery = true)
List<Object[]> getPlaylistByIdUsuario(@Param("id")int id);

@Query(value = "SELECT A.ID_LISTA_REPRODUCCION, A.URL_PORTADA_LISTA, A.NOMBRE_LISTA_REPRODUCCION, " +
    "A.DESCRIPCION, C.NOMBRE_USUARIO, C.URL_FOTO_PERFIL, ID_TIPO_LISTA, COUNT(B.ID_LISTA_REPRODUCCION) AS GUARDADOS " +
    "FROM TBL_LISTAS_REPRODUCCION A " +
    "LEFT JOIN TBL_LISTAS_SEGUIDAS B " +
    "ON (A.ID_LISTA_REPRODUCCION = B.ID_LISTA_REPRODUCCION) " +
    "INNER JOIN TBL_USUARIOS C " +
    "ON (A.ID_USUARIO_PROPIETARIO = C.ID_USUARIO) " +
    "WHERE (A.ID_LISTA_REPRODUCCION = :id) " +
    "GROUP BY A.ID_LISTA_REPRODUCCION, A.URL_PORTADA_LISTA, A.NOMBRE_LISTA_REPRODUCCION, " +
    "A.DESCRIPCION, C.NOMBRE_USUARIO, C.URL_FOTO_PERFIL, ID_TIPO_LISTA", nativeQuery = true)
Object[] getPlaylistView(@Param("id")int id);

@Query(value = "SELECT A.ID_MEDIA, A.NOMBRE_MEDIA, C.PORTADA, E.VALOR_HEXADECIMAL AS COLOR, D.NOMBRE_USUARIO " +
                "FROM TBL_MEDIA A " +
                "INNER JOIN TBL_CANCIONES B " +
                "ON (A.ID_MEDIA = B.ID_CANCION) " +
                "INNER JOIN TBL_ALBUMES C " +
                "ON (B.ID_ALBUM = C.ID_ALBUM) " +
                "INNER JOIN TBL_USUARIOS D " +
                "ON (B.ID_ARTISTA = D.ID_USUARIO) " +
                "INNER JOIN TBL_COLORES E " +
                "ON (C.ID_COLOR = E.ID_COLOR)",
        nativeQuery = true)
List<Object[]> getCancionesPlaylist(@Param("id")int id);

@Query(value = "SELECT A.ID_MEDIA, A.NOMBRE_MEDIA, C.PORTADA, D.NOMBRE_USUARIO, F.VALOR_HEXADECIMAL AS COLOR " +
                "FROM TBL_MEDIA A " +
                "INNER JOIN TBL_CANCIONES B " +
                "ON (A.ID_MEDIA = B.ID_CANCION) " +
                "INNER JOIN TBL_ALBUMES C " +
                "ON (B.ID_ALBUM = C.ID_ALBUM) " +
                "INNER JOIN TBL_USUARIOS D " +
                "ON (B.ID_ARTISTA = D.ID_USUARIO) " +
                "INNER JOIN TBL_LISTAS_Y_CANCIONES E " +
                "ON (A.ID_MEDIA = E.ID_CANCION) " +
                "INNER JOIN TBL_COLORES F " +
                "ON (C.ID_COLOR = F.ID_COLOR) " +
                "WHERE (E.ID_LISTA_REPRODUCCION = :id)", nativeQuery = true)
List<Object[]> getListaCancionesPlaylist(@Param("id")int id);

@Query(value = "SELECT ID_MEDIA, NOMBRE_MEDIA, PORTADA\r\n" + //
                "FROM (\r\n" + //
                "    SELECT \r\n" + //
                "        A.ID_MEDIA, \r\n" + //
                "        D.NOMBRE_MEDIA, \r\n" + //
                "        C.PORTADA,\r\n" + //
                "        ROW_NUMBER() OVER (PARTITION BY A.ID_MEDIA ORDER BY A.FECHA_REPRODUCCION DESC) AS row_num\r\n" + //
                "    FROM TBL_HISTORIAL_MEDIA A\r\n" + //
                "    INNER JOIN TBL_CANCIONES B ON A.ID_MEDIA = B.ID_CANCION\r\n" + //
                "    INNER JOIN TBL_ALBUMES C ON B.ID_ALBUM = C.ID_ALBUM\r\n" + //
                "    INNER JOIN TBL_MEDIA D ON A.ID_MEDIA = D.ID_MEDIA\r\n" + //
                "    INNER JOIN TBL_HISTORIAL_DE_REPRODUCCION E ON A.ID_HISTORIAL_REPRODUCCION = E.ID_HISTORIAL_REPRODUCCION\r\n" + //
                "    INNER JOIN TBL_USUARIO_ESTANDAR F ON E.ID_HISTORIAL_REPRODUCCION = F.ID_HISTORIAL_DE_REPRODUCCION\r\n" + //
                "    WHERE F.ID_USUARIO = :id ORDER BY A.FECHA_REPRODUCCION DESC\r\n" + //
                ") subquery\r\n" + //
                "WHERE row_num = 1 AND ROWNUM <= 10", nativeQuery = true)
List<Object[]> getCancionesRecientes(@Param("id")int id);

@Query(value = "SELECT A.ID_LISTA_REPRODUCCION, C.NOMBRE_LISTA_REPRODUCCION, C.URL_PORTADA_LISTA, \r\n" + //
                "        C.DESCRIPCION\r\n" + //
                "FROM TBL_LISTAS_SEGUIDAS A\r\n" + //
                "INNER JOIN TBL_USUARIOS B\r\n" + //
                "ON (A.ID_USUARIO = B.ID_USUARIO)\r\n" + //
                "INNER JOIN TBL_LISTAS_REPRODUCCION C\r\n" + //
                "ON (A.ID_LISTA_REPRODUCCION = C.ID_LISTA_REPRODUCCION)\r\n" + //
                "WHERE (C.ID_TIPO_LISTA = 2 AND A.ID_USUARIO = :id)", nativeQuery = true)
List<Object[]> getDailyMixs(@Param("id")int id);

@Query(value = "SELECT B.ID_LISTA_REPRODUCCION, B.NOMBRE_LISTA_REPRODUCCION, B.URL_PORTADA_LISTA,\r\n" + //
                "    B.DESCRIPCION\r\n" + //
                "FROM TBL_LISTAS_REPRODUCCION B\r\n" + //
                "WHERE (B.ID_LISTA_REPRODUCCION = 1)\r\n" + //
                "UNION\r\n" + //
                "SELECT B.ID_LISTA_REPRODUCCION, B.NOMBRE_LISTA_REPRODUCCION, B.URL_PORTADA_LISTA,\r\n" + //
                "    B.DESCRIPCION\r\n" + //
                "FROM TBL_LISTAS_REPRODUCCION B\r\n" + //
                "INNER JOIN TBL_TOPS A\r\n" + //
                "ON(B.ID_LISTA_REPRODUCCION = A.ID_LISTA_REPRODUCCION)\r\n" + //
                "INNER JOIN TBL_USUARIOS C\r\n" + //
                "ON(C.ID_PAIS = A.ID_PAIS)\r\n" + //
                "WHERE (C.ID_USUARIO = :id)", nativeQuery = true)
List<Object[]> getTops(@Param("id")int id);

@Query(value = "select  g.nombre_pais,\r\n" + //
                "        d.id_media,\r\n" + //
                "        fecha_reproduccion,\r\n" + //
                "        letra_cancion,\r\n" + //
                "        nombre_media,\r\n" + //
                "        duracion_media,\r\n" + //
                "        d.reproducciones_media,\r\n" + //
                "        count(1) cantidad_escuchada\r\n" + //
                "from tbl_historial_de_reproduccion a\r\n" + //
                "inner join tbl_historial_media b\r\n" + //
                "on a.id_historial_reproduccion = b.id_historial_reproduccion\r\n" + //
                "left join tbl_canciones c\r\n" + //
                "on b.id_media = c.id_cancion\r\n" + //
                "left join tbl_media d\r\n" + //
                "on c.id_cancion = d.id_media\r\n" + //
                "left join tbl_usuario_estandar e\r\n" + //
                "on a.id_historial_reproduccion = e.id_historial_de_reproduccion\r\n" + //
                "left join tbl_usuarios f\r\n" + //
                "on e.id_usuario = f.id_usuario\r\n" + //
                "left join tbl_paises g\r\n" + //
                "on f.id_pais = g.id_pais\r\n" + //
                "where   f.id_pais = :idPais and \r\n" + //
                "        TRUNC(b.fecha_reproduccion) = TRUNC(SYSDATE) - 1\r\n" + //
                "group by g.nombre_pais,\r\n" + //
                "        d.id_media,\r\n" + //
                "        fecha_reproduccion,\r\n" + //
                "        letra_cancion,\r\n" + //
                "        nombre_media,\r\n" + //
                "        duracion_media,\r\n" + //
                "        d.reproducciones_media\r\n" + //
                "order by cantidad_escuchada desc\r\n" + //
                "fetch first 50 rows only", nativeQuery = true)
    List<Object[]> getSongsByIdCountry(@Param("idPais")int id);

}
