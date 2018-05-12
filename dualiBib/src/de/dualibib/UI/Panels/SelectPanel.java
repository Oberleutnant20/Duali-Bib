/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.UI.Panels;

import de.dualibib.Fachlogik.Genreverwaltung.Genre;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorie;
import de.dualibib.Fachlogik.Medienverwaltung.Medien;
import de.dualibib.UI.PanelHandler;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Carina
 */
public class SelectPanel extends javax.swing.JPanel {

    private final PanelHandler panelHandler;
    private Medien medium;

//    private final ArrayList<String> genreListe;
//
//    private final ArrayList<String> kategorieListe;

    /**
     * Creates new form SelectPanel
     */
    public SelectPanel(PanelHandler panelHandler){//List genreListe, List kategorieListe) {
        initComponents();
        this.panelHandler = panelHandler;
        setComboboxKategorie(kategorieComboBox, panelHandler.getKategorieListe());
        setComboboxGenre(genreComboBox, panelHandler.getGenreListe());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        beschreibungField = new javax.swing.JTextArea();
        ausleihenVormerkenButton = new javax.swing.JButton();
        statusField = new javax.swing.JTextField();
        bearbeitenButton = new javax.swing.JButton();
        nameLable = new javax.swing.JLabel();
        statusLable = new javax.swing.JLabel();
        genreLable = new javax.swing.JLabel();
        kategorieLable = new javax.swing.JLabel();
        beschreibungLable = new javax.swing.JLabel();
        genreComboBox = new javax.swing.JComboBox<>();
        kategorieComboBox = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        sucheField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        dateComboBox = new javax.swing.JComboBox<>();

        nameField.setText("jTextField1");
        nameField.setEnabled(false);
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        beschreibungField.setColumns(20);
        beschreibungField.setRows(5);
        beschreibungField.setText("Text");
        beschreibungField.setEnabled(false);
        jScrollPane1.setViewportView(beschreibungField);

        ausleihenVormerkenButton.setText("Ausleihen/Vormerken");
        ausleihenVormerkenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ausleihenVormerkenButtonActionPerformed(evt);
            }
        });

        statusField.setText("jTextField2");
        statusField.setEnabled(false);
        statusField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusFieldActionPerformed(evt);
            }
        });

        bearbeitenButton.setText("Speichern");
        bearbeitenButton.setEnabled(false);
        bearbeitenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bearbeitenButtonActionPerformed(evt);
            }
        });

        nameLable.setText("Name:");

        statusLable.setText("Status:");

        genreLable.setText("Genre:");

        kategorieLable.setText("Kategorie:");

        beschreibungLable.setText("Beschreibung:");

        genreComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        genreComboBox.setEnabled(false);

        kategorieComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        kategorieComboBox.setEnabled(false);

        jTextField1.setText("Suche");

        sucheField.setText("Titelsuche...");
        sucheField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sucheFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Ausleihen bis:");

        dateComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sucheField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLable)
                            .addComponent(beschreibungLable)
                            .addComponent(kategorieLable))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kategorieComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statusLable)
                            .addComponent(genreLable))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(genreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 52, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bearbeitenButton)
                                    .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ausleihenVormerkenButton))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(184, 184, 184)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(185, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sucheField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLable)
                    .addComponent(statusLable))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(beschreibungLable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genreLable)
                    .addComponent(kategorieLable)
                    .addComponent(genreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kategorieComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ausleihenVormerkenButton)
                    .addComponent(bearbeitenButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(140, 140, 140)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(140, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void statusFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusFieldActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        //TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void sucheFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucheFieldActionPerformed
        panelHandler.panelUnsichtbar();
        panelHandler.getSuchePanel().setSearchTitel(sucheField.getText());
        panelHandler.getSuchePanel().setVisible(true);
    }//GEN-LAST:event_sucheFieldActionPerformed

    private void bearbeitenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bearbeitenButtonActionPerformed
        statusField.getText();
        beschreibungField.getText();
        nameField.getText();
        kategorieComboBox.getSelectedItem();
        genreComboBox.getSelectedItem();
        panelHandler.saveMediumChange(medium);
    }//GEN-LAST:event_bearbeitenButtonActionPerformed

    private void ausleihenVormerkenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ausleihenVormerkenButtonActionPerformed
       if(statusField.getText().equals("ausgeliehen")||statusField.getText().equals("bereits vorgemerkt")){
            if(statusField.getText().equals("bereits vorgemerkt")){
        }else{
                medium.setVorgemerkt(true);
                statusField.setText("bereits vorgemerkt");
            }
       }
       else{
           dateComboBox.getSelectedItem();
           medium.berechneVerfuegbare(1);
       }
       
        panelHandler.saveMediumChange(medium);
        
    }//GEN-LAST:event_ausleihenVormerkenButtonActionPerformed

    public void setMitarbeiter(){
        bearbeitenButton.setEnabled(true);
        genreComboBox.setEnabled(true);
        kategorieComboBox.setEnabled(true);
        beschreibungField.setEnabled(true);
        nameField.setEnabled(true);
        statusField.setEnabled(true);
    }
    
    public void setMedium(Medien m){
        medium = m;
        if(m.isAusgeliehen()){
            statusField.setText("ausgeliehen");
            if(m.isVorgemerkt())
            statusField.setText("bereits vorgemerkt");
        }
        beschreibungField.setText("blablalba - in arbeit");
        nameField.setText(m.getName());
        //kategorieComboBox.setSelectedItem();
        //genreComboBox.setSelectedItem();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ausleihenVormerkenButton;
    private javax.swing.JButton bearbeitenButton;
    private javax.swing.JTextArea beschreibungField;
    private javax.swing.JLabel beschreibungLable;
    private javax.swing.JComboBox<String> dateComboBox;
    private javax.swing.JComboBox<String> genreComboBox;
    private javax.swing.JLabel genreLable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> kategorieComboBox;
    private javax.swing.JLabel kategorieLable;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLable;
    private javax.swing.JTextField statusField;
    private javax.swing.JLabel statusLable;
    private javax.swing.JTextField sucheField;
    // End of variables declaration//GEN-END:variables
private void setComboboxKategorie(JComboBox combobox,List<Kategorie> list){
        String[] tmp = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            tmp[i] = list.get(i).getBezeichnung();
        }        
        combobox.setModel(new DefaultComboBoxModel(tmp));
    }
    
    private void setComboboxGenre(JComboBox combobox,List<Genre> list){
        String[] tmp = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            tmp[i] = list.get(i).getBezeichnung();
        }        
        combobox.setModel(new DefaultComboBoxModel(tmp));
    }

}
