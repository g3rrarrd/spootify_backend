package com.spootify.backend_spootify.Models;

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
@Table(name = "TBL_PODCASTERS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Podcaster {
    
    @Id
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuarios;

    private String nombre;

    private String apellido;

    @OneToMany(mappedBy = "podcaster")
    private List<Podcasts> podcasts;

    @ManyToOne
    @JoinColumn(name = "id_podcast")
    private Podcasts podcast;

}
