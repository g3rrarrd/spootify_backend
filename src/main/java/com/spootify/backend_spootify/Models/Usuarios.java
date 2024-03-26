package com.spootify.backend_spootify.Models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_USUARIOS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Usuarios {
    
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    private String correo;

    private String nombre_usuario;

    private Date fecha_nacimiento;

    private Date fecha_registro;

    private String url_foto_perfil;

    private String contrasenia;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Paises pais;

    @OneToOne(mappedBy = "usuarios")
    private Artistas artistas;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;

    @OneToOne(mappedBy = "usuarios")
    private Podcaster podcaster;

    @OneToOne(mappedBy = "usuario")
    private Usuario_Estandar usuario_Estandar;
}
