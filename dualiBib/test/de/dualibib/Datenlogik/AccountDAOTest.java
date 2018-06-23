/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik;

import de.dualibib.Datenlogik.dao.AccountDAO;
import java.io.IOException;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Carina
 */
public class AccountDAOTest {
    
    AccountDAO sut;
    
    public AccountDAOTest() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        sut = new AccountDAO();
    }
    
    @Test
    public void testLadeDb() throws Exception{
        //GIVEN
        //WHEN
        //THEN
        assertTrue(sut.laden()!=null);
    }
}