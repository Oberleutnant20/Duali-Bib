/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Genreverwaltung;

import de.dualibib.Datenlogik.IGenreDAO;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Carina
 */
public class Genreverwaltung{

     private Set<Genre> genreListe;
    private IGenreDAO genreDAO;
    
    public Genreverwaltung(IGenreDAO genreDAO) {
        genreListe = new HashSet<>();
        this.genreDAO = genreDAO;
    }
    
    public void speichern() throws IOException, ConnectionError{
        List<Genre> liste = new ArrayList<>();
        genreListe.forEach((genre) -> {
            liste.add(genre);
         });
		genreDAO.speichern(liste);
    }

    public void laden() {
        genreListe.clear();
		try {
			List<Genre> liste = genreDAO.laden();
                        liste.forEach((genre) -> {
                            this.add(genre);
            });

		} catch (Exception e) {	}
    }

    public void add(Genre genre) {
        if (!genreListe.add(genre)) {
			String error = "Ausleihe gibt es bereits.";
		}
    }

    public void delete(Genre genre) {
        if (!genreListe.remove(genre)) {
			String error = "Ausleihe gibt es nicht.";
		}
    }

    public List<Genre> get() {
        ArrayList<Genre> liste = new ArrayList<>();
        genreListe.forEach((genre) -> {
            liste.add(genre);
         });
		return liste;
    }
}
