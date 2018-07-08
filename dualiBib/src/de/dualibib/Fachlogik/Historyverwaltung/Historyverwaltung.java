package de.dualibib.Fachlogik.Historyverwaltung;

import de.dualibib.Datenlogik.dto.History;
import de.dualibib.Datenlogik.idao.IHistoryDAO;
import de.dualibib.Fachlogik.ElternVerwaltung;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carina
 */
public class Historyverwaltung extends ElternVerwaltung {

    private ArrayList<History> historyListe;
    private ArrayList<History> historyListeRef;
    private IHistoryDAO historyDAO;

    /**
     * Konstruktor für die History Verwaltung.
     *
     * @param historyDAO History Datenbankobjekt
     */
    public Historyverwaltung(IHistoryDAO historyDAO) {
        historyListe = new ArrayList<>();
        historyListeRef = new ArrayList<>();
        this.historyDAO = historyDAO;
        laden();
    }

    /**
     * Speichert eine Liste von Historys.
     *
     * @throws IOException
     * @throws ConnectionError
     */
    public void speichern() throws IOException, ConnectionError {
        List<History> liste = new ArrayList<>();
        if (historyListe.size() > historyListeRef.size()) {
            liste = historyListe.subList(historyListeRef.size(), historyListe.size());
        }
        historyDAO.speichern(liste);
    }

    /**
     * Läd eine Liste von Historys.
     */
    public void laden() {
        historyListe.clear();
        de.dualibib.Logger.debug(this, "laden");
        try {
            List<History> liste = historyDAO.laden();
            for (History history : liste) {
                historyListe.add(history);
                historyListeRef.add(history);
            }

        } catch (Exception e) {
            de.dualibib.Logger.error(this, "laden");
        }
    }

    /**
     * Fügt der History liste eine Element hinzu.
     *
     * @param history Neues History Element
     */
    public void add(History history) {
        if (!historyListe.add(history)) {
            de.dualibib.Logger.error(this, "History gibt es bereits.");
        }
        notifyPanels();
    }

    /**
     * löscht eine History Element.
     *
     * @param history History, welche gelöscht werden soll.
     */
    public void delete(History history) {
        if (!historyListe.remove(history)) {
            de.dualibib.Logger.error(this, "History gibt es nicht.");
        }
        notifyPanels();
    }

    public List<History> get() {
        ArrayList<History> liste = new ArrayList<>();
        historyListe.forEach((history) -> {
            liste.add(history);
        });
        return liste;
    }
}
