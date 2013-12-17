/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe.Strategies;

import Classe.Noeud;
import java.util.ArrayList;

/**
 *
 * @author Joseph
 */
public abstract class AlgorithmePlusCourtChemin {
    protected Noeud ProchainNoeud(Noeud noeudDepart, Noeud noeudDestination, ArrayList<Noeud> systemeRoutier)
    {
        Noeud prochainNoeudTrouve = null;
                
        if(noeudDepart.EstMemePosition(noeudDestination.obtenir_Position()) == false)
        {
            systemeRoutier = InitialiserParcours(noeudDepart,systemeRoutier);

            ArrayList<Noeud> listeNoeudsTraitement = new ArrayList<Noeud>();

            listeNoeudsTraitement.add(noeudDepart);

            while(listeNoeudsTraitement.size() > 0)
            {
                Noeud noeudCourant = ObtenirNoeudPlusPetiteDistance(listeNoeudsTraitement);

                listeNoeudsTraitement.remove(noeudCourant);

                for(Noeud noeudAdjacent: noeudCourant.ObtenirNoeudsAdjacents())
                {
                    if(noeudAdjacent.DejaVisite() == false)
                    {
                        noeudAdjacent.RelacheNoeud(noeudCourant);

                        noeudAdjacent.SetVisite();
                        listeNoeudsTraitement.add(noeudAdjacent);
                    }
                }
            }
            
            prochainNoeudTrouve = noeudDestination;
            
            while(prochainNoeudTrouve.GetPrecedent() != noeudDepart)
            {
                prochainNoeudTrouve = prochainNoeudTrouve.GetPrecedent();
            }
       }
        
       return prochainNoeudTrouve;
    }
    
    protected double ObtenirDistance(Noeud noeudDepart, Noeud noeudDestination, ArrayList<Noeud> systemeRoutier)
    {
        double distance = 0;
                
        if(noeudDepart.EstMemePosition(noeudDestination.obtenir_Position()) == false)
        {
            systemeRoutier = InitialiserParcours(noeudDepart,systemeRoutier);

            ArrayList<Noeud> listeNoeudsTraitement = new ArrayList<Noeud>();

            listeNoeudsTraitement.add(noeudDepart);

            while(listeNoeudsTraitement.size() > 0)
            {
                Noeud noeudCourant = ObtenirNoeudPlusPetiteDistance(listeNoeudsTraitement);

                listeNoeudsTraitement.remove(noeudCourant);

                for(Noeud noeudAdjacent: noeudCourant.ObtenirNoeudsAdjacents())
                {
                    if(noeudAdjacent.DejaVisite() == false)
                    {
                        noeudAdjacent.RelacheNoeud(noeudCourant);

                        noeudAdjacent.SetVisite();
                        listeNoeudsTraitement.add(noeudAdjacent);
                    }
                }
            }
            
            distance = noeudDestination.GetDistance();
       }
        
       return distance;
    }
    
    private ArrayList<Noeud> InitialiserParcours(Noeud noeudDepart, ArrayList<Noeud> systemeRoutier)
    {
        for(Noeud noeudCourant : systemeRoutier)
        {
            noeudCourant.InitialiserValeursParcours();
            
            if(noeudCourant.EstMemePosition(noeudDepart.obtenir_Position()))
            {
                noeudCourant.SetPointDepart();
            }
        }
        
        return systemeRoutier;
    }
    
    private Noeud ObtenirNoeudPlusPetiteDistance(ArrayList<Noeud> listeNoeuds)
    {
        Noeud plusPetiteDistance = null;
        
        for(Noeud noeudCourant: listeNoeuds)
        {
           if(plusPetiteDistance == null || plusPetiteDistance.GetDistance() > noeudCourant.GetDistance())
           {
               plusPetiteDistance = noeudCourant;
           }
        }
        
        return plusPetiteDistance;
    }
}
