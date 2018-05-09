/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.History;

/**
 *
 * @author Carina
 */
public class History {
    int id;
    int userid;
    int medienid;

    public History(int id, int userid, int medienid) {
        this.id = id;
        this.userid = userid;
        this.medienid = medienid;
    }

    public int getId() {
        return id;
    }

    public int getUserid() {
        return userid;
    }

    public int getMedienid() {
        return medienid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setMedienid(int medienid) {
        this.medienid = medienid;
    }
    
}
