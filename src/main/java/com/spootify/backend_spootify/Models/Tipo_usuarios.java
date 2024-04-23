package com.spootify.backend_spootify.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "TBL_TIPO_USUARIO")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tipo_usuarios {
    
    @Id
    @Column(name = "id_tipo_usuario")
    private int idTipoUsuario;

    @Column(name = "tipo_usuario")
    private String tipo_usuario;

    @OneToMany(mappedBy = "tipo_usuarios")
    @JsonIgnore
    private List<Usuarios> usuarios;

}
