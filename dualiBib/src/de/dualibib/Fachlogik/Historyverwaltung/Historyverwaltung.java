/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Historyverwaltung;

import de.dualibib.Datenlogik.IHistoryDAO;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carina
 */
public class Historyverwaltung {

    private ArrayList<History> historyListe;
    private ArrayList<History> historyListeRef;
    private IHistoryDAO historyDAO;

    public Historyverwaltung(IHistoryDAO historyDAO) {
        historyListe = new ArrayList<History>();
        historyListeRef = new ArrayList<History>();
        this.historyDAO = historyDAO;
    }

    public void speichern() throws IOException, ConnectionError {
        List<History> liste = new ArrayList<>();
        if(historyListe.size() > historyListeRef.size()){
            liste = historyListe.subList(historyListeRef.size(), historyListe.size());
            System.out.println("hm");
        }
        historyDAO.speichern(liste);
    }

    public void laden() {
        historyListe.clear();
        try {
            List<History> liste = historyDAO.laden();
            for (History history : liste) {
                historyListe.add(history);
                historyListeRef.add(history);
            }

        } catch (Exception e) {
        }
    }

    public void add(History history) {
        if (!historyListe.add(history)) {
            String error = "Ausleihe gibt es bereits.";
        }
    }

    public void delete(History history) {
        if (!historyListe.remove(history)) {
            String error = "Ausleihe gibt es nicht.";
        }
    }

    public List<History> get() {
        ArrayList<History> liste = new ArrayList<>();
        historyListe.forEach((history) -> {
            liste.add(history);
        });
        return liste;
    }
}
