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

    private String username;
    private String passwort;
    private boolean mitarbeiter;
    private int userid;
    private String vorname;
    private String nachname;

    public Account(String username, String passwort, boolean mitarbeiter, int userid, String vorname, String nachname) {
        this.username = username;
        this.passwort = passwort;
        this.mitarbeiter = mitarbeiter;
        this.userid = userid;
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public void setMitarbeiter(boolean mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswort() {
        return passwort;
    }

    public boolean isMitarbeiter() {
        return mitarbeiter;
    }

    public int getUserid() {
        return userid;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }


}
