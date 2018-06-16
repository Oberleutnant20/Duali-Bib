/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Medienverwaltung;

import de.dualibib.Datenlogik.dto.Medien;
import de.dualibib.Datenlogik.idao.IMedienDAO;
import de.dualibib.Fachlogik.ElternVerwaltung;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carina
 */
public class Medienverwaltung extends ElternVerwaltung{

    private ArrayList<Medien> medienListe;
    private ArrayList<Medien> medienListeRef;
    private ArrayList<Medien> medienListeUpdate;
    private ArrayList<Medien> medienListeDelete;
    private IMedienDAO medienDAO;

    public Medienverwaltung(IMedienDAO medienDAO) {
        medienListe = new ArrayList<Medien>();
        medienListeRef = new ArrayList<Medien>();
        medienListeUpdate = new ArrayList<Medien>();
        medienListeDelete = new ArrayList<Medien>();
        this.medienDAO = medienDAO;
    }

    public void speichern() throws IOException, ConnectionError {
        List<Medien> liste = new ArrayList<>();
        if(medienListe.size() > medienListeRef.size()){
            liste = medienListe.subList(medienListeRef.size(), medienListe.size());
        }
        medienDAO.speichern(liste);
        medienDAO.update(medienListeUpdate);
    }

    public void laden() {
        medienListe.clear();
        medienListeRef.clear();
        de.dualibib.Logger.debug(this,"laden");
        try {
            List<Medien> liste = medienDAO.laden();
            for (Medien medium : liste) {
                medienListe.add(medium);
                medienListeRef.add(medium);
            }

        } catch (Exception e) {
            de.dualibib.Logger.error(this,"laden");
        }
    }

    public void add(Medien medium) {
        if (!medienListe.add(medium)) {
			String error = "Medium gibt es bereits.";
                        System.out.println(error);
		}
        notifyPanels();
    }

    public void delete(Medien medien) {
        if (!medienListe.remove(medien)) {
			String error = "Medium gibt es nicht.";
                        System.out.println(error);
		}
        notifyPanels();
    }
    
    public void update(Medien medien){
        if (!medienListeUpdate.add(medien)) {
			String error = "Medium gibt es nicht.";
                        System.out.println(error);
		}
        notifyPanels();
    }

    public ArrayList<Medien> get() {
        ArrayList<Medien> liste = new ArrayList<Medien>();
		for (Medien medien : medienListe) {
			liste.add(medien);
                        System.out.println(medien.getName());
    }
		return liste;
    }

}
