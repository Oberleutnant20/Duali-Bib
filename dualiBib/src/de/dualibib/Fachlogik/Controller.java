/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik;

import de.dualibib.Fachlogik.Accountverwaltung.Account;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorienverwaltung;
import de.dualibib.Fachlogik.Accountverwaltung.Accountverwaltung;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleihe;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleiheverwaltung;
import de.dualibib.Fachlogik.Genreverwaltung.Genreverwaltung;
import de.dualibib.Fachlogik.Historyverwaltung.History;
import de.dualibib.Fachlogik.Historyverwaltung.Historyverwaltung;
import de.dualibib.Fachlogik.Medienverwaltung.Anderemedienverwaltung;
import de.dualibib.Fachlogik.Medienverwaltung.Printmedienverwaltung;
import de.dualibib.UI.PanelHandler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carina
 */
public class Controller {

    private Accountverwaltung accountverwaltung;
    private Anderemedienverwaltung anderemedienverwaltung;
    private Printmedienverwaltung printmedienverwaltung;
    private Ausleiheverwaltung ausleiheverwaltung;
    private Kategorienverwaltung kategorienverwaltung;
    private Genreverwaltung genreverwaltung;
    private Historyverwaltung historyverwaltung;
    
    private PanelHandler panelHandler;
    
    private Account aktuellerUser;
    private List<History> historyListe;
    private List<Ausleihe> ausleiheListe;

    public Controller(Accountverwaltung accountverwaltung, Anderemedienverwaltung anderemedienverwaltung, Printmedienverwaltung printmedienverwaltung, Ausleiheverwaltung ausleiheverwaltung, Kategorienverwaltung kategorienverwaltung, Genreverwaltung genreverwaltung,Historyverwaltung historyverwaltung) {
        this.accountverwaltung = accountverwaltung;
        this.anderemedienverwaltung = anderemedienverwaltung;
        this.printmedienverwaltung = printmedienverwaltung;
        this.ausleiheverwaltung = ausleiheverwaltung;
        this.kategorienverwaltung = kategorienverwaltung;
        this.genreverwaltung = genreverwaltung;
        this.historyverwaltung = historyverwaltung;
        start();
    }
         
    

    private void start() {
        accountverwaltung.laden();
        anderemedienverwaltung.laden();
        ausleiheverwaltung.laden();
        kategorienverwaltung.laden();
        genreverwaltung.laden();
        historyverwaltung.laden();
        panelHandler = new PanelHandler(this, kategorienverwaltung.get(),genreverwaltung.get());
    }
    
    public Account getAktuellerUser(){
        return aktuellerUser;
    }
    
    public Account setAktuellerUser(String accountname, String passwort){
        aktuellerUser = matchingUser(accountname, passwort);
        if(aktuellerUser!=null){
           ladeUserDaten();
           return aktuellerUser;
        }
        
        return null;
    }

    public boolean isMitarbeiter() {
        if(aktuellerUser!=null){
            return aktuellerUser.isMitarbeiter();
        }
        return false;
    }

    public void addHistory(History history){
        
    }
    
    public void addAusleihe(Ausleihe ausleihe){
        
    }
    
    private void ladeUserDaten() {
        historyListe = ladeHistory();
        ausleiheListe = ladeAusleihe();
        //TODO
    }

    private Account matchingUser(String accountname, String passwort) {
        List<Account> list = accountverwaltung.get();
        for(int i = 0; i < list.size() ; i++){
            if(list.get(i).getPasswort().equals(passwort)&&list.get(i).getUsername().equals(accountname)){
                return list.get(i);
            }
        }
        return null;
    }

    private List<History> ladeHistory() {
        int userid = aktuellerUser.getUserid();
        ArrayList<History> list = new ArrayList<History>();
        
        List<History> listegesamt = historyverwaltung.get();
        for(int i = 0; i < listegesamt.size() ; i++){
            if(listegesamt.get(i).getUserid()==userid){
                list.add(listegesamt.get(i));
            }
        }
        return list;
    }

    private List<Ausleihe> ladeAusleihe() {
        int userid = aktuellerUser.getUserid();
        ArrayList<Ausleihe> list = new ArrayList<Ausleihe>();
        
        List<Ausleihe> listegesamt = ausleiheverwaltung.get();
        for(int i = 0; i < listegesamt.size() ; i++){
            if(listegesamt.get(i).getUserid()==userid){
                list.add(listegesamt.get(i));
            }
        }
        return list;
    }

    public List<History> getHistoryListe() {
        return historyListe;
    }

    public List<Ausleihe> getAusleiheListe() {
        return ausleiheListe;
    }

    public void saveAccountChange(Account a) {
        List<Account> list = accountverwaltung.get();
        for(int i = 0; i < list.size() ; i++){
            if(list.get(i).getPasswort().equals(a.getUserid())){
                accountverwaltung.delete(list.get(i));
                accountverwaltung.add(a);
            }
        }
    }
    
    
}
