package com.spootify.backend_spootify.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.spootify.backend_spootify.Models.Plan;

public interface Planes_Repository extends JpaRepository<Plan, Integer>{
    
    @Query(value = "select * from tbl_planes where id_plan=:idPlan", nativeQuery = true)
    Object[] obtenerInfoPlan(@Param("idPlan")int idPlan);

    @Query(value = "select precio from tbl_planes where id_plan=:idPlan", nativeQuery = true)
    Float obtenerPrecio(@Param("idPlan")int idPlan);

}
