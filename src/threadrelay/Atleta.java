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
public class Atleta implements Runnable, Subject{
    private final ArrayList<Observer> observers = new ArrayList<>();

    private int valore = 0;
    private boolean attivo = true;


    @Override
    public synchronized void addObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public synchronized void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public synchronized void notifyObservers() {
        ArrayList<Observer> copia = new ArrayList<>(observers);
        for (Observer o : copia) {
            o.update(this);
        }
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int v) {
        this.valore = v;
        notifyObservers();   // ogni modifica scatena la notifica
    }

    /** Ferma il loop del thread in modo pulito */
    public void ferma() {
        attivo = false;
    }
    
    @Override
    public void run() {
        while (attivo && valore < 100) {
         try {
             Thread.sleep(50);
         } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            setValore(valore + 1);
        }
    }
    
}
