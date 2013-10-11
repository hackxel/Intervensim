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
    int m_iIndNoeud1;
    
    int m_iIndNoeud2;
    
    double m_Distance;
    
    //Constructeur
    Segment(int p_indexNo1, int p_indexNo2)
    {
        
        if((p_indexNo1 >= 0 && p_indexNo2 >= 0) && p_indexNo1 != p_indexNo2)
        {
            m_iIndNoeud1 = p_indexNo1;
            m_iIndNoeud2 = p_indexNo2;
            
            //Calcul de la distance avec pythagore
            m_Distance = Math.pow((double)p_indexNo1, 2) + Math.pow((double)p_indexNo2, 2);
            m_Distance = Math.sqrt(m_Distance);
        }
        
    }
    
    //Retourner la distance
    double getDistance()
    {
        return m_Distance;
    }
    
}
