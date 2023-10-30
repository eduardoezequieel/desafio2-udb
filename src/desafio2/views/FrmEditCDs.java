package desafio2.views;

import desafio2.controllers.CtrlAuthors;
import desafio2.controllers.CtrlCDs;
import desafio2.helpers.Validators;
import desafio2.models.Author;
import desafio2.models.Cd;
import desafio2.models.Gender;
import java.util.List;

public class FrmEditCDs extends javax.swing.JPanel {
    private Cd selectedCd;
    private CtrlCDs cdsController;
    private CtrlAuthors artistsController;    
    private List<Gender> genders;
    private List<Author> artists;
    
    public FrmEditCDs(Cd cd) {
        initComponents();
        
        selectedCd = cd;
        cdsController = new CtrlCDs();
        artistsController = new CtrlAuthors();
        
        getGenders();
        getArtists();
        
        Validators.allowNumbers(numCancionesTxt, 5);
        Validators.allowNumbers(unidadesTxt, 5);
        initData();
        
    }
    
    private void initData() {
        tituloTxt.setText(selectedCd.getTitulo());
        numCancionesTxt.setText(String.valueOf(selectedCd.getNumero_canciones()));
        unidadesTxt.setText(String.valueOf(selectedCd.getUnidades()));
        duracionTxt.setText(selectedCd.getDuracion());
        codeLbl.setText(selectedCd.getCodigo());
    }
    
    private void getGenders() {
        genders = cdsController.getGenders();
        
        genderCb.removeAllItems();
        genderCb.addItem("Selecciona el género");
        
        for (int i = 0; i < genders.size(); i++) {
            Gender gender = genders.get(i);
            
            genderCb.addItem(gender.getGenero());
        }
        
        for (int i = 0; i < genders.size(); i++) {
            if (selectedCd.getGeneroId()== genders.get(i).getId()) {
                genderCb.setSelectedItem(genders.get(i).getGenero());
                break;
            }
        }
    }
    
    private void getArtists() {
        artists = artistsController.getArtists();
        
        artistCb.removeAllItems();
        artistCb.addItem("Selecciona un artista");
        
        for (int i = 0; i < artists.size(); i++) {
            Author author = artists.get(i);
            
            artistCb.addItem(author.getNombre());
        }
        
        for (int i = 0; i < artists.size(); i++) {
            if (selectedCd.getArtistId()== artists.get(i).getId()) {
                artistCb.setSelectedItem(artists.get(i).getNombre());
                break;
            }
        }
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tituloTxt = new javax.swing.JTextField();
        codeLbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        genderCb = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        numCancionesTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        unidadesTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        duracionTxt = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        artistCb = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(515, 585));
        setMinimumSize(new java.awt.Dimension(515, 585));
        setPreferredSize(new java.awt.Dimension(515, 585));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(515, 585));
        jPanel1.setMinimumSize(new java.awt.Dimension(515, 585));
        jPanel1.setPreferredSize(new java.awt.Dimension(515, 585));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloTxt.setBackground(new java.awt.Color(255, 255, 255));
        tituloTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tituloTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        tituloTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tituloTxtKeyReleased(evt);
            }
        });
        jPanel1.add(tituloTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 480, 30));

        codeLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        codeLbl.setForeground(new java.awt.Color(102, 102, 102));
        codeLbl.setText("LIB00000");
        jPanel1.add(codeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Título:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Código:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Género:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 50, -1));

        genderCb.setBackground(new java.awt.Color(255, 255, 255));
        genderCb.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        genderCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        genderCb.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        genderCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderCbActionPerformed(evt);
            }
        });
        jPanel1.add(genderCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 480, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Número de canciones:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 140, -1));

        numCancionesTxt.setBackground(new java.awt.Color(255, 255, 255));
        numCancionesTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        numCancionesTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        numCancionesTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numCancionesTxtKeyReleased(evt);
            }
        });
        jPanel1.add(numCancionesTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 480, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Unidades disponibles:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        unidadesTxt.setBackground(new java.awt.Color(255, 255, 255));
        unidadesTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        unidadesTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        unidadesTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                unidadesTxtKeyReleased(evt);
            }
        });
        jPanel1.add(unidadesTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 480, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Duración:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        duracionTxt.setBackground(new java.awt.Color(255, 255, 255));
        duracionTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        try {
            duracionTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        duracionTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        duracionTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                duracionTxtKeyReleased(evt);
            }
        });
        jPanel1.add(duracionTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 480, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Artista:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        artistCb.setBackground(new java.awt.Color(255, 255, 255));
        artistCb.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        artistCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        artistCb.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
        artistCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                artistCbActionPerformed(evt);
            }
        });
        jPanel1.add(artistCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 480, 30));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tituloTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tituloTxtKeyReleased
        String text = tituloTxt.getText();
        boolean validLength = Validators.checkTextLength(text, 100);
        boolean validFormat = Validators.matchesRegex(text, Validators.getNoMaliciousCharactersRegex());
        
        if(!validLength) tituloTxt.setText(text.substring(0, 100));
        if (!validFormat) tituloTxt.setText(text.substring(0, text.length() - 1));
        
        selectedCd.setTitulo(tituloTxt.getText());
    }//GEN-LAST:event_tituloTxtKeyReleased

    private void numCancionesTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numCancionesTxtKeyReleased
        selectedCd.setNumero_canciones(Integer.parseInt(numCancionesTxt.getText()));
    }//GEN-LAST:event_numCancionesTxtKeyReleased

    private void unidadesTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unidadesTxtKeyReleased
        selectedCd.setUnidades(Integer.parseInt(unidadesTxt.getText()));
    }//GEN-LAST:event_unidadesTxtKeyReleased

    private void genderCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderCbActionPerformed
        for (int i = 0; i < genders.size(); i++) {
            if(genders.get(i).getGenero().equals(genderCb.getSelectedItem())) {
                selectedCd.setGeneroId(genders.get(i).getId());
                break;
            }
        }
    }//GEN-LAST:event_genderCbActionPerformed

    private void duracionTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_duracionTxtKeyReleased
        selectedCd.setDuracion(duracionTxt.getText());
    }//GEN-LAST:event_duracionTxtKeyReleased

    private void artistCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_artistCbActionPerformed
        for (int i = 0; i < artists.size(); i++) {
            if(artists.get(i).getNombre().equals(artistCb.getSelectedItem())) {
                selectedCd.setArtistId(artists.get(i).getId());
                break;
            }
        }
    }//GEN-LAST:event_artistCbActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> artistCb;
    private javax.swing.JLabel codeLbl;
    private javax.swing.JFormattedTextField duracionTxt;
    private javax.swing.JComboBox<String> genderCb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField numCancionesTxt;
    private javax.swing.JTextField tituloTxt;
    private javax.swing.JTextField unidadesTxt;
    // End of variables declaration//GEN-END:variables
}
