package de.dualibib.Datenlogik.idao;

import de.dualibib.Datenlogik.dto.Ausleihe;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Carina
 */
public interface IAusleiheDAO {
    // TODO - Javadoc?
    List<Ausleihe> laden() throws IOException, ConnectionError;
    void speichern(List<Ausleihe> ausleiheListe)  throws IOException, ConnectionError;
    void loeschen (List<Ausleihe> ausleiheListe) throws IOException, ConnectionError;
}
