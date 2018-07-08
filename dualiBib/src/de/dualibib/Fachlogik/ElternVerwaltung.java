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

    public ArrayList<ElternPanel> panelListe = new ArrayList<>();

    /**
     * Fügt der Panel Liste Elemente hinzu.
     *
     * @param e welches Element hinzugefügt werden soll
     */
    public void addPanelList(ElternPanel e) {
        panelListe.add(e);
    }

    /**
     * Informiert die Panels bei Updates von Daten.
     */
    public void notifyPanels() {
        Logger.debug(this, "notify");
        panelListe.stream().forEach(p -> p.update());
    }

    /**
     * Sprach Einstellungen.
     *
     * @param props Properties, welche geladen werden.
     */
    public void notifyLanguagePanels(Properties props) {
        Logger.debug(this, "notify Language");
        panelListe.stream().forEach(p -> p.updateLanguage(props));
    }
}
