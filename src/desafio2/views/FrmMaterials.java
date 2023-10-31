package desafio2.views;

import desafio2.controllers.CtrlBooks;
import desafio2.controllers.CtrlCDs;
import desafio2.controllers.CtrlDVDs;
import desafio2.controllers.CtrlMagazines;
import desafio2.controllers.CtrlMaterials;
import desafio2.helpers.GenerateCode;
import desafio2.models.Book;
import desafio2.models.Cd;
import desafio2.models.Dvd;
import desafio2.models.Magazine;
import desafio2.models.Material;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class FrmMaterials extends javax.swing.JPanel {
    private CtrlMaterials controller;
    private List<Material> materials;
    private Material selectedMaterial = null;
    private CtrlBooks bookController;
    private CtrlMagazines magazineController;
    private CtrlCDs cdsController;
    private CtrlDVDs dvdsController;
    private JPanel layoutPanel;
   
    public FrmMaterials(JPanel contentPanel) {
        initComponents();
        initData();
        getTableData();
        
        layoutPanel = contentPanel;
        
        bookController = new CtrlBooks();
        magazineController = new CtrlMagazines();
        cdsController = new CtrlCDs();
        dvdsController = new CtrlDVDs();
    }
    
    private void initData() {
        controller = new CtrlMaterials();
        materials = controller.getMaterials();
        
        addBtn.setEnabled(true);
        updateBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        
        FrmWelcome form = new FrmWelcome();
        setContent(form);
    }
    
    private void setContent(JPanel content) {
        contentPanel.removeAll();
        contentPanel.add(content, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
    
    private void setLayoutContent(JPanel content) {
        layoutPanel.removeAll();
        layoutPanel.add(content, BorderLayout.CENTER);
        layoutPanel.revalidate();
        layoutPanel.repaint();
    }
    
    private void updateBook() {
        Book book = (Book)selectedMaterial;
        
        boolean validated = true;
        String[] fields = {book.getTitulo(), book.getIsbn(), String.valueOf(book.getNumPaginas()), String.valueOf(book.getAnioPublicacion()), String.valueOf(book.getUnidades())};
        
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
        
        if(book.getCreadorId() == 0 || book.getEditorialId() == 0) {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
        }
        
        boolean ok = bookController.updateBook(book);
        
        if(!ok) return;
        
        JOptionPane.showMessageDialog(null, "Material actualizado exitosamente");
        
        initData();
        getTableData();
    }
    
    private void updateMagazine() {
        Magazine magazine = (Magazine)selectedMaterial;
        
        boolean validated = true;
        String[] fields = {magazine.getTitulo(), String.valueOf(magazine.getUnidades()), magazine.getFechaPublicacion()};
        
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
        
        if(magazine.getPeriodicidadId()== 0 || magazine.getEditorialId() == 0) {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
        }
        
        boolean ok = magazineController.updateMagazine(magazine);
        
        if(!ok) return;
        
        JOptionPane.showMessageDialog(null, "Material actualizado exitosamente");
        
        initData();
        getTableData();
    }
    
    private void updateCd() {
        Cd cd = (Cd)selectedMaterial;
        
        boolean validated = true;
        String[] fields = {cd.getTitulo(), String.valueOf(cd.getUnidades()), String.valueOf(cd.getNumero_canciones()), cd.getDuracion()};
        
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
        
        if(cd.getGeneroId()== 0 || cd.getArtistId()== 0) {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
        }
        
        boolean ok = cdsController.updateCd(cd);
        
        if(!ok) return;
        
        JOptionPane.showMessageDialog(null, "Material actualizado exitosamente");
        
        initData();
        getTableData();
    }
    
    private void updateDvd() {
        Dvd dvd = (Dvd)selectedMaterial;
        
        boolean validated = true;
        String[] fields = {dvd.getTitulo(), dvd.getDuracion()};
        
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
        
        if(dvd.getGeneroId()== 0 || dvd.getCreadorId()== 0) {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
        }
        
        boolean ok = dvdsController.updateDvd(dvd);
        
        if(!ok) return;
        
        JOptionPane.showMessageDialog(null, "Material actualizado exitosamente");
        
        initData();
        getTableData();
    }
    
    private void getTableData() {
        DefaultTableModel tableModel = new DefaultTableModel();
        
        tableModel.addColumn("Código");
        tableModel.addColumn("Título");
        tableModel.addColumn("Tipo");
        tableModel.addColumn("Categoría");
        
        for (int i = 0; i < materials.size(); i++) {
            Material material = materials.get(i);
            tableModel.addRow(new Object[]{material.getCodigo(), material.getTitulo(), material.getTipoMaterial(), material.getCategoriaMaterial()});
        }
        
        materialTbl.setModel(tableModel);
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        materialTbl.getColumnModel().getColumn(0).setPreferredWidth(1);
        materialTbl.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
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
        materialTbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        searchTxt = new javax.swing.JTextField();
        clearBtn = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        materialTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        materialTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                materialTblMouseClicked(evt);
            }
        });
        materialTbl.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                materialTblComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(materialTbl);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 520, 580));

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
        add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 620, 100, 50));

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
        add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, 100, 50));

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
        add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 620, 100, 50));

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
        add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 620, 100, 50));

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 520, 590));
    }// </editor-fold>//GEN-END:initComponents

    private void materialTblComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_materialTblComponentShown

    }//GEN-LAST:event_materialTblComponentShown

    private void materialTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialTblMouseClicked
        DefaultTableModel model = (DefaultTableModel) materialTbl.getModel();
        int selectedRow = materialTbl.getSelectedRow();
        
        String code = model.getValueAt(selectedRow, 0).toString();
        
        System.out.println(code);
        
        int index = -1;
        
        for (int i = 0; i < materials.size(); i++) {
            if(materials.get(i).getCodigo().equals(code)) {
                index = i;
                break;
            }
        }
        
        if(index == -1) {
            JOptionPane.showMessageDialog(null, "Sucedio un error al seleccionar el registro, contacta con el administrador.");
            return;
        }
        
        selectedMaterial = materials.get(index);
        
        addBtn.setEnabled(false);
        updateBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
        
        if (selectedMaterial.getTipoMaterial().equals("Libro")) {
            Book book = bookController.getBook(selectedMaterial.getCodigo());
            selectedMaterial = book;
            
            FrmEditBooks form = new FrmEditBooks((Book)selectedMaterial);
            setContent(form);
        } else if (selectedMaterial.getTipoMaterial().equals("Revista")) {
            Magazine magazine = magazineController.getMagazine(selectedMaterial.getCodigo());
            selectedMaterial = magazine;
            
            FrmEditMagazine form = new FrmEditMagazine((Magazine) selectedMaterial);
            setContent(form);
        } else if (selectedMaterial.getTipoMaterial().equals("CD")) {
            Cd cd = cdsController.getCd(selectedMaterial.getCodigo());
            selectedMaterial = cd;
            
            FrmEditCDs form = new FrmEditCDs((Cd)selectedMaterial);
            setContent(form);
        } else if (selectedMaterial.getTipoMaterial().equals("DVD")) {
            Dvd dvd = dvdsController.getDvd(selectedMaterial.getCodigo());
            selectedMaterial = dvd;
            
            FrmEditDVDs form = new FrmEditDVDs((Dvd)selectedMaterial);
            setContent(form);
        }
    }//GEN-LAST:event_materialTblMouseClicked

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int response = JOptionPane.showConfirmDialog(null, 
                "¿Estás seguro de que deseas eliminar este registro? Este cambio es irreversible", 
                "Confirmación", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE);
        
        if (response == JOptionPane.YES_OPTION) {
            String id = selectedMaterial.getCodigo();
            boolean editorialWasDeleted = controller.deleteMaterial(id);
                
            if(editorialWasDeleted) {
                initData();
                getTableData();
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        FrmSelectMaterialType form = new FrmSelectMaterialType(layoutPanel);
        setLayoutContent(form);
    }//GEN-LAST:event_addBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        if(selectedMaterial.getTipoMaterialId() == 1) updateBook();
        if(selectedMaterial.getTipoMaterialId() == 2) updateMagazine();
        if(selectedMaterial.getTipoMaterialId() == 3) updateCd();
        if(selectedMaterial.getTipoMaterialId() == 4) updateDvd();
    }//GEN-LAST:event_updateBtnActionPerformed

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        DefaultTableModel model = (DefaultTableModel) materialTbl.getModel();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<DefaultTableModel>(model);
        
        materialTbl.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter(searchTxt.getText()));
    }//GEN-LAST:event_searchTxtKeyReleased

    private void searchTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTxtKeyTyped

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        addBtn.setEnabled(true);
        updateBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        
        FrmWelcome form = new FrmWelcome();
        setContent(form);
    }//GEN-LAST:event_clearBtnActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable materialTbl;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
