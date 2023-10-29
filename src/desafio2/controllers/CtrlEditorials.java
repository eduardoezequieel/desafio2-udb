package desafio2.controllers;

import desafio2.helpers.DatabaseConnection;
import desafio2.models.Editorial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

public class CtrlEditorials {
    
    private static final Logger log = Logger.getLogger(CtrlEditorials.class);
    public CtrlEditorials() {}
    
    public List<Editorial> getEditorials() {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        List<Editorial> editorials = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM editorial";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {            
                Editorial editorial = new Editorial();
                
                editorial.setId(rs.getInt("id"));
                editorial.setEditorial(rs.getString("editorial"));
                
                editorials.add(editorial);
            }
            
            st.close();
            rs.close();
            cn.close();
            
            log.info("INFO: Los registros se obtuvieron correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un problema al obtener los datos. Contacta con el administrador.");
        }
        
        
        return editorials;
    }
    
    public boolean createEditorial(String editorial) {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        boolean response = false;
        
        try {
            String sql = "INSERT INTO editorial(editorial) VALUES (?)";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, editorial);
            
            if(!pst.execute()) response = true;
            
            pst.close();
            cn.close();
            
            log.info("INFO: Se creo la editorial correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Sucedio un error al guardar el registro. Por favor contactar con el administrador.");
        }
        
        return response;
    }
    
    public boolean updateEditorial (String editorial, int id) {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        boolean response = false;
        
        try {
            String sql = "UPDATE editorial SET editorial = ? WHERE id = ?";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, editorial);
            pst.setInt(2, id);
            
            if(!pst.execute()) response = true;
            
            pst.close();
            cn.close();
            log.info("INFO: Se actualizo la editorial con id " +String.valueOf(id)+  " correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Sucedio un error al actualizar el registro. Por favor contactar con el administrador");
        }
        
        return response;
    }
    
    public boolean deleteRelatedMaterials (int editorialId) {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        boolean response = false;
        
        try {
            String sql = "DELETE FROM material WHERE editorial_id = ?";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, editorialId);
            
            if(!pst.execute()) response = true;
            
            pst.close();
            cn.close();
            
            log.info("INFO: Se eliminaron los materiales relacionados a la editorial con id " + String.valueOf(editorialId) + ".");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Sucedio un error al eliminar los materiales relacionados. Por favor contactar con el administrador");
        }
        
        return response;
    }
    
    public boolean deleteEditorial (int id) {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        boolean response = false;
        
        try {
            String sql = "DELETE FROM editorial WHERE id = ?";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            
            if(!pst.execute()) response = true;
            
            pst.close();
            cn.close();
            
            log.info("INFO: Se elimino la editorial con id " + String.valueOf(id) + ".");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Sucedio un error al eliminar la editorial. Por favor contactar con el administrador");
        }
        
        return response;
    }
    
    
}
