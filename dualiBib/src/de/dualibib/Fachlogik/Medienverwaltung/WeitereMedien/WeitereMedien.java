/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Medienverwaltung.WeitereMedien;

import de.dualibib.Fachlogik.Medienverwaltung.Medien;

/**
 *
 * @author Carina
 */
public abstract class WeitereMedien extends Medien{
    
    private int idnr;

    public WeitereMedien(int idnr, String kategorien, String name, boolean ausgeliehen, boolean vorgemerkt) {
        super(kategorien, name, ausgeliehen, vorgemerkt);
        this.idnr = idnr;
    }

    public int getIdnr() {
        return idnr;
    }

    public void setIdnr(int idnr) {
        this.idnr = idnr;
    }
    
    
}