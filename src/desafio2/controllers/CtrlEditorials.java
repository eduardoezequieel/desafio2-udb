package desafio2.controllers;

import desafio2.helpers.DatabaseConnection;
import desafio2.models.Editorial;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CtrlEditorials {
    private Connection cn;
    
    public CtrlEditorials() {
        DatabaseConnection dbcn = new DatabaseConnection();
        cn = dbcn.getConnection();
    }
    
    public List<Editorial> getEditorials() {
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return editorials;
    }
}
