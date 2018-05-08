/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik;

import de.dualibib.Fachlogik.Genreverwaltung.Genre;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carina
 */
public class GenreDAO implements IGenreDAO{

    @Override
    public List<Genre> laden() throws IOException {
        return new ArrayList<>(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void speichern(List<Genre> genreListe) throws IOException {
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
