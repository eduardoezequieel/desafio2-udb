/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio2.views;

import desafio2.controllers.CtrlAuthors;
import desafio2.controllers.CtrlBooks;
import desafio2.controllers.CtrlEditorials;
import desafio2.helpers.GenerateCode;
import desafio2.helpers.Validators;
import desafio2.models.Author;
import desafio2.models.Book;
import desafio2.models.Editorial;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FrmCreateBooks extends javax.swing.JPanel {
    private JPanel layoutPanel;
    private CtrlBooks booksController;
    private CtrlEditorials editorialsController;
    private CtrlAuthors authorsController;
    private List<Author> authors;
    private List<Editorial> editorials;

    public FrmCreateBooks(JPanel layoutPanel) {
        initComponents();
        
        booksController = new CtrlBooks();
        editorialsController = new CtrlEditorials();
        authorsController = new CtrlAuthors();
        getAuthors();
        getEditorials();
        
        this.layoutPanel = layoutPanel;
        
        handleAuthorMode();
        handleEditorialMode();
        
        Validators.allowNumbers(paginasTxt, 5);
        Validators.allowNumbers(anioPubTxt, 4);
        Validators.allowNumbers(unidadesTxt, 5);
    }
    
    private void setLayoutContent(JPanel content) {
        layoutPanel.removeAll();
        layoutPanel.add(content, BorderLayout.CENTER);
        layoutPanel.revalidate();
        layoutPanel.repaint();
    }
    
    private void getAuthors() {
        authors = booksController.getAuthors();
        
        authorCb.removeAllItems();
        authorCb.addItem("Selecciona un autor");
        
        for (int i = 0; i < authors.size(); i++) {
            Author author = authors.get(i);
            
            authorCb.addItem(author.getNombre());
        }
    }
    
    private void getEditorials() {
        editorials = editorialsController.getEditorials();
        
        editorialCb.removeAllItems();
        editorialCb.addItem("Selecciona una editorial");
        
        for (int i = 0; i < editorials.size(); i++) {
            Editorial editorial = editorials.get(i);
            
            editorialCb.addItem(editorial.getEditorial());
        }
    }
    
    private void handleAuthorMode() {
       boolean existentAuthor = existentAuthorRb.isSelected();
       boolean newAuthor = newAuthorRb.isSelected();
       
       authorTxt.setVisible(newAuthor);
       authorCb.setVisible(existentAuthor);
    }
    
    private void handleEditorialMode() {
       boolean existentEditorial = existentEditorialRb.isSelected();
       boolean newEditorial = newEditorialRb.isSelected();
       
       editorialTxt.setVisible(newEditorial);
       editorialCb.setVisible(existentEditorial);
    }
    
    private int handleAuthorCreation () {
        int authorId = 0;
        boolean existentAuthor = existentAuthorRb.isSelected();
        
        if (existentAuthor) {
            for (Author a : authors) {
                if (a.getNombre().equals(authorCb.getSelectedItem())) {
                    authorId = a.getId();
                    break;
                }
            }
            
        } else {
            String authorName = authorTxt.getText().trim();
            
            if(authorName.length() == 0) {
                JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
                return authorId;
            }
            
            Author author = new Author();
            
            author.setNombre(authorName);
            author.setTipoCreadorId(1);
            
            boolean ok = authorsController.createAuthor(author);
            
            if(!ok) return authorId;
            
            Author newAuthor = authorsController.getLatestAuthor();
            authorId = newAuthor.getId();
        }
        
        return authorId;
    }
    
    private int handleEditorialCreation () {
        int editorialId = 0;
        boolean existentEditorial = existentEditorialRb.isSelected();
        
        if (existentEditorial) {
            for (Editorial e : editorials) {
                if (e.getEditorial().equals(editorialCb.getSelectedItem())) {
                    editorialId = e.getId();
                    break;
                }
            }
            
        } else {
            String editorialName = editorialTxt.getText().trim();
            
            if(editorialName.length() == 0) {
                JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
                return editorialId;
            }
            
            boolean ok = editorialsController.createEditorial(editorialName);
            if(!ok) return editorialId;
            
            Editorial newEditorial = editorialsController.getLatestEditorial();
            
            editorialId = newEditorial.getId();
        }
        
        return editorialId;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        authorGroup = new javax.swing.ButtonGroup();
        editorialGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        authorTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        authorCb = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        newAuthorRb = new javax.swing.JRadioButton();
        existentAuthorRb = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        existentEditorialRb = new javax.swing.JRadioButton();
        editorialCb = new javax.swing.JComboBox<>();
        newEditorialRb = new javax.swing.JRadioButton();
        editorialTxt = new javax.swing.JTextField();
        tituloTxt = new javax.swing.JTextField();
        isbnTxt = new javax.swing.JFormattedTextField();
        unidadesTxt = new javax.swing.JTextField();
        paginasTxt = new javax.swing.JTextField();
        anioPubTxt = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(1100, 690));
        setMinimumSize(new java.awt.Dimension(1100, 690));
        setPreferredSize(new java.awt.Dimension(1100, 690));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1100, 690));
        jPanel1.setMinimumSize(new java.awt.Dimension(1100, 690));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 690));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Autor:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        authorTxt.setBackground(new java.awt.Color(255, 255, 255));
        authorTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        authorTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        authorTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                authorTxtKeyReleased(evt);
            }
        });
        jPanel1.add(authorTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 480, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Título:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        authorCb.setBackground(new java.awt.Color(255, 255, 255));
        authorCb.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        authorCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        authorCb.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        jPanel1.add(authorCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 480, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Número de paginas:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("ISBN:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Año de publicación:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Unidades disponibles:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, -1, -1));

        backBtn.setBackground(new java.awt.Color(0, 153, 255));
        backBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Regresar");
        backBtn.setBorder(null);
        backBtn.setBorderPainted(false);
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 630, 140, 40));

        saveBtn.setBackground(new java.awt.Color(0, 153, 255));
        saveBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Guardar");
        saveBtn.setBorder(null);
        saveBtn.setBorderPainted(false);
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        jPanel1.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 630, 140, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Nuevo libro");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        newAuthorRb.setBackground(new java.awt.Color(255, 255, 255));
        authorGroup.add(newAuthorRb);
        newAuthorRb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        newAuthorRb.setForeground(new java.awt.Color(102, 102, 102));
        newAuthorRb.setText("Crear nuevo autor");
        newAuthorRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newAuthorRbActionPerformed(evt);
            }
        });
        jPanel1.add(newAuthorRb, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, -1, -1));

        existentAuthorRb.setBackground(new java.awt.Color(255, 255, 255));
        authorGroup.add(existentAuthorRb);
        existentAuthorRb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        existentAuthorRb.setForeground(new java.awt.Color(102, 102, 102));
        existentAuthorRb.setSelected(true);
        existentAuthorRb.setText("Autor existente");
        existentAuthorRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                existentAuthorRbActionPerformed(evt);
            }
        });
        jPanel1.add(existentAuthorRb, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Editorial:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        existentEditorialRb.setBackground(new java.awt.Color(255, 255, 255));
        editorialGroup.add(existentEditorialRb);
        existentEditorialRb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        existentEditorialRb.setForeground(new java.awt.Color(102, 102, 102));
        existentEditorialRb.setSelected(true);
        existentEditorialRb.setText("Editorial existente");
        existentEditorialRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                existentEditorialRbActionPerformed(evt);
            }
        });
        jPanel1.add(existentEditorialRb, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, -1));

        editorialCb.setBackground(new java.awt.Color(255, 255, 255));
        editorialCb.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        editorialCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        editorialCb.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        jPanel1.add(editorialCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 480, 30));

        newEditorialRb.setBackground(new java.awt.Color(255, 255, 255));
        editorialGroup.add(newEditorialRb);
        newEditorialRb.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        newEditorialRb.setForeground(new java.awt.Color(102, 102, 102));
        newEditorialRb.setText("Crear nueva editorial");
        newEditorialRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEditorialRbActionPerformed(evt);
            }
        });
        jPanel1.add(newEditorialRb, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, -1, -1));

        editorialTxt.setBackground(new java.awt.Color(255, 255, 255));
        editorialTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        editorialTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        editorialTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                editorialTxtKeyReleased(evt);
            }
        });
        jPanel1.add(editorialTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 480, 30));

        tituloTxt.setBackground(new java.awt.Color(255, 255, 255));
        tituloTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tituloTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        tituloTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tituloTxtKeyReleased(evt);
            }
        });
        jPanel1.add(tituloTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 480, 30));

        isbnTxt.setBackground(new java.awt.Color(255, 255, 255));
        isbnTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        try {
            isbnTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#-####-#####-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        isbnTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel1.add(isbnTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 480, 30));

        unidadesTxt.setBackground(new java.awt.Color(255, 255, 255));
        unidadesTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        unidadesTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        unidadesTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                unidadesTxtKeyReleased(evt);
            }
        });
        jPanel1.add(unidadesTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 480, 30));

        paginasTxt.setBackground(new java.awt.Color(255, 255, 255));
        paginasTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        paginasTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        paginasTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paginasTxtKeyReleased(evt);
            }
        });
        jPanel1.add(paginasTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 480, 30));

        anioPubTxt.setBackground(new java.awt.Color(255, 255, 255));
        anioPubTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        anioPubTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        anioPubTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                anioPubTxtKeyReleased(evt);
            }
        });
        jPanel1.add(anioPubTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 480, 30));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        FrmSelectMaterialType form = new FrmSelectMaterialType(layoutPanel);
        setLayoutContent(form);
    }//GEN-LAST:event_backBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        String titulo = tituloTxt.getText().trim();
        String isbn = isbnTxt.getText().trim();
        String paginas = paginasTxt.getText();
        String anioPub = anioPubTxt.getText();
        String unidades = unidadesTxt.getText();
        int autorId;
        int editorialId;
        
        boolean validated = true;
        String[] fields = {titulo, isbn, paginas, anioPub, unidades};
        
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].length() == 0) {
                validated = false;
                break;
            }
        }
        
        if (!validated) {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
            return;
        }
        
        autorId = handleAuthorCreation();
        editorialId = handleEditorialCreation();
        
        if(autorId == 0 || editorialId == 0) {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
        }
        
        GenerateCode gc = new GenerateCode("Libro");
        
        if(gc.getCode().equals("invalid")) {
            JOptionPane.showMessageDialog(null, "Sucedio un error al crear este registro. Comunicate con el administrador.");
        }
        
        Book book = new Book();

        book.setCodigo(gc.getCode());
        book.setTitulo(titulo);
        book.setCreadorId(autorId);
        book.setNumPaginas(Integer.parseInt(paginas));
        book.setIsbn(isbn);
        book.setUnidades(Integer.parseInt(unidades));
        book.setAnioPublicacion(Integer.parseInt(anioPub));
        book.setTipoMaterialId(1);
        book.setEditorialId(editorialId);
        
        boolean ok = booksController.createBook(book);
        
        if(!ok) return;
        
        FrmMaterials form = new FrmMaterials(layoutPanel);
        JOptionPane.showMessageDialog(null, "Material guardado exitosamente");
        
        setLayoutContent(form);
        
    }//GEN-LAST:event_saveBtnActionPerformed

    private void existentAuthorRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_existentAuthorRbActionPerformed
        handleAuthorMode();
    }//GEN-LAST:event_existentAuthorRbActionPerformed

    private void newAuthorRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newAuthorRbActionPerformed
        handleAuthorMode();
    }//GEN-LAST:event_newAuthorRbActionPerformed

    private void existentEditorialRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_existentEditorialRbActionPerformed
        handleEditorialMode();
    }//GEN-LAST:event_existentEditorialRbActionPerformed

    private void newEditorialRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEditorialRbActionPerformed
        handleEditorialMode();
    }//GEN-LAST:event_newEditorialRbActionPerformed

    private void tituloTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tituloTxtKeyReleased
        String text = tituloTxt.getText();
        boolean validLength = Validators.checkTextLength(text, 100);
        boolean validFormat = Validators.matchesRegex(text, Validators.getNoMaliciousCharactersRegex());
        
        if(!validLength) tituloTxt.setText(text.substring(0, 100));
        if (!validFormat) tituloTxt.setText(text.substring(0, text.length() - 1));
    }//GEN-LAST:event_tituloTxtKeyReleased

    private void authorTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_authorTxtKeyReleased
        String text = authorTxt.getText();
        boolean validLength = Validators.checkTextLength(text, 100);
        boolean validFormat = Validators.matchesRegex(text, Validators.getNoMaliciousCharactersRegex());
        
        if(!validLength) authorTxt.setText(text.substring(0, 100));
        if (!validFormat) authorTxt.setText(text.substring(0, text.length() - 1));
    }//GEN-LAST:event_authorTxtKeyReleased

    private void editorialTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editorialTxtKeyReleased
        String text = editorialTxt.getText();
        boolean validLength = Validators.checkTextLength(text, 100);
        boolean validFormat = Validators.matchesRegex(text, Validators.getNoMaliciousCharactersRegex());
        
        if(!validLength) editorialTxt.setText(text.substring(0, 100));
        if (!validFormat) editorialTxt.setText(text.substring(0, text.length() - 1));
    }//GEN-LAST:event_editorialTxtKeyReleased

    private void unidadesTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unidadesTxtKeyReleased
        
    }//GEN-LAST:event_unidadesTxtKeyReleased

    private void paginasTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paginasTxtKeyReleased
        
    }//GEN-LAST:event_paginasTxtKeyReleased

    private void anioPubTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anioPubTxtKeyReleased
        
    }//GEN-LAST:event_anioPubTxtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anioPubTxt;
    private javax.swing.JComboBox<String> authorCb;
    private javax.swing.ButtonGroup authorGroup;
    private javax.swing.JTextField authorTxt;
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> editorialCb;
    private javax.swing.ButtonGroup editorialGroup;
    private javax.swing.JTextField editorialTxt;
    private javax.swing.JRadioButton existentAuthorRb;
    private javax.swing.JRadioButton existentEditorialRb;
    private javax.swing.JFormattedTextField isbnTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton newAuthorRb;
    private javax.swing.JRadioButton newEditorialRb;
    private javax.swing.JTextField paginasTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField tituloTxt;
    private javax.swing.JTextField unidadesTxt;
    // End of variables declaration//GEN-END:variables
}
