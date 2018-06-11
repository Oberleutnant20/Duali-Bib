/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.idao;

import de.dualibib.Datenlogik.dto.KategorieDTO;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;

/**
 *
 * @author Carina
 */
public interface IKategorieDAO {
    KategorieDTO laden() throws IOException, ConnectionError;
    void speichern()  throws IOException, ConnectionError;
    //void update() throws IOException, ConnectionError;
}
