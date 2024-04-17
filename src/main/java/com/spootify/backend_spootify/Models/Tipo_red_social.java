package com.spootify.backend_spootify.Models;

import java.sql.Blob;
import java.sql.Clob;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_TIPO_REDES_SOCIALES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Tipo_red_social {
    
    @Id
    @Column(name = "id_red_social")
    private int idRedSocial;

    private String nombre_red_social;

    private String icono_red_social;

    @OneToMany(mappedBy = "red_social")
    private List<Usuario_red_social> usuario_red_socials;
}
