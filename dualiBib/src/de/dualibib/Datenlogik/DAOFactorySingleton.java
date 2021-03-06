package de.dualibib.Datenlogik;

import de.dualibib.Datenlogik.dao.AccountDAO;
import de.dualibib.Datenlogik.dao.AusleiheDAO;
import de.dualibib.Datenlogik.dao.ElternDAO;
import de.dualibib.Datenlogik.dao.GenreDAO;
import de.dualibib.Datenlogik.dao.HistoryDAO;
import de.dualibib.Datenlogik.dao.KategorieDAO;
import de.dualibib.Datenlogik.dao.MedienDAO;

/**
 *
 * @author Carina
 */
public final class DAOFactorySingleton {

    //create an object of SingleObject
    private static final DAOFactorySingleton INSTANCE = new DAOFactorySingleton();

    /**
     *
     * @return eine Instanz von DAOFactorySingleton
     */
    public static DAOFactorySingleton getInstance() {
        return INSTANCE;
    }

    /**
     * ElternDAO welche das richtige DAO zurück gibt.
     *
     * @param art Was für ein DAO Benötigt wird
     * @return richtiges DAO
     */
    public ElternDAO getDAO(String art) {
        switch (art) {
            case "Account":
                return new AccountDAO();
            case "Medien":
                return new MedienDAO();
            case "Ausleihe":
                return new AusleiheDAO();
            case "Kategorien":
                return new KategorieDAO();
            case "Genre":
                return new GenreDAO();
            case "History":
                return new HistoryDAO();
            default:
                return null;
        }
    }
}
