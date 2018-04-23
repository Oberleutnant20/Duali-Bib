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

    private User user = null;
    private String username = null;
    private String passwort = null;
    private boolean mitarbeiter;

    public User getKunde() {
        return user;
    }

    public boolean getMitarbeiter() {
        return mitarbeiter;
    }

}
