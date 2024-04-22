package com.spootify.backend_spootify.Models;

import java.util.List;

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
@Builder
@Table(name = "TBL_TIPO_MEDIA")
@NoArgsConstructor
@AllArgsConstructor
public class Tipo_Media {
    
    @Id
    private int id_tipo_media;

    private String tipo_media;

    @OneToMany(mappedBy = "tipo_media")
    private List<Media> medias;

}
