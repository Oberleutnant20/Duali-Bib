/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik;

import de.dualibib.Fachlogik.Accountverwaltung.Accountverwaltung;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleiheverwaltung;
import de.dualibib.Fachlogik.Medienverwaltung.Medienverwaltung;

/**
 *
 * @author Carina
 */
public class Controller {

    Accountverwaltung accountverwaltung;
    Medienverwaltung medienverwaltung;
    Ausleiheverwaltung ausleiheverwaltung;
    Kategorienverwaltung kategorienverwaltung;

    public Controller(Accountverwaltung accountverwaltung, Medienverwaltung medienverwaltung, Ausleiheverwaltung ausleiheverwaltung, Kategorienverwaltung kategorienverwaltung) {
        this.accountverwaltung = accountverwaltung;
        this.medienverwaltung = medienverwaltung;
        this.ausleiheverwaltung = ausleiheverwaltung;
        this.kategorienverwaltung = kategorienverwaltung;
    }
         
    

    public void start() {
        
    }
    
}
