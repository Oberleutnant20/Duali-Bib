/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Genreverwaltung;

import de.dualibib.Datenlogik.dto.Genre;
import de.dualibib.Datenlogik.idao.IGenreDAO;
import de.dualibib.Fachlogik.ElternVerwaltung;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carina
 */
public class Genreverwaltung extends ElternVerwaltung{

    private ArrayList<Genre> genreListe;
    private ArrayList<Genre> genreListeRef;
    private IGenreDAO genreDAO;

    public Genreverwaltung(IGenreDAO genreDAO) {
        genreListe = new ArrayList<>();
        genreListeRef = new ArrayList<>();
        this.genreDAO = genreDAO;
        laden();
    }

    public void speichern() throws IOException, ConnectionError {
        List<Genre> liste = new ArrayList<>();
        if(genreListe.size() > genreListeRef.size()){
            liste = genreListe.subList(genreListeRef.size(), genreListe.size());
    }
        genreDAO.speichern(liste);
    }

    public void laden() {
        genreListe.clear();
        genreListeRef.clear();
        de.dualibib.Logger.debug(this, "laden");
        try {
            List<Genre> liste = genreDAO.laden();
            liste.forEach((genre) -> {
                genreListe.add(genre);
                genreListeRef.add(genre);
            });
        } catch (Exception e) {
            de.dualibib.Logger.error(this, "laden");
        }
    }

    public void add(Genre genre) {
        if (!genreListe.add(genre)) {
            de.dualibib.Logger.error(this, "Genre gibt es bereits.");
        }
        notifyPanels();
    }

    public void delete(Genre genre) {
        if (!genreListe.remove(genre)) {
            de.dualibib.Logger.error(this, "Genre gibt es nicht.");
        }
        else {
            notifyPanels();
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
