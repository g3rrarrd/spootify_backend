package com.spootify.backend_spootify.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spootify.backend_spootify.Models.Listas_reproduccion;

public interface Biblioteca_Repository extends JpaRepository<Listas_reproduccion, Integer>{
    
    @Query(
        value = "SELECT A.ID_LISTA_REPRODUCCION, A.NOMBRE_LISTA_REPRODUCCION, \r\n" + //
                        "    A.URL_PORTADA_LISTA, A.DESCRIPCION, COUNT(C.ID_CANCION) AS CANCIONES                 \r\n" + //
                        "FROM TBL_LISTAS_REPRODUCCION A\r\n" + //
                        "INNER JOIN TBL_USUARIOS B\r\n" + //
                        "ON(A.ID_USUARIO_PROPIETARIO = B.ID_USUARIO)\r\n" + //
                        "LEFT JOIN TBL_LISTAS_Y_CANCIONES C\r\n" + //
                        "ON(A.ID_LISTA_REPRODUCCION = C.ID_LISTA_REPRODUCCION)\r\n" + //
                        "WHERE B.ID_USUARIO=:id\r\n" + //
                        "GROUP BY A.ID_LISTA_REPRODUCCION, A.NOMBRE_LISTA_REPRODUCCION, \r\n" + //
                        "    A.URL_PORTADA_LISTA, A.DESCRIPCION\r\n" + //
                        "UNION\r\n" + //
                        "SELECT A.ID_LISTA_REPRODUCCION, A.NOMBRE_LISTA_REPRODUCCION, \r\n" + //
                        "    A.URL_PORTADA_LISTA, A.DESCRIPCION, COUNT(C.ID_CANCION) AS CANCIONES                  \r\n" + //
                        "FROM TBL_LISTAS_REPRODUCCION A\r\n" + //
                        "INNER JOIN TBL_LISTAS_SEGUIDAS B\r\n" + //
                        "ON(A.ID_LISTA_REPRODUCCION = B.ID_LISTA_REPRODUCCION)\r\n" + //
                        "LEFT JOIN TBL_LISTAS_Y_CANCIONES C\r\n" + //
                        "ON(A.ID_LISTA_REPRODUCCION = C.ID_LISTA_REPRODUCCION)\r\n" + //
                        "WHERE (B.ID_USUARIO = :id)\r\n" + //
                        "GROUP BY A.ID_LISTA_REPRODUCCION, A.NOMBRE_LISTA_REPRODUCCION, \r\n" + //
                        "    A.URL_PORTADA_LISTA, A.DESCRIPCION", 
        nativeQuery = true)
    List<Object[]> getPlaylistByIdUsuario(@Param("id")int id);

    @Query(
        value = "SELECT ID_USUARIO, NOMBRE_USUARIO, URL_FOTO_PERFIL\r\n" + //
                        "FROM TBL_USUARIOS\r\n" + //
                        "WHERE (ID_USUARIO = :id)", 
        nativeQuery = true)
    Object[] getUserByid(@Param("id")int id);

    @Query(
        value = "SELECT A.ID_PODCAST, A.NOMBRE_PODCAST, A.URL_PORTADA_PODCAST, B.NOMBRE_USUARIO\r\n" + //
                        "FROM TBL_PODCASTS A\r\n" + //
                        "INNER JOIN TBL_USUARIOS B\r\n" + //
                        "ON(A.ID_PODCASTER = B.ID_USUARIO)\r\n" + //
                        "INNER JOIN TBL_SEGUIDORES C\r\n" + //
                        "ON(A.ID_PODCASTER = C.ID_USUARIO_SEGUIDO)\r\n" + //
                        "WHERE C.ID_USUARIO_SEGUIDOR = :id", 
        nativeQuery = true)
    List<Object[]> getPodcastsByIdUser(@Param("id")int id);

}
