/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Historyverwaltung extends ElternVerwaltung{

    private ArrayList<History> historyListe;
    private ArrayList<History> historyListeRef;
    private IHistoryDAO historyDAO;

    public Historyverwaltung(IHistoryDAO historyDAO) {
        historyListe = new ArrayList<>();
        historyListeRef = new ArrayList<>();
        this.historyDAO = historyDAO;
        laden();
    }

    public void speichern() throws IOException, ConnectionError {
        List<History> liste = new ArrayList<>();
        if (historyListe.size() > historyListeRef.size()) {
            liste = historyListe.subList(historyListeRef.size(), historyListe.size());
        }
        historyDAO.speichern(liste);
    }

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

    public void add(History history) {
        if (!historyListe.add(history)) {
            de.dualibib.Logger.error(this, "History gibt es bereits.");
        }
        notifyPanels();
    }

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
