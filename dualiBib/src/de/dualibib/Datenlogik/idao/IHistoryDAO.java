/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    List<History> laden() throws IOException, ConnectionError;
    void speichern(List<History> historyListe)  throws IOException, ConnectionError;
    //void update(List<History> historyListe) throws IOException, ConnectionError;
}
