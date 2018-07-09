package de.dualibib.Datenlogik.idao;

import de.dualibib.Datenlogik.dto.Account;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Carina
 */
public interface IAccountDAO {

    List<Account> laden() throws IOException, ConnectionError;
    void speichern(List<Account> accountListe) throws IOException, ConnectionError;
    void update(List<Account> accountListe) throws IOException, ConnectionError;
}
