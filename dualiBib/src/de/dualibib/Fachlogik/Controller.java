package de.dualibib.Fachlogik;

import de.dualibib.Datenlogik.dto.Account;
import de.dualibib.Datenlogik.dto.Ausleihe;
import de.dualibib.Datenlogik.dto.History;
import de.dualibib.Datenlogik.dto.Medien;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorienverwaltung;
import de.dualibib.Fachlogik.Accountverwaltung.Accountverwaltung;
import de.dualibib.Fachlogik.Languageverwaltung.Languageverwaltung;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleiheverwaltung;
import de.dualibib.Fachlogik.Genreverwaltung.Genreverwaltung;
import de.dualibib.Fachlogik.Historyverwaltung.Historyverwaltung;
import de.dualibib.Fachlogik.Medienverwaltung.Medienverwaltung;
import de.dualibib.Logger;
import de.dualibib.UI.ElternPanel;
import de.dualibib.UI.PanelHandler;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author Carina
 */
public class Controller {

    private final Accountverwaltung accountverwaltung;
    private final Medienverwaltung medienverwaltung;
    private final Ausleiheverwaltung ausleiheverwaltung;
    private final Kategorienverwaltung kategorienverwaltung;
    private final Genreverwaltung genreverwaltung;
    private final Historyverwaltung historyverwaltung;
    private final Languageverwaltung languageverwaltung;
    private PanelHandler panelHandler;
    private Account aktuellerUser;
    private ArrayList<History> historyListe;
    private ArrayList<Ausleihe> ausleiheListe;

    /**
     * Konstruktor für den Controller.
     *
     * @param languageverwaltung Verwaltungsklasse für die Sprache
     * @param accountverwaltung Verwaltungsklasse für die Accounts
     * @param medienverwaltung Verwaltungsklasse für die Medien
     * @param ausleiheverwaltung Verwaltungsklasse für die Ausleihen
     * @param kategorienverwaltung Verwaltungsklasse für die Kategorien
     * @param genreverwaltung Verwaltungsklasse für die Genres
     * @param historyverwaltung Verwaltungsklasse für die History
     */
    public Controller(Languageverwaltung languageverwaltung, Accountverwaltung accountverwaltung, Medienverwaltung medienverwaltung,
            Ausleiheverwaltung ausleiheverwaltung, Kategorienverwaltung kategorienverwaltung, Genreverwaltung genreverwaltung, Historyverwaltung historyverwaltung) {
        this.languageverwaltung = languageverwaltung;
        this.accountverwaltung = accountverwaltung;
        this.medienverwaltung = medienverwaltung;
        this.ausleiheverwaltung = ausleiheverwaltung;
        this.kategorienverwaltung = kategorienverwaltung;
        this.genreverwaltung = genreverwaltung;
        this.historyverwaltung = historyverwaltung;
    }

    /**
     * starten des Controllers
     *
     * @param panelHandler Panelhandler
     */
    public void start(PanelHandler panelHandler) {
        Logger.info(this, "starten");
        ausleihenPruefen();
        this.panelHandler = panelHandler;
    }

    /**
     * Aktualisierung der Panels beim initialen starten der Anwendung
     */
    public void initUpdate() {
        Logger.info(this, "initUpdate");
        accountverwaltung.notifyPanels();
        medienverwaltung.notifyPanels();
        ausleiheverwaltung.notifyPanels();
        kategorienverwaltung.notifyPanels();
        genreverwaltung.notifyPanels();
        historyverwaltung.notifyPanels();
        try {
            languageverwaltung.getDeutsch();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Account getAktuellerUser() {
        return aktuellerUser;
    }

    public Account setAktuellerUser(String accountname, String passwort) {
        Logger.info(this, "setAktuellerUser");
        aktuellerUser = matchingUser(accountname, passwort);
        if (aktuellerUser != null) {
            ladeUserDaten();
            return aktuellerUser;
        }

        return null;
    }

    /**
     * prüft ob der aktuelle User ein Mitarbeiter ist
     */
    public boolean isMitarbeiter() {
        Logger.info(this, "isMitarbeiter");
        if (aktuellerUser != null) {
            return aktuellerUser.isMitarbeiter();
        }
        return false;
    }

    /**
     * Fügt einen Historyeintrag der Liste hinzu
     */
    public void addHistory(History history) {
        Logger.info(this, "addHistory");
        historyverwaltung.add(history);
    }

    /**
     * Fügt eine Ausleihe der Liste hinzu
     */
    public void addAusleihe(Ausleihe ausleihe) {
        Logger.info(this, "addAusleihe");
        ausleiheverwaltung.add(ausleihe);
    }

    /**
     * Lädt die Listen des jeweiligen Users
     */
    public void ladeUserDaten() {
        historyListe = ladeHistory();
        ausleiheListe = ladeAusleihe();
    }

    /**
     * Zieht den passenden User nach accountname und passwort aus der Liste
     * aller User.
     *
     * @param accountname
     * @param passwort
     * @return
     */
    public Account matchingUser(String accountname, String passwort) {
        Logger.info(this, "matchingUser");
        List<Account> list = accountverwaltung.get();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPasswort().equals(passwort) && list.get(i).getUsername().equals(accountname)) {
                return list.get(i);
            }
        }
        return null;
    }

    /**
     * Läd die User History Informationen.
     *
     * @return Liste von der History eines Users
     */
    private ArrayList<History> ladeHistory() {
        int userid = aktuellerUser.getUserid();
        ArrayList<History> list = new ArrayList<>();
        Logger.info(this, "ladeHistory");
        List<History> listegesamt = historyverwaltung.get();
        for (int i = 0; i < listegesamt.size(); i++) {
            if (listegesamt.get(i).getUserid() == userid) {
                Logger.debug(this, "ladeHistory, History füllen");
                list.add(listegesamt.get(i));
            }
        }
        return list;
    }

    /**
     * Läd die aktuelle Ausleihe eines Nutzers.
     *
     * @return Liste eines Nutzers mit Ausgeliehen Büchern
     */
    private ArrayList<Ausleihe> ladeAusleihe() {
        int userid = aktuellerUser.getUserid();
        ArrayList<Ausleihe> list = new ArrayList<>();
        Logger.info(this, "ladeAusleihe");
        List<Ausleihe> listegesamt = ausleiheverwaltung.get();
        for (int i = 0; i < listegesamt.size(); i++) {
            Logger.debug(this, "ladeAusleihe, Ausleihe Schleife");
            if (listegesamt.get(i).getUserid() == userid) {
                Logger.debug(this, "ladeAusleihe, Ausleihe füllen");
                list.add(listegesamt.get(i));
            }
        }
        return list;
    }

    public List<History> getHistoryListe() {
        return historyverwaltung.get();
    }

    /**
     * Reicht den geänderten Account zum speichern in die Verwaltung weiter.
     */
    public void saveAccountChange(Account a) {
        accountverwaltung.update(a);
    }

    /**
     * Speichert verändertes Medium.
     */
    public void saveMediumChange(Medien m) {
        de.dualibib.Logger.info(this, "saveMediumChange");
        ArrayList<Medien> list = getAllMedien();
        for (Medien medium : list) {
            if (medium.getId() == m.getId()) {
                medienverwaltung.delete(medium);
            }
        }
        medienverwaltung.update(m);
    }

    /**
     * reicht zu löschende Ausleihe an Verwaltung weiter.
     */
    public void deleteAusleihe(Ausleihe a) {
        de.dualibib.Logger.info(this, "deleteAusleihe");
        ausleiheverwaltung.delete(a);
    }

    /**
     * reicht zu speichernden Account weiter.
     */
    public void saveAccount(Account account) {
        de.dualibib.Logger.info(this, "saveAccount");
        accountverwaltung.add(account);
    }

    /**
     * reicht zu löschenden Historyeintrag weiter.
     */
    public void deleteHistory(History h) {
        de.dualibib.Logger.info(this, "deleteHistory");
        historyverwaltung.delete(h);
    }

    public ArrayList<Ausleihe> getAllAusleihenListe() {
        de.dualibib.Logger.info(this, "getAllAusleihenListe");
        return ausleiheverwaltung.get();
    }

    public ArrayList<Account> getAllAccountsListe() {
        de.dualibib.Logger.info(this, "getAllAccountsListe");
        return accountverwaltung.get();
    }

    public ArrayList<Medien> getAllMedien() {
        de.dualibib.Logger.info(this, "getAllMedien");
        ArrayList<Medien> list = medienverwaltung.get();
        de.dualibib.Logger.debug(this, "medien" + list.size());
        return list;
    }

    /**
     * Startet die Methoden zum speichern der Einträge in den Verwaltungen.
     */
    public void saveDB() throws IOException, ConnectionError {
        de.dualibib.Logger.info(this, "Speichern");
        accountverwaltung.speichern();
        medienverwaltung.speichern();
        ausleiheverwaltung.speichern();
        kategorienverwaltung.speichern();
        genreverwaltung.speichern();
        historyverwaltung.speichern();
    }

    /**
     * Überprüft ob ein Eintrag aus der Ausleihe zur History hinzugefügt werden
     * soll.
     */
    private void ausleihenPruefen() {
        de.dualibib.Logger.debug(this, "Ausleihe prüfen");
        ArrayList<Ausleihe> liste = ausleiheverwaltung.get();
        Date heute = new Date();
        int id = historyverwaltung.get().size();
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getDate().before(heute)) {
                History history = new History(id++, liste.get(i).getUserid(), liste.get(i).getMedienid(), liste.get(i).getKategorieid());
                ausleiheverwaltung.delete(liste.get(i));
            }
        }
    }

    /**
     * Reicht eine Ausleihe weiter zum Speichern.
     *
     * @param a Ausleihe
     */
    public void saveAusleihe(Ausleihe a) {
        ausleiheverwaltung.add(a);
    }

    public void setMedienObserver(ElternPanel... panels) {
        for (ElternPanel panel : panels) {
            medienverwaltung.addPanelList(panel);
        }
    }

    public void setKategorieObserver(ElternPanel... panels) {
        for (ElternPanel panel : panels) {
            kategorienverwaltung.addPanelList(panel);
        }
    }

    public void setHistoryObserver(ElternPanel... panels) {
        for (ElternPanel panel : panels) {
            historyverwaltung.addPanelList(panel);
        }
    }

    public void setGenreObserver(ElternPanel... panels) {
        for (ElternPanel panel : panels) {
            genreverwaltung.addPanelList(panel);
        }
    }

    public void setAusleiheObserver(ElternPanel... panels) {
        for (ElternPanel panel : panels) {
            ausleiheverwaltung.addPanelList(panel);
        }
    }

    public void setAccountObserver(ElternPanel... panels) {
        for (ElternPanel panel : panels) {
            accountverwaltung.addPanelList(panel);
        }
    }

    public void setLanguageObserver(ElternPanel... panels) {
        for (ElternPanel panel : panels) {
            languageverwaltung.addPanelList(panel);
        }
    }

    /**
     * Führt eine Sprachen Änderung durch.
     *
     * @param string Sprache, welche genutzt werden soll
     */
    public void changeLanguage(String string) {
        try {
            switch (string) {
                case "deutsch":
                    languageverwaltung.getDeutsch();
                    break;
                case "englisch":
                    languageverwaltung.getEnglisch();
                    break;
                case "japanisch":
                    languageverwaltung.getJapanisch();
                    break;
                default:
                    languageverwaltung.getDeutsch();
            }
        } catch (Exception e) {
            Logger.error(this, string);
        }
    }
}
