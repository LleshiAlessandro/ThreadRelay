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
    public void run(){
        try{
            while(contatore < 100){

                synchronized(staffetta) {

                    while (staffetta.getOccupato()) {
                        staffetta.wait();
                    }

                    staffetta.setOccupato(true);

                    aumentaContatore();

                    // aggiornamento diretto (come richiesto)
                    bars[numTh].setValue((int) contatore);
                    bars[numTh].setString(contatore + "%");

                    Thread.sleep(100);

                    staffetta.setOccupato(false);
                    staffetta.notifyAll();
                }
            }

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public long getContatore() {
        return contatore;
    }
    
    
}
