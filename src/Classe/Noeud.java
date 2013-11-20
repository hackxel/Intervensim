/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.awt.geom.Point2D;

/**
 *
 * @author Joseph
 */
public class Noeud {
    
    Point2D.Float m_Position;
    
    private int distance;
    private boolean visite;
    private Noeud precedent;
   
    //Attributs
     public float obtenir_posX() {
        return m_Position.x;
    }

    public float obtenir_posY() {
        return m_Position.y;
    }
    
    public Point2D.Float obtenir_Position()
    {
        return m_Position;
    }
    
    //Constructeur
    Noeud(Point2D.Float p_CoordNoeud)
    {
        m_Position = p_CoordNoeud;
    }
    
    //Méthodes publique
    boolean EstMemePosition(Point2D.Float p_CoordNoeud)
    {
        return (m_Position.equals(p_CoordNoeud));
    }
    
    public void InitialiserValeursParcours()
    {
        distance = 9999;
        visite = false;
        precedent = null;
    }
    
    public void SetVisite()
    {
        visite = true;
    }
    
    public void RelacheNoeud(int nouvelleDistance, Noeud noeudCourantParcours)
    {
        if(nouvelleDistance < distance)
        {
            distance = nouvelleDistance;
            precedent = noeudCourantParcours;
        }
    }
    
    public int GetDistance()
    {
        return distance;
    }
    
    public Noeud GetPrecedent()
    {
        return precedent;
    }
    
    public boolean DejaVisite()
    {
        return visite;
    }
}
