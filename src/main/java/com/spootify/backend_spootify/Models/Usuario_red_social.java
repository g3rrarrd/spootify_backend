package com.spootify.backend_spootify.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name = "id_red_social")
    private Tipo_red_social red_social;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Artistas artistas;

    private String user_name;

}
