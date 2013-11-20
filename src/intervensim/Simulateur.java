package intervensim;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Classe.Simulation;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
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
    public void AjouterNoeud(Point p_point)
    {
        m_simulation.AjouterNoeud(p_point);
        
    }
     public  void AjouterSegment(Point p_point1,Point p_point2)
    {
        
        m_simulation.AjouterSegment(p_point1, p_point2);
    }
     public void Dessin(Graphics p_graphics,boolean p_affiche)
     {
       m_simulation.Dessin(p_graphics,p_affiche);
     }
}
