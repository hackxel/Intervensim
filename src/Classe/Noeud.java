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
    private ArrayList<Urgence> listeUrgences;
    
    //Attributs
     public float obtenir_posX() {
        return m_Position.x;
    }

    public float obtenir_posY() {
        return m_Position.y;
    }
    public void definir_position(Point2D.Float p_Position){
        m_Position=p_Position;
    }
    
    public Point2D.Float obtenir_Position()
    {
        return m_Position;
    }
    
    //Constructeur
    Noeud(Point2D.Float p_CoordNoeud)
    {
        m_Position = p_CoordNoeud;
        segmentsAdjacents = new ArrayList<>();
        listeUrgences = new ArrayList<>();
    }
    
    //Méthodes publique
    public boolean EstMemePosition(Point2D.Float p_CoordNoeud)
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
    
    public void AjouterUrgence(double tempsAvantDeclenchement)
    {
        if(ContientUrgenceSelonTempsDeclenchement(tempsAvantDeclenchement) == false)
        {
            listeUrgences.add(new Urgence(tempsAvantDeclenchement));
        }
    }
    
    public boolean ContientUrgenceSelonTempsDeclenchement(double tempsAvantDeclenchement)
    {        
        boolean contientUrgence = false;
        
        int compteur = 0;
        
        while(contientUrgence == false && compteur < listeUrgences.size())
        {
            if(listeUrgences.get(compteur).GetTempsAvantDeclenchement() == tempsAvantDeclenchement)
            {
                contientUrgence = true;
            }
            
            compteur++;
        }
        
        return contientUrgence;
    }
    
    public boolean ContientUrgenceDeclencheeNonTraitee()
    {
        boolean contientUrgence = false;
                
        int compteur = 0;
        
        while(contientUrgence == false && compteur < listeUrgences.size())
        {
            if(listeUrgences.get(compteur).UrgenceEstDeclenchee())
            {
                contientUrgence = true;
            }
            
            compteur++;
        }
        
        return contientUrgence;
    }
    
    public Urgence ObtenirUrgenceCouranteDeclenchee()
    {
        Urgence urgenceCourante = null;
        int compteur = 0;
        
        while(urgenceCourante == null && compteur < listeUrgences.size())
        {
            if(listeUrgences.get(compteur).UrgenceEstTerminee() == false)
            {
                return listeUrgences.get(compteur);
            }
            
            compteur++;
        }
        
        return urgenceCourante;
    }
    
    public void SupprimerUrgence(double tempsAvantDeclenchement)
    {
        
    }
    
    public void InitialiserValeursParcours()
    {
        distance = 9999;
        visite = false;
        precedent = null;
    }
    
    public void SetPointDepart()
    {
        distance = 0;
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
    
    public double GetDistance(Noeud noeudAdjacent)
    {
        double distance = 9999;
        int compteur = 0;
        
        while(distance == 9999 && compteur < segmentsAdjacents.size())
        {
            if(segmentsAdjacents.get(compteur).EstMemePosition(obtenir_Position(), noeudAdjacent.obtenir_Position()))
            {
                distance = segmentsAdjacents.get(compteur).getDistance();
            }
            
            compteur++;
        }
        
        return distance;
    }
    
    public double GetDistance(Point2D.Float p_Point)
    {
        // meh
        double distance = Math.pow(m_Position.x - p_Point.x, 2) + Math.pow(m_Position.y - p_Point.y, 2);
        return Math.sqrt(distance);
    }
    
    public void AvancerTemps()
    {
        for(Urgence urg: listeUrgences)
        {
            urg.AvancerTemps();
        }
    }
}
