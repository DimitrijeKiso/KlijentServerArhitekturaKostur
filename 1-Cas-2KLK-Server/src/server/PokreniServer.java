/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dimitrije
 */
public class PokreniServer extends Thread {

    @Override
    public void run() {
        
        try {
            ServerSocket serverskiSoket = new ServerSocket(9000);
            
            while (true) {                
                Socket s = serverskiSoket.accept();
                System.out.println("Povezan klijent");
                
                ObradaKlijentskihZahteva okz = new ObradaKlijentskihZahteva(s);
                okz.start();
                
            }
            
            
            
        } catch (IOException ex) {
            System.getLogger(PokreniServer.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }
    
    
    
    
    
    
}
