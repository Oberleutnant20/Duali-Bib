/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Ausleihverwaltung;

import java.util.Date;

/**
 *
 * @author Carina
 */
public class Ausleihe {
    
    private int id;
    private Date date;
    private int userid;

    public Ausleihe(int id, Date date, int userid) {
        this.id = id;
        this.date = date;
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getUserid() {
        return userid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    
}
