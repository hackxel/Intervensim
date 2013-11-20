/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
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
    Vehicule m_vehicule;
    int lol;
    
    public Carte()
    {
        //Instanciation de la carte va initialiser les listes
        
        m_listeNoeuds = new ArrayList();
        m_listeSegments = new ArrayList();
        m_vehicule=new Vehicule(new Point2D.Float(50.0f,50.0f));
        lol=0;
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
            m_listeSegments.remove(segCourant);
            Retour = true;
        }
            
        return Retour;
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
    
    private ArrayList<Segment> ObtenirSegmentsRelies(Noeud p_noeud)
    {
        ArrayList<Segment> listeLiens = new ArrayList();
        //Lister les Segments qui ont comme destination/départ p_noeud
        for(Segment segmentCourant:m_listeSegments)
        {
            if(segmentCourant.m_Noeud1 == p_noeud || segmentCourant.m_Noeud2 == p_noeud)
                listeLiens.add(segmentCourant);
        }
        
        return listeLiens;
    }
    
    public int getNbSommets()
    {
        return m_listeNoeuds.size();
    }
    public void Dessin(Graphics p_graphics)
    {
       
        Graphics2D g2 = (Graphics2D)p_graphics;  
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);  
        for(int i=0;i < m_listeNoeuds.size();i++)
        {
           Noeud test=m_listeNoeuds.get(i);
           if(m_vehicule.m_portAttache!=null)
           {
               if (test.EstMemePosition(m_vehicule.m_portAttache.m_Position))
               {
                    java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
                    Image image = toolkit.getImage("C:\\Users\\Charles\\Documents\\NetBeansProjects\\Intervensim\\src\\image\\hospital-icon.png");
                    g2.drawImage(image,(int)test.m_Position.x-12,(int)test.m_Position.y-12, 24, 24, null);
               }
               else
               {
                    g2.setColor(Color.black);
                    g2.fillOval((int)test.m_Position.x-8,(int)test.m_Position.y-8, 16, 16);
               }
           }
           else
           {
                g2.setColor(Color.black);
                g2.fillOval((int)test.m_Position.x-8,(int)test.m_Position.y-8, 16, 16);
           }
        }
        for(int i=0;i < m_listeSegments.size();i++)
        {
           Segment test = m_listeSegments.get(i);
           g2.setStroke(new BasicStroke(4));
           g2.drawLine((int)test.m_Noeud1.m_Position.x,(int)test.m_Noeud1.m_Position.y, (int)test.m_Noeud2.m_Position.x, (int)test.m_Noeud2.m_Position.y);
        
        }
    } 
}