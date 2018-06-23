/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.UI;

import de.dualibib.Fachlogik.*;
import de.dualibib.Datenlogik.dto.Genre;
import de.dualibib.Datenlogik.dto.History;
import de.dualibib.Datenlogik.dto.Kategorie;
import de.dualibib.Datenlogik.dto.Medien;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Carina
 */
public class PanelHandlerTest {
    
    
    @Mock
    List<Kategorie> kategorieListe;
    @Mock
    Controller controller;
    @Mock
    List<Genre> genreListe;
    PanelHandler sut;
    
    public PanelHandlerTest() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        sut = new PanelHandler(controller, genreListe, kategorieListe);
    }
    
    @Test
    public void testMapHistoryAndMediumTrue(){
        //GIVEN
        Medien medium = new Medien("isbn", 0, 0, 0, "name", 0, 0, "author", "desc");
        History history = new History(0, 0, 0, 0);
        ArrayList<Medien> liste = new ArrayList<>();
        liste.add(medium);
        //WHEN
        Mockito.when(controller.getAllMedien()).thenReturn(liste);
        //THEN
        assertTrue(medium==sut.mapHistoryAndMedium(history));
    }
    @Test
    public void testMapHistoryAndMediumFalse(){
        //GIVEN
        Medien medium = new Medien("isbn", 1, 1, 1, "name", 1, 1, "author", "desc");
        History history = new History(0, 0, 0, 0);
        ArrayList<Medien> liste = new ArrayList<>();
        liste.add(medium);
        //WHEN
        Mockito.when(controller.getAllMedien()).thenReturn(liste);
        //THEN
        assertFalse(medium==sut.mapHistoryAndMedium(history));
    }
}