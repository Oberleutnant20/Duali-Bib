/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Medienverwaltung.Printmedien;

import de.dualibib.Fachlogik.Medienverwaltung.Medien;

/**
 *
 * @author Carina
 */
public abstract class Printmedien extends Medien{
    
    private int isbn;
    private String verlag;
    private String autor;

    public Printmedien(int isbn, String verlag, String autor, String kategorien, String name, boolean ausgeliehen, boolean vorgemerkt) {
        super(kategorien, name, ausgeliehen, vorgemerkt);
        this.isbn = isbn;
        this.verlag = verlag;
        this.autor = autor;
    }

    

    public int getIsbn() {
        return isbn;
    }

    public String getVerlag() {
        return verlag;
    }

    public String getAutor() {
        return autor;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
}
