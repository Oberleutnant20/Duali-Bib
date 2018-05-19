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
public class Medien {
    
    private Kategorie kategorien;
    private Genre genre;
    private String name;
    //mehr Infos über Ausleihe
    private boolean ausgeliehen;
    private boolean vorgemerkt;
    private long id;
    private String isbn;
    private long barcodenummer;
    private int anzahl;
    private int verfuegbar_anzahl;
    private String author;
    private String desc;

    public Medien(String isbn, long barcodenummer, Genre genre, Kategorie kategorien, String name, boolean ausgeliehen, boolean vorgemerkt, long id, int anzahl, String author, String desc) {
        this.kategorien = kategorien;
        this.name = name;
        this.ausgeliehen = ausgeliehen;
        this.vorgemerkt = vorgemerkt;
        this.id = id;
        this.genre = genre;
        this.barcodenummer = barcodenummer;
        this.isbn = isbn;
        this.anzahl = anzahl;
        this.author = author;
        this.desc = desc;
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
    
    public void berechneVerfuegbare(int ausgeliehene){
        verfuegbar_anzahl = verfuegbar_anzahl - ausgeliehene;
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
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
