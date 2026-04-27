/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

import javax.swing.JProgressBar;

/**
 *
 * @author lleshi.alessandro
 */
public class Altleta extends Thread{
    private Staffetta staffetta;
    private long contatore;
    private int numTh;
    private JProgressBar[] bars;
    
    public Altleta(Staffetta s, int numTh,  JProgressBar[] bars){
        staffetta = s;
        contatore = 0;
        this.numTh = numTh;
        this.bars = bars;
    }
    
    public void aumentaContatore(){
            contatore++;
    }
    
    @Override
    public void run() {
         try {
        while (contatore < 100) {

            synchronized (staffetta) {

                while (staffetta.getOccupato()) {
                    staffetta.wait();
                }

                staffetta.setOccupato(true);

                contatore++;

                bars[numTh].setValue((int) contatore);
                bars[numTh].setString(contatore + "%");

                staffetta.setOccupato(false);
                staffetta.notify(); // NON notifyAll
            }

            Thread.sleep(10);
        }

    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }

    public long getContatore() {
        return contatore;
    }
    
    
}
