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
       systemeRoutier = InitialiserParcours(noeudDepart,systemeRoutier);
       
       ArrayList<Noeud> listeNoeudsTraitement = new ArrayList<Noeud>();
       
       listeNoeudsTraitement.add(noeudDepart);
       
       while(listeNoeudsTraitement.size() > 0)
       {
           Noeud noeudCourant = ObtenirNoeudPlusPetiteDistance(listeNoeudsTraitement);
           
           listeNoeudsTraitement.remove(noeudCourant);
           noeudCourant.SetVisite();
           
           for(Noeud noeudAdjacent: noeudCourant.ObtenirNoeudsAdjacents())
           {
               if(noeudAdjacent.DejaVisite() == false)
               {
                   noeudAdjacent.RelacheNoeud(noeudCourant);
                   
                   listeNoeudsTraitement.add(noeudAdjacent);
               }
           }
       }
       
       Noeud noeudCourant = noeudDestination;
       
       while(noeudCourant.GetPrecedent() != noeudDepart)
       {
           noeudCourant = noeudCourant.GetPrecedent();
       }
       
       return noeudCourant;
    }
    
    private ArrayList<Noeud> InitialiserParcours(Noeud noeudDepart, ArrayList<Noeud> systemeRoutier)
    {
        for(Noeud noeudCourant : systemeRoutier)
        {
            noeudCourant.InitialiserValeursParcours();
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
