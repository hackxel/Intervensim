/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intervensim;

//import com.sun.xml.internal.ws.api.message.Message;

import Classe.Controleur.Simulateur;
import java.awt.Color;
import javax.swing.KeyStroke;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Charles
 */
class PanelMap extends javax.swing.JScrollPane
{
    Simulateur m_simulateur;
    boolean m_afficherGrille;
    int m_zoomCarte;
    Image m_image;
    //Image backgroundImage;
    PanelMap() {
          
      // m_image = new ImageIcon(getClass().getResource("/image/background.png")).getImage();
    }
    public void setImageArrierePlan(String p_image)
    {
         m_image = new ImageIcon(getClass().getResource(p_image)).getImage();
    }
    public void setAffichageGrille(boolean p_afficher)
    {
        m_afficherGrille=p_afficher;
    }
    public void setSimulateur(Simulateur p_sim)
    {
         m_simulateur=p_sim;
    }
    @Override
    protected void paintComponent(Graphics g)  
    {   
        super.paintComponent(g);  
        Graphics2D g2 = (Graphics2D)g;  
        if(m_image!=null)
            g2.drawImage(m_image, 0, 0,560,360,this);
        m_simulateur.Dessin(g,m_afficherGrille);
        g.dispose();
    } 

}
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form JFrame
     */
    String m_etatBoutonClique="";
    Point m_PremierPoint;
    Point m_DeuxiemePoint;
    Point m_pointOffset;
    Point m_pointDepart;
    Simulateur m_simulateur;
    Graphics m_graphics;
    PanelMap jPanelMap;
    Timer m_timer;
    
    
    public GUI() {
        initComponents();
        m_pointOffset= new Point(0, 0);
        jPanelMap = new PanelMap();     
        jPanelMap.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
               jPanelMapMousePressed(evt);
            }
            @Override
                public void mouseReleased(java.awt.event.MouseEvent evt) {
               jPanelMapMouseReleased(evt);
            }
        });
        jPanelMap.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
             @Override
            public void mouseDragged(MouseEvent e) {
               jPanelMapMouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                jPanelMapMouseMoved(e);
            }
        });
            
        
     
        getContentPane().add(jPanelMap);
      
        initilialisationSimulation();
        //Initialisation paint component
        jPanelMap.paintComponent(m_graphics);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jSlidZoom = new javax.swing.JSlider();
        jSlidVitesse = new javax.swing.JSlider();
        jLabZoom = new javax.swing.JLabel();
        jLabVitesse = new javax.swing.JLabel();
        jBtnDemarer = new javax.swing.JButton();
        jBtnPause = new javax.swing.JButton();
        jBtnStop = new javax.swing.JButton();
        jBtnSlection = new javax.swing.JButton();
        jBtnAjouterPortAttache = new javax.swing.JButton();
        jBtnAjouterNoeud = new javax.swing.JButton();
        //Urgence a enlever commentaire
        jBtnAjouterUrgence = new javax.swing.JButton();
        jBtnAjouterSegment = new javax.swing.JButton();
        jBtnAjoutRapide = new javax.swing.JButton();
        jBtnSupprimerNoeud = new javax.swing.JButton();
        jBtnSupprimerSegment = new javax.swing.JButton();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        lblErreur = new java.awt.Label();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFichier = new javax.swing.JMenu();
        jItemImporter = new javax.swing.JMenuItem();
        jItemSauvegarder = new javax.swing.JMenuItem();
        jItemNouvelle = new javax.swing.JMenuItem();
        jItemQuitter = new javax.swing.JMenuItem();
        jMenuUrgence = new javax.swing.JMenu();
        jItemAjouterUrgence = new javax.swing.JMenuItem();
        jMenuOptions = new javax.swing.JMenu();
        jCbAfficherGrille = new javax.swing.JCheckBoxMenuItem();
        jItemOptionAvance = new javax.swing.JMenuItem();
        jMenuAide = new javax.swing.JMenu();
        jMenuPropos = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Intervensim");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        jSlidZoom.setMajorTickSpacing(10);
        jSlidZoom.setMinimum(1);
        jSlidZoom.setMaximum(5);
        jSlidZoom.setMinorTickSpacing(2);
        jSlidZoom.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlidZoomStateChanged(evt);
            }
        });
        jSlidZoom.setValue(1);
        getContentPane().add(jSlidZoom);
        jSlidZoom.setBounds(260, 370, 200, 23);
       
        
        jSlidVitesse.setMinimum(1);
        jSlidVitesse.setMaximum(10);
        jSlidVitesse.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlidVitesseStateChanged(evt);
            }
        });
        jSlidVitesse.setValue(1);
        getContentPane().add(jSlidVitesse);
        jSlidVitesse.setBounds(260, 400, 200, 23);

        jLabZoom.setText("Zoom: 1x");
        getContentPane().add(jLabZoom);
        jLabZoom.setBounds(460, 370, 100, 20);

        jLabVitesse.setText("Vitesse: 1x");
        getContentPane().add(jLabVitesse);
        jLabVitesse.setBounds(460, 400, 100, 20);

        jBtnDemarer.setBackground(new java.awt.Color(204, 204, 204));
        jBtnDemarer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Media-Controls-Play-icon.png"))); // NOI18N
        jBtnDemarer.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnDemarer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnStartActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnDemarer);
        jBtnDemarer.setBounds(20, 380, 40, 40);

        jBtnPause.setBackground(new java.awt.Color(204, 204, 204));
        jBtnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Media-Controls-Pause-icon.png"))); // NOI18N
        jBtnPause.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnPause.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPauseActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnPause);
        jBtnPause.setBounds(60, 380, 40, 40);

        jBtnStop.setBackground(new java.awt.Color(204, 204, 204));
        jBtnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Media-Controls-Stop-icon.png"))); // NOI18N
        jBtnStop.setToolTipText("");
        jBtnStop.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnStop.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnStopActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnStop);
        jBtnStop.setBounds(100, 380, 40, 40);

        jBtnAjouterPortAttache.setBackground(new java.awt.Color(204, 204, 204));
        jBtnAjouterPortAttache.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hospital-icon2.png"))); // NOI18N
        jBtnAjouterPortAttache.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnAjouterPortAttache.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAjouterPortAttacheActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnAjouterPortAttache);
        jBtnAjouterPortAttache.setBounds(570, 130, 60, 60);

        jBtnAjouterNoeud.setBackground(new java.awt.Color(204, 204, 204));
        jBtnAjouterNoeud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Charts-Mind-map-icon.png"))); // NOI18N
        jBtnAjouterNoeud.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnAjouterNoeud.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAjouterNoeudActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnAjouterNoeud);
        jBtnAjouterNoeud.setBounds(570, 10, 60, 60);

        jBtnAjouterSegment.setBackground(new java.awt.Color(204, 204, 204));
        jBtnAjouterSegment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Image-Edition-Tools-Line-icon.png"))); // NOI18N
        jBtnAjouterSegment.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnAjouterSegment.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAjouterSegmentActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnAjouterSegment);
        jBtnAjouterSegment.setBounds(570, 70, 60, 60);

        label1.setText("Ajouter un port d'attache");
        getContentPane().add(label1);
        label1.setBounds(630, 130, 140, 60);

        label2.setText("Ajouter un noeud");
        getContentPane().add(label2);
        label2.setBounds(630, 10, 140, 60);

        label3.setText("Ajouter un segment");
        getContentPane().add(label3);
        label3.setBounds(630, 70, 140, 60);
        
        label4.setText("Ajout rapide");
        getContentPane().add(label4);
        label4.setBounds(630, 190, 140, 60);
        
        label5.setText("Supprimer un noeud");
        getContentPane().add(label5);
        label5.setBounds(630, 250, 140, 60);
        
        label6.setText("Supprimer un segment");
        getContentPane().add(label6);
        label6.setBounds(630, 310, 140, 60);
        
        label7.setText("Ajouter une Urgence");
        getContentPane().add(label7);
        label7.setBounds(845, 10, 140, 60);
        
        label8.setText("Selection");
        getContentPane().add(label8);
        label8.setBounds(845, 70, 140, 60);
        
        lblErreur.setText("");
        getContentPane().add(lblErreur);
        lblErreur.setBounds(20, 450, 500, 60);
        
        
        
        jBtnAjoutRapide.setBackground(new java.awt.Color(204, 204, 204));
        jBtnAjoutRapide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Maps-and-Geolocation-Polyline-icon.png"))); // NOI18N
        jBtnAjoutRapide.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnAjoutRapide.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAjoutRapideActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnAjoutRapide);
        jBtnAjoutRapide.setBounds(570, 190, 60, 60);
        
        jBtnSupprimerNoeud.setBackground(new java.awt.Color(204, 204, 204));
        jBtnSupprimerNoeud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Editing-Delete-icon.png"))); // NOI18N
        jBtnSupprimerNoeud.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnSupprimerNoeud.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSupprimerNoeudActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnSupprimerNoeud);
        jBtnSupprimerNoeud.setBounds(570, 250, 60, 60);

        
        jBtnSupprimerSegment.setBackground(new java.awt.Color(204, 204, 204));
        jBtnSupprimerSegment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Editing-Erase-icon.png"))); // NOI18N
        jBtnSupprimerSegment.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnSupprimerSegment.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSupprimerSegmentActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnSupprimerSegment);
        jBtnSupprimerSegment.setBounds(570, 310, 60, 60);
        
        jBtnAjouterUrgence.setBackground(new java.awt.Color(204, 204, 204));
        jBtnAjouterUrgence.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Medicine-Doctor-suitecase-icon.png"))); // NOI18N
        jBtnAjouterUrgence.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnAjouterUrgence.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAjouterUrgenceActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnAjouterUrgence);
        jBtnAjouterUrgence.setBounds(785, 10, 60, 60);
        
        jBtnSlection.setBackground(new java.awt.Color(204, 204, 204));
        jBtnSlection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Very-Basic-Cursor-icon.png"))); // NOI18N
        jBtnSlection.setPreferredSize(new java.awt.Dimension(50, 50));
        jBtnSlection.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSelectionActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnSlection);
        jBtnSlection.setBounds(785, 70, 60, 60);
        

        jMenuFichier.setText("Fichier");
        jItemNouvelle.setText("Nouvelle simulation");
        jItemNouvelle.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jItemNouvelleActionPerformed(evt);
            }
        });
        jItemNouvelle.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N,java.awt.Event.CTRL_MASK));
        jMenuFichier.add(jItemNouvelle);
        
        jItemImporter.setText("Importer une simulation");
        jItemImporter.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I,java.awt.Event.CTRL_MASK));
        jMenuFichier.add(jItemImporter);

        jItemSauvegarder.setText("Sauvegarder une simulation");
        jItemSauvegarder.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S,java.awt.Event.CTRL_MASK));
        jMenuFichier.add(jItemSauvegarder);

        jItemQuitter.setText("Quitter");
        jItemQuitter.setActionCommand("jMenuQuitter");
        jItemQuitter.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jItemQuitterActionPerformed(evt);
            }
        });
        jItemQuitter.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q,java.awt.Event.CTRL_MASK));
        jMenuFichier.add(jItemQuitter);

        jMenuBar.add(jMenuFichier);

        jMenuUrgence.setText("Urgence");

        jItemAjouterUrgence.setText("Ajouter une urgence");
        jMenuUrgence.add(jItemAjouterUrgence);

        jMenuBar.add(jMenuUrgence);

        jMenuOptions.setText("Options");

        jCbAfficherGrille.setSelected(true);
        jCbAfficherGrille.setText("Affichier la grille");
        jCbAfficherGrille.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G,java.awt.Event.CTRL_MASK));
        jCbAfficherGrille.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPanelMap.setAffichageGrille(jCbAfficherGrille.getState());
                jPanelMap.repaint();
            }
        });
        
        jMenuOptions.add(jCbAfficherGrille);

        jItemOptionAvance.setText("Options avancés");
        jItemOptionAvance.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jItemOptionAvanceActionPerformed(evt);
            }
        });
        jItemOptionAvance.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O,java.awt.Event.CTRL_MASK));
        jMenuOptions.add(jItemOptionAvance);

        jMenuBar.add(jMenuOptions);

        jMenuAide.setText("Aide");

        //jMenuAide.setMnemonic(KeyEvent.VK_A);

        jMenuBar.add(jMenuAide);

        jMenuPropos.setText("À propos");

        //jMenuPropos.setMnemonic(KeyEvent.VK_F);

        jMenuBar.add(jMenuPropos);

        setJMenuBar(jMenuBar);

        pack();
    }
    private void jPanelMapMouseReleased(java.awt.event.MouseEvent evt)
    {
        m_pointOffset=evt.getPoint();
        switch (m_etatBoutonClique) {
            case "Selection":
                m_simulateur.Selection(m_pointOffset,"Released");
                 reinitialisationVar();
                 jPanelMap.repaint();
            break;
        }
    }
    private void jPanelMapMouseDragged(java.awt.event.MouseEvent evt)
    {       
        m_pointOffset=evt.getPoint();
        switch (m_etatBoutonClique) {
            case "Selection":
                m_simulateur.Selection(m_pointOffset,"Dragged");            
                jPanelMap.repaint();
            break;
        }
        /*Point p = evt.getPoint();
        int x = p.x - m_PremierPoint.x;
        int y = p.y - m_PremierPoint.y;
        m_pointOffset = new Point(x, y);
        m_simulateur.PositionFondMap(m_pointOffset);
        lblErreur.setText(String.valueOf(evt.getX()) +" "+ String.valueOf( evt.getY()));
    */}
    private void jPanelMapMouseMoved(java.awt.event.MouseEvent evt)
    {       
        m_simulateur.PositionSouris(evt.getX(),evt.getY());
        jPanelMap.repaint();
    }
    private void jPanelMapMousePressed(java.awt.event.MouseEvent evt)
    {
       
        
        if(m_PremierPoint==null)   
            m_PremierPoint=evt.getPoint();
        else
            m_DeuxiemePoint=evt.getPoint();
        
        switch (m_etatBoutonClique) {
            case "Selection":
                m_simulateur.Selection(m_PremierPoint,"Pressed");
             //  reinitialisationVar();
                //jPanelMap.repaint();
                /* m_PremierPoint = evt.getPoint();
                 m_PremierPoint.x -= m_pointOffset.x;
                 m_PremierPoint.y -= m_pointOffset.y;*/
                
                break;
            case "AjoutNoeud":
                m_simulateur.AjouterNoeud(m_PremierPoint);
                reinitialisationVar();
                jPanelMap.repaint();
                break;
            case "AjoutSegment":
            if(m_DeuxiemePoint != null)
            {
                m_simulateur.AjouterSegment(m_PremierPoint, m_DeuxiemePoint);
                reinitialisationVar();
                jPanelMap.repaint();
            }
            break;
            case "AjoutPortAttache":
                m_simulateur.PortAttache(m_PremierPoint);
                reinitialisationVar();
                jPanelMap.repaint();
            break;
            case "AjoutRapide":
                m_simulateur.AjouterRapide(m_PremierPoint);
                reinitialisationVar();
                jPanelMap.repaint();
            break;
            case "SupprimerNoeud":
                m_simulateur.SupprimerNoeud(m_PremierPoint);
                reinitialisationVar();
                jPanelMap.repaint();
            break;
            case "SupprimerSegment":
                if(m_DeuxiemePoint != null)
                {
                    m_simulateur.SupprimerSegment(m_PremierPoint, m_DeuxiemePoint);
                    reinitialisationVar();
                    jPanelMap.repaint();
                }
            break;
            case "AjouterUrgence":
                m_simulateur.AjouterUrgence(m_PremierPoint, 0.00);
                reinitialisationVar();
                jPanelMap.repaint();
                break;
        }
        
    }
    private void jItemQuitterActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        System.exit(0);
    }  
     private void jItemNouvelleActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
         initilialisationSimulation();
          //final JFileChooser fc = new JFileChooser();
        //  int returnVal = fc.showOpenDialog(this);
    }  
     private void initilialisationSimulation()
     {
         m_graphics=super.getGraphics();
         //Redimentionnement par default
        jPanelMap.setBackground(new java.awt.Color(51, 51, 51));
        jPanelMap.setBounds(0, 0, 560, 360);
        //Initialisation simulateur
        m_simulateur= new Simulateur();
        m_simulateur.ChangerFondEcran("/image/background_1.png");
        jPanelMap.setSimulateur(m_simulateur);
        //Initialisation grille
        jCbAfficherGrille.setState(false);
        jPanelMap.setAffichageGrille(jCbAfficherGrille.getState());
        //Initialisation zoom
        jSlidZoom.setValue(1);
        m_simulateur.ChangerZoom(jSlidZoom.getValue());
        //Initialisation timer et vitesse
        jSlidVitesse.setValue(1);
        m_timer= new Timer(500/jSlidVitesse.getValue(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    m_simulateur.TimerTick();
                    jPanelMap.repaint();
                }
        });   

        //Initialisation variable
        reinitialisationVar();
        m_etatBoutonClique="";
        
        //Rafraichissement
        jPanelMap.repaint();
     }
    private void jItemOptionAvanceActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }   
    private void jBtnStopActionPerformed(java.awt.event.ActionEvent evt) {                                          
     // TODO add your handling code here:
        m_timer.stop();
        lblErreur.setText("Simulation arreter");
       
    }   
     private void jBtnStartActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        if(m_simulateur.SimulationEstPrete())
        {
            m_timer.start();
            lblErreur.setText("Simulation en Court");
        }
    }   
    private void jBtnPauseActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        m_timer.stop();
            lblErreur.setText("Simulation en pause");
    }                                         

    private void jSlidZoomStateChanged(javax.swing.event.ChangeEvent evt) {                                       
        // TODO add your handling code here:
        jLabZoom.setText("Zoom: " + String.valueOf(jSlidZoom.getValue()) + "x");
        if(m_simulateur != null)
        {
            m_simulateur.ChangerZoom(jSlidZoom.getValue());
            jPanelMap.repaint();
        }
    }                                      

    private void jSlidVitesseStateChanged(javax.swing.event.ChangeEvent evt) {                                          
        // TODO add your handling code here:
         jLabVitesse.setText("Vitesse: " + String.valueOf(jSlidVitesse.getValue()) + "x");
    }                                         

    private void formKeyPressed(java.awt.event.KeyEvent evt) {                                
        // TODO add your handling code here:
  
    }                               
    private void jBtnSelectionActionPerformed(java.awt.event.ActionEvent evt){      
        reinitialisationVar();
        m_etatBoutonClique="Selection";
    }   
    private void jBtnAjouterNoeudActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        reinitialisationVar();
        m_etatBoutonClique="AjoutNoeud";
    }                                                

    private void jBtnAjouterSegmentActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
         reinitialisationVar();
         m_etatBoutonClique="AjoutSegment";
    }                                                  

    private void jBtnAjouterPortAttacheActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
         reinitialisationVar();
         m_etatBoutonClique="AjoutPortAttache";
    }                                                      

    private void jBtnAjoutRapideActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
           reinitialisationVar();
           m_etatBoutonClique="AjoutRapide";
    }    
    private void jBtnSupprimerNoeudActionPerformed(java.awt.event.ActionEvent evt) {                                                
    // TODO add your handling code here:
       reinitialisationVar();
       m_etatBoutonClique="SupprimerNoeud";
    }     
    private void jBtnSupprimerSegmentActionPerformed(java.awt.event.ActionEvent evt) {                                                
    // TODO add your handling code here:
       reinitialisationVar();
       m_etatBoutonClique="SupprimerSegment";
    } 
    //Urgence supprimer Comm
    private void jBtnAjouterUrgenceActionPerformed(java.awt.event.ActionEvent evt) {                                                
    // TODO add your handling code here:
       reinitialisationVar();
       m_etatBoutonClique="AjouterUrgence";
    }

    private void reinitialisationVar() {  
        m_PremierPoint=null;
        m_DeuxiemePoint=null;
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify       
    private javax.swing.JButton jBtnSlection;
    private javax.swing.JButton jBtnAjoutRapide;
    private javax.swing.JButton jBtnAjouterNoeud; 
    private javax.swing.JButton jBtnAjouterUrgence; //Urgence enlever Comm
    private javax.swing.JButton jBtnAjouterPortAttache;
    private javax.swing.JButton jBtnAjouterSegment;
    private javax.swing.JButton jBtnSupprimerNoeud;
    private javax.swing.JButton jBtnSupprimerSegment;
    private javax.swing.JButton jBtnDemarer;
    private javax.swing.JButton jBtnPause;
    private javax.swing.JButton jBtnStop;
    private javax.swing.JCheckBoxMenuItem jCbAfficherGrille;
    private javax.swing.JMenuItem jItemAjouterUrgence;
    private javax.swing.JMenuItem jItemNouvelle;
    private javax.swing.JMenuItem jItemImporter;
    private javax.swing.JMenuItem jItemOptionAvance;
    private javax.swing.JMenuItem jItemQuitter;
    private javax.swing.JMenuItem jItemSauvegarder;
    private javax.swing.JLabel jLabVitesse;
    private javax.swing.JLabel jLabZoom;
    private javax.swing.JMenu jMenuAide;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuFichier;
    private javax.swing.JMenu jMenuOptions;
    private javax.swing.JMenu jMenuPropos;
    private javax.swing.JMenu jMenuUrgence;
    private javax.swing.JSlider jSlidVitesse;
    private javax.swing.JSlider jSlidZoom;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label lblErreur;
    // End of variables declaration                   
}
