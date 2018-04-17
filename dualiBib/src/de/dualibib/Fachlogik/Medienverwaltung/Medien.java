/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Medienverwaltung;

/**
 *
 * @author Carina
 */
public abstract class Medien {
    
    private Kategorien kategorien;
    private String name;
    //mehr Infos über Ausleihe
    private boolean ausgeliehen;
    private boolean vorgemerkt;

    public Kategorien getKategorien() {
        return kategorien;
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

    public void setKategorien(Kategorien kategorien) {
        this.kategorien = kategorien;
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
    
    
    
}
