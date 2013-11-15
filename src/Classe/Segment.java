/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

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
    double getDistance()
    {
        double distance = Math.pow((double)Math.abs(m_Noeud1.obtenir_posX() - m_Noeud2.obtenir_posX()), 2) + Math.pow((double)Math.abs(m_Noeud1.obtenir_posY() - m_Noeud2.obtenir_posY()), 2);
        return Math.sqrt(distance);
    }
    
}
