/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.UI;

import de.dualibib.Fachlogik.Accountverwaltung.Account;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleihe;
import de.dualibib.Fachlogik.Controller;
import de.dualibib.Fachlogik.Historyverwaltung.History;
import de.dualibib.Fachlogik.Medienverwaltung.Medien;
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
    
    private final Controller controller;
    private boolean eingeloggt;
    private boolean mitarbeiter;
    private Account aktuellerUser;

    public UI getUi() {
        return ui;
    }

    public Account getAktuellerUser() {
        return aktuellerUser;
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

    public PanelHandler(Controller controller, List genreListe, List kategorieListe) {
        ui = new UI(genreListe, kategorieListe,this, false);
        initPanels();
        ui.add(suchePanel);
        ui.getjPanel1().setVisible(false);
        suchePanel.setVisible(true);
        this.controller = controller;
    }

    private void initPanels(){
        loginPanel = new LoginPanel(this);
        accountBearbeitenPanel = new AccountBearbeitenPanel(this);
        historyPanel = new HistoryPanel(this);
        accountsBearbeitenPanel = new AccountsBearbeitenPanel(this);
        ausleihenPanel = new AusleihenPanel(this);
        optionPanel = new OptionPanel(this);
        ausleihenBearbeitenPanel = new AusleihenBearbeitenPanel(this);
        selectPanel = new SelectPanel(this);
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

    public boolean login(String accountname, String passwort) {
        if(controller.setAktuellerUser(accountname, passwort)!=null){
            this.aktuellerUser =controller.setAktuellerUser(accountname, passwort);
            if(controller.isMitarbeiter()){
                ui.setMitarbeiterOnline();
            }
            ui.setUserOnline();
            ausleihenPanel.setUserAusleihe(controller.getAusleiheListe());
            historyPanel.setUserHistory(controller.getHistoryListe());
            return true;
        }
        return false;
    }

    public void saveAccountChange(int id,String hausnummer, String name, String plz, String stadt, String strasse, String vorname, String passwort,boolean mitarbeiter) {
        Account a = new Account(vorname, passwort, mitarbeiter, id, vorname, vorname);
        controller.saveAccountChange(a);
    }

    public void saveMediumChange(Medien m) {
        controller.saveMediumChange(m);
    }

    public void deleteAusleihe(Ausleihe a) {
        controller.deleteAusleihe(a);
    }

    public void saveAccount(int userid, String hausnummer, String name, String plz, String stadt, String strasse, String vorname, String passwort, boolean mitarbeiter) {
        controller.saveAccount(new Account(vorname, passwort, mitarbeiter, userid, vorname, vorname));
    }

    public void deleteHistory(History h) {
        controller.deleteHistory(h);
    }

    
    
}
