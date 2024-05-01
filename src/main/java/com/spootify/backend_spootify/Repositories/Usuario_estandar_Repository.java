package com.spootify.backend_spootify.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.spootify.backend_spootify.Models.Usuario_Estandar;

public interface Usuario_estandar_Repository extends JpaRepository<Usuario_Estandar, Integer>{
    
    @Query(value = "select count(1) from tbl_historial_de_reproduccion", nativeQuery = true)
    int contarHisotrialRep();

    @Query(value = "select count(1) from tbl_pago_planes", nativeQuery = true)
    int contarPagoPlanes();

    @Query(value = "select count(1) from tbl_usuarios", nativeQuery = true)
    int contarUsuarios();

    @Query(value = "delete from tbl_usuario_estandar where id_usuario = :id", nativeQuery = true)
    void eliminarUsuario(@RequestParam int id);

    @Query(value = "with acierto_correo as (select * from tbl_usuarios where correo like :correo and contrasenia like :contrasenia) select nombre_usuario, url_foto_perfil ,nombre_plan, correo, nombre_genero, tipo_usuario, e.nombre_pais, a.id_usuario from acierto_correo a, tbl_usuario_estandar b, tbl_pago_planes c, tbl_planes d, tbl_paises e, tbl_tipo_usuario f, tbl_genero g WHERE a.id_usuario = b.id_usuario and a.id_pais = e.id_pais and a.id_genero = g.id_genero and a.id_tipo_usuario = f.id_tipo_usuario and c.id_usuario = b.id_usuario and c.id_plan = d.id_plan", nativeQuery = true)
    String validarUsuario(String correo, String contrasenia);

    @Query(value = "select count(1) from tbl_listas_reproduccion", nativeQuery = true)
    int contarListas(@Param("id")int id);

    @Query(value = "select nombre_lista_reproduccion from tbl_listas_reproduccion where id_usuario_propietario = :id", nativeQuery = true)
    List<String> nombreListas(@Param("id")int id);

    @Query(value = "select count(1) from tbl_tarjetas", nativeQuery = true)
    int contarTarjetas();

    @Query(value = "select id_lista_reproduccion from tbl_listas_reproduccion where id_usuario_propietario=:id and id_tipo_lista=5", nativeQuery = true)
    int obtenerIdLikedPlaylist(@Param("id")int id);

}
