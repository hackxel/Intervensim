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
public interface IStrategieTraitement {
    Noeud ObtenirProchainNoeud(Noeud noeudCourant, ArrayList<Noeud> systemeRoutier,Noeud portAttache);
}
