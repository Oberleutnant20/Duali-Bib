/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dto;

import de.dualibib.Fachlogik.Medienverwaltung.Medien;
import de.dualibib.UI.ElternPanel;
import java.util.ArrayList;

/**
 *
 * @author Carina
 */
public class MedienDTO implements DataTransferObject{

    private ArrayList<Medien> medienListe;
    private ArrayList<ElternPanel> panelListe;
    
    public MedienDTO(){
        medienListe = new ArrayList<>();
    }
    
    @Override
    public ArrayList get() {
        return medienListe;
    }

    @Override
    public void set(ArrayList list) {
        medienListe = list;
    }

    public boolean add(Medien a) {
        boolean success = medienListe.add(a);
        return success;
    }

    public boolean remove(Medien a) {
        boolean success = medienListe.remove(a);
        return success;
    }

    @Override
    public int size() {
        return medienListe.size();
    }

    public Medien get(int i){
        return medienListe.get(i);
    }
}
