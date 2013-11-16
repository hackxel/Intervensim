/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

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
    Simulation()
    {
        m_Carte = new Carte();
        
    }
    
    
    //Méthodes publique
    
    void AjouterNoeud(Point p_Coordonnee)
    {
        Point2D.Float CoordNoeud = new Point2D.Float();
        
        CoordNoeud = CoordonneeGrillePoint(p_Coordonnee);
        
        m_Carte.AjouterNoeud(CoordNoeud);
    }
    
    void AjouterSegment(Point p_CoordNd1, Point p_CoordNd2)
    {
        
        Point2D.Float CoordNoeud1 = new Point2D.Float();
        Point2D.Float CoordNoeud2 = new Point2D.Float();
    
        CoordNoeud1 = CoordonneeGrillePoint(p_CoordNd1);
        CoordNoeud2 = CoordonneeGrillePoint(p_CoordNd2);
        
        if(m_Carte.NoeudEstPresent(CoordNoeud1) && m_Carte.NoeudEstPresent(CoordNoeud2))
        {
            m_Carte.AjouterSegment(CoordNoeud1, CoordNoeud2);
        }
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
    
}
