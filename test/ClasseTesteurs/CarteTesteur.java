/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseTesteurs;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Classe.Carte;

/**
 *
 * @author Felix
 */
public class CarteTesteur {
    Carte m_carte;
    
    public CarteTesteur() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        m_carte = new Carte();
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    public void instancierCarte() {
        //ass
    }
}