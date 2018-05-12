/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Medienverwaltung;

import java.util.HashSet;
import java.util.Set;
import de.dualibib.Datenlogik.IMedienDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carina
 */
public class Medienverwaltung{

    private Set<Medien> medienListe;
    private IMedienDAO medienDAO;
    
    public Medienverwaltung(IMedienDAO medienDAO) {
      medienListe = new HashSet<Medien>();
        this.medienDAO = medienDAO;
    }

    public void speichern() throws IOException{
        List<Medien> liste = new ArrayList<>();
		for (Medien m : medienListe)
			liste.add(m);
		medienDAO.speichern(liste);
    }

    public void laden() {
        medienListe.clear();
		try {
			List<Medien> liste = medienDAO.laden();
			for (Medien medium : liste)
				this.add(medium);

		} catch (Exception e) {	}
    }

    public void add(Medien medium) {
        if (!medienListe.add(medium)) {
			String error = "Medium gibt es bereits.";
		}
    }

    public void delete(Medien medien) {
        if (!medienListe.remove(medien)) {
			String error = "Medium gibt es nicht.";
		}
    }

    public ArrayList<Medien> get() {
        ArrayList<Medien> liste = new ArrayList<Medien>();
		for (Medien account : medienListe) {
			liste.add(account);
		}
		return liste;
    }
    
}
