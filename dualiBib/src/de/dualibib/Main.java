/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib;

import de.dualibib.Datenlogik.dao.AccountDAO;
import de.dualibib.Datenlogik.dao.AnderemedienDAO;
import de.dualibib.Datenlogik.dao.AusleiheDAO;
import de.dualibib.Datenlogik.dao.GenreDAO;
import de.dualibib.Datenlogik.dao.KategorieDAO;
import de.dualibib.Datenlogik.dao.PrintmedienDAO;
import de.dualibib.Fachlogik.Accountverwaltung.Accountverwaltung;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleiheverwaltung;
import de.dualibib.Fachlogik.Controller;
import de.dualibib.Fachlogik.Genreverwaltung.Genreverwaltung;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorienverwaltung;
import de.dualibib.Fachlogik.Medienverwaltung.Anderemedienverwaltung;
import de.dualibib.Fachlogik.Medienverwaltung.Printmedienverwaltung;

/**
 *
 * @author Carina
 */
public class Main {

    public static void main(String[] args) {
        Accountverwaltung accountverwaltung = new Accountverwaltung(new AccountDAO());
        Anderemedienverwaltung anderemedienverwaltung = new Anderemedienverwaltung(new AnderemedienDAO());
        Printmedienverwaltung printmedienverwaltung = new Printmedienverwaltung(new PrintmedienDAO());
        Ausleiheverwaltung ausleiheverwaltung = new Ausleiheverwaltung(new AusleiheDAO());
        Kategorienverwaltung kategorienverwaltung = new Kategorienverwaltung(new KategorieDAO());
        Genreverwaltung genreverwaltung = new Genreverwaltung(new GenreDAO());
        Controller controller = new Controller(accountverwaltung, anderemedienverwaltung,printmedienverwaltung,ausleiheverwaltung, kategorienverwaltung,genreverwaltung);
        controller.start();
    }
}
