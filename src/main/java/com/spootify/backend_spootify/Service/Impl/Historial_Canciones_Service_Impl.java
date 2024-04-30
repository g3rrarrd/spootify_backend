package com.spootify.backend_spootify.Service.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.CancionDtoMin;
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
            PreparedStatement psHistorialC = conn.prepareStatement("select distinct to_char(fecha_reproduccion,'fmdy, dd mon yyyy') as fecha_reproduccion from tbl_historial_canciones a inner join tbl_usuario_estandar b on(a.id_historial_reproduccion = b.id_historial_de_reproduccion) where id_usuario =?");
            psHistorialC.setInt(1, id);
            ResultSet rsHistorialC = psHistorialC.executeQuery();
            List<historialCancionDto> listHistorialCanciones = new LinkedList<>();

            while (rsHistorialC.next()) {
                historialCancionDto historialCancion = new historialCancionDto();
                historialCancion.setFechaEscuchada(rsHistorialC.getString(1));
                historialCancion.setCanciones(this.traerCanciones(rsHistorialC.getString(1), id));

                listHistorialCanciones.add(historialCancion);
            }
            
            return listHistorialCanciones;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private List<CancionDtoMin> traerCanciones(String fecha, int idUsuario){
        try {
            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            PreparedStatement psCanciones = conn.prepareStatement("select a.id_media, c.nombre_media, d.nombre_usuario, e.portada from tbl_historial_canciones a inner join tbl_canciones b on (a.id_media = b.id_cancion)"+
                                                                    "inner join tbl_media c on (b.id_cancion = c.id_media) inner join tbl_usuarios d on (b.id_artista = d.id_usuario) inner join tbl_albumes e on (b.id_album = e.id_album) inner join tbl_usuario_estandar f on (a.id_historial_reproduccion = f.id_historial_de_reproduccion) where a.fecha_reproduccion = to_date(?,'fmdy, dd mon yyyy') and f.id_usuario=?");
            psCanciones.setString(1, fecha);
            psCanciones.setInt(2, idUsuario);
            ResultSet rsCanciones = psCanciones.executeQuery();

            List<CancionDtoMin> listaCanciones = new LinkedList<>();

            while (rsCanciones.next()) {
                CancionDtoMin cancion = new CancionDtoMin();

                cancion.setIdCancion(rsCanciones.getString(1));
                cancion.setNombreCancion(rsCanciones.getString(2));
                cancion.setArtistaCancion(rsCanciones.getString(3));;
                cancion.setPortada(rsCanciones.getString(4));

                listaCanciones.add(cancion);
            }

            return listaCanciones;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
}
