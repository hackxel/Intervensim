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
    
    double m_Distance;
    
    //Constructeur
    Segment(Noeud p_Noeud1, Noeud p_Noeud2)
    {
        m_Noeud1 =  p_Noeud1;
        m_Noeud2 = p_Noeud2;
        
        //Calcul de la distance du segment avec pythagore
        m_Distance = Math.pow((double)Math.abs(m_Noeud1.obtenir_posX() - m_Noeud2.obtenir_posX()), 2) + Math.pow((double)Math.abs(m_Noeud1.obtenir_posY() - m_Noeud2.obtenir_posY()), 2);
        m_Distance = Math.sqrt(m_Distance);
    }
    
    //Retourner la distance
    double getDistance()
    {
        return m_Distance;
    }
    
}
