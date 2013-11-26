/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe.Strategies;

import Classe.Noeud;
import Classe.Strategies.IStrategieTraitement;
import Classe.Urgence;
import java.util.ArrayList;

/**
 *
 * @author Joseph
 */
public class AllerNoeudPlusAncien extends AlgorithmePlusCourtChemin implements IStrategieTraitement {
    
    @Override
    public Noeud ObtenirProchainNoeud(Noeud noeudCourant, ArrayList<Noeud> systemeRoutier)
    {
        Noeud noeudUrgencePlusAncienne = null;
        
        for(Noeud unNoeud: systemeRoutier)
        {
            if(noeudUrgencePlusAncienne == null || unNoeud.ObtenirUrgenceCouranteDeclenchee().GetTempsDepuisDeclenchement() > noeudUrgencePlusAncienne.ObtenirUrgenceCouranteDeclenchee().GetTempsDepuisDeclenchement())
            {
                noeudUrgencePlusAncienne = unNoeud;
            }
        }
        
        return ProchainNoeud(noeudCourant, noeudUrgencePlusAncienne, systemeRoutier);
    }
}
