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
public class ThreadManager {
    protected Staffetta s = new Staffetta();
    protected Altleta a1;
    protected Altleta a2;
    protected Altleta a3;
    protected Altleta a4;

    public ThreadManager(JProgressBar[] bars) {
        a1 = new Altleta(s, 0, bars);
        a2 = new Altleta(s, 1, bars);
        a3 = new Altleta(s, 2, bars);
        a4 = new Altleta(s, 3, bars);
    }
    
    
    
    public void start(){
        a1.start();
        a2.start();
        a3.start();
        a4.start();
    }
}
