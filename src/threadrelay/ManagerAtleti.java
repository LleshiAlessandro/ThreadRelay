/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

import java.util.ArrayList;

/**
 *
 * @author aless
 */
public class ManagerAtleti implements Observer{

    private ArrayList<Atleta> atlets = new ArrayList();
    private ArrayList<Thread> threads = new ArrayList();
    private boolean garaIniziata = false;
    private FormAtleti f;
    
    public ManagerAtleti() {
        for(int i = 0; i < 4; i++){
            Atleta a = new Atleta();
            a.addObserver(this);
            atlets.add(a);
        }
        f = new FormAtleti(this);
        f.aggiungiObserverGrafica(atlets);
        f.setVisible(true);
    }
    
    public void startGara(){
        threads.clear();
        f.start.setEnabled(false);
        if(garaIniziata == false){
            garaIniziata = true;
            for(Atleta a: atlets){
                a.setValore(0);
                a.setPaused(false);
                if(f.velocitaCombo.getSelectedItem().equals("lento")){
                    a.setTime(60);
                }
                else if(f.velocitaCombo.getSelectedItem().equals("veloce")){
                    a.setTime(10);
                }
                else{
                    a.setTime(35);
                }
                threads.add(new Thread(a));
            }
            threads.getFirst().start();
        }
    }
    
    public void stopGara(){
        for(Atleta a : atlets){
            a.riprendiDaPausa();
        }
        for(Thread th : threads){
            th.interrupt();
            
        }
        for(Atleta a : atlets){
            a.setValore(0);
        }
        garaIniziata = false;
        f.start.setEnabled(true);
    }
    
    public void pausaGara(){
        for(Atleta a : atlets){
            a.setPaused(true);
        }
    }
    
    public void riprendiGara(){
        for(Atleta a : atlets){
            a.riprendiDaPausa();
        }
    }
    
    
    
    @Override
    public void update(Atleta a) {
        if(a.getValore() == 90 && atlets.size() - 1 > atlets.indexOf(a)){
            threads.get(atlets.indexOf(a) + 1).start();
        }
        else if(atlets.get(3).getValore() == 100){
            garaIniziata = false;
            f.start.setEnabled(true);
        }
    }
}
