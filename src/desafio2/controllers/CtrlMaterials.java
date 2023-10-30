package desafio2.controllers;

import desafio2.helpers.DatabaseConnection;
import desafio2.models.Editorial;
import desafio2.models.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

public class CtrlMaterials {
    private static final Logger log = Logger.getLogger(CtrlMaterials.class);
    
    public CtrlMaterials() {}
    
    public List<Material> getMaterials() {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        List<Material> materials = new ArrayList<>();
        
        try {
            String sql = "SELECT codigo, titulo, tm.nombre as tipo_material, cm.nombre as categoria_material\n" +
                        "FROM material m\n" +
                        "INNER JOIN tipo_material tm ON m.tipo_material_id = tm.id\n" +
                        "INNER JOIN categoria_material cm ON tm.categoria_material_id = cm.id";
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {            
                Material material = new Material();
                
                material.setCodigo(rs.getString("codigo"));
                material.setTitulo(rs.getString("titulo"));
                material.setTipoMaterial(rs.getString("tipo_material"));
                material.setCategoriaMaterial(rs.getString("categoria_material"));
                
                materials.add(material);
            }
            
            st.close();
            rs.close();
            cn.close();
            
            log.info("INFO: Los registros se obtuvieron correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un problema al obtener los datos. Contacta con el administrador.");
        }
        
        
        return materials;
    }
    
    public boolean deleteMaterial (String code) {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        boolean response = false;
        
        try {
            String sql = "DELETE FROM material WHERE codigo = ?";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, code);
            
            if(!pst.execute()) response = true;
            
            pst.close();
            cn.close();
            
            log.info("INFO: Se eliminó el material con código " + String.valueOf(code) + ".");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Sucedio un error al eliminar el material. Por favor contactar con el administrador");
        }
        
        return response;
    }
}
