package de.dualibib.UI.Panels;

import de.dualibib.Fachlogik.Languageverwaltung.PropertyName;
import de.dualibib.UI.ElternPanel;
import de.dualibib.UI.PanelHandler;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Carina
 */
public class LoginPanel extends ElternPanel {

    private boolean online = false;
    private Properties props;

    /**
     * Creates new form Login
     */
    public LoginPanel(PanelHandler panelHandler) {
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

        accountnameField = new javax.swing.JTextField();
        passwortField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        accountLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        meldungText = new javax.swing.JLabel();
        sucheField = new javax.swing.JTextField();

        accountnameField.setText("Accountname");

        passwortField.setText("Passwort");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        accountLabel.setText("Accountname");

        passwordLabel.setText("Passwort");

        meldungText.setText("Bitte gib deinen Accountnamen und Passwort an.");

        sucheField.setText("Titelsuchen...");
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
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(meldungText)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordLabel)
                            .addComponent(accountLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(accountnameField)
                            .addComponent(passwortField)
                            .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sucheField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sucheField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(meldungText)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountLabel))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLabel))
                .addGap(28, 28, 28)
                .addComponent(loginButton)
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Führt das Login durch.
     *
     * @param evt
     */
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        if (!online) {
            String accountname = accountnameField.getText();
            String passwort = passwortField.getText();
            panelHandler.login(accountname, passwort);
        } else {
            try {
                panelHandler.ausloggen();
            } catch (Exception e) {
                System.err.println(e);
                meldungText.setText("Speichern der Sitzung nicht möglich");
            }
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    /**
     * Führt eine Suche aus.
     *
     * @param evt
     */
    private void sucheFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sucheFieldActionPerformed
        panelHandler.panelUnsichtbar();
        panelHandler.getSuchePanel().setSearchTitel(sucheField.getText());
        panelHandler.getSuchePanel().setVisible(true);
    }//GEN-LAST:event_sucheFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountLabel;
    private javax.swing.JTextField accountnameField;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel meldungText;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField passwortField;
    private javax.swing.JTextField sucheField;
    // End of variables declaration//GEN-END:variables

    /**
     * Meldet einen Nutzer im System an.
     *
     * @param einloggen
     */
    public void einloggen(boolean einloggen) {
        if (einloggen) {
            meldungText.setText((String) props.get(PropertyName.LOGINPANEL_SUCCESSLOGIN));
            accountnameField.setEnabled(false);
            passwortField.setEnabled(false);
            loginButton.setText((String) props.get(PropertyName.LOGINPANEL_LOGOUTBUTTON));
            online = true;
            panelHandler.panelUnsichtbar();
            panelHandler.getSuchePanel().setVisible(true);
        } else {
            meldungText.setText((String) props.get(PropertyName.LOGINPANEL_WRONG));
        }
    }

    /**
     * Loggt den angemeldeten Nutzer ab.
     *
     * @throws IOException
     * @throws ConnectionError
     */
    public void ausloggen() throws IOException, ConnectionError {
        meldungText.setText((String) props.get(PropertyName.LOGINPANEL_SUCCESSLOGOUT));
        loginButton.setText((String) props.get(PropertyName.LOGINPANEL_LOGINBUTTON));
        accountnameField.setEnabled(true);
        passwortField.setEnabled(true);
        online = false;
    }

    @Override
    public void update() {
    }

    /**
     * Setzt die Sprachkonfiguration anhand der Properties um.
     *
     * @param props Properties Datei
     */
    @Override
    public void updateLanguage(Properties props) {
        this.props = props;
        meldungText.setText((String) props.get(PropertyName.LOGINPANEL_MELDUNG));
        sucheField.setText((String) props.get(PropertyName.SUCHEFIELD));
        meldungText.setText((String) props.get(PropertyName.LOGINPANEL_ACCOUNTLABEL));
        accountLabel.setText((String) props.get(PropertyName.LOGINPANEL_ACCOUNTLABEL));
        accountnameField.setText((String) props.get(PropertyName.LOGINPANEL_ACCOUNTNAMEFIELD));
        passwordLabel.setText((String) props.get(PropertyName.LOGINPANEL_PASSWORDLABEL));
        passwortField.setText((String) props.get(PropertyName.LOGINPANEL_PASSWORTFIELD));
        loginButton.setText((String) props.get(PropertyName.LOGINPANEL_LOGINBUTTON));
    }
}
