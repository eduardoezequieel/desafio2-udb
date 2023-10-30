package desafio2.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

public class GenerateCode {
    private static final Logger log = Logger.getLogger(GenerateCode.class);
    private String code;
    private ArrayList<String> allowedTypes = new ArrayList<>(Arrays.asList("Libro", "Revista", "CD", "DVD"));
    
    public String getCode() {
        return code;
    }
    
    public GenerateCode(String type){
        if(!allowedTypes.contains(type)) {
            log.error("ERROR: Tipo de material desconocido");
            code = "invalid";
            return;
        }
        
        String latestCode = getLatestCode(type);
        code = generateCode(latestCode);
    }
    
    private String generateCode(String latestCode) {
        String prefix = latestCode.substring(0, 3);
        String numericPart = latestCode.substring(3);
        
        int newCode = Integer.parseInt(numericPart) + 1;
        
        String newNumericPart = String.format("%05d", newCode);
        
        return prefix + newNumericPart;
    }
    
    private String getLatestCode(String type) {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        String code = "";
        
        try {
            int materialType = 0;
            
            if (type == "Libro") materialType = 1;
            if (type == "Revista") materialType = 2;
            if (type == "CD") materialType = 3;
            if (type == "DVD") materialType = 4;
            
            String sql = "SELECT codigo FROM material WHERE tipo_material_id = ? ORDER BY codigo DESC LIMIT 1";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setInt(1, materialType);
            ResultSet rs = pst.executeQuery();
           
            while (rs.next()) {                
                code = rs.getString("codigo");
            }
            
            cn.close();
            pst.close();
            rs.close();
            
            log.info("INFO: Se obtuvo el ultimo codigo asignado correctamente.");
            
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Sucedio un problema al obtener el ultimo código disponible. Contacta con el administrador");
        }
        
        if (code.length() == 0) {
            if (type == "Libro") code = "LIB00000";
            if (type == "Revista") code = "REV00000";
            if (type == "CD") code = "CDA00000";
            if (type == "DVD") code = "DVD00000";
        }
        
        return code;
    }
}
