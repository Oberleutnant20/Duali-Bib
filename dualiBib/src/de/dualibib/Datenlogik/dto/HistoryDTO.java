/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dto;

import de.dualibib.Fachlogik.Historyverwaltung.History;
import de.dualibib.UI.ElternPanel;
import java.util.ArrayList;

/**
 *
 * @author Carina
 */
public class HistoryDTO implements DataTransferObject{

    private ArrayList<History> historyListe;
    private ArrayList<ElternPanel> panelListe;
    
    public HistoryDTO(){
        historyListe = new ArrayList<>();
    }
    
    @Override
    public ArrayList get() {
        return historyListe;
    }

    @Override
    public void set(ArrayList list) {
        historyListe = list;
    }

    public boolean add(History a) {
        boolean success = historyListe.add(a);
        return success;
    }

    public boolean remove(History a) {
        boolean success = historyListe.remove(a);
        return success;
    }

    @Override
    public int size() {
        return historyListe.size();
    }
    
    public History get(int i){
        return historyListe.get(i);
    }
    
}
