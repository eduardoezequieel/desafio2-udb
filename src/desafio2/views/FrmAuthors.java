package desafio2.views;

import desafio2.controllers.CtrlAuthors;
import desafio2.helpers.Validators;
import desafio2.models.Author;
import desafio2.models.AuthorType;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class FrmAuthors extends javax.swing.JPanel {
    private CtrlAuthors controller;
    private List<Author> authors;
    private List<AuthorType> types;
    private Author selectedAuthor = null;
   
    public FrmAuthors() {
        initComponents();
        initData();
        initAuthorTypes();
        getTableData();
    }
    
    private void initData() {
        controller = new CtrlAuthors();
        authors = controller.getAuthors();
        
        creatorTxt.setText("");
        
        addBtn.setEnabled(true);
        updateBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
    }
    
    private void initAuthorTypes() {
        types = controller.getAuthorTypes();
        creatorTypeCb.removeAllItems();
        
        creatorTypeCb.addItem("Selecciona un tipo de creador");
        
        for (int i = 0; i < types.size(); i++) {
            AuthorType type = types.get(i);
            creatorTypeCb.addItem(type.getTipoCreador());
        }
        
        creatorTypeCb.setSelectedIndex(0);
    }
    
    private void getTableData() {
        DefaultTableModel tableModel = new DefaultTableModel();
        
        tableModel.addColumn("Id");
        tableModel.addColumn("Creador");
        tableModel.addColumn("Tipo");
        
        for (int i = 0; i < authors.size(); i++) {
            Author author = authors.get(i);
            tableModel.addRow(new Object[]{author.getId(), author.getNombre(), author.getTipoCreador()});
        }
        
        creatorTbl.setModel(tableModel);
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        creatorTbl.getColumnModel().getColumn(0).setPreferredWidth(1);
        creatorTbl.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        creatorTbl = new javax.swing.JTable();
        creatorTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        searchTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        clearBtn = new javax.swing.JButton();
        creatorTypeCb = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        creatorTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        creatorTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                creatorTblMouseClicked(evt);
            }
        });
        creatorTbl.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                creatorTblComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(creatorTbl);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 520, 580));

        creatorTxt.setBackground(new java.awt.Color(255, 255, 255));
        creatorTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        creatorTxt.setToolTipText("Coloca el nombre de la editorial.");
        creatorTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        creatorTxt.setSelectionColor(new java.awt.Color(0, 153, 255));
        creatorTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creatorTxtActionPerformed(evt);
            }
        });
        creatorTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                creatorTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                creatorTxtKeyTyped(evt);
            }
        });
        add(creatorTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 450, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Buscar:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        deleteBtn.setBackground(new java.awt.Color(0, 153, 255));
        deleteBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Eliminar");
        deleteBtn.setBorder(null);
        deleteBtn.setBorderPainted(false);
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 100, 50));

        addBtn.setBackground(new java.awt.Color(0, 153, 255));
        addBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Agregar");
        addBtn.setBorder(null);
        addBtn.setBorderPainted(false);
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 100, 50));

        updateBtn.setBackground(new java.awt.Color(0, 153, 255));
        updateBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Actualizar");
        updateBtn.setBorder(null);
        updateBtn.setBorderPainted(false);
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 100, 50));

        searchTxt.setBackground(new java.awt.Color(255, 255, 255));
        searchTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        searchTxt.setToolTipText("Coloca el nombre de la editorial.");
        searchTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        searchTxt.setSelectionColor(new java.awt.Color(0, 153, 255));
        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTxtKeyTyped(evt);
            }
        });
        add(searchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 520, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Tipo de creador");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        clearBtn.setBackground(new java.awt.Color(0, 153, 255));
        clearBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("Limpiar");
        clearBtn.setBorder(null);
        clearBtn.setBorderPainted(false);
        clearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 100, 50));

        creatorTypeCb.setBackground(new java.awt.Color(255, 255, 255));
        creatorTypeCb.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        creatorTypeCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        creatorTypeCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creatorTypeCbActionPerformed(evt);
            }
        });
        add(creatorTypeCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 450, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Nombre del creador:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void creatorTblComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_creatorTblComponentShown

    }//GEN-LAST:event_creatorTblComponentShown

    private void creatorTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creatorTxtKeyTyped
        
    }//GEN-LAST:event_creatorTxtKeyTyped

    private void creatorTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creatorTblMouseClicked
        selectedAuthor = authors.get(creatorTbl.getSelectedRow());
        
        addBtn.setEnabled(false);
        updateBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
       
        creatorTxt.setText(selectedAuthor.getNombre());
        creatorTypeCb.setSelectedItem(selectedAuthor.getTipoCreador());
    }//GEN-LAST:event_creatorTblMouseClicked

    private void creatorTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_creatorTxtKeyReleased
        String text = creatorTxt.getText();
        boolean validLength = Validators.checkTextLength(text, 100);
        boolean validFormat = Validators.matchesRegex(text, Validators.getNoMaliciousCharactersRegex());
        
        if(!validLength) creatorTxt.setText(text.substring(0, 100));
        if (!validFormat) creatorTxt.setText(text.substring(0, text.length() - 1));
    }//GEN-LAST:event_creatorTxtKeyReleased

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int response = JOptionPane.showConfirmDialog(null, 
                "¿Estás seguro de que deseas eliminar este registro? Todos los datos relacionados a el se seran eliminados. Este cambio es irreversible", 
                "Confirmación", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE);
        
        if (response == JOptionPane.YES_OPTION) {
            int id = selectedAuthor.getId();
            boolean relatedMaterialsWereDeleted = controller.deleteRelatedMaterials(id);
            
            if(relatedMaterialsWereDeleted) {
                boolean authorWasDeleted = controller.deleteAuthor(id);
                
                if(authorWasDeleted) {
                    initData();
                    initAuthorTypes();
                    getTableData();
                }
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        Author author = new Author();
        int creatorTypeId = 0;
        
        for (AuthorType a : types) {
            if (a.getTipoCreador().equals(creatorTypeCb.getSelectedItem())) {
                creatorTypeId = a.getId();
                break;
            }
        }
        
        if(creatorTypeId != 0) {
            String creator = creatorTxt.getText().trim();
            
            author.setId(0);
            author.setNombre(creator);
            author.setTipoCreadorId(creatorTypeId);

            if(creator.length() == 0) {
                JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
                return;
            }

            boolean ok = controller.createAuthor(author);
            
            if(ok) {
                initData();
                initAuthorTypes();
                getTableData();
            };
        } else {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        Author author = new Author();
        int creatorTypeId = 0;
        
        for (AuthorType a : types) {
            if (a.getTipoCreador().equals(creatorTypeCb.getSelectedItem())) {
                creatorTypeId = a.getId();
                break;
            }
        }
        
        if(creatorTypeId != 0) {
            String creator = creatorTxt.getText().trim();
            
            author.setId(selectedAuthor.getId());
            author.setNombre(creator);
            author.setTipoCreadorId(creatorTypeId);

            if(creator.length() == 0) {
                JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
                return;
            }

            boolean ok = controller.updateAuthor(author);
            
            if(ok) {
                initData();
                initAuthorTypes();
                getTableData();
            };
        } else {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        DefaultTableModel model = (DefaultTableModel) creatorTbl.getModel();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<DefaultTableModel>(model);
        
        creatorTbl.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter(searchTxt.getText()));
    }//GEN-LAST:event_searchTxtKeyReleased

    private void searchTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTxtKeyTyped

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        creatorTxt.setText("");
        addBtn.setEnabled(true);
        updateBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
    }//GEN-LAST:event_clearBtnActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void creatorTypeCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creatorTypeCbActionPerformed

    }//GEN-LAST:event_creatorTypeCbActionPerformed

    private void creatorTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creatorTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creatorTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTable creatorTbl;
    private javax.swing.JTextField creatorTxt;
    private javax.swing.JComboBox<String> creatorTypeCb;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
