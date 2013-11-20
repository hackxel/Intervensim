/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

import java.util.ArrayList;

/**
 *
 * @author Joseph
 */
public abstract class AlgorithmePlusCourtChemin {
    protected Noeud ProchainNoeud(Noeud noeudDepart, Noeud noeudDestination, ArrayList<Noeud> systemeRoutier)
    {
       systemeRoutier = InitialiserParcours(noeudDepart,systemeRoutier);
       
       return null;
    }
    
    private ArrayList<Noeud> InitialiserParcours(Noeud noeudDepart, ArrayList<Noeud> systemeRoutier)
    {
        for(Noeud noeudCourant : systemeRoutier)
        {
            noeudCourant.InitialiserValeursParcours();
            
            if(noeudCourant.EstMemePosition(noeudDepart.obtenir_Position()))
            {
                noeudCourant.SetVisite();
            }
        }
        
        return systemeRoutier;
    }
}
