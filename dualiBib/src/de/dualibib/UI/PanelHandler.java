package de.dualibib.UI;

import de.dualibib.Datenlogik.dto.Account;
import de.dualibib.Datenlogik.dto.Ausleihe;
import de.dualibib.Datenlogik.dto.Genre;
import de.dualibib.Datenlogik.dto.History;
import de.dualibib.Datenlogik.dto.Kategorie;
import de.dualibib.Datenlogik.dto.Medien;
import de.dualibib.Fachlogik.Controller;
import de.dualibib.Logger;
import de.dualibib.UI.Panels.AccountBearbeitenPanel;
import de.dualibib.UI.Panels.AccountsBearbeitenPanel;
import de.dualibib.UI.Panels.AusleihenBearbeitenPanel;
import de.dualibib.UI.Panels.AusleihenPanel;
import de.dualibib.UI.Panels.HistoryPanel;
import de.dualibib.UI.Panels.LoginPanel;
import de.dualibib.UI.Panels.OptionPanel;
import de.dualibib.UI.Panels.SelectPanel;
import de.dualibib.UI.Panels.SuchePanel;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
    private Account aktuellerUser;
    private List<Genre> genreListe;
    private List<Kategorie> kategorieListe;

    /**
     * Konstruktor für den PanelHander
     *
     * @param controller Angabe des Controllers
     * @param genreListe Die Genre Liste
     * @param kategorieListe Die Kategorie Liste
     */
    public PanelHandler(Controller controller, List<Genre> genreListe, List<Kategorie> kategorieListe) {
        this.controller = controller;
        this.genreListe = genreListe;
        this.kategorieListe = kategorieListe;
    }

    /**
     * Startet den PanelHandler
     */
    public void start() {
        ui = new UI(this);
        initPanels();
        ui.add(suchePanel);
        ui.getjPanel1().setVisible(false);
        initObsever();
        suchePanel.update();
        suchePanel.setVisible(true);
    }

    /**
     * Initzialisiert das Observer Muster.
     */
    private void initObsever() {
        de.dualibib.Logger.debug(this, "initObsever");
        ElternPanel[] accountArray = {accountBearbeitenPanel, accountsBearbeitenPanel};
        ElternPanel[] ausleiheArray = {ausleihenPanel, ausleihenBearbeitenPanel};
        ElternPanel[] genreArray = {selectPanel, suchePanel};
        ElternPanel[] historyArray = {historyPanel};
        ElternPanel[] kategorieArray = {selectPanel, suchePanel};
        ElternPanel[] medienArray = {ausleihenPanel, ausleihenBearbeitenPanel, selectPanel, suchePanel};
        ElternPanel[] languageArray = {ausleihenBearbeitenPanel, optionPanel, ausleihenPanel, historyPanel, accountsBearbeitenPanel, accountBearbeitenPanel, loginPanel, selectPanel, suchePanel};

        controller.setAccountObserver(accountArray);
        controller.setAusleiheObserver(ausleiheArray);
        controller.setGenreObserver(genreArray);
        controller.setHistoryObserver(historyArray);
        controller.setKategorieObserver(kategorieArray);
        controller.setMedienObserver(medienArray);
        controller.setLanguageObserver(languageArray);
    }

    /**
     * initialisiert die Panels
     */
    private void initPanels() {
        de.dualibib.Logger.debug(this, "initPanels");
        loginPanel = new LoginPanel(this);
        accountBearbeitenPanel = new AccountBearbeitenPanel(this);
        historyPanel = new HistoryPanel(this);
        accountsBearbeitenPanel = new AccountsBearbeitenPanel(this);
        ausleihenPanel = new AusleihenPanel(this);
        optionPanel = new OptionPanel(this);
        ausleihenBearbeitenPanel = new AusleihenBearbeitenPanel(this);
        selectPanel = new SelectPanel(this);
        suchePanel = new SuchePanel(this);
    }

    /**
     * Setzt die Panel Sichtbarkeit auf false.
     */
    public void panelUnsichtbar() {
        de.dualibib.Logger.debug(this, "panelUnsichtbar");
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

    /**
     * Stellt die Loginfunktion zur Verfügung.
     * @param accountname Username
     * @param passwort User Passwort
     */
    public void login(String accountname, String passwort) {
        de.dualibib.Logger.debug(this, "login");
        boolean login = false;
        if (controller.setAktuellerUser(accountname, passwort) != null) {
            this.aktuellerUser = controller.setAktuellerUser(accountname, passwort);
            if (controller.isMitarbeiter()) {
                ui.setMitarbeiterOnline();
                selectPanel.setMitarbeiter();
            }
            ui.setUserOnline();
            controller.ladeUserDaten();
            controller.initUpdate();
            login = true;
        }
        loginPanel.einloggen(login);
    }

    /**
     * nimmt die Parameter an, erstellt einen Account und gibt den zum Speichern an den Controller
     * @param id
     * @param hausnummer
     * @param name
     * @param plz
     * @param ort
     * @param strasse
     * @param vorname
     * @param passwort
     * @param mitarbeiter
     * @param accountname 
     */
    public void saveAccountChange(int id, String hausnummer, String name, int plz, String ort, String strasse, String vorname, String passwort, boolean mitarbeiter, String accountname) {
        Account a = new Account(accountname, passwort, mitarbeiter, id, vorname, name, plz, strasse, hausnummer, ort);
        controller.saveAccountChange(a);
    }

    /**
     * nimmt die Parameter an, erzeugt ein neues Medium und setzt die alten und neuen Werte ein
     * Medium wird weitergereicht
     * @param isbn
     * @param barcodenummer
     * @param selectedGenre
     * @param selectedKategorie
     * @param name
     * @param id
     * @param anzahl
     * @param author
     * @param desc 
     */
    public void saveMediumChange(String isbn, long barcodenummer, Object selectedGenre, Object selectedKategorie, String name, long id, int anzahl, String author, String desc) {
        Kategorie kategorie = null;
        boolean gefunden = false;
        for (int i = 0; i < getKategorieListe().size() && !gefunden; i++) {
            gefunden = getKategorieListe().get(i).getBezeichnung().equals(selectedKategorie);
            if (gefunden) {
                kategorie = getKategorieListe().get(i);
            }
        }
        Genre genre = null;
        gefunden = false;
        for (int i = 0; i < getGenreListe().size() && !gefunden; i++) {
            gefunden = getGenreListe().get(i).getBezeichnung().equals(selectedGenre);
            if (gefunden) {
                genre = getGenreListe().get(i);
            }
        }
        Medien m = new Medien(isbn, barcodenummer, genre.getId(), kategorie.getId(), name, id, anzahl, author, desc);
        controller.saveMediumChange(m);
    }

    /**
     * Löscht eine Ausleihe.
     * @param a Ausleihe
     */
    public void deleteAusleihe(Ausleihe a) {
        controller.deleteAusleihe(a);
    }

    /**
     * nimmt Parameter entgegen und erzeugt neuen Account zum weiterreichen
     * @param id
     * @param hausnummer
     * @param name
     * @param plz
     * @param ort
     * @param strasse
     * @param vorname
     * @param passwort
     * @param mitarbeiter
     * @param accountname 
     */
    public void saveAccount(int id, String hausnummer, String name, int plz, String ort, String strasse, String vorname, String passwort, boolean mitarbeiter, String accountname) {
        controller.saveAccount(new Account(accountname, passwort, mitarbeiter, id, vorname, name, plz, strasse, hausnummer, ort));
    }

    public List<Ausleihe> getAusleihe() {
        return controller.getAllAusleihenListe();
    }

    public List<History> getHistory() {
        return controller.getHistoryListe();
    }

    public List<Medien> returnMedien() {
        return controller.getAllMedien();
    }

    public ArrayList<Account> getAllAccounts() {
        return controller.getAllAccountsListe();
    }

    public ArrayList<Ausleihe> getAllAusleihen() {
        return controller.getAllAusleihenListe();
    }

    /**
     * Wählt passendes Medium zum Historyeintrag und gibt es wieder
     */
    public Medien mapHistoryAndMedium(History selected) {
        Medien medium = null;
        List<Medien> liste = controller.getAllMedien();
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getId() == selected.getMedienid()) {
                medium = liste.get(i);
            }
        }
        return medium;
    }

    /**
     * Meldet den aktuellen User ab.
     * @throws IOException
     * @throws ConnectionError 
     */
    public void ausloggen() throws IOException, ConnectionError {
        controller.saveDB();
        ui.setUserOffline();
        aktuellerUser = null;
        loginPanel.ausloggen();
    }

    /**
     * Erstellt eine neue Ausleihe
     * @param userid UserID welcher sich was ausleiht
     * @param date Datum
     * @param katid Kategorie ID
     */
    public void createNewAusleihe(long userid, Date date, long katid) {
        long id;
        try {
            id = controller.getAllAusleihenListe().get(controller.getAllAusleihenListe().size() - 1).getId() + 1;
        } catch (Exception e) {
            id = 0;
        }
        Ausleihe a = new Ausleihe(id, userid, date, aktuellerUser.getUserid(), katid);
        controller.saveAusleihe(a);
    }

    public UI getUi() {
        return ui;
    }

    public List<Genre> getGenreListe() {
        return genreListe;
    }

    public List<Kategorie> getKategorieListe() {
        return kategorieListe;
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

    public String getKatBezeichnung(long kategorienId) {
        List<Kategorie> kat = getKategorieListe();
        String bez = "";
        for (Kategorie kategorie : kat) {
            if (kategorie.getId() == kategorienId) {
                return kategorie.getBezeichnung();
            }
        }
        return bez;
    }

    public String getGenBezeichnung(long genreId) {
        List<Genre> gen = getGenreListe();
        String bez = "";
        for (Genre genre : gen) {
            if (genre.getId() == genreId) {
                return genre.getBezeichnung();
            }
        }
        return bez;
    }

    public int getVerfuegbare(int medienId) {
        int verfuegbare = 0;

        for (Medien medien : controller.getAllMedien()) {
            if (medien.getId() == medienId) {
                verfuegbare = medien.getAnzahl();
                Logger.info(this, "gefunden");
            }
        }
        Logger.info(this, verfuegbare + " verfügbare gefunden");
        for (Ausleihe ausleihe : controller.getAllAusleihenListe()) {
            if (ausleihe.getMedienid() == medienId) {
                verfuegbare--;
            }
        }
        return verfuegbare;
    }

    public List<Medien> getMedienliste() {
        Logger.info(this, "Medienliste gezogen");
        return controller.getAllMedien();
    }

    /**
     * initialisiert das SelectPanel
     */
    public void setSelectPanel(Medien mediumfromIndices) {
        Logger.info(this, mediumfromIndices.getName() + " wird angezeigt");
        selectPanel.setMedium(mediumfromIndices);
        panelUnsichtbar();
        ui.add(selectPanel);
        selectPanel.setVisible(true);
    }

    /**
     * verändert die Sprache
     */
    public void changeLanguage(String string) {
        controller.changeLanguage(string);
    }
}
