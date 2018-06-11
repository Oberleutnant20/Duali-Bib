/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.UI.Panels;

import de.dualibib.Datenlogik.dto.MedienDTO;
import de.dualibib.Fachlogik.Genreverwaltung.Genre;
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
public class SuchePanel extends ElternPanel {

    MedienDTO medienListe;

    /**
     * Creates new form SuchePanel
     */
    public SuchePanel(PanelHandler panelHandler) {
        super(panelHandler);
        initComponents();
        setComboboxKategorie(kategorieComboBox, panelHandler.getKategorieListe().get());
        setComboboxGenre(genreComboBox, panelHandler.getGenreListe().get());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sucheField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        kategorieLable = new javax.swing.JLabel();
        genreLable = new javax.swing.JLabel();
        kategorieComboBox = new javax.swing.JComboBox<>();
        genreComboBox = new javax.swing.JComboBox<>();
        selectButton = new javax.swing.JButton();

        sucheField.setText("Suche");
        sucheField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sucheFieldActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Kategorie", "Genre", "ISBN", "Verfügbar"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        kategorieLable.setText("Katgorie");

        genreLable.setText("Genre");

        kategorieComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        kategorieComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kategorieComboBoxActionPerformed(evt);
            }
        });

        genreComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        genreComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genreComboBoxActionPerformed(evt);
            }
        });

        selectButton.setText("Auswählen");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kategorieLable)
                .addGap(26, 26, 26)
                .addComponent(kategorieComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(genreLable)
                .addGap(18, 18, 18)
                .addComponent(genreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(selectButton))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sucheField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sucheField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kategorieLable)
                    .addComponent(genreLable)
                    .addComponent(kategorieComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectButton))
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
      try {
            panelHandler.getSelectPanel().setMedium(getMediumfromIndices(getListSelections()));
            if(panelHandler.getAktuellerUser().isMitarbeiter()){
                panelHandler.getSelectPanel().setMitarbeiter();
            }
            panelHandler.panelUnsichtbar();
            panelHandler.getUi().add(panelHandler.getSelectPanel());
            panelHandler.getSelectPanel().setVisible(true);
        } catch (Exception e) {
            System.err.println("problem beim aufrufen vom selectpanel");
        }
        
    }//GEN-LAST:event_selectButtonActionPerformed

    private void sucheFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucheFieldActionPerformed
        setSearchTitel(sucheField.getText());
    }//GEN-LAST:event_sucheFieldActionPerformed

    private void kategorieComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategorieComboBoxActionPerformed
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        String text = kategorieComboBox.getItemAt(0);
        for (int i = model.getRowCount() - 1; i > -1; i--) {
            model.removeRow(i);
        }
        
        int kategorieid = -1;
        for (int i = 0; i < panelHandler.getKategorieListe().size(); i++) {
         if(panelHandler.getKategorieListe().get(i).getBezeichnung().equals(text))   
             kategorieid=(int) panelHandler.getKategorieListe().get(i).getId();
        }
        
        for (int i = 0; i < medienListe.size(); i++) {
            if(medienListe.get(i).getKategorien().getId()==kategorieid)
             model.addRow(addObject(i));    
        }
    }//GEN-LAST:event_kategorieComboBoxActionPerformed

    private void genreComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genreComboBoxActionPerformed
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        String text =genreComboBox.getItemAt(0);
        for (int i = model.getRowCount() - 1; i > -1; i--) {
            model.removeRow(i);
        }
        
        int genreid = -1;
        for (int i = 0; i < panelHandler.getKategorieListe().size(); i++) {
         if(panelHandler.getGenreListe().get(i).getBezeichnung().equals(text))   
             genreid=(int) panelHandler.getGenreListe().get(i).getId();
        }
        
        for (int i = 0; i < medienListe.size(); i++) {
            if(medienListe.get(i).getGenre().getId()==genreid)
             model.addRow(addObject(i));    
        }
    }//GEN-LAST:event_genreComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> genreComboBox;
    private javax.swing.JLabel genreLable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> kategorieComboBox;
    private javax.swing.JLabel kategorieLable;
    private javax.swing.JButton selectButton;
    private javax.swing.JTextField sucheField;
    // End of variables declaration//GEN-END:variables

    void setSearchTitel(String text) {
        medienListe = panelHandler.returnMedien();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        for (int i = model.getRowCount() - 1; i > -1; i--) {
            model.removeRow(i);
        }
        
        if(text.equals("")||text.equals("Suche")||text.equals("Titelsuchen...")||text.equals("Titelsuche...")){
            for (int i = 0; i < medienListe.size(); i++) {
                model.addRow(addObject(i)); 
            }
            return;
        }
        
        for (int i = 0; i < medienListe.size(); i++) {
            if(medienListe.get(i).getName().equals(text))
             model.addRow(addObject(i));    
        }
    }
    
    public void setMedienListe(MedienDTO medien){
        medienListe = medien;
    }
    
    public void fillTable(){
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        for (int i = 0; i < medienListe.size(); i++) {
          model.addRow(addObject(i));  
        }
    }
    
    private Medien getMediumfromIndices(int position) {
		Medien selected = null;
		selected = medienListe.get(position);
		return selected;
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
    
    private void setComboboxGenre(JComboBox combobox,List<Genre> list){
        String[] tmp = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            tmp[i] = list.get(i).getBezeichnung();
        }        
        combobox.setModel(new DefaultComboBoxModel(tmp));
    }

    private Object[] addObject(int i) {
        String kategorie = medienListe.get(i).getKategorien().getBezeichnung();
        String genre = medienListe.get(i).getGenre().getBezeichnung();
        return new Object[]{medienListe.get(i).getName(),kategorie,genre,medienListe.get(i).getIsbn(),medienListe.get(i).getVerfuegbare()};
    }

    @Override
    public void update() {
        fillTable();
    }
}
