package de.dualibib.Datenlogik.idao;

import de.dualibib.Datenlogik.dto.Kategorie;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Carina
 */
public interface IKategorieDAO {
    List<Kategorie> laden() throws IOException, ConnectionError;
    void speichern(List<Kategorie> kategorieListe)  throws IOException, ConnectionError;
}
