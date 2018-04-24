/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik;

import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorie;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Carina
 */
public interface IKategorieDAO {
    List<Kategorie> laden() throws IOException;
    void speichern(List<Kategorie> kategorieListe)  throws IOException;
}