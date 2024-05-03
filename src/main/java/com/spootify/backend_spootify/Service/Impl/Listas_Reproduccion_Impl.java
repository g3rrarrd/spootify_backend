package com.spootify.backend_spootify.Service.Impl;

    import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.annotations.TimeZoneStorage;
import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Dtos.caratulaCancionDto;
import com.spootify.backend_spootify.Dtos.caratulaPlaylistDto;
import com.spootify.backend_spootify.Dtos.playlistDto;
import com.spootify.backend_spootify.OracleData.oraData;
import com.spootify.backend_spootify.Repositories.Listas_Reproduccion_Repository;
import com.spootify.backend_spootify.Service.Listas_Reproduccion_Service;
    
    
    @Service
public class Listas_Reproduccion_Impl implements Listas_Reproduccion_Service {
    @Autowired
    Listas_Reproduccion_Repository listas;

    @Override
    public playlistDto obtenerPlaylistsTopGlobal() {
        List<Object[]> playlistTop = listas.getCancionesMasEscuchadas();

        //Metodo para Ontener Canciones de Playlist
        List<caratulaCancionDto> canciones = new LinkedList<>();
        for (Object obj : playlistTop) {
            Object[] songInfo = (Object[]) obj; 
            
            caratulaCancionDto cancion = new caratulaCancionDto();
            BigDecimal id_cancion = (BigDecimal) songInfo[0];
            cancion.setId_cancion(id_cancion);
            cancion.setNombreCancion((String) songInfo[6]);
            cancion.setPortadaCancion((String) songInfo[3]);
            cancion.setArtistaCancion((String) songInfo[3]);

            canciones.add(cancion);
        }
        Object[] playlistView = listas.getPlaylistView(1);
        playlistDto playlist = new playlistDto();
        for (Object obj : playlistView) {
            Object[] songInfo = (Object[]) obj; // Convertir el objeto en un array de objetos

            BigDecimal id_playlist = (BigDecimal) songInfo[0];
            playlist.setId_playlist(id_playlist);
            playlist.setPortadaPlaylist((String) songInfo[1]);
            playlist.setNombrePlaylist((String) songInfo[2]);
            playlist.setDescripcion((String) songInfo[3]);
            playlist.setNombreUsuario((String) songInfo[4]);
            BigDecimal guardados = (BigDecimal) songInfo[6];
            playlist.setGuardados(guardados);
            playlist.setFotoUsuario((String) songInfo[5]);
        
        }
        playlist.setCanciones(canciones);
        //playlist.setNombrePlaylist(playlistView);
        return playlist;
    }



    @Override
    public playlistDto obtenerPlaylistsTopPais() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPlaylistsTopPais'");
    }

    @Override
    public List<caratulaPlaylistDto> obtenerPlaylistCreadas(int id) {
        List<Object[]> playlistTop = listas.getPlaylistByIdUsuario(id);
        //Metodo para Obtener las playlist del usuario
        List<caratulaPlaylistDto> playlists = new LinkedList<>();
        for (Object obj : playlistTop) {
            Object[] songInfo = (Object[]) obj; 
            
            caratulaPlaylistDto playlist = new caratulaPlaylistDto();
            BigDecimal id_playlist = (BigDecimal) songInfo[0];
            playlist.setId_Playlist(id_playlist);
            playlist.setNombrePlaylist((String) songInfo[1]);
            playlist.setPortadaPlaylist((String) songInfo[2]); 
            playlist.setDescripcion((String) songInfo[3]);

            playlists.add(playlist);
        }
        
        return playlists;
    }

    @Override
    public playlistDto obtenerDailyMix() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerDailyMix'");
    }

    @Override
    public List<playlistDto> obtenerHitsMasEscuchados() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerHitsMasEscuchados'");
    }

    @Override
    public Boolean crarPlaylist(String nombrePlaylist, String descripcion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crarPlaylist'");
    }

    public List<caratulaCancionDto> getSongsById(int id){

        List<Object[]> songsPlaylist = listas.getListaCancionesPlaylist(id);

        //Metodo para Obtener Canciones de Playlist
        List<caratulaCancionDto> canciones = new LinkedList<>();
        for (Object obj : songsPlaylist) {
            Object[] songInfo = (Object[]) obj; 
            System.out.println(songInfo);
            caratulaCancionDto cancion = new caratulaCancionDto();
            BigDecimal id_cancion = (BigDecimal) songInfo[0];
            cancion.setId_cancion(id_cancion);
            cancion.setNombreCancion((String) songInfo[1]);
            cancion.setPortadaCancion((String) songInfo[2]); 
            cancion.setArtistaCancion((String) songInfo[3]);
            cancion.setColor((String) songInfo[4]);

            canciones.add(cancion);
            
        }
        return canciones;
    }

    public List<caratulaCancionDto> getTop50Songs(int id){

        List<Object[]> playlistTop = listas.getCancionesMasEscuchadas();

        //Metodo para Ontener Canciones de Playlist
        List<caratulaCancionDto> canciones = new LinkedList<>();
        for (Object obj : playlistTop) {
            Object[] songInfo = (Object[]) obj; 
            
            caratulaCancionDto cancion = new caratulaCancionDto();
            BigDecimal id_cancion = (BigDecimal) songInfo[0];
            cancion.setId_cancion(id_cancion);
            cancion.setNombreCancion((String) songInfo[2]);
            cancion.setPortadaCancion((String) songInfo[1]);
            cancion.setArtistaCancion((String) songInfo[3]);

            canciones.add(cancion);
        }
        return canciones;
    }

    public List<caratulaCancionDto> getTopCountrySongs(int id){

        List<Object[]> playlistTop = listas.getSongsByIdCountry(id);

        //Metodo para Ontener Canciones de Playlist
        List<caratulaCancionDto> canciones = new LinkedList<>();
        for (Object obj : playlistTop) {
            Object[] songInfo = (Object[]) obj; 
            
            caratulaCancionDto cancion = new caratulaCancionDto();
            BigDecimal id_cancion = (BigDecimal) songInfo[0];
            cancion.setId_cancion(id_cancion);
            cancion.setNombreCancion((String) songInfo[3]);
            cancion.setPortadaCancion((String) songInfo[4]);
            cancion.setArtistaCancion((String) songInfo[5]);

            canciones.add(cancion);
        }
        return canciones;
    }


    @Override
    public playlistDto getPlaylistById(int id) {

        Object[] playlistView = listas.getPlaylistView(id);
        playlistDto playlist = new playlistDto();
        BigDecimal tipoLista = BigDecimal.ZERO;
        for (Object obj : playlistView) {
            Object[] songInfo = (Object[]) obj; // Convertir el objeto en un array de objetos

            BigDecimal id_playlist = (BigDecimal) songInfo[0];
            playlist.setId_playlist(id_playlist);
            playlist.setPortadaPlaylist((String) songInfo[1]);
            playlist.setNombrePlaylist((String) songInfo[2]);
            playlist.setDescripcion((String) songInfo[3]);
            playlist.setNombreUsuario((String) songInfo[4]);
            BigDecimal guardados = (BigDecimal) songInfo[6];
            playlist.setGuardados(guardados);
            playlist.setFotoUsuario((String) songInfo[5]);
            tipoLista = (BigDecimal) songInfo[7];
        }
        int intValue = tipoLista.intValue();
        if(id == 1){
            playlist.setCanciones(getTop50Songs(id));
        } else if (id != 1 && intValue==1) {
            playlist.setCanciones(getTopCountrySongs(id));
        } else {
            playlist.setCanciones(getSongsById(id));
        }
        
        //playlist.setNombrePlaylist(playlistView);
        return playlist;
    }



    @Override
    public Boolean addSongToPlaylist(int idCancion, int idPlaylist) {
        try {
            java.sql.Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            conn.setAutoCommit(false); 

            PreparedStatement ps = conn.prepareStatement("insert into tbl_listas_y_canciones values(?,?)");
            ps.setInt(1, idPlaylist);
            ps.setInt(2, idCancion);

            ps.executeUpdate();
            conn.commit();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

   
    
    
      
}
