/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Medienverwaltung;

import de.dualibib.Fachlogik.Genreverwaltung.Genre;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorie;

/**
 *
 * @author Carina
 */
public abstract class Medien {
    
    private Kategorie kategorien;
    private Genre genre;
    private String name;
    //mehr Infos über Ausleihe
    private boolean ausgeliehen;
    private boolean vorgemerkt;
    private long id;

    public Medien(Genre genre, Kategorie kategorien, String name, boolean ausgeliehen, boolean vorgemerkt, long id) {
        this.kategorien = kategorien;
        this.name = name;
        this.ausgeliehen = ausgeliehen;
        this.vorgemerkt = vorgemerkt;
        this.id = id;
        this.genre = genre;
    }

    public void setKategorien(Kategorie kategorien) {
        this.kategorien = kategorien;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAusgeliehen() {
        return ausgeliehen;
    }

    public boolean isVorgemerkt() {
        return vorgemerkt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAusgeliehen(boolean ausgeliehen) {
        this.ausgeliehen = ausgeliehen;
    }

    public void setVorgemerkt(boolean vorgemerkt) {
        this.vorgemerkt = vorgemerkt;
    }

    public Kategorie getKategorien() {
        return kategorien;
    }

    public Genre getGenre() {
        return genre;
    }
    
    
    
}
