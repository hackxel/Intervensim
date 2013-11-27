/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.geom.Point2D;
import javax.swing.ImageIcon;

/**
 *
 * @author Joseph
 */
public class Carte {
    ArrayList<Segment> m_listeSegments;
    ArrayList<Noeud> m_listeNoeuds;
    //Liste d'urgence a ajouter ici
    Image m_ImgFond;
    Vehicule m_vehicule;
    Noeud m_noeudRapide;
    
    public Carte()
    {
        //Instanciation de la carte va initialiser les listes
        
        m_listeNoeuds = new ArrayList();
        m_listeSegments = new ArrayList();
        m_vehicule=new Vehicule(new Point2D.Float(50.0f,50.0f));
        m_noeudRapide=null;
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
    
    public boolean AjouterUrgence(Point2D.Float p_CoordUrg, double p_TempsDeclenchement)
    {
        boolean ajoutReussi = false;
        
        Noeud ndCourant = ObtenirNoeud(p_CoordUrg);
        //Vérifier si le Noeud existe et temps de déclenchement, *impossible ajouter urg sur port attache
        if(ndCourant != null && p_TempsDeclenchement >= 0 && (m_vehicule.m_portAttache == null || !ndCourant.EstMemePosition(m_vehicule.m_portAttache.obtenir_Position()) ))
        {
            ndCourant.AjouterUrgence(p_TempsDeclenchement);
            ajoutReussi = true;    
        }
        
        return ajoutReussi;
    }
    
    public boolean SupprimerUrgence(Point2D.Float p_CoordUrg)
    {
        boolean suppressionReussie = false;
        
        Noeud ndCourant = ObtenirNoeud(p_CoordUrg);
        if(ndCourant != null && (m_vehicule.m_portAttache == null || !ndCourant.EstMemePosition(m_vehicule.m_portAttache.obtenir_Position())))
        {
            suppressionReussie = ndCourant.SupprimerUrgence(); 
        }
        
        return suppressionReussie;
    }
    
    public boolean SupprimerNoeud(Point2D.Float p_CoordNd)
    {
        Boolean suppressionReussie = false;
        Noeud noeudASupprimer = ObtenirNoeud(p_CoordNd);
        
        if(noeudASupprimer != null)
        {
             //Trouver la liste des Segments reliés au Noeud
             ArrayList<Segment> listeLiens = ObtenirSegmentsRelies(noeudASupprimer);
             
             //Enlever les segments de la liste de Segment
             m_listeSegments.removeAll(listeLiens);
             
             //Enlever le Noeud
             m_listeNoeuds.remove(noeudASupprimer);
             
             suppressionReussie = true;
        }
        
        return suppressionReussie;
    }
    
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
    
    public Noeud ObtenirNoeud(Point2D.Float p_CoordNd)
    {
        Noeud noeudTrouve = null;
        int compteurNoeuds = 0;
        Noeud noeudCourant ;
        
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
                noeud1.AjouterSegment(nouveauSegment);
                noeud2.AjouterSegment(nouveauSegment);
                m_listeSegments.add(nouveauSegment);
                ajoutReussi = true;
            }
        }
        
        return ajoutReussi;
    }
    
    public boolean SupprimerSegment(Point2D.Float p_CoordNoeud1, Point2D.Float p_CoordNoeud2)
    {
        boolean Retour = false;
        Segment segCourant = ObtenirSegment(p_CoordNoeud1, p_CoordNoeud2);
        if(segCourant != null)
        {
            //Supprimer les référence dans chaque noeud
            segCourant.SupprimerRefSegNd();
            //Supprimer le segment de la liste 
            m_listeSegments.remove(segCourant);
            Retour = true;
        } 
        return Retour;
    }
    
    public boolean SegmentExiste(Point2D.Float CoordNoeud1, Point2D.Float CoordNoeud2)
    {
        return ObtenirSegment(CoordNoeud1, CoordNoeud2) != null;
    }
    public boolean AjouterRapide(Point2D.Float CoordNoeud)
    {
        boolean ajoutExistant=true;
       /* Noeud noeudCourt;
        boolean Retour = false;
        if(!NoeudEstPresent(CoordNoeud))
        {
            AjouterNoeud(CoordNoeud);
            Retour=true;
            for(int i=0;i < m_listeNoeuds.size();i++)
            {
                noeudCourt=m_listeNoeuds.get(i);
                AjouterSegment(CoordNoeud, noeudCourt.m_Position);
                if(!SegmentExiste(CoordNoeud,  noeudCourt.m_Position))
                {
                    Retour=false;
                }
            }
        } 
        return Retour;*/
         
        Noeud noeudCourt;
        boolean Retour = true;
       
        if(!NoeudEstPresent(CoordNoeud))
        {
            ajoutExistant=false;
            AjouterNoeud(CoordNoeud);
        }

        if(m_listeNoeuds.size()>1)
        {
            if(ajoutExistant)
            {
                noeudCourt=m_listeNoeuds.get(m_listeNoeuds.size()-1);
                m_noeudRapide=ObtenirNoeud(CoordNoeud);
            }
            else
            {
                if(m_noeudRapide!=null)
                {
                    noeudCourt=m_noeudRapide;
                    m_noeudRapide=null;
                }
                else
                {
                    noeudCourt=m_listeNoeuds.get(m_listeNoeuds.size()-2);
                }
            }
            AjouterSegment(CoordNoeud,noeudCourt.m_Position);
            if(!SegmentExiste(CoordNoeud,  noeudCourt.m_Position))
            {
                Retour=false;
            }
        }
        return Retour;
    }
    public boolean DeplacerNoeud(Point2D.Float p_CoordNoeud,Point2D.Float p_nouvCoordNoeud)
    {
        if(NoeudEstPresent(p_CoordNoeud))
        {
            Noeud noeudCourt=ObtenirNoeud(p_CoordNoeud);
            noeudCourt.definir_position(p_nouvCoordNoeud);
            if(noeudCourt.obtenir_Position().equals(p_nouvCoordNoeud))
            {
                return true;
            }
        }
        return false;
    }
    public void TimerTick()
    {
        for(Noeud nd: m_listeNoeuds)
        {
            nd.AvancerTemps();
        }
        m_vehicule.AvancerTemps(m_listeNoeuds,1);
    }
    public Segment ObtenirSegment(Point2D.Float CoordNoeud1, Point2D.Float CoordNoeud2)
    {
        Segment segmentTrouve = null;
        int compteurSegments = 0;
        Segment segmentCourant;
        
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
    
    private ArrayList<Segment> ObtenirSegmentsRelies(Noeud p_noeud)
    {
        ArrayList<Segment> listeLiens = new ArrayList();
        //Lister les Segments qui ont comme destination/départ p_noeud
        for(Segment segmentCourant:m_listeSegments)
        {
            if(segmentCourant.m_Noeud1 == p_noeud || segmentCourant.m_Noeud2 == p_noeud)
            {
                listeLiens.add(segmentCourant);
            }
        }
        return listeLiens;
    }
    
    public int getNbSommets()
    {
        return m_listeNoeuds.size();
    }
    public void Dessin(Graphics p_graphics, Rectangle.Float p_rectVisible, int p_largPix, int p_hautPix)
    {
        Point ptAffiche1, ptAffiche2;
        Image img;
        Graphics2D g2 = (Graphics2D)p_graphics;  
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.black);
        
        for(int i=0;i < m_listeSegments.size();i++)
        {
            Segment test = m_listeSegments.get(i);
            g2.setStroke(new BasicStroke(4));
            ptAffiche1 = new Point((int)((test.m_Noeud1.m_Position.x - p_rectVisible.x) * p_largPix / p_rectVisible.width), (int)((test.m_Noeud1.m_Position.y - p_rectVisible.y) * p_hautPix / p_rectVisible.height));
            ptAffiche2 = new Point((int)((test.m_Noeud2.m_Position.x - p_rectVisible.x) * p_largPix / p_rectVisible.width), (int)((test.m_Noeud2.m_Position.y - p_rectVisible.y) * p_hautPix / p_rectVisible.height));
            g2.drawLine(ptAffiche1.x, ptAffiche1.y, ptAffiche2.x, ptAffiche2.y);
        
        }
        for(int i=0;i < m_listeNoeuds.size();i++)
        {
            Noeud ndCourant =m_listeNoeuds.get(i);
            ptAffiche1 = new Point((int)((ndCourant.m_Position.x - p_rectVisible.x) * p_largPix / p_rectVisible.width), (int)((ndCourant.m_Position.y - p_rectVisible.y) * p_hautPix / p_rectVisible.height));
           
            if(m_vehicule.m_portAttache!=null && ndCourant.EstMemePosition(m_vehicule.m_portAttache.m_Position))
            {
                 img = new ImageIcon(getClass().getResource("/image/hospital-icon2.png")).getImage();
                 g2.drawImage(img, ptAffiche1.x-12, ptAffiche1.y-12, 24, 24, null);
            }
            else
            {
                if(ndCourant.ContientUrgenceDeclencheeNonTraitee())
                {
                    img = new ImageIcon(getClass().getResource("/image/emergency.png")).getImage();
                    g2.drawImage(img, ptAffiche1.x-12, ptAffiche1.y-12, 24, 24, null);
                }
                else
                {
                     g2.fillOval(ptAffiche1.x-8, ptAffiche1.y-8, 16, 16);
                }
            }
        }
        //Dessin du véhicule
        if(m_vehicule.m_portAttache != null)
        {
            ptAffiche1 = new Point((int)((m_vehicule.m_Position.x - p_rectVisible.x) * p_largPix / p_rectVisible.width), (int)((m_vehicule.m_Position.y - p_rectVisible.y) * p_hautPix / p_rectVisible.height));
            img = new ImageIcon(getClass().getResource("/image/Medicine-Ambulance-icon.png")).getImage();
            g2.drawImage(img, ptAffiche1.x-12, ptAffiche1.y-12, 24, 24, null);
        }
       
    }
    
    public Statistiques ObtenirStatistiques()
    {
        Statistiques donneesStatistiques = new Statistiques();
        
        for(Noeud unNoeud: m_listeNoeuds)
        {
            donneesStatistiques = unNoeud.ObtenirTempsMoyenTraitementUrgence(donneesStatistiques);
        }
        
        donneesStatistiques.DefinirDistanceParcourue(m_vehicule.ObtenirDistanceParcourue());
        
        return donneesStatistiques;
    }
    
    public void DefinirStrategieAttente(int codeStrategie)
    {
        m_vehicule.DefinirStrategieAttente(codeStrategie);
    }
    
    public void DefinirStrategieTraitement(int codeStrategie)
    {
        m_vehicule.DefinirStrategieTraitement(codeStrategie);
    }
    
    public void Reinitialiser()
    {
        for(Noeud unNoeud: m_listeNoeuds)
        {
            unNoeud.Reinitialiser();
        }
        
        m_vehicule.Reinitialiser();
    }
}
