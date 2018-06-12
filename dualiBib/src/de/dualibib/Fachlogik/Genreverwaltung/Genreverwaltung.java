/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Genreverwaltung;

import de.dualibib.Datenlogik.dto.GenreDTO;
import de.dualibib.Datenlogik.idao.IGenreDAO;
import de.dualibib.Fachlogik.ElternVerwaltung;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carina
 */
public class Genreverwaltung extends ElternVerwaltung{

    private GenreDTO genreListe;
    private GenreDTO genreListeRef;
    private IGenreDAO genreDAO;

    public Genreverwaltung(IGenreDAO genreDAO) {
        genreListeRef = new GenreDTO();
        this.genreDAO = genreDAO;
    }

    public void speichern() throws IOException, ConnectionError {
        /*List<Genre> liste = new ArrayList<>();
        if(genreListe.size() > genreListeRef.size()){
            liste = genreListe.subList(genreListeRef.size(), genreListe.size());
        }*/
        genreDAO.speichern();
    }

    public void laden() {
        de.dualibib.Logger.debug(this,"laden");
        try {
            genreListe = genreDAO.laden();
        } catch (IOException | ConnectionError ex) {
            Logger.getLogger(Genreverwaltung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add(Genre genre) {
        if (!genreListe.add(genre)) {
            String error = "Ausleihe gibt es bereits.";
        }
        notifyPanels();
    }

    public void delete(Genre genre) {
        if (!genreListe.remove(genre)) {
            String error = "Ausleihe gibt es nicht.";
        }
        else{
            notifyPanels();
        }
    }

    public GenreDTO get() {
        return genreListe;
    }
}
