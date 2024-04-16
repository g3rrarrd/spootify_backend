package com.spootify.backend_spootify.Repositories;

import java.sql.Blob;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spootify.backend_spootify.Models.Tipo_red_social;

public interface Tipo_red_social_Repository extends JpaRepository<Tipo_red_social, Integer>{
    
    
    @Query(value = "Select count(1) from tbl_tipo_redes_sociales", nativeQuery = true)
    int contarRegistros();

    @Query(value = "Select Nombre_Red, Icono_Red_Social from tbl_tipo_redes_sociales", nativeQuery = true)
    Map<String, Blob> redSocial();

    @Query(value = "delete from tbl_tipo_redes_sociales where id_red_social = :id", nativeQuery = true)
    void eliminarRegistro(@Param("id") int id);

    @Query(value = "update tbl_tipo_redes_sociales set nombre_red_social = :nombre where id_red_social =  :id ", nativeQuery = true)
    void actualizar_sociales(@Param("nombre") String nombre, @Param("id") int id);

}
