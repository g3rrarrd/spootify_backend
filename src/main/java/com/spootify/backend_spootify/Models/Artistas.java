package com.spootify.backend_spootify.Models;

import java.sql.Clob;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_ARTISTAS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Artistas {
    
    @Id
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuarios;

    @ManyToOne
    @JoinColumn(name = "id_merch")
    private Merch merch;

    private int oyentes_mensuales;

    private Clob biografia;

    @OneToMany(mappedBy = "artistas")
    private List<Albumes> albumes;

    @OneToMany(mappedBy = "artistas")
    private List<Creditos> creditos;

    @OneToMany(mappedBy = "artistas")
    private List<Canciones> canciones;

    @OneToMany(mappedBy = "artistas")
    private List<Eventos> eventos;

    @OneToMany(mappedBy = "artistas")
    private List<Usuario_red_social> usuario_red_socials;

    @ManyToMany(mappedBy = "artistasmany")
    private List<Canciones> cancionesmany;
}
