/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik;

import de.dualibib.Fachlogik.Accountverwaltung.Account;
import de.dualibib.Fachlogik.Accountverwaltung.Accountverwaltung;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleihe;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleiheverwaltung;
import de.dualibib.Fachlogik.Genreverwaltung.Genreverwaltung;
import de.dualibib.Fachlogik.Historyverwaltung.History;
import de.dualibib.Fachlogik.Historyverwaltung.Historyverwaltung;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorienverwaltung;
import de.dualibib.Fachlogik.Medienverwaltung.Medien;
import de.dualibib.Fachlogik.Medienverwaltung.Medienverwaltung;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import static org.junit.Assert.*;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Carina
 */
public class ControllerTest {
    
    
    @Mock
    Accountverwaltung accountverwaltung;
    @Mock
    Medienverwaltung medienverwaltung;
    @Mock
    Ausleiheverwaltung ausleiheverwaltung;
    @Mock
    Kategorienverwaltung kategorienverwaltung;
    @Mock
    Genreverwaltung genreverwaltung;
    @Mock
    Historyverwaltung historyverwaltung;
    Controller sut;
    
    public ControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        sut = new Controller(accountverwaltung, medienverwaltung, ausleiheverwaltung, kategorienverwaltung, genreverwaltung, historyverwaltung);
    }
    
    @After
    public void tearDown() {
    }

    

    /**
     * Test of setAktuellerUser method, of class Controller.
     */
    @Test
    public void testSetAktuellerUser() {
        System.out.println("setAktuellerUser");
        String accountname = "";
        String passwort = "";
        Controller instance = null;
        Account expResult = null;
        Account result = instance.setAktuellerUser(accountname, passwort);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveDB method, of class Controller.
     */
    @Test
    public void testSaveDB() throws Exception {
        System.out.println("saveDB");
        Controller instance = null;
        instance.saveDB();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /*
    start - werden methoden aufgerufen?
setaktuelleuser matchingccount - stubben
ladeUserdaten - prüfen ob listen da sind
matchinguser
ladeHistory
ladeAusleihe
savedb - methodenaufruf
ausleiheprüfen -methodenaufruf
    */
}