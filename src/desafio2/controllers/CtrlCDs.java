package desafio2.controllers;

import desafio2.helpers.DatabaseConnection;
import desafio2.models.Cd;
import desafio2.models.Gender;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

public class CtrlCDs {
    private static final Logger log = Logger.getLogger(CtrlCDs.class);
    
    public List<Gender> getGenders() {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        List<Gender> genders = new ArrayList<>();
        
        try {
            String sql = "SELECT*FROM genero WHERE tipo_genero_id = 1;";
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {            
                Gender gender = new Gender();
                
                gender.setId(rs.getInt("id"));
                gender.setGenero(rs.getString("genero"));
                
                genders.add(gender);
            }
            
            st.close();
            rs.close();
            cn.close();
            
            log.info("INFO: Los registros de generos para CDs se obtuvieron correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un problema al obtener los datos de autores. Contacta con el administrador.");
        }
        
        return genders;
    }
    
    public Cd getCd(String code) {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        Cd cd = new Cd();
        
        try {
            String sql = "SELECT codigo, titulo, creador_id, genero_id, duracion, numero_canciones, unidades, tipo_material_id FROM material WHERE codigo = ?";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, code);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {            
                cd.setCodigo(rs.getString("codigo"));
                cd.setTitulo(rs.getString("titulo"));
                cd.setArtistId(rs.getInt("creador_id"));
                cd.setGeneroId(rs.getInt("genero_id"));
                cd.setDuracion(rs.getString("duracion"));
                cd.setNumero_canciones(rs.getInt("numero_canciones"));
                cd.setUnidades(rs.getInt("unidades"));
                cd.setTipoMaterialId(rs.getInt("tipo_material_id"));
            }
            
            pst.close();
            rs.close();
            cn.close();
            
            log.info("INFO: El registro de CD se obtuvo correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un problema al obtener la revista. Contacta con el administrador.");
        }
        
        return cd;
    }
    
    public boolean createCd(Cd cd) {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        boolean response = false;
        
        try {
            String sql = "INSERT INTO material(codigo, titulo, creador_id, genero_id, duracion, numero_canciones, unidades, tipo_material_id) VALUES (?,?,?,?,?,?,?,?)";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, cd.getCodigo());
            pst.setString(2, cd.getTitulo());
            pst.setInt(3, cd.getArtistId());
            pst.setInt(4, cd.getGeneroId());
            pst.setString(5, cd.getDuracion());
            pst.setInt(6, cd.getNumero_canciones());
            pst.setInt(7, cd.getUnidades());
            pst.setInt(8, cd.getTipoMaterialId());
            
            if(!pst.execute()) response = true;
            
            pst.close();
            cn.close();
            
            log.info("INFO: Se creo el CD correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Sucedio un error al guardar el registro. Por favor contactar con el administrador.");
        }
        
        return response;
    }
    
    public boolean updateCd(Cd cd) {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        boolean response = false;
        
        try {
            String sql = "UPDATE material SET titulo = ?, creador_id = ?, genero_id = ?, duracion = ?, numero_canciones = ?, unidades = ?, tipo_material_id = ? WHERE codigo = ?";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, cd.getTitulo());
            pst.setInt(2, cd.getArtistId());
            pst.setInt(3, cd.getGeneroId());
            pst.setString(4, cd.getDuracion());
            pst.setInt(5, cd.getNumero_canciones());
            pst.setInt(6, cd.getUnidades());
            pst.setInt(7, cd.getTipoMaterialId());
            pst.setString(8, cd.getCodigo());
            
            if(!pst.execute()) response = true;
            
            pst.close();
            cn.close();
            
            log.info("INFO: Se actualizó el CD correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Sucedio un error al actualizar el registro. Por favor contactar con el administrador.");
        }
        
        return response;
    }
}
