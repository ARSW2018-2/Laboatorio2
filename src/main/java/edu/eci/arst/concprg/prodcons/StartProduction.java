/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arst.concprg.prodcons;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartProduction {
    
    
    public static void main(String[] args) {
        
        //Queue<Integer> queue=new LinkedBlockingQueue<>();
        LinkedBlockingQueue queue=new LinkedBlockingQueue(10) ;   
        new Producer(queue,Long.MAX_VALUE).start();
        
        //let the producer create products for 5 seconds (stock).
        try {

            synchronized(queue)

            {
                //Thread.sleep(5000);
                queue.wait();

            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(StartProduction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        new Consumer(queue).start();
        
        
        try {

        synchronized(queue)
        {
            queue.wait(5);
            
        }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(StartProduction.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    

}