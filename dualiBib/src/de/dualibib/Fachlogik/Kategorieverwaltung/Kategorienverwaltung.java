/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Kategorieverwaltung;

import de.dualibib.Datenlogik.IKategorieDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Carina
 */
public class Kategorienverwaltung{

    private Set<Kategorie> kategorieListe;
    private IKategorieDAO kategorieDAO;
    
    public Kategorienverwaltung(IKategorieDAO kategorieDAO) {
        kategorieListe = new HashSet<>();
        this.kategorieDAO = kategorieDAO;
    }
    
    public void speichern() throws IOException{
        List<Kategorie> liste = new ArrayList<>();
        kategorieListe.forEach((kategorie) -> {
            liste.add(kategorie);
         });
		kategorieDAO.speichern(liste);
    }

    public void laden() {
        kategorieListe.clear();
		try {
			List<Kategorie> liste = kategorieDAO.laden();
                        liste.forEach((kategorie) -> {
                            this.add(kategorie);
            });

		} catch (Exception e) {	}
    }

    public void add(Kategorie kategorie) {
        if (!kategorieListe.add(kategorie)) {
			String error = "Ausleihe gibt es bereits.";
		}
    }

    public void delete(Kategorie kategorie) {
        if (!kategorieListe.remove(kategorie)) {
			String error = "Ausleihe gibt es nicht.";
		}
    }

    public List<Kategorie> get() {
        ArrayList<Kategorie> liste = new ArrayList<>();
        kategorieListe.forEach((kategorie) -> {
            liste.add(kategorie);
         });
		return liste;
    }
}
