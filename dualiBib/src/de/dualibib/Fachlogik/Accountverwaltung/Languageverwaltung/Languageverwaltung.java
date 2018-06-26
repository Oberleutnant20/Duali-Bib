package de.dualibib.Fachlogik.Accountverwaltung.Languageverwaltung;

import de.dualibib.Datenlogik.dto.Account;
import de.dualibib.Datenlogik.idao.IAccountDAO;
import de.dualibib.Fachlogik.ElternVerwaltung;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carina
 */
public class Languageverwaltung extends ElternVerwaltung{

    private ArrayList<Account> accountListe;
    private ArrayList<Account> accountListeUpdate;
    private ArrayList<Account> accountListeDelete;
    private ArrayList<Account> accountListeRef;
    private IAccountDAO accountDAO;

    public Languageverwaltung() {
        try {
            Properties props = new Properties();
            FileReader fileReader = new FileReader("C:/temp/props.txt");
            props.load(fileReader);
            System.out.println(props.get("carina"));
        } catch (IOException ex) {
            Logger.getLogger(Languageverwaltung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void laden() {
        accountListe.clear();
        accountListeRef.clear();
        de.dualibib.Logger.debug(this,"laden");
        try {
            List<Account> liste = accountDAO.laden();
            for (Account account : liste) {
                accountListe.add(account);
                accountListeRef.add(account);
        }
        } catch (Exception e) {
    }
    }
    
    public ArrayList<Account> get() {
        ArrayList<Account> liste = new ArrayList<Account>();
        for (Account account : accountListe) {
            liste.add(account);
    }
        return liste;
}
    }
