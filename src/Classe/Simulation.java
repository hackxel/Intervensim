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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Timer;

/**
 *
 * @author Axel
 */

public class Simulation {
   
    boolean         m_Etat;
    Carte           m_Carte;
    float           m_Zoom;
    Rectangle.Float m_RectVisible; //Coordonnée du coin en haut à gauche, pour affichage
    int             m_HautPx;
    int             m_LargPx;
    Image           m_image;
    int             m_positionSourisX;
    int             m_positionSourisY;
    float           m_DistanceEntrePts;
    Point2D.Float   m_positionNouvSelection;
    Point2D.Float   m_positionSelection;
    Statistiques    m_statistiques;
    int             m_temps;

   public Simulation()
    {
        m_RectVisible=new Rectangle.Float(0, 0, 560, 360);
        m_DistanceEntrePts=20;
        m_Carte = new Carte();
        m_HautPx=360;
        m_LargPx=560;
        m_Zoom = 1.0f;
        m_positionSourisX=0;
        m_positionSourisY=0;
        m_positionSelection=null;
        m_positionNouvSelection=null;
        m_statistiques=null;
        m_Etat = false;
        m_temps = 0;
    }  
    //Méthodes publique
    public void DemarrerSimulation()
    {
       m_Etat = true;
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
        if(!m_Carte.NoeudEstPresent(CoordNoeud))
        {
            m_Carte.AjouterNoeud(CoordNoeud);
        }
        
        Noeud ndCourant = m_Carte.ObtenirNoeud(CoordNoeud);
        m_Carte.m_vehicule.DefinirPortAttache(ndCourant);
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
    
    public void AjouterUrgence(Point p_Coordonnee, double p_TempsDeclenchement)
    {
        Point2D.Float CoordNoeud;
        
        CoordNoeud = CoordonneeGrillePoint(p_Coordonnee);
        
        m_Carte.AjouterUrgence(CoordNoeud, m_temps, m_Etat);
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
          //  g.drawImage(m_image,(int) m_RectVisible.x, (int) m_RectVisible.y, null);
        }
        if (p_affiche)
        {
            AfficherGrille(p_graphics);
        }
        m_Carte.Dessin(p_graphics, m_RectVisible, m_LargPx, m_HautPx);  
         p_graphics.setColor(Color.black);
        p_graphics.drawString("pos:"+String.valueOf(m_positionSourisX) +", " +String.valueOf(m_positionSourisY), 10, 10);
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
    public void TimerTick()
    {
        m_Carte.TimerTick();
        m_temps++;
    }
    public boolean SimulationEstPrete()
    {
        if(m_Carte.m_vehicule.m_portAttache!=null && m_Carte.m_listeNoeuds.size()>1 && m_Carte.m_listeSegments.size() >0)
        {
            return true;
        }
        return false;
    }
    public void ChangerZoom(float p_nouveauZoom)
    {
        m_Zoom = p_nouveauZoom;
        m_RectVisible.width = m_LargPx / m_Zoom;
        m_RectVisible.height = m_HautPx / m_Zoom;
        m_RectVisible.x = (m_LargPx - m_RectVisible.width) / 2.0f;
        m_RectVisible.y = (m_HautPx - m_RectVisible.height) / 2.0f; 
    }
    public void ChangerFondEcran(String p_pathImage)
    {
        BufferedImage img=null;   
        try {
            img = ImageIO.read(getClass().getResource(p_pathImage));
        } catch (IOException ex) {
            Logger.getLogger(Simulation.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(img!=null)
            m_image= img.getScaledInstance(m_LargPx, m_HautPx, Image.SCALE_SMOOTH);       
    }
    public void PositionSouris(int p_x,int p_y)
    {
        m_positionSourisX=p_x;
        m_positionSourisY=p_y;
    }
    private Point SnapBorne(Point p_point)
    {
        if(p_point.y>=m_HautPx-5)
            p_point.y=m_HautPx-5;
        else if (p_point.y<5)
            p_point.y=5;

        if(p_point.x>=m_LargPx-5)
            p_point.x=m_LargPx-5;
        else if (p_point.x<5)
            p_point.x=5;
            
        return p_point;
                      
    }
    public void Selection(Point p_point,String p_mode)
    {
        Point2D.Float CoordNoeud;
        Point2D.Float NouvCoordNoeud;
        switch(p_mode)
        {
             case "Pressed":
                 CoordNoeud = CoordonneeGrillePoint(p_point);
                 if(m_Carte.NoeudEstPresent(CoordNoeud))
                 {
                     m_positionSelection=CoordNoeud;
                     m_positionNouvSelection=CoordNoeud;
                 } 
             break;
             case "Dragged":
                 if(m_positionSelection!=null)
                 {        
                    p_point = SnapBorne(p_point);  
                    NouvCoordNoeud=new Point2D.Float();
                    NouvCoordNoeud.x = (p_point.x * m_RectVisible.width) / m_LargPx + m_RectVisible.x;
                    NouvCoordNoeud.y = (p_point.y * m_RectVisible.height) / m_HautPx + m_RectVisible.y;
                    

                     m_Carte.DeplacerNoeud(m_positionNouvSelection,NouvCoordNoeud);
                     m_positionNouvSelection=NouvCoordNoeud;
                 }
             break;
             case "Released":
                if(m_positionSelection!=null)
                {   
                    p_point=SnapBorne(p_point);
                    NouvCoordNoeud=CoordonneeGrillePoint(p_point);
                  
                    if(m_Carte.NoeudEstPresent(NouvCoordNoeud))
                    {
                        m_Carte.DeplacerNoeud(m_positionNouvSelection,m_positionSelection);
                    }
                    else
                    {
                        m_Carte.DeplacerNoeud(m_positionNouvSelection,NouvCoordNoeud);
                    }
                }
                m_positionSelection=null;
                m_positionNouvSelection=null;
               break;     
        }
    }
    public Statistiques AfficherStatistique()
    {
        return m_Carte.ObtenirStatistiques();
    }
    public void ReinitilialiserSimulation()
    {
        m_temps = 0;
        m_Carte.Reinitialiser();
    }
    public void DefinirStrategieAttente(int p_StrategieAttente)
    {
        m_Carte.DefinirStrategieAttente(p_StrategieAttente);
    }
    public void DefinirStrategieDeplacement(int p_StrategieDeplacement)
    {
        m_Carte.DefinirStrategieTraitement(p_StrategieDeplacement);
    }
    public void DefinirTempsTraimentUrgence(float p_temps)
    {
        m_Carte.m_vehicule.DefinirTempsTraitement(p_temps);
    }
}
