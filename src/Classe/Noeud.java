/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 *
 * @author Joseph
 */
public class Noeud {
    
    Point2D.Float m_Position;
    
    private double distance;
    private boolean visite;
    private Noeud precedent;
   
    private ArrayList<Segment> segmentsAdjacents;
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
        segmentsAdjacents = new ArrayList<Segment>();
    }
    
    //Méthodes publique
    boolean EstMemePosition(Point2D.Float p_CoordNoeud)
    {
        return (m_Position.equals(p_CoordNoeud));
    }
    
    public void AjouterSegment(Segment segmentAAjouter)
    {
        if(segmentsAdjacents.contains(segmentAAjouter) == false)
        {
            segmentsAdjacents.add(segmentAAjouter);
        }        
    }
    
    public void SupprimerSegment(Segment segmentASupprimer)
    {
        if(segmentsAdjacents.contains(segmentASupprimer) == true)
        {
            segmentsAdjacents.remove(segmentASupprimer);
        }
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
    
    public void RelacheNoeud(Noeud noeudCourantParcours)
    {
        double nouvelleDistance = GetDistance(noeudCourantParcours);
        
        if(nouvelleDistance < distance)
        {
            distance = nouvelleDistance;
            precedent = noeudCourantParcours;
        }
    }
    
    public double GetDistance()
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
    
    public ArrayList<Noeud> ObtenirNoeudsAdjacents()
    {
        ArrayList<Noeud> listeNoeudsAdjacents = new ArrayList<>();
        
        for(Segment unSegment: segmentsAdjacents)
        {
            if(unSegment.m_Noeud1 == this)
            {
                listeNoeudsAdjacents.add(unSegment.m_Noeud2);
            }
            else
            {
                listeNoeudsAdjacents.add(unSegment.m_Noeud1);
            }
        }
        
        return listeNoeudsAdjacents;
    }
    
    private double GetDistance(Noeud noeudAdjacent)
    {
        double distance = 9999;
        
        for(Segment segmentCourant: segmentsAdjacents)
        {
            if(segmentCourant.EstMemePosition(obtenir_Position(), noeudAdjacent.obtenir_Position()))
            {
                distance = segmentCourant.getDistance();
            }
        }
        
        return distance;
    }
}
