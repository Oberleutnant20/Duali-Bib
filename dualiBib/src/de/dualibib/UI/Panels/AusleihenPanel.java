package de.dualibib.UI.Panels;

import de.dualibib.Datenlogik.dto.Account;
import de.dualibib.Datenlogik.dto.Ausleihe;
import de.dualibib.Datenlogik.dto.Medien;
import de.dualibib.Fachlogik.Languageverwaltung.PropertyName;
import de.dualibib.Logger;
import de.dualibib.UI.ElternPanel;
import de.dualibib.UI.PanelHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carina
 */
public class AusleihenPanel extends ElternPanel {

    List<Ausleihe> ausleiheUserListe;
    Account account;

    /**
     * Creates new form AusleihenPanel
     */
    public AusleihenPanel(PanelHandler panelHandler) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        entfernenButton = new javax.swing.JButton();
        sucheField = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AusleiheID", "MedienID", "Date", "UserID", "KategorieID"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        entfernenButton.setText("Entfernen");
        entfernenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entfernenButtonActionPerformed(evt);
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
                .addGap(33, 33, 33)
                .addComponent(entfernenButton)
                .addGap(34, 286, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sucheField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sucheField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addComponent(entfernenButton)
                .addGap(56, 56, 56))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void entfernenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entfernenButtonActionPerformed
        try {
            Ausleihe ausleihe = getAusleihefromIndices(getListSelections());
            Logger.info(this, "" + ausleihe.getId());
            panelHandler.deleteAusleihe(ausleihe);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_entfernenButtonActionPerformed

    private void sucheFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucheFieldActionPerformed
        panelHandler.panelUnsichtbar();
        panelHandler.getSuchePanel().setSearchTitel(sucheField.getText());
        panelHandler.getSuchePanel().setVisible(true);
    }//GEN-LAST:event_sucheFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton entfernenButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField sucheField;
    // End of variables declaration//GEN-END:variables

    private Ausleihe getAusleihefromIndices(int position) {
        Ausleihe selected = null;
        selected = ausleiheUserListe.get(position);
        return selected;
    }

    private int getListSelections() {
        int[] selected = jTable1.getSelectedRows();
        for (int i = 0; i < selected.length; i++) {
            selected[i] = jTable1.convertRowIndexToModel(selected[i]);
        }
        return selected[0];
    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = model.getRowCount() - 1; i > -1; i--) {
            model.removeRow(i);
        }
        for (int i = 0; i < ausleiheUserListe.size(); i++) {
            model.addRow(addObject(i));
        }
    }

    private Object[] addObject(int i) {
        String medienName = "";
        List<Medien> medienlist = panelHandler.returnMedien();
        for (int j = 0; j < medienlist.size(); j++) {
            if (ausleiheUserListe.get(i).getMedienid() == medienlist.get(j).getId()) {
                medienName = medienlist.get(j).getName();
            }
        }

        String kategorieName = "";

        for (int j = 0; j < panelHandler.getKategorieListe().size(); j++) {
            if (ausleiheUserListe.get(i).getKategorieid() == panelHandler.getKategorieListe().get(j).getId()) {
                medienName = panelHandler.getKategorieListe().get(j).getName();
            }
        }

        return new Object[]{ausleiheUserListe.get(i).getId(), medienName, ausleiheUserListe.get(i).getDate(), panelHandler.getAktuellerUser().getUsername(), kategorieName};
    }

    public void setAccount(Account aktuellerUser) {
        account = aktuellerUser;
    }

    public void setAusleihenListe(List<Ausleihe> allAusleihenListe) {
        ausleiheUserListe = allAusleihenListe;
    }

    @Override
    public void update() {
        Logger.info(this, "update");
        account = panelHandler.getAktuellerUser();
        if (account != null) {
            ausleiheUserListe = new ArrayList<>();
            for (int i = 0; i < panelHandler.getAusleihe().size(); i++) {
                if (panelHandler.getAusleihe().get(i).getUserid() == account.getUserid()) {
                    ausleiheUserListe.add(panelHandler.getAusleihe().get(i));
                }
            }
            fillTable();
        }
    }

    @Override
    public void updateLanguage(Properties props) {
        entfernenButton.setText((String) props.get(PropertyName.AUSLEIHENPANEL_ENTFERNENBUTTON));
        sucheField.setText((String) props.get(PropertyName.SUCHEFIELD));
    }
}
