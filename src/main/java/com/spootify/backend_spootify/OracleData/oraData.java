package com.spootify.backend_spootify.OracleData;

import java.io.File;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

/**
 * oracle
 */
public class oraData {

    public static final String driver = "oracle.jdbc.driver.OracleDriver";
    public static final String  url = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String  userid = "C##SPT";
	public static final String  password = "oracle";
    
    public String bytesFile(String file, String fileName) {
        try {

            byte[] byte_array = Base64.getDecoder().decode(file);
            String iconoBase64 = Base64.getEncoder().encodeToString(byte_array);

            return iconoBase64;

        } catch (Exception e) {
             return null;
        }
     }
}
