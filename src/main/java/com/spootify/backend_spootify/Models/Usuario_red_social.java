package com.spootify.backend_spootify.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_USUARIO_RED_SOCIAL")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Usuario_red_social {
    
    @Id
    @Column(name = "id_red_social")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRedSocial;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    private String user_name;

}
