/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik.Ausleihverwaltung;

import de.dualibib.Datenlogik.dto.AusleiheDTO;
import de.dualibib.Datenlogik.idao.IAusleiheDAO;
import de.dualibib.Fachlogik.ElternVerwaltung;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carina
 */
public class Ausleiheverwaltung extends ElternVerwaltung{

    private AusleiheDTO ausleiheListe;
    private AusleiheDTO ausleiheListeRef;
    private AusleiheDTO ausleiheListeUpdate;
    private AusleiheDTO ausleiheListeDelete;
    private IAusleiheDAO ausleiheDAO;

    public Ausleiheverwaltung(IAusleiheDAO ausleiheDAO) {
        ausleiheListeRef = new AusleiheDTO();
        ausleiheListeUpdate = new AusleiheDTO();
        ausleiheListeDelete = new AusleiheDTO();
        this.ausleiheDAO = ausleiheDAO;
    }

    public void speichern() throws IOException, ConnectionError {
        List<Ausleihe> liste = new ArrayList<>();
        if(ausleiheListe.size() > ausleiheListeRef.size()){
            //liste = ausleiheListe.subList(ausleiheListeRef.size(), ausleiheListe.size());
        }
        ausleiheDAO.speichern();
        //ausleiheDAO.loeschen(ausleiheListeDelete);
    }

    public void laden() {
        de.dualibib.Logger.debug(this,"laden");
        try {
            ausleiheListe = ausleiheDAO.laden();

        } catch (Exception e) {
        }
    }

    public void add(Ausleihe ausleihe) {
        if (!ausleiheListe.add(ausleihe)) {
            String error = "Ausleihe gibt es bereits.";
        }
        notifyPanels();
    }

    public void delete(Ausleihe ausleihe) {
        if (!ausleiheListeDelete.add(ausleihe)) {
            String error = "Ausleihe gibt es nicht.";
        }
        else{
            ausleiheListe.remove(ausleihe);
            notifyPanels();
        }
    }
    
    public void update(Ausleihe ausleihe){
        if (!ausleiheListeUpdate.add(ausleihe)) {
            String error = "Ausleihe gibt es nicht.";
        }
        notifyPanels();
    }

    public AusleiheDTO get() {
        return ausleiheListe;
    }
}
