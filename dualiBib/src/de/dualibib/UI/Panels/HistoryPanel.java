/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.UI.Panels;

import de.dualibib.Datenlogik.dto.HistoryDTO;
import de.dualibib.Fachlogik.Historyverwaltung.History;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorie;
import de.dualibib.Fachlogik.Medienverwaltung.Medien;
import de.dualibib.UI.ElternPanel;
import de.dualibib.UI.PanelHandler;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carina
 */
public class HistoryPanel extends ElternPanel {

    HistoryDTO historyListe;

    /**
     * Creates new form HistoryPanel
     */
    public HistoryPanel(PanelHandler panelHandler) {
        super(panelHandler);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        historysuchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        auswaehlenButton = new javax.swing.JButton();
        kategorieLable = new javax.swing.JLabel();
        kategorieComboBox = new javax.swing.JComboBox<>();
        sucheField = new javax.swing.JTextField();

        historysuchField.setText("Historysuche...");
        historysuchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historysuchFieldActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "HistoryID", "UserID", "MedienID", "KategorieID"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        auswaehlenButton.setText("Auswählen");
        auswaehlenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auswaehlenButtonActionPerformed(evt);
            }
        });

        kategorieLable.setText("Kategorie:");

        kategorieComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        kategorieComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kategorieComboBoxActionPerformed(evt);
            }
        });

        sucheField.setText("Titelsuche...");
        sucheField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sucheFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(kategorieLable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kategorieComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                        .addComponent(auswaehlenButton)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(historysuchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sucheField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(historysuchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sucheField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(auswaehlenButton)
                    .addComponent(kategorieLable)
                    .addComponent(kategorieComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sucheFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucheFieldActionPerformed
        panelHandler.panelUnsichtbar();
        panelHandler.getSuchePanel().setSearchTitel(sucheField.getText());
        panelHandler.getSuchePanel().setVisible(true);
    }//GEN-LAST:event_sucheFieldActionPerformed

    private void auswaehlenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auswaehlenButtonActionPerformed
       try {
            panelHandler.getSelectPanel().setMedium(getMediumfromHistoryIndices(getListSelections()));
            panelHandler.panelUnsichtbar();
            panelHandler.getUi().add(panelHandler.getSelectPanel());
            if(panelHandler.getAktuellerUser().isMitarbeiter()){
                panelHandler.getSelectPanel().setMitarbeiter();
            }
            panelHandler.getSelectPanel().setVisible(true);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_auswaehlenButtonActionPerformed

    private void historysuchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historysuchFieldActionPerformed
        setSearchKategorie(kategorieComboBox.getSelectedItem()+"");
    }//GEN-LAST:event_historysuchFieldActionPerformed

    private void kategorieComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategorieComboBoxActionPerformed
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        String text = kategorieComboBox.getItemAt(0);
        int selectedID = -1;
        panelHandler.getKategorieListe();
        
        for (int i = 0; i < panelHandler.getKategorieListe().size(); i++) {
            if(panelHandler.getKategorieListe().get(i).getBezeichnung().equals(text))
                selectedID=(int) panelHandler.getKategorieListe().get(i).getId();
        }
        
        for (int i = model.getRowCount() - 1; i > -1; i--) {
            model.removeRow(i);
        }
        for (int i = 0; i < historyListe.size(); i++) {
            if(historyListe.get(i).getKategorieid()==selectedID)
             model.addRow(new Object[]{historyListe.get(i).getId()});    
        }
        
    }//GEN-LAST:event_kategorieComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton auswaehlenButton;
    private javax.swing.JTextField historysuchField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> kategorieComboBox;
    private javax.swing.JLabel kategorieLable;
    private javax.swing.JTextField sucheField;
    // End of variables declaration//GEN-END:variables

    public void setUserHistory(HistoryDTO history) {
       historyListe = history;
    }
    
    private Medien getMediumfromHistoryIndices(int position) {
		History selected = null;
                Medien medium = null;
		selected = historyListe.get(position);
                medium = panelHandler.mapHistoryAndMedium(selected);
		return medium;
	}
    
    private int getListSelections() {
	int[] selected = jTable1.getSelectedRows();
	for (int i = 0; i < selected.length; i++) {
		selected[i] = jTable1.convertRowIndexToModel(selected[i]);
	}
	return selected[0];
    }
    
    private void setComboboxKategorie(JComboBox combobox,List<Kategorie> list){
        String[] tmp = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            tmp[i] = list.get(i).getBezeichnung();
        }        
        combobox.setModel(new DefaultComboBoxModel(tmp));
    }

    private void setSearchKategorie(String kategorie) {
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        for (int i = model.getRowCount() - 1; i > -1; i--) {
            model.removeRow(i);
        }
        int kategorieid = -1;
        for (int i = 0; i < panelHandler.getKategorieListe().size(); i++) {
         if(panelHandler.getKategorieListe().get(i).getBezeichnung().equals(kategorie))   
             kategorieid=(int) panelHandler.getKategorieListe().get(i).getId();
        }
                        
        for (int i = 0; i < historyListe.size(); i++) {
            if(historyListe.get(i).getKategorieid()==kategorieid)
             model.addRow(addObject(i));    
        }
    }

    private Object[] addObject(int i) {
        String medienName = "";
        
        for (int j = 0; j < panelHandler.returnMedien().size(); j++) {
            if(historyListe.get(i).getMedienid() == panelHandler.returnMedien().get(j).getId())
                medienName = panelHandler.returnMedien().get(j).getName();
        }
        
        String kategorieName = "";
        
        for (int j = 0; j < panelHandler.getKategorieListe().size(); j++) {
            if(historyListe.get(i).getKategorieid() == panelHandler.getKategorieListe().get(j).getId())
                medienName = panelHandler.getKategorieListe().get(j).getName();
        }
        
        return new Object[]{historyListe.get(i).getId(),panelHandler.getAktuellerUser().getUsername(),medienName,kategorieName};
    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        for (int i = model.getRowCount() - 1; i > -1; i--) {
            model.removeRow(i);
        }
        for (int i = 0; i < historyListe.size(); i++) {
          model.addRow(addObject(i));  
        }
    }

    @Override
    public void update() {
        setComboboxKategorie(kategorieComboBox, panelHandler.getKategorieListe().get());
        if(historyListe!=null)
        fillTable();
    }
    
}
