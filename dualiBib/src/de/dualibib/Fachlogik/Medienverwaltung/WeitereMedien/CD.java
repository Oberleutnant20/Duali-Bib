/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Medienverwaltung.WeitereMedien;

import de.dualibib.Fachlogik.Genreverwaltung.Genre;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorie;
import de.dualibib.Fachlogik.Medienverwaltung.Anderemedien;

/**
 *
 * @author Carina
 */
public class CD extends Anderemedien{
 
    private String kuenstler;

    public CD(String kuenstler, int barcodenummer, Genre genre, Kategorie kategorien, String name, boolean ausgeliehen, boolean vorgemerkt, int id) {
        super(barcodenummer, genre, kategorien, name, ausgeliehen, vorgemerkt, id);
        this.kuenstler = kuenstler;
    }

    
    
    public String getKuenstler() {
        return kuenstler;
    }

    public void setKuenstler(String kuenstler) {
        this.kuenstler = kuenstler;
    }
    
    
    
}
