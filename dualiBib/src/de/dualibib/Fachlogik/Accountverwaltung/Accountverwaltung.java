/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Accountverwaltung;

import de.dualibib.Datenlogik.IAccountDAO;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carina
 */
public class Accountverwaltung {

    private ArrayList<Account> accountListe;
    private ArrayList<Account> accountListeRef;
    private IAccountDAO accountDAO;

    public Accountverwaltung(IAccountDAO accountDAO) {
        accountListe = new ArrayList<Account>();
        accountListeRef = new ArrayList<Account>();
        this.accountDAO = accountDAO;
    }

    public void speichern() throws IOException, ConnectionError {
        List<Account> liste = new ArrayList<>();
        if (accountListe.size() > accountListeRef.size()) {
            liste = accountListe.subList(accountListeRef.size(), accountListe.size());
        }
        accountDAO.speichern(liste);
    }

    public void laden() {
        accountListe.clear();
        accountListeRef.clear();
        try {
            List<Account> liste = accountDAO.laden();
            for (Account account : liste) {
                accountListe.add(account);
                accountListeRef.add(account);
            }
        } catch (Exception e) {
        }
    }

    public void add(Account account) {
        if (!accountListe.add(account)) {
            String error = "Account gibt es bereits.";
        }
    }

    public void delete(Account account) {
        if (!accountListe.remove(account)) {
            String error = "Account gibt es nicht.";
        }
    }

    public ArrayList<Account> get() {
        ArrayList<Account> liste = new ArrayList<Account>();
        for (Account account : accountListe) {
            liste.add(account);
        }
        return liste;
    }

}
