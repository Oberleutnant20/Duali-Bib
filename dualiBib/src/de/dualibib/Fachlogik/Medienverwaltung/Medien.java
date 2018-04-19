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
    
    private String kategorien;
    private String name;
    //mehr Infos über Ausleihe
    private boolean ausgeliehen;
    private boolean vorgemerkt;

    public Medien(String kategorien, String name, boolean ausgeliehen, boolean vorgemerkt) {
        this.kategorien = kategorien;
        this.name = name;
        this.ausgeliehen = ausgeliehen;
        this.vorgemerkt = vorgemerkt;
    }

    
    
    public String getKategorien() {
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

    public void setKategorien(String kategorien) {
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
