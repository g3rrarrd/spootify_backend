package com.spootify.backend_spootify.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spootify.backend_spootify.Models.Usuarios;

public interface Usuario_Repository extends JpaRepository<Usuarios, Integer>{
    
}
