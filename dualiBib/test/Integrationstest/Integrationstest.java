/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integrationstest;

import de.dualibib.Datenlogik.*;
import de.dualibib.Fachlogik.Accountverwaltung.Accountverwaltung;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleiheverwaltung;
import de.dualibib.Fachlogik.Controller;
import de.dualibib.Fachlogik.Genreverwaltung.Genreverwaltung;
import de.dualibib.Fachlogik.Historyverwaltung.Historyverwaltung;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorienverwaltung;
import de.dualibib.Fachlogik.Medienverwaltung.Medienverwaltung;
import de.dualibib.Logger;
import de.dualibib.UI.PanelHandler;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Carina
 */
public class Integrationstest {
    
    Controller controller;
    PanelHandler panelHandler;
    
    public Integrationstest() {
    }
    
    
    @BeforeClass
    public void setUp() {
        VerwaltungsFactorySingleton singleton = VerwaltungsFactorySingleton.getInstance();
        Accountverwaltung accountverwaltung = (Accountverwaltung)singleton.getVerwaltung("Account");
        Medienverwaltung medienverwaltung = (Medienverwaltung)singleton.getVerwaltung("Medien");
        Ausleiheverwaltung ausleiheverwaltung = (Ausleiheverwaltung)singleton.getVerwaltung("Ausleihe");
        Kategorienverwaltung kategorienverwaltung = (Kategorienverwaltung)singleton.getVerwaltung("Kategorien");
        Genreverwaltung genreverwaltung = (Genreverwaltung)singleton.getVerwaltung("Genre");
        Historyverwaltung historyverwaltung = (Historyverwaltung)singleton.getVerwaltung("History");
        Logger.enableDebug(true);
        Logger.enableWarnung(true);
        controller = new Controller(accountverwaltung, medienverwaltung,ausleiheverwaltung, kategorienverwaltung,genreverwaltung, historyverwaltung);
        panelHandler = new PanelHandler(controller, genreverwaltung.get(), kategorienverwaltung.get());
        controller.start(panelHandler);
        panelHandler.start();
    }
    
    @Test
    public void test() throws Exception{
        //ANZEIGE
        
        //LOGIN
        panelHandler.login("user", "pw");
        assertTrue(panelHandler.getAktuellerUser()!=null);
        //HISTORY
        //MEDIEN ÄNDER
        //AUSLEIHEN
        //ACCOUNTBEARBEITEN
        //ACCOUNTSBEARBEITEN
        //LOGOUT
    }
}