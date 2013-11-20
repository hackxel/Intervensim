/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
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
    float           m_DistanceEntrePts;
    Timer           m_timer;
   public Simulation()
    {
        m_RectVisible=new Rectangle.Float(0, 0, 560, 360);
        m_DistanceEntrePts=20;
        m_Carte = new Carte();
        m_HautPx=360;
        m_LargPx=560;
    }  
    //Méthodes publique
    public void DemarrerSimulation()
    {
       
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
    public void Dessin(Graphics p_graphics,boolean p_affiche)
    {
        if (p_affiche)
        {
            AfficherGrille(p_graphics);
        }
        m_Carte.Dessin(p_graphics);
        
    }
    //Méthodes Privées
    Point2D.Float CoordonneeGrillePoint(Point p_Coord)
    {
        Point2D.Float CoordModif = new Point2D.Float();
        
        CoordModif.x = (p_Coord.x * m_RectVisible.width) / m_LargPx;
        CoordModif.y = (p_Coord.y * m_RectVisible.height) / m_HautPx;
        //Arrondissement pour la grille mangnétique
        CoordModif.x = ((int)(CoordModif.x / m_DistanceEntrePts + 0.5)) * m_DistanceEntrePts; 
        CoordModif.y = ((int)(CoordModif.y / m_DistanceEntrePts + 0.5)) * m_DistanceEntrePts;
        
        return CoordModif;
    }
    public void AfficherGrille(Graphics p_graphics)
    {
        
        int lignex=(int) (m_HautPx/m_DistanceEntrePts);
        int ligney=(int) (m_LargPx/m_DistanceEntrePts);
         p_graphics.setColor(Color.lightGray);
        for(int i=0;i<lignex;i++)
        {
            p_graphics.drawLine(0, (int) (i*m_DistanceEntrePts), m_LargPx, (int) (i*m_DistanceEntrePts));
        }
        for(int j=0;j<ligney;j++)
        {
            p_graphics.drawLine((int) (j*m_DistanceEntrePts),0 , (int) (j*m_DistanceEntrePts), m_HautPx);
        }
    }
}
   
