/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe.Strategies;

import Classe.Noeud;
import Classe.Strategies.IStrategieAttente;
import java.util.ArrayList;

/**
 *
 * @author Joseph
 */
public class AllerPortAttache extends AlgorithmePlusCourtChemin implements IStrategieAttente{

    @Override
    public Noeud ObtenirProchainNoeud(Noeud noeudCourant, ArrayList<Noeud> systemeRoutier,Noeud portAttache) {
        return ProchainNoeud(noeudCourant, portAttache, systemeRoutier);
    }
    
}
