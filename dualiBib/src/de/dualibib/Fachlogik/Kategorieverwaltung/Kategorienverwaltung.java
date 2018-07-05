/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Kategorieverwaltung;

import de.dualibib.Datenlogik.dto.Kategorie;
import de.dualibib.Datenlogik.idao.IKategorieDAO;
import de.dualibib.Fachlogik.ElternVerwaltung;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carina
 */
public class Kategorienverwaltung extends ElternVerwaltung{

    private ArrayList<Kategorie> kategorieListe;
    private ArrayList<Kategorie> kategorieListeRef;
    private IKategorieDAO kategorieDAO;

    public Kategorienverwaltung(IKategorieDAO kategorieDAO) {
        kategorieListe = new ArrayList<>();
        kategorieListeRef = new ArrayList<>();
        this.kategorieDAO = kategorieDAO;
        laden();
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
        de.dualibib.Logger.debug(this, "laden");
        try {
            List<Kategorie> liste = kategorieDAO.laden();
            liste.forEach((kategorie) -> {
                kategorieListe.add(kategorie);
                kategorieListeRef.add(kategorie);
            });

        } catch (Exception e) { 
            de.dualibib.Logger.error(this, "laden");
        }
    }

    public void add(Kategorie kategorie) {
        if (!kategorieListe.add(kategorie)) {
            de.dualibib.Logger.error(this, "Kategorie gibt es bereits.");
        }
        notifyPanels();
    }

    public void delete(Kategorie kategorie) {
        if (!kategorieListe.remove(kategorie)) {
            de.dualibib.Logger.error(this, "Kategorie gibt es nicht.");
        }
        notifyPanels();
    }

    public List<Kategorie> get() {
        ArrayList<Kategorie> liste = new ArrayList<>();
        kategorieListe.forEach((kategorie) -> {
            liste.add(kategorie);
        });
        return liste;
    }
}
