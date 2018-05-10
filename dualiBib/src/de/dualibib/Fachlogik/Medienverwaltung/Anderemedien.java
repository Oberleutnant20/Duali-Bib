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
public class Anderemedien extends Medien{
    
    private int barcodenummer;
    
    public Anderemedien(int barcodenummer, Genre genre, Kategorie kategorien, String name, boolean ausgeliehen, boolean vorgemerkt, int id) {
        super(genre, kategorien, name, ausgeliehen, vorgemerkt, id);
        this.barcodenummer = barcodenummer;
    }

    public void setBarcodenummer(int barcodenummer) {
        this.barcodenummer = barcodenummer;
    }

    public int getBarcodenummer() {
        return barcodenummer;
    }
    
}
