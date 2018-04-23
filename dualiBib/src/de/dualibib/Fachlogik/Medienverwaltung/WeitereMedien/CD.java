/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Medienverwaltung.WeitereMedien;

/**
 *
 * @author Carina
 */
public class CD extends WeitereMedien{
 
    private String kuenstler;

    public CD(String kuenstler, int idnr, String kategorien, String name, boolean ausgeliehen, boolean vorgemerkt) {
        super(idnr, kategorien, name, ausgeliehen, vorgemerkt);
        this.kuenstler = kuenstler;
    }

    public String getKuenstler() {
        return kuenstler;
    }

    public void setKuenstler(String kuenstler) {
        this.kuenstler = kuenstler;
    }
    
    
    
}
