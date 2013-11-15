/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseTesteur;

import junit.framework.TestCase;
import Classe.Carte;
import java.awt.geom.Point2D;
/**
 *
 * @author Axel
 */
public class CarteTest extends TestCase {
    
    Carte m_Carte;
    
    public CarteTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    // TODO add test methods here. The name must begin with 'test'. For example:
    public void testInstanceCarte() {
        m_Carte = new Carte();
        
        assertEquals(0, m_Carte.getNbSommets());
    }
    
    public void testAjouterNoeud(){
        m_Carte = new Carte();
        Point2D.Float Coord = new Point2D.Float((float)1.12,(float)2.32);
        
        m_Carte.AjouterNoeud(Coord);
        
        Coord = new Point2D.Float(6f,15f);
        
        
        m_Carte.AjouterNoeud(Coord);
        
        assertEquals(2, m_Carte.getNbSommets());
        assertTrue(m_Carte.NoeudEstPresent(Coord));
    }
}
