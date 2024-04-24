package com.spootify.backend_spootify.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spootify.backend_spootify.Models.Listas_reproduccion;

public interface Listas_Reproduccion_Repository extends JpaRepository<Listas_reproduccion, Integer>{
    @Query("SELECT * FROM (" +
            "WITH T AS(SELECT ID_MEDIA, COUNT(ID_MEDIA) AS REPRODUCCIONES" +
                    "FROM TBL_HISTORIAL_CANCIONES" +
                    "GROUP BY ID_MEDIA)" +
            "SELECT A.ID_MEDIA, A.NOMBRE_MEDIA, B.PORTADA, B.NOMBRE_USUARIO" +
            "FROM TBL_MEDIA A" +
            "INNER JOIN(SELECT A.ID_CANCION, B.PORTADA, C.NOMBRE_USUARIO" +
                    "FROM TBL_CANCIONES A" +
                    "INNER JOIN TBL_ALBUMES B" +
                    "ON (A.ID_ALBUM = B.ID_ALBUM)" +
                    "INNER JOIN TBL_USUARIOS C" +
                    "ON (A.ID_ARTISTA = C.ID_USUARIO)) B" +
            "ON(A.ID_MEDIA=B.ID_CANCION)" +
            "INNER JOIN T" +
            "ON(A.ID_MEDIA = T.ID_MEDIA)" +
            "ORDER BY T.REPRODUCCIONES DESC)" +
            "WHERE ROWNUM <= 10;")
    List<Object[]> getCancionesMasEscuchadas();

    @Query("SELECT A.ID_LISTA_REPRODUCCION, A.ID_USUARIO_PROPIETARIO, A.NOMBRE_LISTA_REPRODUCCION," +
            "A.URL_PORTADA_LISTA, COUNT(C.ID_LISTA_REPRODUCCION) AS GUARDADOS" +
            "FROM TBL_LISTAS_REPRODUCCION A" +
            "INNER JOIN TBL_USUARIOS B" +
            "ON(A.ID_USUARIO_PROPIETARIO = B.ID_USUARIO)" +
            "LEFT JOIN TBL_LISTAS_SEGUIDAS C" +
            "ON(A.ID_LISTA_REPRODUCCION = C.ID_LISTA_REPRODUCCION)" +
            "WHERE B.ID_USUARIO=35" +
            "GROUP BY A.ID_LISTA_REPRODUCCION, A.ID_USUARIO_PROPIETARIO, A.NOMBRE_LISTA_REPRODUCCION," +
                    "A.URL_PORTADA_LISTA;")
    List<Object[]> getPlaylistByIdUsuario(@Param("id")int id);

    @Query("SELECT A.ID_LISTA_REPRODUCCION, A.URL_PORTADA_LISTA, A.NOMBRE_LISTA_REPRODUCCION, " +
        "A.DESCRIPCION, C.NOMBRE_USUARIO, COUNT(B.ID_LISTA_REPRODUCCION) AS GUARDADOS" +
        "FROM TBL_LISTAS_REPRODUCCION A" +
        "LEFT JOIN TBL_LISTAS_SEGUIDAS B" +
        "ON(A.ID_LISTA_REPRODUCCION = B.ID_LISTA_REPRODUCCION)" +
        "INNER JOIN TBL_USUARIOS C" +
        "ON(A.ID_USUARIO_PROPIETARIO = C.ID_USUARIO)" +
        "WHERE(A.ID_LISTA_REPRODUCCION = :id)" +
        "GROUP BY A.ID_LISTA_REPRODUCCION, A.URL_PORTADA_LISTA, A.NOMBRE_LISTA_REPRODUCCION, " +
        "A.DESCRIPCION, C.NOMBRE_USUARIO;")
    List<Object[]> getPlaylistView(@Param("id")int id);

    @Query("SELECT A.ID_MEDIA, A.NOMBRE_MEDIA, C.PORTADA, D.NOMBRE_USUARIO" +
            "FROM TBL_MEDIA A" +
            "INNER JOIN TBL_CANCIONES B" +
            "ON (A.ID_MEDIA = B.ID_CANCION)" +
            "INNER JOIN TBL_ALBUMES C" +
            "ON (B.ID_ALBUM = C.ID_ALBUM)" +
            "INNER JOIN TBL_USUARIOS D" +
            "ON (B.ID_ARTISTA = D.ID_USUARIO)")
    List<Object[]> getCancionesPlaylist(@Param("id")int id);

    @Query("SELECT A.ID_MEDIA, A.NOMBRE_MEDIA, C.PORTADA, D.NOMBRE_USUARIO" +
            "FROM TBL_MEDIA A" +
            "INNER JOIN TBL_CANCIONES B" +
            "ON (A.ID_MEDIA = B.ID_CANCION)" +
            "INNER JOIN TBL_ALBUMES C" +
            "ON (B.ID_ALBUM = C.ID_ALBUM)" +
            "INNER JOIN TBL_USUARIOS D" +
            "ON (B.ID_ARTISTA = D.ID_USUARIO)" +
            "INNER JOIN TBL_LISTAS_Y_CANCIONES E" +
            "ON (A.ID_MEDIA = E.ID_CANCION)" +
            "WHERE (E.ID_LISTA_REPRODUCCION = 8)")
    List<Object[]> getListaCancionesPlaylist(@Param("id")int id);
}
