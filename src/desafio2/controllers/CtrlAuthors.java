
package desafio2.controllers;

import desafio2.helpers.DatabaseConnection;
import desafio2.models.Author;
import desafio2.models.AuthorType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

public class CtrlAuthors {
    private static final Logger log = Logger.getLogger(CtrlAuthors.class);
    
    public CtrlAuthors() {}
    
    public List<Author> getAuthors() {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        List<Author> authors = new ArrayList<>();
        
        try {
            String sql = "SELECT c.id, c.nombre, tc.tipo_creador FROM creador c INNER JOIN tipo_creador tc ON tc.id = c.tipo_creador_id ORDER BY c.id ASC";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {            
                Author author = new Author();
                
                author.setId(rs.getInt("id"));
                author.setNombre(rs.getString("nombre"));
                author.setTipoCreador(rs.getString("tipo_creador"));
                
                authors.add(author);
            }
            
            st.close();
            rs.close();
            cn.close();
            
            log.info("INFO: Los registros se obtuvieron correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un problema al obtener los datos. Contacta con el administrador.");
        }
        
        
        return authors;
    }
    
    public List<AuthorType> getAuthorTypes() {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        List<AuthorType> authorTypes = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM tipo_creador";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {            
                AuthorType authorType = new AuthorType();
                
                authorType.setId(rs.getInt("id"));
                authorType.setTipoCreador(rs.getString("tipo_creador"));
                
                authorTypes.add(authorType);
            }
            
            st.close();
            rs.close();
            cn.close();
            
            log.info("INFO: Los registros de tipo se obtuvieron correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un problema al obtener los datos. Contacta con el administrador.");
        }
        
        
        return authorTypes;
    }
    
    public boolean createAuthor(Author author) {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        boolean response = false;
        
        System.out.println(author.getTipoCreadorId());
        
        try {
            String sql = "INSERT INTO creador(nombre, tipo_creador_id) VALUES (?, ?)";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, author.getNombre());
            pst.setInt(2, author.getTipoCreadorId());
            
            if(!pst.execute()) response = true;
            
            pst.close();
            cn.close();
            
            log.info("INFO: Se creo el autor correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Sucedio un error al guardar el registro. Por favor contactar con el administrador.");
        }
        
        return response;
    }
    
    public boolean updateAuthor(Author author) {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        boolean response = false;
        
        System.out.println(author.getTipoCreadorId());
        
        try {
            String sql = "UPDATE creador SET nombre = ?, tipo_creador_id = ? WHERE id = ?";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, author.getNombre());
            pst.setInt(2, author.getTipoCreadorId());
            pst.setInt(3,author.getId());
            
            if(!pst.execute()) response = true;
            
            pst.close();
            cn.close();
            
            log.info("INFO: Se actualizo el autor correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Sucedio un error al actualizar el registro. Por favor contactar con el administrador.");
        }
        
        return response;
    }
    
    public boolean deleteRelatedMaterials (int creatorId) {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        boolean response = false;
        
        try {
            String sql = "DELETE FROM material WHERE creador_id = ?";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, creatorId);
            
            if(!pst.execute()) response = true;
            
            pst.close();
            cn.close();
            
            log.info("INFO: Se eliminaron los materiales relacionados al creador con id " + String.valueOf(creatorId) + ".");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Sucedio un error al eliminar los materiales relacionados. Por favor contactar con el administrador");
        }
        
        return response;
    }
    
    public boolean deleteAuthor (int id) {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        boolean response = false;
        
        try {
            String sql = "DELETE FROM creador WHERE id = ?";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            
            if(!pst.execute()) response = true;
            
            pst.close();
            cn.close();
            
            log.info("INFO: Se elimino el creador con id " + String.valueOf(id) + ".");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Sucedio un error al eliminar al creador. Por favor contactar con el administrador");
        }
        
        return response;
    }
}
