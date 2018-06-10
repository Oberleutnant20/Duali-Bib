/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dto;

import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleihe;
import de.dualibib.UI.ElternPanel;
import java.util.ArrayList;

/**
 *
 * @author Carina
 */
public class AusleiheDTO implements DataTransferObject{

    private ArrayList<Ausleihe> ausleiheListe;
    private ArrayList<ElternPanel> panelListe;
    
    public AusleiheDTO(){
        ausleiheListe = new ArrayList<>();
    }
    
    @Override
    public ArrayList get() {
        return ausleiheListe;
    }

    @Override
    public void set(ArrayList list) {
        ausleiheListe = list;
    }

    public boolean add(Ausleihe a) {
        boolean success = ausleiheListe.add(a);
        return success;
    }

    public boolean remove(Ausleihe a) {
        boolean success = ausleiheListe.remove(a);
        return success;
    }

    @Override
    public int size() {
        return ausleiheListe.size();
    }
    
    public Ausleihe get(int i){
        return ausleiheListe.get(i);
    }
    
}
