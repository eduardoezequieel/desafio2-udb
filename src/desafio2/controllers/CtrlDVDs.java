package desafio2.controllers;

import desafio2.helpers.DatabaseConnection;
import desafio2.models.Cd;
import desafio2.models.Dvd;
import desafio2.models.Gender;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

public class CtrlDVDs {
    private static final Logger log = Logger.getLogger(CtrlDVDs.class);
    
    public List<Gender> getGenders() {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        List<Gender> genders = new ArrayList<>();
        
        try {
            String sql = "SELECT*FROM genero WHERE tipo_genero_id = 2;";
            
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
            
            log.info("INFO: Los registros de generos para DVDs se obtuvieron correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un problema al obtener los datos de autores. Contacta con el administrador.");
        }
        
        return genders;
    }
    
    public boolean createDvd(Dvd dvd) {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        boolean response = false;
        
        try {
            String sql = "INSERT INTO material(codigo, titulo, creador_id, genero_id, duracion, tipo_material_id) VALUES (?,?,?,?,?,?)";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, dvd.getCodigo());
            pst.setString(2, dvd.getTitulo());
            pst.setInt(3, dvd.getCreadorId());
            pst.setInt(4, dvd.getGeneroId());
            pst.setString(5, dvd.getDuracion());
            pst.setInt(6, dvd.getTipoMaterialId());
            
            if(!pst.execute()) response = true;
            
            pst.close();
            cn.close();
            
            log.info("INFO: Se creo el DVD correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Sucedio un error al guardar el registro. Por favor contactar con el administrador.");
        }
        
        return response;
    }
}
