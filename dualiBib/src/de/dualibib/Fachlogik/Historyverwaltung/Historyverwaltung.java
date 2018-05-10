/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Historyverwaltung;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Carina
 */
public class Historyverwaltung {
private Set<History> historyListe;
    private IHistoryDAO historyDAO;
    
    public Historyverwaltung(IHistoryDAO historyDAO) {
        historyListe = new HashSet<>();
        this.historyDAO = historyDAO;
    }
    
    public void speichern() throws IOException{
        List<History> liste = new ArrayList<>();
        historyListe.forEach((kategorie) -> {
            liste.add(kategorie);
         });
		historyDAO.speichern(liste);
    }

    public void laden() {
        historyListe.clear();
		try {
			List<History> liste = historyDAO.laden();
                        liste.forEach((history) -> {
                            this.add(history);
            });

		} catch (Exception e) {	}
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
        historyListe.forEach((kategorie) -> {
            liste.add(kategorie);
         });
		return liste;
    }    
}
