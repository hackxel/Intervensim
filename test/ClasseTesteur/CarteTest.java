/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasseTesteur;

import junit.framework.TestCase;
import Classe.Carte;
import java.awt.geom.Point2D;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
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
        boolean Retour;
        m_Carte = new Carte();
        
        Point2D.Float Coord = new Point2D.Float((float)1.12,(float)2.32);
        Retour = m_Carte.AjouterNoeud(Coord);
        
        assertTrue(Retour);
        
        Coord = new Point2D.Float(6f,15f);
        Retour = m_Carte.AjouterNoeud(Coord);
        
        assertTrue(Retour);
        assertEquals(2, m_Carte.getNbSommets());
        assertTrue(m_Carte.NoeudEstPresent(Coord));
    }
    
    public void testSupprimerUnNoeud(){
        boolean Retour;
        m_Carte = new Carte();
        
        Point2D.Float Coord1 = new Point2D.Float(1.12f,2.32f);
        m_Carte.AjouterNoeud(Coord1);
        
        Retour = m_Carte.SupprimerNoeud(Coord1);
        
        assertTrue(Retour);
        assertEquals(0, m_Carte.getNbSommets());
        assertFalse(m_Carte.NoeudEstPresent(Coord1));
    }
    
    public void testSupprimerNoeudAvecArc(){
        boolean Retour;
        m_Carte = new Carte();
        
        Point2D.Float Coord1 = new Point2D.Float(1.12f,2.32f);
        Point2D.Float Coord2 = new Point2D.Float(6f,15f);
        Point2D.Float Coord3 = new Point2D.Float(10f,20f);
        
        
        m_Carte.AjouterNoeud(Coord1);
        m_Carte.AjouterNoeud(Coord2);
        m_Carte.AjouterNoeud(Coord3);
        m_Carte.AjouterSegment(Coord1, Coord2);
        m_Carte.AjouterSegment(Coord1, Coord3);
        m_Carte.AjouterSegment(Coord2, Coord3);
        
        Retour = m_Carte.SupprimerNoeud(Coord1);
        
        assertTrue(Retour);
        assertEquals(2, m_Carte.getNbSommets());
        assertFalse(m_Carte.NoeudEstPresent(Coord1));
        assertTrue(m_Carte.NoeudEstPresent(Coord2));
        assertTrue(m_Carte.NoeudEstPresent(Coord3));
        assertFalse(m_Carte.SegmentExiste(Coord2, Coord1));
        assertTrue(m_Carte.SegmentExiste(Coord2, Coord3));
    }
    
    public void testAjouterArc(){
        boolean Retour;
        m_Carte = new Carte();
        
        Point2D.Float Coord1 = new Point2D.Float(1.12f,2.32f);
        Point2D.Float Coord2 = new Point2D.Float(6f,15f);
        
        m_Carte.AjouterNoeud(Coord1);
        m_Carte.AjouterNoeud(Coord2);
        Retour = m_Carte.AjouterSegment(Coord1, Coord2);
        
        assertTrue(Retour);
        assertTrue(m_Carte.SegmentExiste(Coord1, Coord2));
    }
    
    public void testSupprimerArc(){
        boolean Retour;
        m_Carte = new Carte();
        
        Point2D.Float Coord1 = new Point2D.Float(1.12f,2.32f);
        Point2D.Float Coord2 = new Point2D.Float(6f,15f);
        Point2D.Float Coord3 = new Point2D.Float(12f,14f);
        
        m_Carte.AjouterNoeud(Coord1);
        m_Carte.AjouterNoeud(Coord2);
        m_Carte.AjouterNoeud(Coord3);
        
        m_Carte.AjouterSegment(Coord1, Coord2);
        m_Carte.AjouterSegment(Coord3,Coord2);
        m_Carte.AjouterSegment(Coord1, Coord3);
        
        assertTrue(m_Carte.SegmentExiste(Coord1, Coord2));
        assertTrue(m_Carte.SegmentExiste(Coord3, Coord2));
        assertTrue(m_Carte.SegmentExiste(Coord1, Coord3));
        
        Retour = m_Carte.SupprimerSegment(Coord1, Coord2);
        assertTrue(Retour);
        assertFalse(m_Carte.SegmentExiste(Coord1, Coord2));
        
        //noeud a été ajouter dans le sens inversem, mais segment existe
        Retour = m_Carte.SupprimerSegment(Coord3, Coord1);
        assertTrue(Retour);
        assertFalse(m_Carte.SegmentExiste(Coord1, Coord3));
        
    }
}
