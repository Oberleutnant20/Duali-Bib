/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Kategorieverwaltung;

import de.dualibib.Datenlogik.IKategorieDAO;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carina
 */
public class Kategorienverwaltung {

    private ArrayList<Kategorie> kategorieListe;
    private ArrayList<Kategorie> kategorieListeRef;
    private IKategorieDAO kategorieDAO;

    public Kategorienverwaltung(IKategorieDAO kategorieDAO) {
        kategorieListe = new ArrayList<Kategorie>();
        kategorieListeRef = new ArrayList<Kategorie>();
        this.kategorieDAO = kategorieDAO;
    }

    public void speichern() throws IOException, ConnectionError {
        List<Kategorie> liste = new ArrayList<>();
        if(kategorieListe.size() > kategorieListeRef.size()){
            liste = kategorieListe.subList(kategorieListeRef.size(), kategorieListe.size());
        }
        kategorieDAO.speichern(liste);
    }

    public void laden() {
        kategorieListe.clear();
        kategorieListeRef.clear();
        try {
            List<Kategorie> liste = kategorieDAO.laden();
            liste.forEach((kategorie) -> {
                kategorieListe.add(kategorie);
                kategorieListeRef.add(kategorie);
            });

        } catch (Exception e) {
        }
    }

    public void add(Kategorie kategorie) {
        if (!kategorieListe.add(kategorie)) {
            String error = "Ausleihe gibt es bereits.";
        }
    }

    public void delete(Kategorie kategorie) {
        if (!kategorieListe.remove(kategorie)) {
            String error = "Ausleihe gibt es nicht.";
        }
    }

    public List<Kategorie> get() {
        ArrayList<Kategorie> liste = new ArrayList<>();
        kategorieListe.forEach((kategorie) -> {
            liste.add(kategorie);
        });
        return liste;
    }
}
