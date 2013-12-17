/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe.Strategies;

import Classe.Noeud;
import Classe.Strategies.IStrategieTraitement;
import java.util.ArrayList;

/**
 *
 * @author Joseph
 */
public class AllerNoeudPlusPret extends AlgorithmePlusCourtChemin implements IStrategieTraitement {
    
    @Override
    public Noeud ObtenirProchainNoeud(Noeud noeudCourant, ArrayList<Noeud> systemeRoutier)
    {
        Noeud noeudUrgencePlusProche = null;
        double distanceUrgencePlusProche = 9999;
        
        for(Noeud unNoeud: systemeRoutier)
        {
            
            if(unNoeud.ContientUrgenceDeclencheeNonTraitee())
            {
                double distanceNoeud = ObtenirDistance(noeudCourant, unNoeud, systemeRoutier);
                
                if(noeudUrgencePlusProche == null || distanceUrgencePlusProche > distanceNoeud)
                {
                    noeudUrgencePlusProche = unNoeud;
                    distanceUrgencePlusProche = distanceNoeud;
                }
            }
        }
        
        Noeud prochainNoeudUrgencePlusProche = null;
        
        if(noeudUrgencePlusProche != null)
        {
            prochainNoeudUrgencePlusProche = ProchainNoeud(noeudCourant, noeudUrgencePlusProche, systemeRoutier);
        }
        
        return prochainNoeudUrgencePlusProche;
    }
}
