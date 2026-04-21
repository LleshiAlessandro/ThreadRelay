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
    private long contatore;
    
    public Altleta(Staffetta s){
        staffetta = s;
        contatore = 0;
    }
    
    public void aumentaContatore(){
        for(int i = 0; i < 100; i++){
            i++;
        }
    }
    
    @Override
    public void run(){
        try{
            synchronized(staffetta){
                if(staffetta.getOccupato() == false){
                    staffetta.setOccupato(true);
                    while(contatore >= 100){
                        Thread.sleep(contatore);//non sono sicuro che quando il contatore arriva a 99 il thread smetta lo sleep
                        this.aumentaContatore();
                    }
                    staffetta.setOccupato(false);
                    staffetta.notifyAll();
                }
                else{
                    staffetta.wait();
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public long getContatore() {
        return contatore;
    }
    
    
}
