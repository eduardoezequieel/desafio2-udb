package desafio2.controllers;

import desafio2.helpers.DatabaseConnection;
import desafio2.models.Author;
import desafio2.models.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

public class CtrlBooks {
    private static final Logger log = Logger.getLogger(CtrlBooks.class);
    
    public CtrlBooks() {}
    
    public List<Author> getAuthors() {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        List<Author> authors = new ArrayList<>();
        
        try {
            String sql = "SELECT id, nombre FROM creador WHERE tipo_creador_id = 1";
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {            
                Author author = new Author();
                
                author.setId(rs.getInt("id"));
                author.setNombre(rs.getString("nombre"));
                
                authors.add(author);
            }
            
            st.close();
            rs.close();
            cn.close();
            
            log.info("INFO: Los registros de autores para libros se obtuvieron correctamente.");
        } catch (Exception e) {
            log.error("ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un problema al obtener los datos de autores. Contacta con el administrador.");
        }
        
        return authors;
    }
    
    public boolean createBook(Book book) {
        DatabaseConnection dbcn = new DatabaseConnection();
        Connection cn = dbcn.getConnection();
        boolean response = false;
        
        try {
            String sql = "INSERT INTO material(codigo, titulo, creador_id, numero_paginas, isbn, anio_publicacion, unidades, tipo_material_id, editorial_id) VALUES (?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, book.getCodigo());
            pst.setString(2, book.getTitulo());
            pst.setInt(3, book.getCreadorId());
            pst.setInt(4, book.getNumPaginas());
            pst.setString(5, book.getIsbn());
            pst.setInt(6, book.getAnioPublicacion());
            pst.setInt(7, book.getUnidades());
            pst.setInt(8, book.getTipoMaterialId());
            pst.setInt(9, book.getEditorialId());
            
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
