package de.dualibib.Datenlogik.idao;

import de.dualibib.Datenlogik.dto.Medien;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Carina
 */
public interface IMedienDAO {

    List<Medien> laden() throws IOException, ConnectionError;
    void speichern(List<Medien> medienListe)  throws IOException, ConnectionError;
    void update(List<Medien> medienListe) throws IOException, ConnectionError;
}
