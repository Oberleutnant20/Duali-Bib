/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik;

import de.dualibib.UI.ElternPanel;
import java.util.ArrayList;

/**
 *
 * @author Carina
 */
public abstract class ElternVerwaltung {
    
    public ArrayList<ElternPanel> panelListe = new  ArrayList<ElternPanel>();
    
    public void addPanelList(ElternPanel e) {
        panelListe.add(e);
    }
    
    public void notifyPanels() {
        panelListe.stream().forEach(p -> p.update());
    }
}
