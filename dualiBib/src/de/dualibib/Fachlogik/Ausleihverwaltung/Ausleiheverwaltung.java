/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Ausleihverwaltung;

import de.dualibib.Datenlogik.IAusleiheDAO;
import de.dualibib.Fachlogik.IVerwaltung;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Carina
 */
public class Ausleiheverwaltung implements IVerwaltung{

    private Set<Ausleihe> accountListe;
    private IAusleiheDAO ausleiheDAO;
    
    public Ausleiheverwaltung(IAusleiheDAO ausleiheDAO) {
        accountListe = new HashSet<Ausleihe>();
        this.ausleiheDAO = ausleiheDAO;
    }

    @Override
    public void speichern() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void laden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean istLeer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
