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
public class Genre implements Serializable {

    private int id;
    private String bezeichnung;

    /**
     * Konstruktor für die Genres.
     *
     * @param id Genre ID
     * @param bezeichnung Name des Genres
     */
    public Genre(int id, String bezeichnung) {
        this.id = id;
        this.bezeichnung = bezeichnung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
}
