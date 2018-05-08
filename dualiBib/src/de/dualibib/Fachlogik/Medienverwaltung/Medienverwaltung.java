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
        //to do
    }

    public void laden() {
        //to do
    }

    public boolean istLeer() {
        return false;
    }

    public void add(Medien medien) {
        //to do
    }

    public void delete() {
        //to do
    }
    
}
