/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import Classe.Strategies.SuivreParcoursOptimal;
import Classe.Strategies.AllerNoeudPlusAncien;
import Classe.Strategies.AllerNoeudPlusPret;
import Classe.Strategies.AttendreNoeud;
import Classe.Strategies.AllerPortAttache;
import Classe.Strategies.IStrategieAttente;
import Classe.Strategies.IStrategieTraitement;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 *
 * @author Joseph
 */
public class Vehicule {
    private float m_tempsTraitementUrgence;
    private float m_tempsEcouleSurUrgence;
    
    Noeud m_noeudCourant;
    Noeud m_prochainNoeud;
    Point2D.Float m_Position;
    
    Noeud m_portAttache;
    IStrategieAttente m_strategieAttente;
    IStrategieTraitement m_strategieTraitement;
    
    public Vehicule (Point2D.Float p_point)
    {
        m_Position=p_point;
        m_tempsTraitementUrgence = 0;
        m_portAttache = null;
        m_tempsEcouleSurUrgence = 0;
        
        DefinirStrategieAttente(0);
        DefinirStrategieTraitement(0);
    }
    
    public void DefinirPortAttache(Noeud p_nouveauPort)
    {
        m_portAttache = p_nouveauPort;
    }
    
    public void setPosition(Point2D.Float p_point)
    {
        m_Position=p_point;
    }
    
    public void DefinirTempsTraitement(float nouveauTemps)
    {
        m_tempsTraitementUrgence = nouveauTemps;
    }
    
    public void DefinirStrategieAttente(int indexStrategie)
    {
        if(indexStrategie == 2)
        {
            m_strategieAttente = new AllerPortAttache();
        }
        else
        {
            m_strategieAttente = new AttendreNoeud();
        }
    }
    
    public void DefinirStrategieTraitement(int indexStrategie)
    {
        if(indexStrategie == 2)
        {
            m_strategieTraitement = new AllerNoeudPlusAncien();
        }
        else
        {
            if(indexStrategie == 3)
            {
                m_strategieTraitement = new SuivreParcoursOptimal();
            }
            else
            {
                m_strategieTraitement = new AllerNoeudPlusPret();
            }
        }
    }
    
    public void AvancerTemps(ArrayList<Noeud> systemeRoutier, double vitesse)
    {
        //Verifie si véhicule est sur un noeud
        if(m_noeudCourant.EstMemePosition(m_Position))
        {
            if(m_noeudCourant.ContientUrgenceDeclencheeNonTraitee())
            {
                AvancerTraitementUrgence(vitesse);
            }
            else
            {
                
            }
        }
    }
    
    private void AvancerTraitementUrgence(double vitesse)
    {
        m_tempsEcouleSurUrgence += vitesse;
        
        if(m_tempsEcouleSurUrgence >= m_tempsTraitementUrgence)
        {
            m_tempsEcouleSurUrgence = 0;
            
            Urgence urgenceCourante = m_noeudCourant.ObtenirUrgenceCouranteDeclenchee();
            
            urgenceCourante.DefinirTerminee();
        }
    }
    
    private boolean SystemeContientUrgenceRestante(ArrayList<Noeud> systemeRoutier)
    {
        boolean systemeContientUrgence =  false;
        int compteur = 0;
        
        while(systemeContientUrgence = false && compteur < systemeRoutier.size())
        {
            if(systemeRoutier.get(compteur).ContientUrgenceDeclencheeNonTraitee())
            {
                systemeContientUrgence = true;
            }
        }
        
        return systemeContientUrgence;
    }

}
