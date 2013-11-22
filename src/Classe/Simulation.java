/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Axel
 */

public class Simulation {
   
    Carte           m_Carte;
    float           m_Zoom;
    Rectangle.Float m_RectVisible; //Coordonnée du coin en haut à gauche, pour affichage
    int             m_HautPx;
    int             m_LargPx;
    Image           m_image;
    BufferedImage   m_image2;
    float           m_DistanceEntrePts;
    Timer           m_timer;
   public Simulation()
    {
        m_RectVisible=new Rectangle.Float(0, 0, 560, 360);
        m_DistanceEntrePts=20;
        m_Carte = new Carte();
        m_HautPx=360;
        m_LargPx=560;
        m_Zoom = 1.0f;
    }  
    //Méthodes publique
    public void DemarrerSimulation()
    {
       
    }
    public void SupprimerNoeud(Point p_Coordonnee)
    {
        Point2D.Float CoordNoeud;
        
        CoordNoeud = CoordonneeGrillePoint(p_Coordonnee);
        if(m_Carte.NoeudEstPresent(CoordNoeud))
        {
            m_Carte.SupprimerNoeud(CoordNoeud);
        }
    }
    public void SupprimerSegment(Point p_point1,Point p_point2)
    {
        Point2D.Float CoordNoeud1;
        Point2D.Float CoordNoeud2;
    
        CoordNoeud1 = CoordonneeGrillePoint(p_point1);
        CoordNoeud2 = CoordonneeGrillePoint(p_point2);
        
        if(m_Carte.NoeudEstPresent(CoordNoeud1) && m_Carte.NoeudEstPresent(CoordNoeud2))
        {
            m_Carte.SupprimerSegment(CoordNoeud1, CoordNoeud2);
        }
       
    }
    public  void PortAttache(Point p_Coordonnee)
    {
        Point2D.Float CoordNoeud;
        CoordNoeud = CoordonneeGrillePoint(p_Coordonnee);
        if(m_Carte.NoeudEstPresent(CoordNoeud))
        {
           Noeud test=m_Carte.ObtenirNoeud(CoordNoeud);
           m_Carte.m_vehicule.DefinirPortAttache(test);
        }
        else
        {
            m_Carte.AjouterNoeud(CoordNoeud);
            Noeud test=m_Carte.ObtenirNoeud(CoordNoeud);
            m_Carte.m_vehicule.DefinirPortAttache(test);
        }
    }
    public void AjouterRapide(Point p_Coordonnee)
    {
        Point2D.Float CoordNoeud;
        CoordNoeud = CoordonneeGrillePoint(p_Coordonnee);
        m_Carte.AjouterRapide(CoordNoeud);
    }
    public void AjouterNoeud(Point p_Coordonnee)
    {
        Point2D.Float CoordNoeud;
        
        CoordNoeud = CoordonneeGrillePoint(p_Coordonnee);
        
        m_Carte.AjouterNoeud(CoordNoeud);
    }
    
    public void AjouterSegment(Point p_CoordNd1, Point p_CoordNd2)
    {
        
        Point2D.Float CoordNoeud1;
        Point2D.Float CoordNoeud2;
    
        CoordNoeud1 = CoordonneeGrillePoint(p_CoordNd1);
        CoordNoeud2 = CoordonneeGrillePoint(p_CoordNd2);
        
        if(m_Carte.NoeudEstPresent(CoordNoeud1) && m_Carte.NoeudEstPresent(CoordNoeud2))
        {
            m_Carte.AjouterSegment(CoordNoeud1, CoordNoeud2);
        }
    }
    public void Dessin(Graphics p_graphics,boolean p_affiche) throws IOException
    {
        if(m_image!=null)
        {
            
            Graphics2D g = (Graphics2D) p_graphics; 
            g.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,
                                RenderingHints.VALUE_RENDER_QUALITY));
            int w = m_LargPx;
            int h = m_HautPx;
            int imageWidth = m_image.getWidth(null);
            int imageHeight = m_image.getHeight(null);  
            double x = (w - m_Zoom * imageWidth)/2;  
            double y = (h - m_Zoom * imageHeight)/2; 
            AffineTransform at = AffineTransform.getTranslateInstance(x,y);  
            at.scale(m_Zoom, m_Zoom);  
            g.drawImage(m_image, at,null);  
        }
        if (p_affiche)
        {
            AfficherGrille(p_graphics);
        }
        m_Carte.Dessin(p_graphics, m_RectVisible, m_LargPx, m_HautPx);     
    }
    //Méthodes Privées
    Point2D.Float CoordonneeGrillePoint(Point p_Coord)
    {
        Point2D.Float CoordModif = new Point2D.Float();
        
        CoordModif.x = (p_Coord.x * m_RectVisible.width) / m_LargPx + m_RectVisible.x;
        CoordModif.y = (p_Coord.y * m_RectVisible.height) / m_HautPx + m_RectVisible.y;
        //Arrondissement pour la grille mangnétique
        CoordModif.x = ((int)(CoordModif.x / m_DistanceEntrePts + 0.5)) * m_DistanceEntrePts; 
        CoordModif.y = ((int)(CoordModif.y / m_DistanceEntrePts + 0.5)) * m_DistanceEntrePts;
        
        return CoordModif;
    }
   
    public void AfficherGrille(Graphics p_graphics)
    {
        int coordonnee;
        float i;
        p_graphics.setColor(Color.lightGray);
        
        // Affiche les lignes verticales
        for(i = 0.0f; i < m_LargPx; i += m_DistanceEntrePts)
        {
            coordonnee = (int) ((i - m_RectVisible.x) * m_LargPx / m_RectVisible.width);
            p_graphics.drawLine(coordonnee, 0, coordonnee, m_HautPx);
        }
        
        // Affiche les lignes horizontales
        for(i = 0.0f; i < m_HautPx; i += m_DistanceEntrePts)
        {
            coordonnee = (int) ((i - m_RectVisible.y) * m_HautPx / m_RectVisible.height);
            p_graphics.drawLine(0, coordonnee, m_LargPx, coordonnee);
        }
    }
    
    public void ChangerZoom(float p_nouveauZoom)
    {
        m_Zoom = p_nouveauZoom;
        m_RectVisible.width = m_LargPx / m_Zoom;
        m_RectVisible.height = m_HautPx / m_Zoom;
        m_RectVisible.x = (m_LargPx - m_RectVisible.width) / 2.0f;
        m_RectVisible.y = (m_HautPx - m_RectVisible.height) / 2.0f; 
    }
    public void ChangerFondEcran(String p_pathImage) throws IOException
    {
        BufferedImage img = ImageIO.read(getClass().getResource(p_pathImage));   
        m_image= img.getScaledInstance(m_LargPx, m_HautPx, Image.SCALE_SMOOTH);       
    }
}