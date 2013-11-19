/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intervensim;

//import com.sun.xml.internal.ws.api.message.Message;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.Component;
import java.awt.geom.Point2D;
import java.awt.Point;
import intervensim.Simulateur;

/**
 *
 * @author Charles
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form JFrame
     */
    String m_etatBoutonClique="";
    Point m_PremierPoint;
    Point m_DeuxiemePoint;
    Simulateur m_simulateur;
    
    
    public GUI() {
        initComponents();
        m_simulateur= new Simulateur();
        javax.swing.JPanel jPanelMap = new javax.swing.JPanel();
        jPanelMap.setBackground(new java.awt.Color(51, 51, 51));
        jPanelMap.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               jPanelMapMouseClicked(evt);
            }
        });
        getContentPane().add(jPanelMap);
        jPanelMap.setBounds(0, 0, 560, 360);
       
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
        jBtnAjouterPortAttache = new javax.swing.JButton();
        jBtnAjouterNoeud = new javax.swing.JButton();
        jBtnAjouterSegment = new javax.swing.JButton();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        jBtnAjoutRapide = new javax.swing.JButton();
        label4 = new java.awt.Label();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFichier = new javax.swing.JMenu();
        jItemImporter = new javax.swing.JMenuItem();
        jItemSauvegarder = new javax.swing.JMenuItem();
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
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
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

        jSlidVitesse.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlidVitesseStateChanged(evt);
            }
        });
        jSlidVitesse.setValue(0);
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
        getContentPane().add(jBtnStop);
        jBtnStop.setBounds(100, 380, 40, 40);

        jBtnAjouterPortAttache.setBackground(new java.awt.Color(204, 204, 204));
        jBtnAjouterPortAttache.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Medicine-Ambulance-icon.png"))); // NOI18N
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

        label4.setText("Ajout rapide");
        getContentPane().add(label4);
        label4.setBounds(630, 190, 140, 60);

        jMenuFichier.setText("Fichier");

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
    }// </editor-fold>                        

    private void jPanelMapMouseClicked(java.awt.event.MouseEvent evt)
    {
        if(m_PremierPoint==null)   
            m_PremierPoint=new Point(evt.getX(),evt.getY());
        else
            m_DeuxiemePoint=new Point(evt.getX(),evt.getY());
        
        switch (m_etatBoutonClique) {
            case "AjoutNoeud":
                m_simulateur.AjouterNoeud(m_PremierPoint);
                reinitialisationVar();
                break;
            case "AjoutSegment":
                if(m_DeuxiemePoint != null)
                {
                    m_simulateur.AjouterSegment(m_PremierPoint, m_DeuxiemePoint);
                    reinitialisationVar();
                }
                break;
        }
    }
    private void jItemQuitterActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        System.exit(0);
    }                                            

    private void jItemOptionAvanceActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void jBtnPauseActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void jSlidZoomStateChanged(javax.swing.event.ChangeEvent evt) {                                       
        // TODO add your handling code here:
       jLabZoom.setText("Zoom: " + String.valueOf(jSlidZoom.getValue()) + "x");
    }                                      

    private void jSlidVitesseStateChanged(javax.swing.event.ChangeEvent evt) {                                          
        // TODO add your handling code here:
         jLabVitesse.setText("Vitesse: " + String.valueOf(jSlidVitesse.getValue()) + "x");
    }                                         

    private void formKeyPressed(java.awt.event.KeyEvent evt) {                                
        // TODO add your handling code here:
  
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

    private void reinitialisationVar() {  
        m_PremierPoint=null;
        m_DeuxiemePoint=null;
        m_etatBoutonClique="";
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
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
    private javax.swing.JButton jBtnAjoutRapide;
    private javax.swing.JButton jBtnAjouterNoeud;
    private javax.swing.JButton jBtnAjouterPortAttache;
    private javax.swing.JButton jBtnAjouterSegment;
    private javax.swing.JButton jBtnDemarer;
    private javax.swing.JButton jBtnPause;
    private javax.swing.JButton jBtnStop;
    private javax.swing.JCheckBoxMenuItem jCbAfficherGrille;
    private javax.swing.JMenuItem jItemAjouterUrgence;
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
    // End of variables declaration                   
}
