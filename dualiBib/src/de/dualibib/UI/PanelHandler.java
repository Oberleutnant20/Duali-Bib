/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.UI;

import de.dualibib.UI.Panels.AccountBearbeitenPanel;
import de.dualibib.UI.Panels.AccountsBearbeitenPanel;
import de.dualibib.UI.Panels.AusleihenBearbeitenPanel;
import de.dualibib.UI.Panels.AusleihenPanel;
import de.dualibib.UI.Panels.HistoryPanel;
import de.dualibib.UI.Panels.LoginPanel;
import de.dualibib.UI.Panels.OptionPanel;
import de.dualibib.UI.Panels.SelectPanel;
import de.dualibib.UI.Panels.SuchePanel;
import java.util.List;

/**
 *
 * @author Carina
 */
public class PanelHandler {
    
    private AusleihenBearbeitenPanel ausleihenBearbeitenPanel;
    private OptionPanel optionPanel;
    private AusleihenPanel ausleihenPanel;
    private HistoryPanel historyPanel;
    private AccountsBearbeitenPanel accountsBearbeitenPanel;
    private AccountBearbeitenPanel accountBearbeitenPanel;
    private LoginPanel loginPanel;
    private SelectPanel selectPanel;
    private SuchePanel suchePanel;
    private UI ui;

    public UI getUi() {
        return ui;
    }

    public SuchePanel getSuchePanel() {
        return suchePanel;
    }

    public AusleihenBearbeitenPanel getAusleihenBearbeitenPanel() {
        return ausleihenBearbeitenPanel;
    }

    public OptionPanel getOptionPanel() {
        return optionPanel;
    }

    public AusleihenPanel getAusleihenPanel() {
        return ausleihenPanel;
    }

    public HistoryPanel getHistoryPanel() {
        return historyPanel;
    }

    public AccountsBearbeitenPanel getAccountsBearbeitenPanel() {
        return accountsBearbeitenPanel;
    }

    public AccountBearbeitenPanel getAccountBearbeitenPanel() {
        return accountBearbeitenPanel;
    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }

    public SelectPanel getSelectPanel() {
        return selectPanel;
    }

    public PanelHandler(List genreListe, List kategorieListe) {
        ui = new UI(genreListe, kategorieListe);
        initPanels();
        ui.add(suchePanel);
        ui.getjPanel1().setVisible(false);
        suchePanel.setVisible(true);
    }

    private void initPanels(){
        loginPanel = new LoginPanel(this);
        accountBearbeitenPanel = new AccountBearbeitenPanel();
        historyPanel = new HistoryPanel();
        accountsBearbeitenPanel = new AccountsBearbeitenPanel();
        ausleihenPanel = new AusleihenPanel();
        optionPanel = new OptionPanel();
        ausleihenBearbeitenPanel = new AusleihenBearbeitenPanel();
        selectPanel = new SelectPanel();
        suchePanel= new SuchePanel(this);
    }
    public void panelUnsichtbar() {
        selectPanel.setVisible(false);
        loginPanel.setVisible(false);
        suchePanel.setVisible(false); 
        accountBearbeitenPanel.setVisible(false);
        historyPanel.setVisible(false);
        accountsBearbeitenPanel.setVisible(false);
        ausleihenPanel.setVisible(false);
        optionPanel.setVisible(false);
        ausleihenBearbeitenPanel.setVisible(false);
    }
}
