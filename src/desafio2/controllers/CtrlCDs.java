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
            
            log.info("INFO: Se creo el libro correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Sucedio un error al guardar el registro. Por favor contactar con el administrador.");
        }
        
        return response;
    }
}
