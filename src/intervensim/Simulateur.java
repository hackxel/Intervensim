/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intervensim;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Charles
 */
public class Simulateur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     
        
        GUI.main(args);
     
    }
    public static void AjouterNoeud(Point2D.Float p_point)
    {
        javax.swing.JOptionPane.showMessageDialog(null,p_point.toString()); 
    }
     public  static void AjouterSegment(Point2D.Float p_point1,Point2D.Float p_point2)
    {
        javax.swing.JOptionPane.showMessageDialog(null,p_point1.toString() + " " + p_point2.toString() );
    }
}
