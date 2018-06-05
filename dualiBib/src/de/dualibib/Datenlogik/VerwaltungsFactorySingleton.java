/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik;

import de.dualibib.Datenlogik.dao.AccountDAO;
import de.dualibib.Datenlogik.dao.AusleiheDAO;
import de.dualibib.Datenlogik.dao.GenreDAO;
import de.dualibib.Datenlogik.dao.HistoryDAO;
import de.dualibib.Datenlogik.dao.KategorieDAO;
import de.dualibib.Datenlogik.dao.MedienDAO;
import de.dualibib.Fachlogik.Accountverwaltung.Accountverwaltung;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleiheverwaltung;
import de.dualibib.Fachlogik.ElternVerwaltung;
import de.dualibib.Fachlogik.Genreverwaltung.Genreverwaltung;
import de.dualibib.Fachlogik.Historyverwaltung.Historyverwaltung;
import de.dualibib.Fachlogik.Medienverwaltung.Medienverwaltung;

/**
 *
 * @author Carina
 */
class VerwaltungsFactorySingleton {
    //create an object of SingleObject
   private static VerwaltungsFactorySingleton instance = new VerwaltungsFactorySingleton();

   //make the constructor private so that this class cannot be
   //instantiated
   private VerwaltungsFactorySingleton(){}

   //Get the only object available
   public static VerwaltungsFactorySingleton getInstance(){
      return instance;
   }

   public ElternVerwaltung getVerwaltung(String art){
      DAOFactorySingleton singleton = DAOFactorySingleton.getInstance();
       switch (art){
          case "Account" :
              AccountDAO dao = (AccountDAO)singleton.getDAO("Account");
              return new Accountverwaltung(dao);
          case "Medien" :
              MedienDAO dao = (MedienDAO)singleton.getDAO("Medien");
              return new Medienverwaltung(dao);
          case "Ausleihe" :
              AusleiheDAO dao = (AusleiheDAO)singleton.getDAO("Ausleihe");
              return new Ausleiheverwaltung(dao);
          case "Kategorien" :
              KategorieDAO dao = (KategorieDAO)singleton.getDAO("Kategorien");
              return new Kategorieverwaltung(dao);
          case "Genre" :
              GenreDAO dao = (GenreDAO)singleton.getDAO("Genre");
              return new Genreverwaltung(dao);
          case "History" :
              HistoryDAO dao = (HistoryDAO)singleton.getDAO("History");
              return new Historyverwaltung(dao);
          default:return null;
              
      }
   }
}
