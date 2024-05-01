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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_HISTORiAL_DE_REPRODUCCION")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Historial_reproduccion {
    
    @Id
    @Column(name = "id_historial_reproduccion")
    private int id_HistorialRepr;


    @OneToMany(mappedBy = "historial_reproduccion")
    private List<Historial_Media> historial_Canciones;

    @OneToMany(mappedBy = "hisotrial_reproduccion")
    private List<Usuario_Estandar> Usuario_Estandar;
}
