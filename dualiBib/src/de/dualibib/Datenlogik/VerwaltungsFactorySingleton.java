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
import de.dualibib.Fachlogik.Languageverwaltung.Languageverwaltung;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleiheverwaltung;
import de.dualibib.Fachlogik.ElternVerwaltung;
import de.dualibib.Fachlogik.Genreverwaltung.Genreverwaltung;
import de.dualibib.Fachlogik.Historyverwaltung.Historyverwaltung;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorienverwaltung;
import de.dualibib.Fachlogik.Medienverwaltung.Medienverwaltung;

/**
 *
 * @author Carina
 */
public final class VerwaltungsFactorySingleton {
    //create an object of SingleObject
   private static final VerwaltungsFactorySingleton INSTANCE = new VerwaltungsFactorySingleton();

    /**
     * 
     * @return eine einzige Instanz
     */
    public static VerwaltungsFactorySingleton getInstance() {
      return INSTANCE;
   }

   public ElternVerwaltung getVerwaltung(String art){
      DAOFactorySingleton singleton = DAOFactorySingleton.getInstance();
       switch (art) {
          case "Language" :
              return new Languageverwaltung();
          case "Account" :
              AccountDAO accountdao = (AccountDAO) singleton.getDAO("Account");
              return new Accountverwaltung(accountdao);
          case "Medien" :
              MedienDAO mediendao = (MedienDAO) singleton.getDAO("Medien");
              return new Medienverwaltung(mediendao);
          case "Ausleihe" :
              AusleiheDAO ausleihedao = (AusleiheDAO) singleton.getDAO("Ausleihe");
              return new Ausleiheverwaltung(ausleihedao);
          case "Kategorien" :
              KategorieDAO kategoriedao = (KategorieDAO) singleton.getDAO("Kategorien");
              return new Kategorienverwaltung(kategoriedao);
          case "Genre" :
              GenreDAO genredao = (GenreDAO) singleton.getDAO("Genre");
              return new Genreverwaltung(genredao);
          case "History" :
              HistoryDAO historydao = (HistoryDAO) singleton.getDAO("History");
              return new Historyverwaltung(historydao);
          default: return null;

      }
   }

}
