/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.idao;

import de.dualibib.Fachlogik.Medienverwaltung.Medien;
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
