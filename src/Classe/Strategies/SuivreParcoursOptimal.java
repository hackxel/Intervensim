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
public class SuivreParcoursOptimal extends AlgorithmePlusCourtChemin implements IStrategieTraitement {
    
    @Override
    public Noeud ObtenirProchainNoeud(Noeud noeudCourant, ArrayList<Noeud> systemeRoutier)
    {
        return null;
    }
}
