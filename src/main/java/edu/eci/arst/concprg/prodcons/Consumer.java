/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arst.concprg.prodcons;

import com.sun.javafx.scene.control.skin.VirtualFlow.ArrayLinkedList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class Consumer extends Thread{
    
    private LinkedBlockingQueue queue;
    
    
    public Consumer(LinkedBlockingQueue queue){
        this.queue=queue;        
    }
    
    @Override
    public synchronized  void run() {
        while (true) {

            if (queue.size() > 0) {
                Object elem=queue.remove();                
                System.out.println("Consumer consumes "+elem.toString());                                
            }else{/**
                try {
                    queue.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }            
            **/
            }
        }
    }
}
