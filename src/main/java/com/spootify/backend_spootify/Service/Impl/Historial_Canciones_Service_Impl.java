package com.spootify.backend_spootify.Service.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.artistaDto;
import com.spootify.backend_spootify.Dtos.cancionDto;
import com.spootify.backend_spootify.Dtos.historialCancionDto;
import com.spootify.backend_spootify.OracleData.oraData;
import com.spootify.backend_spootify.Service.Historial_Canciones_Service;

@Service
public class Historial_Canciones_Service_Impl implements Historial_Canciones_Service{

    @Override
    public List<historialCancionDto> traerHistorialCanciones(int id) {
        
        return traerHistorial(id);

    }

    private List<historialCancionDto> traerHistorial(int id){
        try {
            
            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            PreparedStatement psHistorialC = conn.prepareStatement("select  a.id_historial_reproduccion, b.id_media, e.nombre_usuario, e.url_foto_perfil, f.biografia, e.fecha_nacimiento, b.nombre_media, g.portada, TO_CHAR(a.fecha_reproduccion, 'dd-mm') fecha_reproduccion from tbl_historial_canciones a inner join tbl_media b on a.id_media = b.id_media inner join tbl_usuario_estandar c on a.id_historial_reproduccion = c.id_historial_de_reproduccion inner join tbl_canciones d on b.id_media = d.id_cancion inner join tbl_usuarios e on d.id_artista = e.id_usuario inner join tbl_artistas f on d.id_artista = f.id_usuario inner join tbl_albumes g on d.id_album = g.id_album where c.id_usuario = ?");
            psHistorialC.setInt(1, id);
            ResultSet rsHistorialC = psHistorialC.executeQuery();
            List<historialCancionDto> listHistorialCanciones = new LinkedList<>();

            while (rsHistorialC.next()) {
                historialCancionDto historialCancion = new historialCancionDto();
                cancionDto cancion = new cancionDto();
                artistaDto aritsta = new artistaDto();

                cancion.setIdCancion(rsHistorialC.getInt(2));
                aritsta.setNombre(rsHistorialC.getString(3));
                aritsta.setFoto(rsHistorialC.getString(4));
                aritsta.setBiografia(rsHistorialC.getString(5));
                aritsta.setFechaNacimiento(rsHistorialC.getString(6));
                cancion.setArtista(aritsta);
                cancion.setNombreCancion(rsHistorialC.getString(7));
                cancion.setPortada(rsHistorialC.getString(8));

                historialCancion.setCancion(cancion);
                historialCancion.setFechaEscuchada(rsHistorialC.getString(9));

                listHistorialCanciones.add(historialCancion);
            }
            
            return listHistorialCanciones;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
}
