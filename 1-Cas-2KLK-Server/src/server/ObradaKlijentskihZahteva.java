/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import operacije.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Dimitrije
 */
public class ObradaKlijentskihZahteva extends Thread {
    
    private Socket s;

    public ObradaKlijentskihZahteva() {
    }

    public ObradaKlijentskihZahteva(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {            
            
     
                KlijentskiZahtev kz = primiZahtev(); // dobijamo u potpisu (operacija,parametar)
                ServerskiOdgovor so = new ServerskiOdgovor();


                switch (kz.getOperacija()) {
                    case Operacije.LOGIN: 
        //                return "kontroler -> dbb -> login";
                  //        so.setOdgovor("Neki odgovor...");
                       break;      

                   default:
                       break;
                }

                so.setOdgovor("Neki odgovor...");
                posaljiOdgovor(so);
        
           }
        
                
    }

    private KlijentskiZahtev primiZahtev() {
        
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            try {
                return (KlijentskiZahtev) ois.readObject();
            } catch (ClassNotFoundException ex) {
                System.getLogger(ObradaKlijentskihZahteva.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        } catch (IOException ex) {
            System.getLogger(ObradaKlijentskihZahteva.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return null;
    }

    private void posaljiOdgovor(ServerskiOdgovor so) {
        
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so); 
            oos.flush(); 
            
        } catch (IOException ex) {
            System.getLogger(ObradaKlijentskihZahteva.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        
    }
    
    
    
    
    
}
