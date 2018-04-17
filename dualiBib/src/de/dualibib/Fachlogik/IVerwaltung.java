/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik;

/**
 *
 * @author Carina
 */
public interface IVerwaltung {
    
    public void speichern();
    public void laden();
    public boolean istLeer();
    public void add();
    public void delete();
}
