/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.UI.Panels;

import de.dualibib.Fachlogik.Accountverwaltung.Account;
import de.dualibib.UI.PanelHandler;

/**
 *
 * @author Carina
 */
public class AccountBearbeitenPanel extends javax.swing.JPanel {

    private final PanelHandler panelHandler;

    /**
     * Creates new form AccountBearbeiten
     */
    
    private Account account;
    private boolean neu;
            
    public AccountBearbeitenPanel(PanelHandler panelHandler) {
        initComponents();
        this.panelHandler = panelHandler;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vornameLable = new javax.swing.JLabel();
        nameLable = new javax.swing.JLabel();
        strasseLable = new javax.swing.JLabel();
        hausnummerLable = new javax.swing.JLabel();
        plzLable = new javax.swing.JLabel();
        stadtLable = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        passwortLable = new javax.swing.JLabel();
        checkPasswortLable = new javax.swing.JLabel();
        mitarbeiterCheckBox = new javax.swing.JCheckBox();
        vornameField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        hausnummerField = new javax.swing.JTextField();
        stadtField = new javax.swing.JTextField();
        checkPasswortField = new javax.swing.JTextField();
        passwortField = new javax.swing.JTextField();
        plzField = new javax.swing.JTextField();
        strasseField = new javax.swing.JTextField();
        sucheField = new javax.swing.JTextField();
        meldungText = new javax.swing.JLabel();

        vornameLable.setText("Vorname:");

        nameLable.setText("Name:");

        strasseLable.setText("Straße:");

        hausnummerLable.setText("Hausnummer:");

        plzLable.setText("PLZ:");

        stadtLable.setText("Stadt:");

        saveButton.setText("Speichern");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        passwortLable.setText("Passwort:");

        checkPasswortLable.setText("Passwort bestätigen:");

        mitarbeiterCheckBox.setText("Mitarbeiter");
        mitarbeiterCheckBox.setEnabled(false);

        vornameField.setText("jTextField1");

        nameField.setText("jTextField2");

        hausnummerField.setText("jTextField3");

        stadtField.setText("jTextField4");

        checkPasswortField.setText("jTextField5");

        passwortField.setText("jTextField6");

        plzField.setText("jTextField7");

        strasseField.setText("jTextField8");

        sucheField.setText("Titelsuche...");
        sucheField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sucheFieldActionPerformed(evt);
            }
        });

        meldungText.setText("Hier können die Accountinformationen bearbeitet werden");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sucheField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mitarbeiterCheckBox)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(meldungText))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(plzLable)
                                    .addComponent(strasseLable)
                                    .addComponent(vornameLable)
                                    .addComponent(passwortLable))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(vornameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(strasseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(plzField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(71, 71, 71)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hausnummerLable)
                                            .addComponent(nameLable)
                                            .addComponent(stadtLable))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(stadtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(hausnummerField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(passwortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkPasswortLable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkPasswortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sucheField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vornameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vornameLable)
                    .addComponent(nameLable)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(strasseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strasseLable)
                    .addComponent(hausnummerLable)
                    .addComponent(hausnummerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plzField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plzLable)
                    .addComponent(stadtLable)
                    .addComponent(stadtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwortLable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkPasswortLable)
                    .addComponent(checkPasswortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(mitarbeiterCheckBox)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(meldungText))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sucheFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucheFieldActionPerformed
        panelHandler.panelUnsichtbar();
        panelHandler.getSuchePanel().setSearchTitel(sucheField.getText());
        panelHandler.getSuchePanel().setVisible(true);
    }//GEN-LAST:event_sucheFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        if(passwortField.getText().equals(checkPasswortField.getText())){
            String hausnummer = hausnummerField.getText();
            String name = nameField.getText();
            String plz = plzField.getText();
            String stadt = stadtField.getText();
            String strasse = strasseField.getText();
            String vorname = vornameField.getText();
            String passwort = passwortField.getText();
            boolean mitarbeiter = mitarbeiterCheckBox.isSelected();
            panelHandler.saveAccountChange(account.getUserid(),hausnummer, name, plz, stadt, strasse, vorname, passwort,mitarbeiter);
            meldungText.setText("Änderungen wurden übernommen.");
        }
        else{
            meldungText.setText("Passwort stimmt nicht überein.");
        }
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField checkPasswortField;
    private javax.swing.JLabel checkPasswortLable;
    private javax.swing.JTextField hausnummerField;
    private javax.swing.JLabel hausnummerLable;
    private javax.swing.JLabel meldungText;
    private javax.swing.JCheckBox mitarbeiterCheckBox;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLable;
    private javax.swing.JTextField passwortField;
    private javax.swing.JLabel passwortLable;
    private javax.swing.JTextField plzField;
    private javax.swing.JLabel plzLable;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField stadtField;
    private javax.swing.JLabel stadtLable;
    private javax.swing.JTextField strasseField;
    private javax.swing.JLabel strasseLable;
    private javax.swing.JTextField sucheField;
    private javax.swing.JTextField vornameField;
    private javax.swing.JLabel vornameLable;
    // End of variables declaration//GEN-END:variables

    public void setAccount(Account a) {
        neu = false;
        account =a;
        if(a==null)
            System.out.println("null");
        hausnummerField.setText(TOOL_TIP_TEXT_KEY);
        nameField.setText(a.getNachname());
        plzField.setText(TOOL_TIP_TEXT_KEY);
        stadtField.setText(TOOL_TIP_TEXT_KEY);
        strasseField.setText(TOOL_TIP_TEXT_KEY);
        vornameField.setText(a.getVorname());
    }
        
    public void save(int id,String hausnummer, String name, String plz, String stadt, String strasse, String vorname,String  passwort, boolean mitarbeiter){
        if(neu)
        panelHandler.saveAccountChange(account.getUserid(),hausnummer, name, plz, stadt, strasse, vorname, passwort,mitarbeiter);
        else
          panelHandler.saveAccount(account.getUserid(),hausnummer, name, plz, stadt, strasse, vorname, passwort,mitarbeiter);  
    }
    
    public void bearbeitenMitarbeiter(){
        mitarbeiterCheckBox.setEnabled(true);
    }

    void setNewAccount(Account a) {
        neu = true;
        account =a;
        if(a==null)
            System.out.println("null");
        hausnummerField.setText(TOOL_TIP_TEXT_KEY);
        nameField.setText(a.getNachname());
        plzField.setText(TOOL_TIP_TEXT_KEY);
        stadtField.setText(TOOL_TIP_TEXT_KEY);
        strasseField.setText(TOOL_TIP_TEXT_KEY);
        vornameField.setText(a.getVorname());
    }
}
