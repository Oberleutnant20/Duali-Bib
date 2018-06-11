/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dto;

import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorie;
import de.dualibib.UI.ElternPanel;
import java.util.ArrayList;

/**
 *
 * @author Carina
 */
public class KategorieDTO implements DataTransferObject{

    private ArrayList<Kategorie> kategorieListe;
    private ArrayList<ElternPanel> panelListe;
    
    public KategorieDTO(){
        kategorieListe = new ArrayList<>();
    }
    
    @Override
    public ArrayList get() {
        return kategorieListe;
    }

    @Override
    public void set(ArrayList list) {
        kategorieListe = list;
    }

    public boolean add(Kategorie a) {
        boolean success = kategorieListe.add(a);
        return success;
    }

    public boolean remove(Kategorie a) {
        boolean success = kategorieListe.remove(a);
        return success;
    }

    @Override
    public int size() {
        return kategorieListe.size();
    }

    public Kategorie get(int i){
        return kategorieListe.get(i);
    }
    
}
