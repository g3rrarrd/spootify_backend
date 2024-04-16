package com.spootify.backend_spootify.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spootify.backend_spootify.Models.Paises;

public interface Paises_Repository extends JpaRepository<Paises, Integer>{
    
    @Query(value = "select count(1) from tbl_paises", nativeQuery = true)
    int contarPaises();

    @Query(value = "delete from tbl_paises where id_paises = :id", nativeQuery = true)
    void eliminarPais(@Param("id")int id);

    @Query(value = "Select nombre_pais from tbl_paises", nativeQuery = true)
    List<String> obtenerNombre();
}
