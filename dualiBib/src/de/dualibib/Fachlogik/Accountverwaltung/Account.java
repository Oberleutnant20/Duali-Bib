/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Accountverwaltung;

/**
 *
 * @author Carina
 */
public class Account {

    private Kunde kunde = null;
    private Mitarbeiter mitarbeiter = null;
    private String emailAdresse = null;
    private String passwort = null;

    public Kunde getKunde() {
        return kunde;
    }

    public Mitarbeiter getMitarbeiter() {
        return mitarbeiter;
    }

}
