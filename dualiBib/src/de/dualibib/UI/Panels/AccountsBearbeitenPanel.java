/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.dualibib.UI.Panels;

import de.dualibib.Fachlogik.Accountverwaltung.Account;
import de.dualibib.UI.PanelHandler;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carina
 */
public class AccountsBearbeitenPanel extends javax.swing.JPanel {

    private final PanelHandler panelHandler;
    ArrayList<Account> accountListe;

    /** Creates new form AccountsBearbeiten */
    public AccountsBearbeitenPanel(PanelHandler panelHandler) {
        initComponents();
        this.panelHandler = panelHandler;
        //setAccountListe();
        //fillTable();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        sucheAccountField = new javax.swing.JTextField();
        bearbeitenButton = new javax.swing.JButton();
        anlegenButton = new javax.swing.JButton();
        sucheField = new javax.swing.JTextField();
        accountnameField = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usename", "Vorname", "Nachname"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        sucheAccountField.setText("Suche Account");
        sucheAccountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sucheAccountFieldActionPerformed(evt);
            }
        });

        bearbeitenButton.setText("Bearbeiten");
        bearbeitenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bearbeitenButtonActionPerformed(evt);
            }
        });

        anlegenButton.setText("Anlegen");
        anlegenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anlegenButtonActionPerformed(evt);
            }
        });

        sucheField.setText("Titelsuche...");
        sucheField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sucheFieldActionPerformed(evt);
            }
        });

        accountnameField.setText("Accountname");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(sucheAccountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sucheField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(anlegenButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accountnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(bearbeitenButton)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(sucheField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(sucheAccountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bearbeitenButton)
                    .addComponent(anlegenButton)
                    .addComponent(accountnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sucheFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucheFieldActionPerformed
        panelHandler.panelUnsichtbar();
        panelHandler.getSuchePanel().setSearchTitel(sucheField.getText());
        panelHandler.getSuchePanel().setVisible(true);
    }//GEN-LAST:event_sucheFieldActionPerformed

    private void bearbeitenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bearbeitenButtonActionPerformed
        try {
            Account a = getAccountfromIndices(getListSelections());
            panelHandler.panelUnsichtbar();
            panelHandler.getUi().add(panelHandler.getAccountBearbeitenPanel());
            panelHandler.getAccountBearbeitenPanel().setAccount(a);
            panelHandler.getAccountBearbeitenPanel().bearbeitenMitarbeiter();
            panelHandler.getAccountBearbeitenPanel().setVisible(true);
        } catch (Exception e) {
        }
        
        
    }//GEN-LAST:event_bearbeitenButtonActionPerformed

    private void anlegenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anlegenButtonActionPerformed
        if(!acountNameZulaessig(accountnameField.getText())){}
        else{
            panelHandler.panelUnsichtbar();
            panelHandler.getUi().add(panelHandler.getAccountBearbeitenPanel());
            panelHandler.getAccountBearbeitenPanel().bearbeitenMitarbeiter();
            panelHandler.getAccountBearbeitenPanel().setNewAccount(new Account(accountnameField.getText(), "todo", false, 0, "todo", "todo", 0, "todo", "todo", "todo"));
            panelHandler.getAccountBearbeitenPanel().setVisible(true);
        }
    }//GEN-LAST:event_anlegenButtonActionPerformed

    private void sucheAccountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucheAccountFieldActionPerformed
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        for (int i = model.getRowCount() - 1; i > -1; i--) {
            model.removeRow(i);
        }
        
        for (int i = 0; i < accountListe.size(); i++) {
            if(accountListe.get(i).getUsername().equals(sucheAccountField.getText()))
             model.addRow(new Object[]{accountListe.get(i).getUsername(),accountListe.get(i).getNachname(),accountListe.get(i).getVorname()});  
        }
    }//GEN-LAST:event_sucheAccountFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountnameField;
    private javax.swing.JButton anlegenButton;
    private javax.swing.JButton bearbeitenButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField sucheAccountField;
    private javax.swing.JTextField sucheField;
    // End of variables declaration//GEN-END:variables

    
    public void setAccountListe(ArrayList<Account> account){
        accountListe = account;
    }
    
    public void fillTable(){
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        for (int i = model.getRowCount() - 1; i > -1; i--) {
            model.removeRow(i);
        }
        for (int i = 0; i < accountListe.size(); i++) {
          model.addRow(new Object[]{accountListe.get(i).getUsername(),accountListe.get(i).getNachname(),accountListe.get(i).getVorname()});  
        }
    }
    
    private Account getAccountfromIndices(int position) {
		Account selected = null;
		selected = accountListe.get(position);
		return selected;
	}
    
    private int getListSelections() {
	int[] selected = jTable1.getSelectedRows();
	for (int i = 0; i < selected.length; i++) {
		selected[i] = jTable1.convertRowIndexToModel(selected[i]);
	}
	return selected[0];
    }

    private boolean acountNameZulaessig(String text) {
        if(text.length()<8||text.length()>0){

            for (int i = 0; i < accountListe.size(); i++) {
                if(accountListe.get(i).getUsername().equals(text))
                        return  false;
            }
            return true;
        } else {
            return false;
        }  
        
    }
}
