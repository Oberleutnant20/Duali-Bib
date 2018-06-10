/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Accountverwaltung;

import de.dualibib.Datenlogik.dto.AccountDTO;
import de.dualibib.Datenlogik.idao.IAccountDAO;
import de.dualibib.Fachlogik.ElternVerwaltung;
import de.dualibib.UI.ElternPanel;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carina
 */
public class Accountverwaltung extends ElternVerwaltung{

    private AccountDTO accountListe;
    private AccountDTO accountListeUpdate;
    private AccountDTO accountListeDelete;
    private AccountDTO accountListeRef;
    private IAccountDAO accountDAO;

    public Accountverwaltung(IAccountDAO accountDAO) {
        accountListeRef = new AccountDTO();
        accountListeUpdate = new AccountDTO();
        accountListeDelete = new AccountDTO();    
        this.accountDAO = accountDAO;
    }

    public void speichern() throws IOException, ConnectionError {
        List<Account> liste = new ArrayList<>();
        if (accountListe.size() > accountListeRef.size()) {
            //liste = accountListe.subList(accountListeRef.size(), accountListe.size());
        }
        accountDAO.speichern();
        //accountDAO.update(accountListeUpdate);
    }

    public void laden() {
        try {
            accountListe = accountDAO.laden();
            accountListeRef = accountDAO.laden();
        } catch (IOException ex) {
            Logger.getLogger(Accountverwaltung.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ConnectionError ex) {
            Logger.getLogger(Accountverwaltung.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update(Account account){
        if (!accountListeUpdate.add(account)) {
            String error = "Account gibt es bereits.";
        }
        accountListe.add(account);
        notifyPanels();
    }
    
    public void delete(Account account) {
        if (!accountListeDelete.add(account)) {
            String error = "Account gibt es bereits.";
        }
        else{
            accountListe.remove(account);
            notifyPanels();
        }
    }
    
    public void add(Account account) {
        if (!accountListe.add(account)) {
            String error = "Ausleihe gibt es bereits.";
        }
        notifyPanels();
    }
    
    public AccountDTO get() {
        return accountListe;
    }
}
