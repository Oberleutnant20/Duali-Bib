/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Medienverwaltung;

import de.dualibib.Datenlogik.dto.MedienDTO;
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

    private MedienDTO medienListe;
    private MedienDTO medienListeRef;
    private MedienDTO medienListeUpdate;
    private MedienDTO medienListeDelete;
    private IMedienDAO medienDAO;

    public Medienverwaltung(IMedienDAO medienDAO) {
        medienListeRef = new MedienDTO();
        medienListeUpdate = new MedienDTO();
        medienListeDelete = new MedienDTO();
        this.medienDAO = medienDAO;
    }

    public void speichern() throws IOException, ConnectionError {
        List<Medien> liste = new ArrayList<>();
        if(medienListe.size() > medienListeRef.size()){
            //liste = medienListe.subList(medienListeRef.size(), medienListe.size());
        }
        medienDAO.speichern();
        //medienDAO.update(medienListeUpdate);
    }

    public void laden() {
        de.dualibib.Logger.debug(this,"laden");
        try {
            medienListe = medienDAO.laden();
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

    public MedienDTO get() {
	return medienListe;
    }

}
