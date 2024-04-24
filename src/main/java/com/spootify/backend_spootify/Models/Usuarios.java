package com.spootify.backend_spootify.Models;


import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @OneToOne(mappedBy = "usuario")
    private Usuario_Estandar usuario_Estandar;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario")
    private Tipo_usuarios tipo_usuarios;

    @OneToMany(mappedBy = "usuarios1")
    private List<Seguidores> seguidores;

    @OneToMany(mappedBy = "usuarios2")
    private List<Seguidores> seguidos;
}
