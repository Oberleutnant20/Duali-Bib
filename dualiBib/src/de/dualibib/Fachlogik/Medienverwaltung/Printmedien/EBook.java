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
public class EBook extends Medien{
    
    public EBook(String kategorien, String name, boolean ausgeliehen, boolean vorgemerkt) {
        super(kategorien, name, ausgeliehen, vorgemerkt);
    }
    
}
