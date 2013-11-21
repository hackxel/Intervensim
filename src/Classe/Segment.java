/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.awt.geom.Point2D;

/**
 *
 * @author Axel
 */
public class Segment {
    
    //Attributs
    Noeud m_Noeud1;
    
    Noeud m_Noeud2;
    
    //Constructeur
    Segment(Noeud p_Noeud1, Noeud p_Noeud2)
    {
        m_Noeud1 =  p_Noeud1;
        m_Noeud2 = p_Noeud2;
    }
    
    //Retourner la distance
    public double getDistance()
    {
        double distance = Math.pow((double)Math.abs(m_Noeud1.obtenir_posX() - m_Noeud2.obtenir_posX()), 2) + Math.pow((double)Math.abs(m_Noeud1.obtenir_posY() - m_Noeud2.obtenir_posY()), 2);
        return Math.sqrt(distance);
    }
    
    boolean EstMemePosition(Point2D.Float p_CoordNoeud1, Point2D.Float p_CoordNoeud2)
    {
        return ((p_CoordNoeud1.equals(m_Noeud1.obtenir_Position())) && p_CoordNoeud2.equals(m_Noeud2.obtenir_Position())) ||
                ((p_CoordNoeud2.equals(m_Noeud1.obtenir_Position())) && p_CoordNoeud1.equals(m_Noeud2.obtenir_Position()));
        
        /*return (m_Noeud1.obtenir_Position() == p_CoordNoeud1 && m_Noeud2.obtenir_Position() == p_CoordNoeud2) ||
                (m_Noeud2.obtenir_Position() == p_CoordNoeud2 && m_Noeud1.obtenir_Position() == p_CoordNoeud1);*/
    }
    
}
