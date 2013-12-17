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
    private double m_tempsEcoule;
    private double m_tempsAvantDeclenchement;
    private boolean m_traitementTermine;
    
    Urgence(double tempsDeclenchement, boolean declencherImmediatement)
    {
        m_tempsAvantDeclenchement = tempsDeclenchement;
        
        if(declencherImmediatement == true)
        {
            m_tempsEcoule = 0;
        }
        else
        {
            m_tempsEcoule = 0 - tempsDeclenchement;
        }
        
        m_traitementTermine = false;
    }
    
    public double GetTempsAvantDeclenchement()
    {
        return m_tempsAvantDeclenchement;
    }
    
    public boolean UrgenceEstDeclenchee()
    {
        return m_tempsEcoule >= 0 && m_traitementTermine == false;
    }
    
    public boolean UrgenceEstTerminee()
    {
        return m_tempsEcoule >= 0 && m_traitementTermine == true;
    }
    
    public boolean UrgenceNonDeclenchee()
    {
        return m_tempsEcoule < 0;
    }
    
    public void DefinirTerminee()
    {
        m_traitementTermine = true;
    }
    
    public void Reinitialiser()
    {
        m_tempsEcoule = 0 - m_tempsAvantDeclenchement;
        m_traitementTermine = false;
    }
    
    public double GetTempsDepuisDeclenchement()
    {
        return m_tempsEcoule;
    }
    
    public void AvancerTemps()
    {
        if(m_traitementTermine == false)
        {
           m_tempsEcoule++; 
        }        
    }
}
