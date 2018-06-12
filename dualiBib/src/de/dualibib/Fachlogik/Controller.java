package de.dualibib.Fachlogik;

import de.dualibib.Datenlogik.dto.AccountDTO;
import de.dualibib.Datenlogik.dto.AusleiheDTO;
import de.dualibib.Datenlogik.dto.HistoryDTO;
import de.dualibib.Datenlogik.dto.MedienDTO;
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
import de.dualibib.Logger;
import de.dualibib.UI.ElternPanel;
import de.dualibib.UI.PanelHandler;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.Date;

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
    private HistoryDTO historyListe;
    private AusleiheDTO ausleiheListe;

    public Controller(Accountverwaltung accountverwaltung, Medienverwaltung medienverwaltung, Ausleiheverwaltung ausleiheverwaltung, Kategorienverwaltung kategorienverwaltung, Genreverwaltung genreverwaltung, Historyverwaltung historyverwaltung) {
        this.accountverwaltung = accountverwaltung;
        this.medienverwaltung = medienverwaltung;
        this.ausleiheverwaltung = ausleiheverwaltung;
        this.kategorienverwaltung = kategorienverwaltung;
        this.genreverwaltung = genreverwaltung;
        this.historyverwaltung = historyverwaltung;
        start();
    }

    private void start() {
        Logger.info(this,"starten");
        accountverwaltung.laden();
        medienverwaltung.laden();
        ausleiheverwaltung.laden();
        kategorienverwaltung.laden();
        genreverwaltung.laden();
        historyverwaltung.laden();
        panelHandler = new PanelHandler(this, genreverwaltung.get(), kategorienverwaltung.get());
        ausleihenPruefen();
    }

    public Account getAktuellerUser() {
        return aktuellerUser;
    }

    public Account setAktuellerUser(String accountname, String passwort) {
        Logger.info(this,"setAktuellerUser");
        aktuellerUser = matchingUser(accountname, passwort);
        if (aktuellerUser != null) {
            ladeUserDaten();
            return aktuellerUser;
        }

        return null;
    }

    public boolean isMitarbeiter() {
        Logger.info(this,"isMitarbeiter");
        if (aktuellerUser != null) {
            return aktuellerUser.isMitarbeiter();
        }
        return false;
    }

    public void addHistory(History history) {
        Logger.info(this,"addHistory");
        historyverwaltung.add(history);
    }

    public void addAusleihe(Ausleihe ausleihe) {
        Logger.info(this,"addAusleihe");
        ausleiheverwaltung.add(ausleihe);
    }

    private void ladeUserDaten() {
        historyListe = ladeHistory();
        ausleiheListe = ladeAusleihe();
    }

    private Account matchingUser(String accountname, String passwort) {
        Logger.info(this,"matchingUser");
        AccountDTO list = accountverwaltung.get();
        for(int i = 0; i < list.size() ; i++){
            if(list.get(i).getPasswort().equals(passwort)&&list.get(i).getUsername().equals(accountname)){
                return list.get(i);
            }
        }
        return null;
    }

    private HistoryDTO ladeHistory() {
        Logger.info(this,"ladeHistory");
        int userid = aktuellerUser.getUserid();
        HistoryDTO list = new HistoryDTO();        
        HistoryDTO listegesamt = historyverwaltung.get();
        for(int i = 0; i < listegesamt.size() ; i++){
            if(listegesamt.get(i).getUserid()==userid){
                list.add(listegesamt.get(i));
            }
        }
        return list;
    }

    private AusleiheDTO ladeAusleihe() {
        Logger.info(this,"ladeAusleihe");
        int userid = aktuellerUser.getUserid();
        AusleiheDTO list = new AusleiheDTO();        
        AusleiheDTO listegesamt = ausleiheverwaltung.get();
        for(int i = 0; i < listegesamt.size() ; i++){
            if(listegesamt.get(i).getUserid()==userid){
                list.add(listegesamt.get(i));
            }
        }
        return list;
    }

    public HistoryDTO getHistoryListe() {
        return historyListe;
    }

    public AusleiheDTO getAusleiheListe() {
        return ausleiheListe;
    }

    public void saveAccountChange(Account a) {
        accountverwaltung.update(a);
    }

    public void saveMediumChange(Medien m) {
        de.dualibib.Logger.info(this,"saveMediumChange");
        medienverwaltung.update(m);
    }

    public void deleteAusleihe(Ausleihe a) {
        de.dualibib.Logger.info(this,"deleteAusleihe");
        ausleiheverwaltung.delete(a);
    }

    public void saveAccount(Account account) {
        de.dualibib.Logger.info(this,"saveAccount");
        accountverwaltung.add(account);
    }

    public void deleteHistory(History h) {
        de.dualibib.Logger.info(this,"deleteHistory");
        historyverwaltung.delete(h);
    }

    public AusleiheDTO getAllAusleihenListe() {
        de.dualibib.Logger.info(this,"getAllAusleihenListe");
        return ausleiheverwaltung.get();
    }

    public AccountDTO getAllAccountsListe() {
        de.dualibib.Logger.info(this,"getAllAccountsListe");
        return accountverwaltung.get();
    }

    public MedienDTO getAllMedien() {
        de.dualibib.Logger.info(this,"getAllMedien");
        de.dualibib.Logger.debug(this,"medien"+medienverwaltung.get().size()+"");
        return medienverwaltung.get();
    }

    public void saveDB() throws IOException, ConnectionError {
        de.dualibib.Logger.info(this,"Speichern");
        accountverwaltung.speichern();
        medienverwaltung.speichern();
        ausleiheverwaltung.speichern();
        kategorienverwaltung.speichern();
        genreverwaltung.speichern();
        historyverwaltung.speichern();
    }

    private void ausleihenPruefen() {
        de.dualibib.Logger.debug(this,"Ausleihe prüfen");
        AusleiheDTO liste = ausleiheverwaltung.get();
        Date heute = new Date();
        int id = historyverwaltung.get().size();
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getDate().before(heute)) {
                History history = new History(id++, liste.get(i).getUserid(), liste.get(i).getMedienid(), liste.get(i).getKategorieid());
                //historyListe.add(history);
                ausleiheverwaltung.delete(liste.get(i));
            }
            System.out.println("ka");
        }
    }

    public void saveAusleihe(Ausleihe a) {
        ausleiheverwaltung.add(a);
    }

    public void setMedienObserver(ElternPanel... panels) {
       for(ElternPanel panel : panels){
           medienverwaltung.addPanelList(panel);
       }
    }

    public void setKategorieObserver(ElternPanel... panels) {
        for(ElternPanel panel : panels){
           kategorienverwaltung.addPanelList(panel);
       }
    }

    public void setHistoryObserver(ElternPanel... panels) {
        for(ElternPanel panel : panels){
           historyverwaltung.addPanelList(panel);
       }
    }

    public void setGenreObserver(ElternPanel... panels) {
        for(ElternPanel panel : panels){
           genreverwaltung.addPanelList(panel);
       }
    }

    public void setAusleiheObserver(ElternPanel... panels) {
        for(ElternPanel panel : panels){
           ausleiheverwaltung.addPanelList(panel);
       }
    }

    public void setAccountObserver(ElternPanel... panels) {
        for(ElternPanel panel : panels){
           accountverwaltung.addPanelList(panel);
       }
    }
  
}
