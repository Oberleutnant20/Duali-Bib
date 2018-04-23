/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Medienverwaltung;

import de.dualibib.Datenlogik.IMedienDAO;
//import de.dualibib.Datenlogik.MedienDAO;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Carina
 */
public class Medienverwaltung{

    private Set<Medien> accountListe;
    private IMedienDAO medienDAO;
    
    public Medienverwaltung(IMedienDAO medienDAO) {
      accountListe = new HashSet<Medien>();
        this.medienDAO = medienDAO;
    }

    public void speichern() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void laden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean istLeer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
