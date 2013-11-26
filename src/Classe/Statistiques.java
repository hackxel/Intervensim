/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classe;

/**
 *
 * @author Joseph
 */
public class Statistiques {
    
    private double tempsTraitementTotal;
    private int nombreUrgencesTraitees;
    private double distanceParcourue;
    
    Statistiques()
    {
        tempsTraitementTotal = 0;
        nombreUrgencesTraitees = 0;
    }
    
    public double ObtenirMoyenneTraitement()
    {
        return tempsTraitementTotal / nombreUrgencesTraitees;
    }
    
    public void AjouterStatistiquesUrgence(double tempsTraitement)
    {
        tempsTraitementTotal += tempsTraitement;
        nombreUrgencesTraitees++;
    }
    
    public void DefinirDistanceParcourue(double distance)
    {
        distanceParcourue = distance;
    }
    
    public double ObtenirDistanceParcourue()
    {
        return distanceParcourue;
    }
    
}
