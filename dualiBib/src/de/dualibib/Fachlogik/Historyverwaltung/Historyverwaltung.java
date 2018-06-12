/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Historyverwaltung;

import de.dualibib.Datenlogik.dto.HistoryDTO;
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

    private HistoryDTO historyListe;
    private HistoryDTO historyListeRef;
    private IHistoryDAO historyDAO;

    public Historyverwaltung(IHistoryDAO historyDAO) {
        historyListeRef = new HistoryDTO();
        this.historyDAO = historyDAO;
    }

    public void speichern() throws IOException, ConnectionError {
        List<History> liste = new ArrayList<>();
        if(historyListe.size() > historyListeRef.size()){
            //liste = historyListe.subList(historyListeRef.size(), historyListe.size());
            System.out.println("hm");
        }
        historyDAO.speichern();
    }

    public void laden() {
        de.dualibib.Logger.debug(this,"laden");
        try {
            historyListe = historyDAO.laden();
        } catch (Exception e) {
        }
    }

    public void add(History history) {
        if (!historyListe.add(history)) {
            String error = "Ausleihe gibt es bereits.";
        }
        notifyPanels();
    }

    public void delete(History history) {
        if (!historyListe.remove(history)) {
            String error = "Ausleihe gibt es nicht.";
        }
        notifyPanels();
    }

    public HistoryDTO get() {
        return historyListe;
    }
}
