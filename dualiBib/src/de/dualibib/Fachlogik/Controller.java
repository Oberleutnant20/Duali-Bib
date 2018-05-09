/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik;

import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorienverwaltung;
import de.dualibib.Fachlogik.Accountverwaltung.Accountverwaltung;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleiheverwaltung;
import de.dualibib.Fachlogik.Genreverwaltung.Genreverwaltung;
import de.dualibib.Fachlogik.Medienverwaltung.Anderemedienverwaltung;
import de.dualibib.Fachlogik.Medienverwaltung.Printmedienverwaltung;
import de.dualibib.UI.PanelHandler;

/**
 *
 * @author Carina
 */
public class Controller {

    private Accountverwaltung accountverwaltung;
    private Anderemedienverwaltung anderemedienverwaltung;
    private Printmedienverwaltung printmedienverwaltung;
    private Ausleiheverwaltung ausleiheverwaltung;
    private Kategorienverwaltung kategorienverwaltung;
    private Genreverwaltung genreverwaltung;
    
    private PanelHandler panelHandler;

    public Controller(Accountverwaltung accountverwaltung, Anderemedienverwaltung anderemedienverwaltung, Printmedienverwaltung printmedienverwaltung, Ausleiheverwaltung ausleiheverwaltung, Kategorienverwaltung kategorienverwaltung, Genreverwaltung genreverwaltung) {
        this.accountverwaltung = accountverwaltung;
        this.anderemedienverwaltung = anderemedienverwaltung;
        this.printmedienverwaltung = printmedienverwaltung;
        this.ausleiheverwaltung = ausleiheverwaltung;
        this.kategorienverwaltung = kategorienverwaltung;
        this.genreverwaltung = genreverwaltung;
    }
         
    

    public void start() {
        accountverwaltung.laden();
        anderemedienverwaltung.laden();
        ausleiheverwaltung.laden();
        kategorienverwaltung.laden();
        genreverwaltung.laden();
        panelHandler = new PanelHandler(kategorienverwaltung.get(),genreverwaltung.get());
    }
    
}
