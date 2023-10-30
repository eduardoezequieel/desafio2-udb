package desafio2.controllers;

import desafio2.helpers.DatabaseConnection;
import desafio2.models.Book;
import desafio2.models.Magazine;
import desafio2.models.Periodicity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

public class CtrlMagazines {
    private static final Logger log = Logger.getLogger(CtrlMagazines.class);
    
    public CtrlMagazines() {}
    
    public List<Periodicity> getPeriodicites() {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        List<Periodicity> periodicities = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM periodicidad";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {            
                Periodicity periodicity = new Periodicity();
                
                periodicity.setId(rs.getInt("id"));
                periodicity.setPeriodicidad(rs.getString("periodicidad"));
                
                periodicities.add(periodicity);
            }
            
            st.close();
            rs.close();
            cn.close();
            
            log.info("INFO: Los registros de periodicidad se obtuvieron correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un problema al obtener los datos. Contacta con el administrador.");
        }
        
        
        return periodicities;
    }
    
    public Magazine getMagazine(String code) {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        Magazine magazine = new Magazine();
        
        try {
            String sql = "SELECT codigo, titulo, periodicidad_id, fecha_publicacion, unidades, tipo_material_id, editorial_id FROM material WHERE codigo = ?";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, code);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {            
                magazine.setCodigo(rs.getString("codigo"));
                magazine.setTitulo(rs.getString("titulo"));
                magazine.setPeriodicidadId(rs.getInt("periodicidad_id"));
                magazine.setFechaPublicacion(rs.getString("fecha_publicacion"));
                magazine.setUnidades(rs.getInt("unidades"));
                magazine.setTipoMaterialId(rs.getInt("tipo_material_id"));
                magazine.setEditorialId(rs.getInt("editorial_id"));
            }
            
            pst.close();
            rs.close();
            cn.close();
            
            log.info("INFO: El registro de revista se obtuvo correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un problema al obtener la revista. Contacta con el administrador.");
        }
        
        return magazine;
    }
    
    public boolean createMagazine(Magazine magazine) {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        boolean response = false;
        
        try {
            String sql = "INSERT INTO material(codigo, titulo, periodicidad_id, fecha_publicacion, unidades, tipo_material_id, editorial_id) VALUES (?,?,?,?,?,?,?)";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, magazine.getCodigo());
            pst.setString(2, magazine.getTitulo());
            pst.setInt(3, magazine.getPeriodicidadId());
            pst.setString(4, magazine.getFechaPublicacion());
            pst.setInt(5, magazine.getUnidades());
            pst.setInt(6, magazine.getTipoMaterialId());
            pst.setInt(7, magazine.getEditorialId());
            
            if(!pst.execute()) response = true;
            
            pst.close();
            cn.close();
            
            log.info("INFO: Se creo la revista correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Sucedio un error al guardar el registro. Por favor contactar con el administrador.");
        }
        
        return response;
    }
    
     public boolean updateMagazine(Magazine magazine) {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        boolean response = false;
        
        try {
            String sql = "UPDATE material SET titulo = ?, periodicidad_id = ?, fecha_publicacion = ?, unidades = ?, tipo_material_id = ?, editorial_id = ? WHERE codigo = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, magazine.getTitulo());
            pst.setInt(2, magazine.getPeriodicidadId());
            pst.setString(3, magazine.getFechaPublicacion());
            pst.setInt(4, magazine.getUnidades());
            pst.setInt(5, magazine.getTipoMaterialId());
            pst.setInt(6, magazine.getEditorialId());
            pst.setString(7, magazine.getCodigo());
            
            if(!pst.execute()) response = true;
            
            pst.close();
            cn.close();
            
            log.info("INFO: Se actualizó la revista correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Sucedio un error al actualizar el registro. Por favor contactar con el administrador.");
        }
        
        return response;
    }
}
