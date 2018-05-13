/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Medienverwaltung.WeitereMedien;

import de.dualibib.Fachlogik.Genreverwaltung.Genre;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorie;
import de.dualibib.Fachlogik.Medienverwaltung.Medien;

/**
 *
 * @author Carina
 */
public class CD extends Medien{

    public CD(String isbn, int barcodenummer, Genre genre, Kategorie kategorien, String name, boolean ausgeliehen, boolean vorgemerkt, int id,int anzahl ,String interpret, String beschreibung) {
        super(isbn, barcodenummer, genre, kategorien, name, ausgeliehen, vorgemerkt, id, anzahl, interpret, beschreibung);

    }    
}
