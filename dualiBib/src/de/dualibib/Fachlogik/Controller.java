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
import de.dualibib.Fachlogik.Medienverwaltung.Medien;
import de.dualibib.Fachlogik.Medienverwaltung.Medienverwaltung;
import de.dualibib.UI.PanelHandler;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Carina
 */
public class Controller {

    private Accountverwaltung accountverwaltung;
    private Medienverwaltung medienverwaltung;
    private Ausleiheverwaltung ausleiheverwaltung;
    private Kategorienverwaltung kategorienverwaltung;
    private Genreverwaltung genreverwaltung;
    private Historyverwaltung historyverwaltung;
    
    private PanelHandler panelHandler;
    
    private Account aktuellerUser;
    private ArrayList<History> historyListe;
    private ArrayList<Ausleihe> ausleiheListe;

    public Controller(Accountverwaltung accountverwaltung, Medienverwaltung medienverwaltung, Ausleiheverwaltung ausleiheverwaltung, Kategorienverwaltung kategorienverwaltung, Genreverwaltung genreverwaltung,Historyverwaltung historyverwaltung) {
        this.accountverwaltung = accountverwaltung;
        this.medienverwaltung = medienverwaltung;
        this.ausleiheverwaltung = ausleiheverwaltung;
        this.kategorienverwaltung = kategorienverwaltung;
        this.genreverwaltung = genreverwaltung;
        this.historyverwaltung = historyverwaltung;
        start();
    }
         
    

    private void start() {
        accountverwaltung.laden();
        medienverwaltung.laden();
        ausleiheverwaltung.laden();
        kategorienverwaltung.laden();
        genreverwaltung.laden();
        historyverwaltung.laden();
        ausleihenPruefen();
        panelHandler = new PanelHandler(this, genreverwaltung.get(),kategorienverwaltung.get());
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
        historyverwaltung.add(history);
    }
    
    public void addAusleihe(Ausleihe ausleihe){
        ausleiheverwaltung.add(ausleihe);
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

    private ArrayList<History> ladeHistory() {
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

    private ArrayList<Ausleihe> ladeAusleihe() {
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

    public ArrayList<History> getHistoryListe() {
        return historyListe;
    }

    public ArrayList<Ausleihe> getAusleiheListe() {
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

    public void saveMediumChange(Medien m) {
        List<Medien> list = medienverwaltung.get();
        for(int i = 0; i < list.size() ; i++){
            if(list.get(i).getId() ==m.getId()){
                medienverwaltung.delete(list.get(i));
                medienverwaltung.add(m);
            }
        }
    }

    public void deleteAusleihe(Ausleihe a) {
       ausleiheverwaltung.delete(a);
    }

    public void saveAccount(Account account) {
        accountverwaltung.add(account);
    }

    public void deleteHistory(History h) {
        historyverwaltung.delete(h);
    }

    public ArrayList<Ausleihe> getAllAusleihenListe() {
        return ausleiheverwaltung.get();
    }

    public ArrayList<Account> getAllAccountsListe() {
        return accountverwaltung.get();
    }

    public ArrayList<Medien> getAllMedien() {
        System.out.println(medienverwaltung.get().get(0)+"getAllMedien in Controller");
        return medienverwaltung.get();
    }

    public void saveDB() throws IOException, ConnectionError {
        accountverwaltung.speichern();
        medienverwaltung.speichern();
        ausleiheverwaltung.speichern();
        kategorienverwaltung.speichern();
        genreverwaltung.speichern();
        historyverwaltung.speichern();
    }

    private void ausleihenPruefen() {
        ArrayList<Ausleihe> liste = ausleiheverwaltung.get();
        Date heute = new Date();
        int id = historyverwaltung.get().size();
        for (int i = 0; i < liste.size(); i++) {
            if(liste.get(i).getDate().before(heute)){
                System.out.println("For Schleife i -->"+i);
                System.out.println("ID -->"+id);
                History history = new History(id++,liste.get(i).getUserid(),liste.get(i).getMedienid(), liste.get(i).getKategorieid());
                historyListe.add(history);
                ausleiheverwaltung.delete(liste.get(i));
            }
        }
    }

    public void saveAusleihe(Ausleihe a) {
        ausleiheverwaltung.add(a);
    }
    
    
}
