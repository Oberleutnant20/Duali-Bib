/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik;

import de.dualibib.Fachlogik.Accountverwaltung.Account;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Carina
 */
public interface IAccountDAO {
    List<Account> laden() throws IOException;
    void speichern(List<Account> accountListe)  throws IOException;
}
