/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Ausleihverwaltung;

import de.dualibib.Datenlogik.IAusleiheDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Carina
 */
public class Ausleiheverwaltung{

    private Set<Ausleihe> ausleiheListe;
    private IAusleiheDAO ausleiheDAO;
    
    public Ausleiheverwaltung(IAusleiheDAO ausleiheDAO) {
        ausleiheListe = new HashSet<Ausleihe>();
        this.ausleiheDAO = ausleiheDAO;
    }

    public void speichern() throws IOException{
        List<Ausleihe> liste = new ArrayList<>();
		for (Ausleihe a : ausleiheListe)
			liste.add(a);
		ausleiheDAO.speichern(liste);
    }

    public void laden() {
        ausleiheListe.clear();
		try {
			List<Ausleihe> liste = ausleiheDAO.laden();
			for (Ausleihe ausleihe : liste)
				this.add(ausleihe);

		} catch (Exception e) {	}
    }

    public void add(Ausleihe ausleihe) {
        if (!ausleiheListe.add(ausleihe)) {
			String error = "Ausleihe gibt es bereits.";
		}
    }

    public void delete(Ausleihe ausleihe) {
        if (!ausleiheListe.remove(ausleihe)) {
			String error = "Ausleihe gibt es nicht.";
		}
    }

    public ArrayList<Ausleihe> get() {
        ArrayList<Ausleihe> liste = new ArrayList<Ausleihe>();
		for (Ausleihe ausleihe : ausleiheListe) {
			liste.add(ausleihe);
		}
		return liste;
    }
    
}
