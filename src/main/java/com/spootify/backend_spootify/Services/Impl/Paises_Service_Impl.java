package com.spootify.backend_spootify.Services.Impl;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Models.Paises;
import com.spootify.backend_spootify.Models.paisJson;
import com.spootify.backend_spootify.OracleData.oraData;
import com.spootify.backend_spootify.Repositories.Paises_Repository;
import com.spootify.backend_spootify.Services.Paises_Service;

import oracle.sql.BLOB;

@Service
public class Paises_Service_Impl implements Paises_Service{

    @Autowired
    private Paises_Repository paises_Repository;

    @Autowired
    private Idiomas_Service_Impl idiomas_Service_Impl;

    @Override
    public void insertarPais(paisJson pais) {
       try {
        Class.forName(oraData.driver);

        Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);

        PreparedStatement ps = conn.prepareStatement("insert into tbl_paises values(?,?,?,?,?)");

            if(pais.getNombre_pais().length() > 0 && pais.getIdioma() != 0){
                if (this.paises_Repository.contarPaises() > 0) {
                    ps.setInt(1, this.paises_Repository.contarPaises() + 1);
                
                }else{
                    ps.setInt(1, 1);
                }
    
                ps.setString(2, pais.getNombre_pais());
                ps.setString(3, pais.getAbreviacion_pais());
                ps.setString(4, bytesFileEscritura(pais));
                ps.setInt(5, pais.getIdioma());
                ps.executeUpdate();
                conn.close();
    
            }

       } catch (Exception e) {
        // TODO: handle exception
       }
    }

    @Override
    public void eliminarPais(int id) {
       try {
        this.paises_Repository.eliminarPais(id);
       } catch (Exception e) {
        e.printStackTrace();
       }
    }

    @Override
    public List<Paises> obtenerPaises() {

        try {
            
            Class.forName(oraData.driver);

            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);

            PreparedStatement ps = conn.prepareStatement("Select * from tbl_paises");

            List<Paises> paises = new LinkedList<>();

            ResultSet rs = ps.executeQuery();
            Paises pais = new Paises();
            while (rs.next()) {
                
                pais.setIdPais(rs.getInt(1));
                pais.setNombre_pais(rs.getString(2));
                pais.setAbreviacion_pais(rs.getString(3));
                String file = rs.getString(4);
                bytesFileLectura(file, pais.getNombre_pais());
                pais.setIdiomas(this.idiomas_Service_Impl.buscarIdioma(rs.getInt(5)));

                paises.add(pais);

            }

            conn.close();

            return paises;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }


    }

    @Override
    public Map<String, String[]> buscarPaises(int id) {
        
        try {
            Class.forName(oraData.driver);

            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
            PreparedStatement ps = conn.prepareStatement("Select nombre_pais, id_idioma ,icono_pais from tbl_paises where id_pais = ?");

            Map<String, String[]> valores = new HashMap<>();

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
           if (rs.next()) {
                String[] cadena = new String[2];

                cadena[0] = this.idiomas_Service_Impl.buscarIdioma(rs.getInt(2)).getNombre_idioma();
                cadena[1] = onlyRead(rs.getString(3));
                valores.put(rs.getString(1), cadena);

           }

           conn.close();
           
            return valores;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<String> nombrePaises() {
        try {
            return this.paises_Repository.obtenerNombre();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    
    private String bytesFileLectura(String file, String fileName) {
        try {

            byte[] byte_array = Base64.getDecoder().decode(file);
            String userHome = System.getProperty("user.home");
            FileUtils.writeByteArrayToFile(new File(userHome + File.separator + "Desktop\\Data\\" + fileName + ".jpg"), byte_array); 
            String iconoBase64 = Base64.getEncoder().encodeToString(byte_array);

            return iconoBase64;

        } catch (Exception e) {
             return null;
        }
     }

     private String onlyRead(String file){

            byte[] byte_array = Base64.getDecoder().decode(file);      
            String iconoBase64 = Base64.getEncoder().encodeToString(byte_array);

            return iconoBase64;
     }

     private String bytesFileEscritura(paisJson paisJson){
       try {
            byte[] imageBytes = FileUtils.readFileToByteArray(new File(paisJson.getUrl_pais()));
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            return base64Image;
       } catch (Exception e) {
            return null;
       }
     }

}
