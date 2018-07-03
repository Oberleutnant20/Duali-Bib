/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik;

import de.dualibib.UI.ElternPanel;
import java.util.ArrayList;
import de.dualibib.Logger;
import java.util.Properties;
/**
 *
 * @author Carina
 */
public abstract class ElternVerwaltung {

    public ArrayList<ElternPanel> panelListe = new  ArrayList<>();

    public void addPanelList(ElternPanel e) {
        panelListe.add(e);
    }

    public void notifyPanels() {
        Logger.debug(this, "notify");
        panelListe.stream().forEach(p -> p.update());
    }

    public void notifyLanguagePanels(Properties props) {
        Logger.debug(this, "notify Language");
        panelListe.stream().forEach(p -> p.updateLanguage(props));
    }
}
