package de.dualibib.Fachlogik.Medienverwaltung.Print;


import de.dualibib.Fachlogik.Genreverwaltung.Genre;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorie;
import de.dualibib.Fachlogik.Medienverwaltung.Printmedien;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Carina
 */
public class Zeitschrift extends Printmedien{
    
    public Zeitschrift(String isbn, int barcodenummer, Genre genre, Kategorie kategorien, String name, boolean ausgeliehen, boolean vorgemerkt, int id) {
        super(isbn, barcodenummer, genre, kategorien, name, ausgeliehen, vorgemerkt, id);
    }
    
    
    
}