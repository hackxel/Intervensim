/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

/**
 *
 * @author Joseph
 */
public class Urgence {
    private float m_tempsTraitement;
    
    public void DefinirTempsTraitement(float nouveauTemps)
    {
        m_tempsTraitement = nouveauTemps;
    }
    
    public float ObtenirTempsTraitement()
    {
        return m_tempsTraitement;
    }
}
