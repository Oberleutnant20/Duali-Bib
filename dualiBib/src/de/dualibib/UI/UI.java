/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.UI;

import de.dualibib.Datenlogik.dto.Genre;
import de.dualibib.Datenlogik.dto.Kategorie;
import de.dualibib.info.Informationen;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Carina
 */
public class UI extends javax.swing.JFrame {
    
    PanelHandler panelHandler;

    /**
     * Creates new form UI
     */
    public UI(PanelHandler panelHandler) {
        initComponents();
        setLayout(new java.awt.BorderLayout());
        setVisible(true);
        this.panelHandler = panelHandler;
    }

    public JPanel getjPanel1() {
        return jPanel1;
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
        jMenuBar1 = new javax.swing.JMenuBar();
        accountMenu = new javax.swing.JMenu();
        LoginLogoutMenu = new javax.swing.JMenuItem();
        editAccountMenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        historyMenu = new javax.swing.JMenuItem();
        aktuelleAusleiheMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        beendenMenu = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        informationMenu = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        optionMenu = new javax.swing.JMenuItem();
        administrationMenu = new javax.swing.JMenu();
        accountsBearbeitenItem = new javax.swing.JMenuItem();
        ausleihenBearbeiten = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        accountMenu.setText("Account");

        LoginLogoutMenu.setText("Login/Logout");
        LoginLogoutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginLogoutMenuActionPerformed(evt);
            }
        });
        accountMenu.add(LoginLogoutMenu);

        editAccountMenu.setText("Account bearbeiten");
        editAccountMenu.setEnabled(false);
        editAccountMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAccountMenuActionPerformed(evt);
            }
        });
        accountMenu.add(editAccountMenu);
        accountMenu.add(jSeparator2);

        historyMenu.setText("History");
        historyMenu.setEnabled(false);
        historyMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyMenuActionPerformed(evt);
            }
        });
        accountMenu.add(historyMenu);

        aktuelleAusleiheMenu.setText("aktuelle Ausleihe");
        aktuelleAusleiheMenu.setEnabled(false);
        aktuelleAusleiheMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aktuelleAusleiheMenuActionPerformed(evt);
            }
        });
        accountMenu.add(aktuelleAusleiheMenu);
        accountMenu.add(jSeparator1);

        beendenMenu.setText("Beenden");
        beendenMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beendenMenuActionPerformed(evt);
            }
        });
        accountMenu.add(beendenMenu);

        jMenuBar1.add(accountMenu);

        helpMenu.setText("Help");

        informationMenu.setText("Information");
        informationMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informationMenuActionPerformed(evt);
            }
        });
        helpMenu.add(informationMenu);
        helpMenu.add(jSeparator3);

        optionMenu.setText("Option");
        optionMenu.setEnabled(false);
        optionMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionMenuActionPerformed(evt);
            }
        });
        helpMenu.add(optionMenu);

        jMenuBar1.add(helpMenu);

        administrationMenu.setText("Administration");
        administrationMenu.setEnabled(false);

        accountsBearbeitenItem.setText("Accounts bearbeiten");
        accountsBearbeitenItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountsBearbeitenItemActionPerformed(evt);
            }
        });
        administrationMenu.add(accountsBearbeitenItem);

        ausleihenBearbeiten.setText("Ausleihen bearbeiten");
        ausleihenBearbeiten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ausleihenBearbeitenActionPerformed(evt);
            }
        });
        administrationMenu.add(ausleihenBearbeiten);

        jMenuBar1.add(administrationMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void beendenMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beendenMenuActionPerformed
        try {
            panelHandler.ausloggen();
            System.exit(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Speichern nicht möglich.", "Beenden", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_beendenMenuActionPerformed

    private void LoginLogoutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginLogoutMenuActionPerformed
        panelHandler.panelUnsichtbar();
        add(panelHandler.getLoginPanel());
        panelHandler.getLoginPanel().setVisible(true);
    }//GEN-LAST:event_LoginLogoutMenuActionPerformed

    private void editAccountMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAccountMenuActionPerformed
        panelHandler.panelUnsichtbar();
        add(panelHandler.getAccountBearbeitenPanel());
        panelHandler.getAccountBearbeitenPanel().setAccount(panelHandler.getAktuellerUser());
        panelHandler.getAccountBearbeitenPanel().setVisible(true);
    }//GEN-LAST:event_editAccountMenuActionPerformed

    private void accountsBearbeitenItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountsBearbeitenItemActionPerformed
        panelHandler.panelUnsichtbar();
        panelHandler.getAccountsBearbeitenPanel().fillTable();
        add(panelHandler.getAccountsBearbeitenPanel());
        panelHandler.getAccountsBearbeitenPanel().setVisible(true);
    }//GEN-LAST:event_accountsBearbeitenItemActionPerformed

    private void historyMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyMenuActionPerformed
        panelHandler.panelUnsichtbar();
        panelHandler.getHistoryPanel().fillTable();
        add(panelHandler.getHistoryPanel());
        panelHandler.getHistoryPanel().setVisible(true);
    }//GEN-LAST:event_historyMenuActionPerformed

    private void aktuelleAusleiheMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aktuelleAusleiheMenuActionPerformed
        panelHandler.panelUnsichtbar();
        panelHandler.getAusleihenPanel().setAccount(panelHandler.getAktuellerUser());
        panelHandler.getAusleihenPanel().fillTable();
        add(panelHandler.getAusleihenPanel());
        panelHandler.getAusleihenPanel().setVisible(true);
    }//GEN-LAST:event_aktuelleAusleiheMenuActionPerformed

    private void optionMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionMenuActionPerformed
        panelHandler.panelUnsichtbar();
        add(panelHandler.getOptionPanel());
        panelHandler.getOptionPanel().setVisible(true);
    }//GEN-LAST:event_optionMenuActionPerformed

    private void ausleihenBearbeitenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ausleihenBearbeitenActionPerformed
        panelHandler.panelUnsichtbar();
        panelHandler.getAusleihenBearbeitenPanel().fillTable();
        add(panelHandler.getAusleihenBearbeitenPanel());
        panelHandler.getAusleihenBearbeitenPanel().setVisible(true);
    }//GEN-LAST:event_ausleihenBearbeitenActionPerformed

    private void informationMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informationMenuActionPerformed
        info();
    }//GEN-LAST:event_informationMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem LoginLogoutMenu;
    private javax.swing.JMenu accountMenu;
    private javax.swing.JMenuItem accountsBearbeitenItem;
    private javax.swing.JMenu administrationMenu;
    private javax.swing.JMenuItem aktuelleAusleiheMenu;
    private javax.swing.JMenuItem ausleihenBearbeiten;
    private javax.swing.JMenuItem beendenMenu;
    private javax.swing.JMenuItem editAccountMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem historyMenu;
    private javax.swing.JMenuItem informationMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuItem optionMenu;
    // End of variables declaration//GEN-END:variables
    // Variablen
    

    private void info() {
        JOptionPane.showMessageDialog(rootPane, new Informationen().printEntwickler(), "Entwicklerinfo", JOptionPane.INFORMATION_MESSAGE);
    }

    private void entwicklung() {
        JOptionPane.showMessageDialog(rootPane, new Informationen().printEntwicklung(""), "Entwicklung", JOptionPane.ERROR_MESSAGE);
    }

    void setMitarbeiterOnline() {
        System.out.println("enable admin");
        administrationMenu.setEnabled(true);

        panelHandler.loadAdminAccounts();
        panelHandler.loadAusleihen();
    }

    void setUserOnline() {
        System.out.println("enable user");
        editAccountMenu.setEnabled(true);
        historyMenu.setEnabled(true);
        aktuelleAusleiheMenu.setEnabled(true);

        panelHandler.getHistory();
        panelHandler.getAusleihe();
    }

    void setUserOffline() {
        editAccountMenu.setEnabled(false);
        historyMenu.setEnabled(false);
        aktuelleAusleiheMenu.setEnabled(false);
        administrationMenu.setEnabled(false);
    }
}
