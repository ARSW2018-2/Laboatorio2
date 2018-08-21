/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arst.concprg.prodcons;

import com.sun.javafx.scene.control.skin.VirtualFlow.ArrayLinkedList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class Consumer extends Thread{
    
    private Queue<Integer> queue;
    
    
    public Consumer(Queue<Integer> queue){
        this.queue=queue;        
    }
    
    @Override
    public synchronized  void run() {
        while (true) {

            if (queue.size() > 0) {
                int elem=queue.poll();                
                //int elem=queue.remove(0);
                System.out.println("Consumer consumes "+elem);                                
            }
            try {
                queue.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
