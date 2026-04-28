/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

import java.util.ArrayList;

/**
 *
 * @author lleshi.alessandro
 */
public class Atleta implements Runnable, Subject, Observer{
    private Staffetta s;
    private ArrayList<Observer> observers = new ArrayList();

    public Atleta(Staffetta s) {
        this.s = s;
    }

    @Override
    public void addObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void noifyObservers() {
        
    }

    @Override
    public void update(int valore) {

    }
    
    @Override
    public void run() {
        
    }
    
}
