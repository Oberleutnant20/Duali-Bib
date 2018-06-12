/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dto;

import de.dualibib.Fachlogik.Accountverwaltung.Account;
import de.dualibib.UI.ElternPanel;
import java.util.ArrayList;

/**
 *
 * @author Carina
 */
public class AccountDTO implements DataTransferObject{

    private ArrayList<Account> accountListe;
    private ArrayList<ElternPanel> panelListe;
    
    public AccountDTO(){
        accountListe = new ArrayList<>();
    }
    
    @Override
    public ArrayList get() {
        return accountListe;
    }

    @Override
    public void set(ArrayList list) {
        accountListe = list;
        de.dualibib.Logger.debug(this,accountListe.size()+"");
    }

    public boolean add(Account a) {
        boolean success = accountListe.add(a);
        return success;
    }

    public boolean remove(Account a) {
        boolean success = accountListe.remove(a);
        return success;
    }

    @Override
    public int size() {
        return accountListe.size();
    }
    
    public Account get(int i){
        return accountListe.get(i);
    }
}
