package Classe.Controleur;

import java.awt.Graphics;
import java.awt.Point;
import Classe.Simulation;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void AjouterUrgence(Point p_point, double p_TempsDecl)
    {
        m_simulation.AjouterUrgence(p_point, p_TempsDecl);
    }
    
    public void Dessin(Graphics p_graphics,boolean p_affiche)
    {
      try {
          m_simulation.Dessin(p_graphics,p_affiche);
      } catch (IOException ex) {
          Logger.getLogger(Simulateur.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    public void ChangerZoom(float p_nouveauZoom)
    {
        m_simulation.ChangerZoom(p_nouveauZoom);
    }
    public void ChangerFondEcran(String p_pathImage)
    {
        m_simulation.ChangerFondEcran(p_pathImage);
    }
    public void PositionSouris(int p_x,int p_y)
    {
        m_simulation.PositionSouris(p_x,p_y);
    }
    public void Selection(Point p_point,String p_mode)
    {
        m_simulation.Selection(p_point,p_mode);
    }
}
