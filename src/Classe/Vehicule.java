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
    
    public void DefinirPortAttache(Noeud p_nouveauPort)
    {
        m_portAttache = p_nouveauPort;
    }
}
