/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio2;

import desafio2.helpers.DatabaseConnection;
import desafio2.views.FrmLayout;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Eduardo
 */
public class Desafio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatabaseConnection cn = new DatabaseConnection();
        Statement st;
        ResultSet rs;
        
        try {
            st = cn.getConnection().createStatement();
            rs = st.executeQuery("SELECT * FROM material");
            
            while (rs.next()) {
                System.out.println(rs.getString("codigo"));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        FrmLayout layout = new FrmLayout();
        layout.setVisible(true);
    }
    
}
