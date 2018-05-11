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
public class Printmedien extends Medien{
    
    private String isbn;
    private long barcodenummer;
    private int anzahl;
    private int verfuegbar_anzahl;
    
    public Printmedien(String isbn, long barcodenummer, Genre genre, Kategorie kategorien, String name, boolean ausgeliehen, boolean vorgemerkt, long id, int anzahl) {
        super(genre, kategorien, name, ausgeliehen, vorgemerkt, id);
        this.barcodenummer = barcodenummer;
        this.isbn = isbn;
        this.anzahl = anzahl;
    }

    public void berechneVerfuegbare(int ausgeliehene){
        verfuegbar_anzahl = anzahl - ausgeliehene;
    }
    
    public int getVerfuegbare(){
        return verfuegbar_anzahl;
    }
    
    public int getAnzahl(){
        return anzahl;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setBarcodenummer(long barcodenummer) {
        this.barcodenummer = barcodenummer;
    }

    public String getIsbn() {
        return isbn;
    }

    public long getBarcodenummer() {
        return barcodenummer;
    }
    
}
