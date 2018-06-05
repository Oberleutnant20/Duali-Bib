/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib;

import de.dualibib.Datenlogik.VerwaltungsFactorySingleton;
import de.dualibib.Datenlogik.dao.AccountDAO;
import de.dualibib.Datenlogik.dao.AusleiheDAO;
import de.dualibib.Datenlogik.dao.GenreDAO;
import de.dualibib.Datenlogik.dao.HistoryDAO;
import de.dualibib.Datenlogik.dao.KategorieDAO;
import de.dualibib.Datenlogik.dao.MedienDAO;
import de.dualibib.Fachlogik.Accountverwaltung.Accountverwaltung;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleiheverwaltung;
import de.dualibib.Fachlogik.Controller;
import de.dualibib.Fachlogik.Genreverwaltung.Genreverwaltung;
import de.dualibib.Fachlogik.Historyverwaltung.Historyverwaltung;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorienverwaltung;
import de.dualibib.Fachlogik.Medienverwaltung.Medienverwaltung;

/**
 *
 * @author Carina
 */
public class Main {

    public static void main(String[] args) {
        VerwaltungsFactorySingleton singleton = VerwaltungsFactorySingleton.getInstance();
        Accountverwaltung accountverwaltung = (Accountverwaltung)singleton.getVerwaltung("Account");
        Medienverwaltung medienverwaltung = (Medienverwaltung)singleton.getVerwaltung("Medien");
        Ausleiheverwaltung ausleiheverwaltung = (Ausleiheverwaltung)singleton.getVerwaltung("Ausleihe");
        Kategorienverwaltung kategorienverwaltung = (Kategorienverwaltung)singleton.getVerwaltung("Kategorien");
        Genreverwaltung genreverwaltung = (Genreverwaltung)singleton.getVerwaltung("Genre");
        Historyverwaltung historyverwaltung = (Historyverwaltung)singleton.getVerwaltung("History");
        
        //Accountverwaltung accountverwaltung = new Accountverwaltung(new AccountDAO());
        //Medienverwaltung medienverwaltung = new Medienverwaltung(new MedienDAO());
        //Ausleiheverwaltung ausleiheverwaltung = new Ausleiheverwaltung(new AusleiheDAO());
        //Kategorienverwaltung kategorienverwaltung = new Kategorienverwaltung(new KategorieDAO());
        //Genreverwaltung genreverwaltung = new Genreverwaltung(new GenreDAO());
        //Historyverwaltung historyverwaltung = new Historyverwaltung(new HistoryDAO());
        
        Controller controller = new Controller(accountverwaltung, medienverwaltung,ausleiheverwaltung, kategorienverwaltung,genreverwaltung, historyverwaltung);
        
    }
}
