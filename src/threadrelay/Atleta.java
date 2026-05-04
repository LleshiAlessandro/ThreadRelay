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
    private long time = 50;
    private volatile boolean paused = false;
    private Object pauseLock = new Object();


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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public void riprendiDaPausa() {
        synchronized (pauseLock) {
            paused = false;
            pauseLock.notifyAll();
        }
    }

    @Override
    public void run() {
        while (attivo && valore < 100) {
            synchronized (pauseLock) {
                while (paused) {
                    try {
                        pauseLock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            setValore(valore + 1);
        }
    }
    
}
