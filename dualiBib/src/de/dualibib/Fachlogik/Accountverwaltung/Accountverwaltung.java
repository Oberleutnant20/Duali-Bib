package de.dualibib.Fachlogik.Accountverwaltung;

import de.dualibib.Datenlogik.dto.Account;
import de.dualibib.Datenlogik.idao.IAccountDAO;
import de.dualibib.Fachlogik.ElternVerwaltung;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carina
 */
public class Accountverwaltung extends ElternVerwaltung{

    private ArrayList<Account> accountListe;
    private ArrayList<Account> accountListeUpdate;
    private ArrayList<Account> accountListeDelete;
    private ArrayList<Account> accountListeRef;
    private IAccountDAO accountDAO;

    public Accountverwaltung(IAccountDAO accountDAO) {
        accountListe = new ArrayList<>();
        accountListeRef = new ArrayList<>();
        accountListeUpdate = new ArrayList<>();
        accountListeDelete = new ArrayList<>();
        this.accountDAO = accountDAO;
        laden();
    }

    public void speichern() throws IOException, ConnectionError {
        List<Account> liste = new ArrayList<>();
        if (accountListe.size() > accountListeRef.size()) {
            liste = accountListe.subList(accountListeRef.size(), accountListe.size());
        }
        accountDAO.speichern(liste);
        accountDAO.update(accountListeUpdate);
    }

    public void laden() {
        accountListe.clear();
        accountListeRef.clear();
        de.dualibib.Logger.debug(this, "laden");
        try {
            List<Account> liste = accountDAO.laden();
            for (Account account : liste) {
                accountListe.add(account);
                accountListeRef.add(account);
        }
        } catch (Exception e) {
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
        else {
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
    public ArrayList<Account> get() {
        ArrayList<Account> liste = new ArrayList<>();
        accountListe.forEach((account) -> {
            liste.add(account);
        });
        return liste;
}
    }
