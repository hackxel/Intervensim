/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.util.List;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Point2D;

/**
 *
 * @author Joseph
 */
public class Carte {
    ArrayList<Segment> m_listeSegments;
    ArrayList<Noeud> m_listeNoeuds;
    //Liste d'urgence a ajouter ici
    Image m_ImgFond;
    
    public Carte()
    {
        //Instanciation de la carte va initialiser les listes
        
        m_listeNoeuds = new ArrayList();
        m_listeSegments = new ArrayList();
    }
    
    public boolean AjouterNoeud(Point2D.Float p_CoordNoeud)
    {
        boolean ajoutReussi = false;
    
        if(NoeudEstPresent(p_CoordNoeud) == false)
        {
             m_listeNoeuds.add(new Noeud(p_CoordNoeud));
             ajoutReussi = true;
        }
        
        return ajoutReussi;
    }
    /*
    boolean SupprimerNoeud(int p_posX,int p_posY)
    {
        Boolean suppressionReussie = false;
        Noeud noeudASupprimer = ObtenirNoeud(p_posX, p_posY);
        
        if(noeudASupprimer != null)
        {
             m_listeNoeuds.remove(noeudASupprimer);
             
             List<Segment> listeLiens = ObtenirSegmentsRelies(noeudASupprimer);
             
             for(Segment segmentASupprimer:listeLiens)
             {
                 m_listeSegments.remove(segmentASupprimer);
             }
             
             suppressionReussie = true;
        }
        
        return suppressionReussie;
    }
    */
    private double ObtenirDistanceSegment(Noeud p_noeud1, Noeud p_noeud2)
    {
        float deplacementX = p_noeud2.obtenir_posX() - p_noeud1.obtenir_posX();
        float deplacementY = p_noeud2.obtenir_posY() - p_noeud1.obtenir_posY();
        
        return Math.sqrt(Math.pow(deplacementX, 2) + Math.pow(deplacementY, 2));
    }
    
    public boolean NoeudEstPresent(Point2D.Float p_CoordNoeud)
    {
        return ObtenirNoeud(p_CoordNoeud) != null;
    }
    
    private Noeud ObtenirNoeud(Point2D.Float p_CoordNd)
    {
        Noeud noeudTrouve = null;
        int compteurNoeuds = 0;
        Noeud noeudCourant = null;
        
        while(compteurNoeuds < m_listeNoeuds.size() && noeudTrouve == null)
        {
            noeudCourant = m_listeNoeuds.get(compteurNoeuds);
            
            if(noeudCourant.EstMemePosition(p_CoordNd))
            {
                noeudTrouve = noeudCourant;
            }
            
            compteurNoeuds++;
        }
        
        return noeudTrouve;
    }
    
    public boolean AjouterSegment(Point2D.Float CoordNoeud1, Point2D.Float CoordNoeud2)
    {
        boolean ajoutReussi = false;
        
        if(SegmentExiste(CoordNoeud1, CoordNoeud2) == false)
        {
            Noeud noeud1 = ObtenirNoeud(CoordNoeud1);
            Noeud noeud2 = ObtenirNoeud(CoordNoeud2);
            
            if(noeud1 != null && noeud2 != null)
            {
                Segment nouveauSegment = new Segment(noeud1, noeud2);
                
                m_listeSegments.add(nouveauSegment);
            }
        }
        
        return ajoutReussi;
    }
    
    public boolean SegmentExiste(Point2D.Float CoordNoeud1, Point2D.Float CoordNoeud2)
    {
        return ObtenirSegment(CoordNoeud1, CoordNoeud2) != null;
    }
    
    public Segment ObtenirSegment(Point2D.Float CoordNoeud1, Point2D.Float CoordNoeud2)
    {
        Segment segmentTrouve = null;
        int compteurSegments = 0;
        Segment segmentCourant = null;
        
        while(compteurSegments < m_listeSegments.size() && segmentTrouve == null)
        {
            segmentCourant = m_listeSegments.get(compteurSegments);
            
            if(segmentCourant.EstMemePosition(CoordNoeud1,CoordNoeud2))
            {
                segmentTrouve = segmentCourant;
            }
            
            compteurSegments++;
        }
        
        return segmentTrouve;
    }
    
    private List<Segment> ObtenirSegmentsRelies(Noeud p_noeud)
    {
        List<Segment> listeLiens = new ArrayList<>();
        int indexNoeud = m_listeNoeuds.indexOf(p_noeud);
        
        for(Segment segmentCourant:m_listeSegments)            
        {
            /*if(segmentCourant.m_iIndNoeud1 == indexNoeud || segmentCourant.m_iIndNoeud2 == indexNoeud)
            {
                listeLiens.add(segmentCourant);
            }*/
        }
        
        return listeLiens;
    }
    
    public int getNbSommets()
    {
        return m_listeNoeuds.size();
    }
}