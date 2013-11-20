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
public class Vehicule {
    private float m_tempsTraitementUrgence;
    Point2D.Float m_Position;
    Noeud m_portAttache;
    
    public Vehicule (Point2D.Float p_point)
    {
        m_Position=p_point;
        m_tempsTraitementUrgence=0;
        m_portAttache=null;
    }
    public void DefinirPortAttache(Noeud p_nouveauPort)
    {
        m_portAttache = p_nouveauPort;
    }
    public void setPosition(Point2D.Float p_point)
    {
        m_Position=p_point;
    }

}
