/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Fachlogik;

import de.dualibib.Datenlogik.dto.Account;
import de.dualibib.Fachlogik.Accountverwaltung.Accountverwaltung;
import de.dualibib.Fachlogik.Ausleihverwaltung.Ausleiheverwaltung;
import de.dualibib.Fachlogik.Genreverwaltung.Genreverwaltung;
import de.dualibib.Fachlogik.Historyverwaltung.Historyverwaltung;
import de.dualibib.Fachlogik.Kategorieverwaltung.Kategorienverwaltung;
import de.dualibib.Fachlogik.Languageverwaltung.Languageverwaltung;
import de.dualibib.Fachlogik.Medienverwaltung.Medienverwaltung;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Carina
 */
public class ControllerTest {
    
    
    @Mock
    Languageverwaltung languageverwaltung;
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
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        sut = new Controller(languageverwaltung, accountverwaltung, medienverwaltung, ausleiheverwaltung, kategorienverwaltung, genreverwaltung, historyverwaltung);
    }
        
    @Test
    public void testGetAktuellerUser(){
        assertTrue(sut.getAktuellerUser()==null);
    }
    
    @Test
    public void testmatchinguserTrue(){
        //GIVEN
        String pw="blub";
        String user="bloed";
        Account a = new Account(user, pw, true, 0, user, user, 0, user, user, pw);
        ArrayList<Account> liste = new ArrayList<>();
        liste.add(a);
        //WHEN
        Mockito.when(accountverwaltung.get()).thenReturn(liste);
        //THEN
        assertTrue(sut.matchingUser(user, pw)==a);
    }
    
    @Test
    public void testmatchinguserFalse(){
        //GIVEN
        String pw="blub";
        String user="bloed";
        Account a = new Account(user, pw, true, 0, user, user, 0, user, user, pw);
        ArrayList<Account> liste = new ArrayList<>();
        liste.add(a);
        //WHEN
        Mockito.when(accountverwaltung.get()).thenReturn(liste);
        //THEN
        assertFalse(sut.matchingUser("user", "pw")==a);
    }
    
    @Test
    public void testIsMitarbeiter(){
        assertFalse(sut.isMitarbeiter());
    }
    
    @Test
    public void testIsMitarbeiterTrue(){
       //GIVEN
       String pw="BLÄH";
       String user="BLÖH";
       Account a = new Account(user, pw, true, 0, user, user, 0, user, user, pw);
       ArrayList<Account> liste = new ArrayList<>();
       liste.add(a);
       //WHEN
       Mockito.when(accountverwaltung.get()).thenReturn(liste);
       sut.setAktuellerUser(user, pw);
       //THEN
       assertTrue(sut.isMitarbeiter());
    }
    
    @Test
    public void testIsMitarbeiterFalse(){
       //GIVEN
       String pw="BLÄH";
       String user="BLÖH";
       Account a = new Account(user, pw, false, 0, user, user, 0, user, user, pw);
       ArrayList<Account> liste = new ArrayList<>();
       liste.add(a);
       //WHEN
       Mockito.when(accountverwaltung.get()).thenReturn(liste);
       sut.setAktuellerUser(user, pw);
       //THEN
       assertFalse(sut.isMitarbeiter());
    }

    

    
}