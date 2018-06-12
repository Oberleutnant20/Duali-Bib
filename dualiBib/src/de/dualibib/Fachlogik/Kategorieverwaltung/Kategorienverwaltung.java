/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Kategorieverwaltung;

import de.dualibib.Datenlogik.dto.KategorieDTO;
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

    private KategorieDTO kategorieListe;
    private KategorieDTO kategorieListeRef;
    private IKategorieDAO kategorieDAO;

    public Kategorienverwaltung(IKategorieDAO kategorieDAO) {
        kategorieListeRef = new KategorieDTO();
        this.kategorieDAO = kategorieDAO;
    }

    public void speichern() throws IOException, ConnectionError {
        List<Kategorie> liste = new ArrayList<>();
        if(kategorieListe.size() > kategorieListeRef.size()){
            //liste = kategorieListe.subList(kategorieListeRef.size(), kategorieListe.size());
        }
        kategorieDAO.speichern();
    }

    public void laden() {
        de.dualibib.Logger.debug(this,"laden");
        try {
            kategorieListe = kategorieDAO.laden();
        } catch (Exception e) {
        }
    }

    public void add(Kategorie kategorie) {
        if (!kategorieListe.add(kategorie)) {
            String error = "Ausleihe gibt es bereits.";
        }
        notifyPanels();
    }

    public void delete(Kategorie kategorie) {
        if (!kategorieListe.remove(kategorie)) {
            String error = "Ausleihe gibt es nicht.";
        }
        notifyPanels();
    }

    public KategorieDTO get() {
        return kategorieListe;
    }
}
