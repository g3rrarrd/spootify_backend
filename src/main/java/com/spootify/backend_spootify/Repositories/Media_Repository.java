package com.spootify.backend_spootify.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spootify.backend_spootify.Models.Media;

public interface Media_Repository extends JpaRepository<Media,Integer>{
    
}
