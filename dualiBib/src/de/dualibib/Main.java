package de.dualibib;

import de.dualibib.Datenlogik.VerwaltungsFactorySingleton;
import de.dualibib.Fachlogik.Accountverwaltung.Accountverwaltung;
import de.dualibib.Fachlogik.Languageverwaltung.Languageverwaltung;
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

    /**
     * Ausführende Main Methode.
     * @param args
     */
    public static void main(String[] args) {
        Logger.enableDebug(true);
        Logger.enableWarnung(true);

        VerwaltungsFactorySingleton singleton;
        singleton = VerwaltungsFactorySingleton.getInstance();
        Languageverwaltung languageverwaltung;
        languageverwaltung = (Languageverwaltung) singleton.getVerwaltung("Language");
        Accountverwaltung accountverwaltung;
        accountverwaltung = (Accountverwaltung) singleton.getVerwaltung("Account");
        Medienverwaltung medienverwaltung;
        medienverwaltung = (Medienverwaltung) singleton.getVerwaltung("Medien");
        Ausleiheverwaltung ausleiheverwaltung;
        ausleiheverwaltung = (Ausleiheverwaltung) singleton.getVerwaltung("Ausleihe");
        Kategorienverwaltung kategorienverwaltung;
        kategorienverwaltung = (Kategorienverwaltung) singleton.getVerwaltung("Kategorien");
        Genreverwaltung genreverwaltung;
        genreverwaltung = (Genreverwaltung) singleton.getVerwaltung("Genre");
        Historyverwaltung historyverwaltung;
        historyverwaltung = (Historyverwaltung) singleton.getVerwaltung("History");

        Controller controller;
        controller = new Controller(languageverwaltung, accountverwaltung, medienverwaltung, ausleiheverwaltung, kategorienverwaltung, genreverwaltung, historyverwaltung);

        PanelHandler panelHandler;
        panelHandler = new PanelHandler(controller, genreverwaltung.get(), kategorienverwaltung.get());

        controller.start(panelHandler);
        panelHandler.start();
    }
}
