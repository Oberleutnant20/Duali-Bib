package de.dualibib.UI;

import de.dualibib.Datenlogik.dto.Genre;
import de.dualibib.Datenlogik.dto.Kategorie;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Carina
 */
public abstract class ElternComboboxPanel extends ElternPanel {

    /**
     * Creates new form ElternPanel
     */
    public ElternComboboxPanel(PanelHandler panelHandler) {
        super(panelHandler);
    }

    public void setComboboxKategorie(JComboBox combobox, List<Kategorie> list) {
        String[] tmp = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            tmp[i] = list.get(i).getBezeichnung();
        }
        combobox.setModel(new DefaultComboBoxModel(tmp));
    }

    public void setComboboxGenre(JComboBox combobox, List<Genre> list) {
        String[] tmp = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            tmp[i] = list.get(i).getBezeichnung();
        }
        combobox.setModel(new DefaultComboBoxModel(tmp));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
