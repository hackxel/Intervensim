package intervensim;

import java.awt.Graphics;
import java.awt.Point;
import Classe.Simulation;

/**
 *
 * @author Charles
 */
public class Simulateur {

    /**
     * @param args the command line arguments
     */
  Simulation m_simulation;
    
    public Simulateur()
    {
        m_simulation= new Simulation();
    }
    public void PortAttache(Point p_point)
    {
        m_simulation.PortAttache(p_point);
    }
    public void SupprimerNoeud(Point p_point)
    {
        m_simulation.SupprimerNoeud(p_point);
    }
    public void SupprimerSegment(Point p_point1,Point p_point2)
    {
        m_simulation.SupprimerSegment(p_point1, p_point2);
    }
    public void AjouterNoeud(Point p_point)
    {
        m_simulation.AjouterNoeud(p_point);
        
    }
    public void AjouterRapide(Point p_point)
    {
        m_simulation.AjouterRapide(p_point);
    }
    public  void AjouterSegment(Point p_point1,Point p_point2)
    {
        
        m_simulation.AjouterSegment(p_point1, p_point2);
    }

    public void Dessin(Graphics p_graphics,boolean p_affiche)
    {
        m_simulation.Dessin(p_graphics,p_affiche);
    }
    
    public void ChangerZoom(float p_nouveauZoom)
    {
        m_simulation.ChangerZoom(p_nouveauZoom);
    }
}
