/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dto;

import java.io.Serializable;

/**
 *
 * @author Carina
 */
public class Kategorie implements Serializable {

    private long id;
    private String name;
    private String bezeichnung;

    public Kategorie(long id, String name, String bezeichnung) {
        this.id = id;
        this.name = name;
        this.bezeichnung = bezeichnung;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
