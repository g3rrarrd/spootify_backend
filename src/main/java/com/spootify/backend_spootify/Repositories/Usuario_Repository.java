package com.spootify.backend_spootify.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.spootify.backend_spootify.Models.Usuarios;

public interface Usuario_Repository extends JpaRepository<Usuarios, Integer>{
    
    @Query(value = "select nombre_usuario from tbl_usuarios where id_usuario = :id", nativeQuery = true)
    String obtenerNombre(@RequestParam int id);

    @Query(value = "select id_usuario,correo,contrasenia from tbl_usuarios where correo=:correo", nativeQuery = true)
    String obtenerPorCorreo(@Param("correo") String correo);

    @Query(value = "select count(1) from tbl_seguidores where id_usuario_seguido = :idSeguido and tbl_seguidores.id_usuario_seguidor = :idSeguidor", nativeQuery = true)
    int seSiguen(@RequestParam int idSeguido, @RequestParam int idSeguidor);

    @Query(value = "delete from tbl_seguidores where id_usuario_seguido = :idSeguido and id_usuario_seguidor = :idSeguidor", nativeQuery = true)
    void dejarSeguid(@Param("idSeguido")int idSeguido,@Param("idSeguidor")int idSeguidor);

    @Query(value = "Select count(1) from tbl_seguidores where id_usuario_seguidor = :id", nativeQuery = true)
    int numeroSeguidos(@RequestParam int id);

    @Query(value = "Select count(1) from tbl_seguidores where id_usuario_seguido = :id", nativeQuery = true)
    int numeroSeguidores(@RequestParam int id);

    @Query(value = "with seguidores as (select id_usuario_seguido, id_usuario_seguidor from tbl_seguidores where id_usuario_seguido = :idSeguido) select Nombre_usuario, url_foto_perfil from tbl_usuarios a inner join seguidores b on b.id_usuario_seguidor = a.id_usuario ", nativeQuery = true)
    List<String> nombreSeguidores(@RequestParam int idSeguido);

    @Query(value = "with seguidos as (select id_usuario_seguido, id_usuario_seguidor from tbl_seguidores where id_usuario_seguidor = :idSeguidor) select Nombre_usuario, url_foto_perfil from tbl_usuarios a inner join seguidos b on b.id_usuario_seguido = a.id_usuario ", nativeQuery = true)
    List<String> nombreSeguidos(@RequestParam int idSeguidor);

    @Query(value = "select url_foto_perfil from tbl_usuarios where id_usuario= :id", nativeQuery = true)
    String urlFotoPerfil(@RequestParam int id);

}
