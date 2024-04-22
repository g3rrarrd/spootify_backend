package com.spootify.backend_spootify.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spootify.backend_spootify.Models.Tipo_usuarios;

public interface Tipo_usuario_Repository extends JpaRepository<Tipo_usuarios, Integer>{
    
}
