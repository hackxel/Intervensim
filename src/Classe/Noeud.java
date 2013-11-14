/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

/**
 *
 * @author Joseph
 */
public class Noeud {
    
   //Attributs
    private float m_posX;
    
    private float m_posY;
    
     public float obtenir_posX() {
        return m_posX;
    }

    public float obtenir_posY() {
        return m_posY;
    }
    
    //Constructeur
    Noeud(float p_posX, float p_posY)
    {
        m_posX = p_posX;
        m_posY = p_posY;
    }
    
    boolean EstMemePosition(float p_posX, float p_posY)
    {
        return (m_posX == p_posX && m_posY == p_posY);
    }
}
