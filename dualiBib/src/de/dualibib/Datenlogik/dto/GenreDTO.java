/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dto;

import de.dualibib.Fachlogik.Genreverwaltung.Genre;
import de.dualibib.UI.ElternPanel;
import java.util.ArrayList;

/**
 *
 * @author Carina
 */
public class GenreDTO implements DataTransferObject{

    private ArrayList<Genre> genreListe;
    private ArrayList<ElternPanel> panelListe;
    
    public GenreDTO(){
        genreListe = new ArrayList<>();
    }
    
    @Override
    public ArrayList get() {
        return genreListe;
    }

    @Override
    public void set(ArrayList list) {
        genreListe = list;
        de.dualibib.Logger.debug(this,genreListe.size()+"");
    }

    public boolean add(Genre a) {
        boolean success = genreListe.add(a);
        return success;
    }

    public boolean remove(Genre a) {
        boolean success = genreListe.remove(a);
        return success;
    }

    @Override
    public int size() {
        return genreListe.size();
    }
    
    public Genre get(int i){
        return genreListe.get(i);
    }
}
