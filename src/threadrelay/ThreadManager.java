/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 *
 * @author lleshi.alessandro
 */
public class ThreadManager {
    private Staffetta s = new Staffetta();
    private Altleta a1 = new Altleta(s);
    private Altleta a2 = new Altleta(s);
    private Altleta a3 = new Altleta(s);
    private Altleta a4 = new Altleta(s);
    
    public void start(){
        a1.start();
        a2.start();
        a3.start();
        a4.start();
    }
}
