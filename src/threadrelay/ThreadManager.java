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
    protected Staffetta s = new Staffetta();
    protected Altleta a1 = new Altleta(s);
    protected Altleta a2 = new Altleta(s);
    protected Altleta a3 = new Altleta(s);
    protected Altleta a4 = new Altleta(s);
    
    public void start(){
        a1.start();
        a2.start();
        a3.start();
        a4.start();
    }
}
