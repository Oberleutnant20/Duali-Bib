
import de.dualibib.Datenlogik.dao.AccountDAO;
import de.dualibib.Datenlogik.dao.AusleiheDAO;
import de.dualibib.Datenlogik.dao.KategorieDAO;
import de.dualibib.Datenlogik.MedienDAO;
import de.dualibib.Fachlogik.Accountverwaltung.Account;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleihe;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorie;
import de.dualibib.Fachlogik.Medienverwaltung.Medien;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Carina
 */
public class DatenbankTest {

    @Test
    public void accountTest() throws Exception {
        AccountDAO sut = new AccountDAO();
        List<Account> datenListe = new ArrayList<>();
        //hinzufügen
        List<Account> datenbankListe = sut.laden();
        assertTrue(datenListe.equals(datenbankListe));
    }

    @Test
    public void ausleiheTest() throws Exception {
        AusleiheDAO sut = new AusleiheDAO();
        List<Ausleihe> datenListe = new ArrayList<>();
        //hinzufügen
        List<Ausleihe> datenbankListe = sut.laden();
        assertTrue(datenListe.equals(datenbankListe));
    }

    @Test
    public void kategorieTest() throws Exception {
        KategorieDAO sut = new KategorieDAO();
        List<Kategorie> datenListe = new ArrayList<>();
        //hinzufügen
        List<Kategorie> datenbankListe = sut.laden();
        assertTrue(datenListe.equals(datenbankListe));
    }

    @Test
    public void medienTest() throws Exception {
        MedienDAO sut = new MedienDAO();
        List<Medien> datenListe = new ArrayList<>();
        //hinzufügen
        List<Medien> datenbankListe = sut.laden();
        assertTrue(datenListe.equals(datenbankListe));
    }
}
