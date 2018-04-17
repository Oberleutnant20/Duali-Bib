/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib;

import de.dualibib.Datenlogik.AccountDAO;
import de.dualibib.Datenlogik.AusleiheDAO;
import de.dualibib.Datenlogik.MedienDAO;
import de.dualibib.Fachlogik.Accountverwaltung.Accountverwaltung;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleiheverwaltung;
import de.dualibib.Fachlogik.Controller;
import de.dualibib.Fachlogik.Medienverwaltung.Medienverwaltung;

/**
 *
 * @author Carina
 */
public class Main {

    public static void main(String[] args) {
        Accountverwaltung accountverwaltung = new Accountverwaltung(new AccountDAO());
        Medienverwaltung medienverwaltung = new Medienverwaltung(new MedienDAO());
        Ausleiheverwaltung ausleiheverwaltung = new Ausleiheverwaltung(new AusleiheDAO());
        Controller controller = new Controller(accountverwaltung, medienverwaltung,ausleiheverwaltung);
        controller.start();
    }
}
