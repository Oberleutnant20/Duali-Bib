
import de.dualibib.Datenlogik.dao.AccountDAO;
import de.dualibib.Datenlogik.dao.AnderemedienDAO;
import de.dualibib.Datenlogik.dao.AusleiheDAO;
import de.dualibib.Datenlogik.dao.GenreDAO;
import de.dualibib.Datenlogik.dao.HistoryDAO;
import de.dualibib.Datenlogik.dao.KategorieDAO;
import de.dualibib.Datenlogik.dao.PrintmedienDAO;
import de.dualibib.Fachlogik.Accountverwaltung.Account;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleihe;
import de.dualibib.Fachlogik.Genreverwaltung.Genre;
import de.dualibib.Fachlogik.Historyverwaltung.History;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorie;
import de.dualibib.Fachlogik.Medienverwaltung.Anderemedien;
import de.dualibib.Fachlogik.Medienverwaltung.Printmedien;
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
        datenListe.add(new Account("admin001", "1f91db1eb1781471c712d1001a21971a01611ab1431601491881da1ed19111c12213e1df1241111ad1f014b1b214c1de1041f61ca1681371621c710318719612113213a1b81cc11a1ea10e1841c11d11c01851d21571a412a14111a13718d1e6", true, 0, "Admin", "Min"));
        //hinzufügen  
        List<Account> datenbankListe = sut.laden();
        boolean equal = true;
        for (int i = 0;i <datenbankListe.size();i++) {
            
            equal = equal && datenbankListe.get(i).getNachname().equals(datenbankListe.get(i).getNachname());
            equal = equal && datenbankListe.get(i).getVorname().equals(datenbankListe.get(i).getVorname());
            equal = equal && datenbankListe.get(i).getPasswort().equals(datenbankListe.get(i).getPasswort());
            equal = equal && (datenbankListe.get(i).getUserid() == datenbankListe.get(i).getUserid());
            equal = equal && datenbankListe.get(i).getUsername().equals(datenbankListe.get(i).getUsername());
            equal = equal && (datenbankListe.get(i).isMitarbeiter() == datenbankListe.get(i).isMitarbeiter());
        }
        assertTrue(equal);
    }

    @Test
    public void ausleiheTest() throws Exception {
        AusleiheDAO sut = new AusleiheDAO();
        List<Ausleihe> datenListe = new ArrayList<>();
        //hinzufügen
        List<Ausleihe> datenbankListe = sut.laden();boolean equal = true;
        for (int i = 0;i <datenbankListe.size();i++) {
            
            equal = equal && datenbankListe.get(i).getDate().equals(datenbankListe.get(i).getDate());
            equal = equal && (datenbankListe.get(i).getId() == datenbankListe.get(i).getMedienid());
            equal = equal && (datenbankListe.get(i).getUserid() == datenbankListe.get(i).getUserid());
            equal = equal && (datenbankListe.get(i).getId() == datenbankListe.get(i).getId());
            equal = equal && (datenbankListe.get(i).getKategorieid() == datenbankListe.get(i).getKategorieid());
        }
        assertTrue(equal);
    }

    @Test
    public void kategorieTest() throws Exception {
        KategorieDAO sut = new KategorieDAO();
        List<Kategorie> datenListe = new ArrayList<>();
        //hinzufügen
        List<Kategorie> datenbankListe = sut.laden();boolean equal = true;
        for (int i = 0;i <datenbankListe.size();i++) {
            
            equal = equal && datenbankListe.get(i).getBezeichnung().equals(datenbankListe.get(i).getBezeichnung());
            equal = equal && (datenbankListe.get(i).getId() == datenbankListe.get(i).getId());
            equal = equal && datenbankListe.get(i).getName().equals(datenbankListe.get(i).getName());
        }
        assertTrue(equal);
    }
    
    @Test
    public void historyTest() throws Exception {
        HistoryDAO sut = new HistoryDAO();
        List<History> datenListe = new ArrayList<>();
        //hinzufügen
        List<History> datenbankListe = sut.laden();boolean equal = true;
        for (int i = 0;i <datenbankListe.size();i++) {
            
            equal = equal && (datenbankListe.get(i).getId() == datenbankListe.get(i).getId());
            equal = equal && (datenbankListe.get(i).getMedienid() == datenbankListe.get(i).getMedienid());
            equal = equal && (datenbankListe.get(i).getKategorieid() == datenbankListe.get(i).getKategorieid());
            equal = equal && (datenbankListe.get(i).getUserid() == datenbankListe.get(i).getUserid());
        }
        assertTrue(equal);
    }

    @Test
    public void genreTest() throws Exception {
        GenreDAO sut = new GenreDAO();
        List<Genre> datenListe = new ArrayList<>();
        //hinzufügen
        List<Genre> datenbankListe = sut.laden();boolean equal = true;
        for (int i = 0;i <datenbankListe.size();i++) {
            
            equal = equal && datenbankListe.get(i).getBezeichnung().equals(datenbankListe.get(i).getBezeichnung());
            equal = equal && (datenbankListe.get(i).getId() == datenbankListe.get(i).getId());
        }
        assertTrue(equal);
    }
    
    @Test
    public void anderemedienTest() throws Exception {
        AnderemedienDAO sut = new AnderemedienDAO();
        List<Anderemedien> datenListe = new ArrayList<>();
        //hinzufügen
        List<Anderemedien> datenbankListe = sut.laden();boolean equal = true;
        for (int i = 0;i <datenbankListe.size();i++) {
                       
            equal = equal && (datenbankListe.get(i).getBarcodenummer() == datenbankListe.get(i).getBarcodenummer());
            equal = equal && datenbankListe.get(i).getGenre().equals(datenbankListe.get(i).getGenre());
            equal = equal && datenbankListe.get(i).getKategorien().equals(datenbankListe.get(i).getKategorien());
            equal = equal && datenbankListe.get(i).getName().equals(datenbankListe.get(i).getName());
            equal = equal && (datenbankListe.get(i).isAusgeliehen() == datenbankListe.get(i).isAusgeliehen());
            equal = equal && (datenbankListe.get(i).isVorgemerkt() == datenbankListe.get(i).isVorgemerkt());
            equal = equal && (datenbankListe.get(i).getId() == datenbankListe.get(i).getId());
        }
        assertTrue(equal);
    }
    
    @Test
    public void printmedienTest() throws Exception {
        PrintmedienDAO sut = new PrintmedienDAO();
        List<Printmedien> datenListe = new ArrayList<>();
        //hinzufügen
        List<Printmedien> datenbankListe = sut.laden();boolean equal = true;
        for (int i = 0;i <datenbankListe.size();i++) {
            
            equal = equal && (datenbankListe.get(i).getBarcodenummer() == datenbankListe.get(i).getBarcodenummer());
            equal = equal && datenbankListe.get(i).getGenre().equals(datenbankListe.get(i).getGenre());
            equal = equal && datenbankListe.get(i).getKategorien().equals(datenbankListe.get(i).getKategorien());
            equal = equal && datenbankListe.get(i).getName().equals(datenbankListe.get(i).getName());
            equal = equal && datenbankListe.get(i).getIsbn().equals(datenbankListe.get(i).getIsbn());
            equal = equal && (datenbankListe.get(i).isAusgeliehen() == datenbankListe.get(i).isAusgeliehen());
            equal = equal && (datenbankListe.get(i).isVorgemerkt() == datenbankListe.get(i).isVorgemerkt());
            equal = equal && (datenbankListe.get(i).getId() == datenbankListe.get(i).getId());
        }
        assertTrue(equal);
    }

}
