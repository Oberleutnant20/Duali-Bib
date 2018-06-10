/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.idao;

import de.dualibib.Datenlogik.dto.AusleiheDTO;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleihe;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Carina
 */
public interface IAusleiheDAO {
    AusleiheDTO laden() throws IOException, ConnectionError;
    void speichern()  throws IOException, ConnectionError;
    void loeschen () throws IOException, ConnectionError;
}
