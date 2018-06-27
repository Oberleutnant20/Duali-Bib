/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib;

import de.dualibib.Datenlogik.VerwaltungsFactorySingleton;
import de.dualibib.Fachlogik.Accountverwaltung.Accountverwaltung;
import de.dualibib.Fachlogik.Accountverwaltung.Languageverwaltung.Languageverwaltung;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleiheverwaltung;
import de.dualibib.Fachlogik.Controller;
import de.dualibib.Fachlogik.Genreverwaltung.Genreverwaltung;
import de.dualibib.Fachlogik.Historyverwaltung.Historyverwaltung;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorienverwaltung;
import de.dualibib.Fachlogik.Medienverwaltung.Medienverwaltung;
import de.dualibib.UI.PanelHandler;

/**
 *
 * @author Carina
 */
public class Main {

    public static void main(String[] args) {
        VerwaltungsFactorySingleton singleton = VerwaltungsFactorySingleton.getInstance();
        Languageverwaltung languageverwaltung = (Languageverwaltung)singleton.getVerwaltung("Language");
        Accountverwaltung accountverwaltung = (Accountverwaltung)singleton.getVerwaltung("Account");
        Medienverwaltung medienverwaltung = (Medienverwaltung)singleton.getVerwaltung("Medien");
        Ausleiheverwaltung ausleiheverwaltung = (Ausleiheverwaltung)singleton.getVerwaltung("Ausleihe");
        Kategorienverwaltung kategorienverwaltung = (Kategorienverwaltung)singleton.getVerwaltung("Kategorien");
        Genreverwaltung genreverwaltung = (Genreverwaltung)singleton.getVerwaltung("Genre");
        Historyverwaltung historyverwaltung = (Historyverwaltung)singleton.getVerwaltung("History");
        Logger.enableDebug(true);
        Logger.enableWarnung(true);
        Controller controller = new Controller(languageverwaltung,accountverwaltung, medienverwaltung,ausleiheverwaltung, kategorienverwaltung,genreverwaltung, historyverwaltung);
        PanelHandler panelHandler = new PanelHandler(controller, genreverwaltung.get(), kategorienverwaltung.get());
        controller.start(panelHandler);
        panelHandler.start();
    }
}
