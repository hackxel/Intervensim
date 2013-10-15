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
    private int m_posX;
    
    private int m_posY;

    public int obtenir_posX() {
        return m_posX;
    }

    public int obtenir_posY() {
        return m_posY;
    }
    
    //Constructeur
    Noeud(int p_posX, int p_posY)
    {
        m_posX = p_posX;
        m_posY = p_posY;
    }
    
    boolean EstMemePosition(int p_posX, int p_posY)
    {
        return (m_posX == p_posX && m_posY == p_posY);
    }
}
