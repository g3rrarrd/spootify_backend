package com.spootify.backend_spootify.Services.Impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.stereotype.Service;

import com.spootify.backend_spootify.Models.Tipo_red_social;
import com.spootify.backend_spootify.Models.red_social;
import com.spootify.backend_spootify.OracleData.oraData;
import com.spootify.backend_spootify.Repositories.Tipo_red_social_Repository;
import com.spootify.backend_spootify.Services.Tipo_red_social_Service;

import ch.qos.logback.core.util.FileUtil;
import oracle.sql.BLOB;
import oracle.sql.BlobDBAccess;

@Service
public class Tipo_red_social_Service_Impl implements Tipo_red_social_Service{

	public static final String  sql = "insert into TBL_tipo_redes_sociales(ID_RED_SOCIAL, NOMBRE_RED_SOCIAL, ICONO_RED_SOCIAL) values(?, ?, ?)";
    public static final String lectura = "select * from TBL_tipo_redes_sociales where id_red_social = ?";
    public static final String leer_todos = "select * from TBL_tipo_redes_sociales";

    @Autowired
    private Tipo_red_social_Repository tipo_red_social_Repository;

    @Override
    public void insertarRedSocial(red_social red_social) {
         try {

           Class.forName(oraData.driver);

           Connection conn = DriverManager.getConnection(oraData.url , oraData.userid, oraData.password);

           PreparedStatement ps = conn.prepareStatement(sql);

           if(this.tipo_red_social_Repository.contarRegistros() > 0){
                ps.setInt(1, this.tipo_red_social_Repository.contarRegistros() + 1);
            
           }
           else{
                ps.setInt(1, 1);
           }

           ps.setString(2, red_social.getNombre());

           byte[] imageBytes = FileUtils.readFileToByteArray(new File(red_social.getUrl()));
           String base64Image = Base64.getEncoder().encodeToString(imageBytes);

           ps.setString(3, base64Image);
           
           ps.executeUpdate();

           conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public Map<String, String> obtenerRedSocial(int id) {
           try {
            Class.forName(oraData.driver);

            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
 
            PreparedStatement ps = conn.prepareStatement(lectura);
            //retrieve
 
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                int fileid = rs.getInt(1);
                String fileName = rs.getString(2);

                String b = rs.getString(3);

                String iconoBase64 = bytesFile(b, fileName);
                
                Map<String, String> valores = new HashMap<>();
                valores.put(fileName, iconoBase64);
                conn.close();
                return valores;
            }
            conn.close();
            return null;
            
           } catch (Exception e) {
            e.printStackTrace();
            return null;
           }
    }

    @Override
    public Map<String, String> obtenerRedesSociales() {
        try {
            Map<String, String> valores = new HashMap<>();

            Class.forName(oraData.driver);

            Connection conn = DriverManager.getConnection(oraData.url, oraData.userid, oraData.password);
 
            PreparedStatement ps = conn.prepareStatement(leer_todos);
            //retrieve
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                String fileName = rs.getString(2);

                String b = rs.getString(3);
                
               String iconoBase64 = bytesFile(b, fileName);

                valores.put(fileName, iconoBase64);
                
            }

            conn.close();
            return valores;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    
    @Override
    public void eliminarRedSocial(int id) {
        try {
            
            this.tipo_red_social_Repository.eliminarRegistro(id);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizarRedSocial(int id, red_social red_social) {
        
        try {

           this.tipo_red_social_Repository.actualizar_sociales(red_social.getNombre(), id);
 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    private String bytesFile(String file, String fileName) {
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
 
 
}
