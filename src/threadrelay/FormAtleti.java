/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package threadrelay;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author aless
 */
public class FormAtleti extends javax.swing.JFrame implements Observer {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormAtleti.class.getName());
    private JPanel mainP;
    private ArrayList<Atleta> atleti;
    private JProgressBar[] bars;
    protected JButton start;
    protected JComboBox<String> velocitaCombo;
    /**su
     * Creates new form FormAtleti
     */
    public FormAtleti(ManagerAtleti mA) {
        initComponents();
        mainP = new JPanel(new BorderLayout(12, 12));
        mainP.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        mainP.setBackground(new Color(246, 248, 251));
        setTitle("Thread Relay");
        
        JPanel titolo = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        titolo.setBackground(mainP.getBackground());
        JLabel titoloLabel = new JLabel("STAFFETTA DEI THREAD");
        titoloLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        titoloLabel.setForeground(new Color(26, 39, 57));
        titolo.add(titoloLabel);
        
        
        JPanel barsPanel = new JPanel(new GridLayout(4, 1, 12, 12));
        barsPanel.setOpaque(false);
        bars = new JProgressBar[4];
        Color[] laneColors = {
            new Color(46, 125, 50),
            new Color(21, 101, 192),
            new Color(239, 108, 0),
            new Color(123, 31, 162)
        };
        
        for(int i = 0; i < 4; i++){
            JProgressBar b = new JProgressBar(0, 100);
            bars[i] = b;
            b.setValue(0);
            b.setStringPainted(true);
            b.setForeground(laneColors[i]);
            b.setBackground(Color.WHITE);
            b.setFont(new Font("SansSerif", Font.BOLD, 12));
            barsPanel.add(b);
        }
        
        /*
        JProgressBar bar1 = new JProgressBar();
        JProgressBar bar2 = new JProgressBar();
        JProgressBar bar3 = new JProgressBar();
        JProgressBar bar4 = new JProgressBar();
        barsPanel.add(bar1);
        barsPanel.add(bar2);
        barsPanel.add(bar3);
        barsPanel.add(bar4);
        */
        
        JPanel nomiPanel = new JPanel(new GridLayout(4, 1, 12, 12));
        nomiPanel.setOpaque(false);
        
        nomiPanel.add(createLaneLabel("Atleta 1"));
        nomiPanel.add(createLaneLabel("Atleta 2"));
        nomiPanel.add(createLaneLabel("Atleta 3"));
        nomiPanel.add(createLaneLabel("Atleta 4"));
        
        JPanel controlPanel = new JPanel(new BorderLayout(0, 12));
        controlPanel.setOpaque(false);

        JPanel speedPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        speedPanel.setOpaque(false);
        JLabel velocitaLabel = new JLabel("Velocita:");
        velocitaLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        velocitaLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 8));
        velocitaCombo = new JComboBox<>(new String[]{"lento", "normale", "veloce"});
        velocitaCombo.setSelectedIndex(1);
        velocitaCombo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        velocitaCombo.setBackground(Color.WHITE);
        speedPanel.add(velocitaLabel);
        speedPanel.add(velocitaCombo);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.setOpaque(false);
        start = new JButton("start");
        styleButton(start);
        start.addActionListener(e -> {
            mA.startGara();
            
        });
        
        
        JButton stop = new JButton("stop");
        styleButton(stop);
        stop.addActionListener(e -> {
            mA.stopGara();
            
        });
        JButton pausa = new JButton("pausa");
        styleButton(pausa);
        pausa.addActionListener(e -> {
            mA.pausaGara();
            
        });
        JButton riprendi = new JButton("riprendi");
        styleButton(riprendi);
        riprendi.addActionListener(e -> {
            mA.riprendiGara();
            
        });
        
        buttonPanel.add(start);
        buttonPanel.add(stop);
        buttonPanel.add(pausa);
        buttonPanel.add(riprendi);
        controlPanel.add(speedPanel, BorderLayout.NORTH);
        controlPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        mainP.add(titolo, BorderLayout.NORTH);
        mainP.add(barsPanel, BorderLayout.CENTER);
        JPanel spacer = new JPanel();
        spacer.setOpaque(false);
        mainP.add(spacer, BorderLayout.EAST);
        mainP.add(nomiPanel, BorderLayout.WEST);
        mainP.add(controlPanel, BorderLayout.SOUTH);
        this.add(mainP);
        this.setSize(560, 400);
        this.setLocationRelativeTo(null);
    }
    
    
    public void aggiungiObserverGrafica(ArrayList atlets){
        atleti = atlets;
        for(Atleta a : atleti){
            a.addObserver(this);
        }
    }
    
    
    @Override
    public void update(Atleta a) {
        bars[atleti.indexOf(a)].setValue(a.getValore());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private JLabel createLaneLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.BOLD, 13));
        label.setForeground(new Color(44, 62, 80));
        return label;
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("SansSerif", Font.BOLD, 13));
        button.setBackground(new Color(233, 238, 245));
        button.setFocusPainted(false);
    }
}
