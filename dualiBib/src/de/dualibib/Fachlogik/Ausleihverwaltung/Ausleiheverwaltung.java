/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Ausleihverwaltung;

import de.dualibib.Datenlogik.IAusleiheDAO;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carina
 */
public class Ausleiheverwaltung {

    private ArrayList<Ausleihe> ausleiheListe;
    private ArrayList<Ausleihe> ausleiheListeRef;
    private ArrayList<Ausleihe> ausleiheListeUpdate;
    private ArrayList<Ausleihe> ausleiheListeDelete;
    private IAusleiheDAO ausleiheDAO;

    public Ausleiheverwaltung(IAusleiheDAO ausleiheDAO) {
        ausleiheListe = new ArrayList<Ausleihe>();
        ausleiheListeRef = new ArrayList<Ausleihe>();
        ausleiheListeUpdate = new ArrayList<Ausleihe>();
        ausleiheListeDelete = new ArrayList<Ausleihe>();
        this.ausleiheDAO = ausleiheDAO;
    }

    public void speichern() throws IOException, ConnectionError {
        List<Ausleihe> liste = new ArrayList<>();
        if(ausleiheListe.size() > ausleiheListeRef.size()){
            liste = ausleiheListe.subList(ausleiheListeRef.size(), ausleiheListe.size());
        }
        ausleiheDAO.speichern(liste);
        ausleiheDAO.loeschen(ausleiheListeDelete);
    }

    public void laden() {
        ausleiheListe.clear();
        ausleiheListeRef.clear();
        try {
            List<Ausleihe> liste = ausleiheDAO.laden();
            for (Ausleihe ausleihe : liste) {
                ausleiheListe.add(ausleihe);
                ausleiheListeRef.add(ausleihe);
            }

        } catch (Exception e) {
        }
    }

    public void add(Ausleihe ausleihe) {
        if (!ausleiheListe.add(ausleihe)) {
            String error = "Ausleihe gibt es bereits.";
        }
    }

    public void delete(Ausleihe ausleihe) {
        if (!ausleiheListeDelete.add(ausleihe)) {
            String error = "Ausleihe gibt es nicht.";
        }
    }
    
    public void update(Ausleihe ausleihe){
        if (!ausleiheListeUpdate.add(ausleihe)) {
            String error = "Ausleihe gibt es nicht.";
        }
    }

    public ArrayList<Ausleihe> get() {
        ArrayList<Ausleihe> liste = new ArrayList<Ausleihe>();
        for (Ausleihe ausleihe : ausleiheListe) {
            liste.add(ausleihe);
        }
        return liste;
    }

}
