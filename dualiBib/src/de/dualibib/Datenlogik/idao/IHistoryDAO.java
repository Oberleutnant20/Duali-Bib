package de.dualibib.Datenlogik.idao;

import de.dualibib.Datenlogik.dto.History;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Carina
 */
public interface IHistoryDAO {
    // TODO - Javadoc?
    List<History> laden() throws IOException, ConnectionError;
    void speichern(List<History> historyListe)  throws IOException, ConnectionError;
}
