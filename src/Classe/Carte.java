/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Joseph
 */
public class Carte {
    List<Noeud> m_listeNoeuds = new ArrayList<>();
    List<Segment> m_listeSegments = new ArrayList<>();
    
    boolean AjouterNoeud(int p_posX,int p_posY)
    {
        Boolean ajoutReussi = false;
        
        if(NoeudEstPresent(p_posX, p_posY) == false)
        {
             m_listeNoeuds.add(new Noeud(p_posX, p_posY));
             ajoutReussi = true;
        }
        
        return ajoutReussi;
    }
    
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
    
    double ObtenirDistanceSegment(Noeud p_noeud1, Noeud p_noeud2)
    {
        int deplacementX = p_noeud2.obtenir_posX() - p_noeud1.obtenir_posX();
        int deplacementY = p_noeud2.obtenir_posY() - p_noeud1.obtenir_posY();
        
        return Math.sqrt(Math.pow(deplacementX, 2) + Math.pow(deplacementY, 2));
    }
    
    boolean NoeudEstPresent(int p_posX,int p_posY)
    {
        boolean estPresent = false;
        int compteurNoeuds = 0;
        Noeud noeudCourant;
        
        while(compteurNoeuds < m_listeNoeuds.size() && estPresent == false)
        {
            noeudCourant = m_listeNoeuds.get(compteurNoeuds);
            
            if(noeudCourant.EstMemePosition(p_posX, p_posY))
            {
                estPresent = true;
            }
            
            compteurNoeuds++;
        }
        
        return estPresent;
    }
    
    Noeud ObtenirNoeud(int p_posX,int p_posY)
    {
        Noeud noeudTrouve = null;
        int compteurNoeuds = 0;
        Noeud noeudCourant = null;
        
        while(compteurNoeuds < m_listeNoeuds.size() && noeudTrouve == null)
        {
            noeudCourant = m_listeNoeuds.get(compteurNoeuds);
            
            if(noeudCourant.EstMemePosition(p_posX, p_posY))
            {
                noeudTrouve = noeudCourant;
            }
            
            compteurNoeuds++;
        }
        
        return noeudCourant;
    }
    
    List<Segment> ObtenirSegmentsRelies(Noeud p_noeud)
    {
        List<Segment> listeLiens = new ArrayList<>();
        int indexNoeud = m_listeNoeuds.indexOf(p_noeud);
        
        for(Segment segmentCourant:m_listeSegments)            
        {
            if(segmentCourant.m_iIndNoeud1 == indexNoeud || segmentCourant.m_iIndNoeud2 == indexNoeud)
            {
                listeLiens.add(segmentCourant);
            }
        }
        
        return listeLiens;
    }
}