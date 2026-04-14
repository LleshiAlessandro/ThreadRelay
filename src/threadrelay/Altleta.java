/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 *
 * @author lleshi.alessandro
 */
public class Altleta extends Thread{
    private Staffetta staffetta = new Staffetta();
    private int contatore;
    
    public Altleta(Staffetta s){
        staffetta = s;
        contatore = 0;
    }
    
    
    @Override
    public void run(){
        synchronized(staffetta){
            
        }
    }
}
