/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Dimitrije
 */
public class Komunikacija {
    
    private Socket s;

    private static Komunikacija instance;
    
    
    public Komunikacija() {
        try {
            s = new Socket("localhost", 9000);
        } catch (IOException ex) {
            System.getLogger(Komunikacija.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } 
    }
    
    
    public static Komunikacija getKomunikacija(){
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }
    
    
    
    public ServerskiOdgovor primiOdgovor(){
    
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            try {
                return (ServerskiOdgovor) ois.readObject();
            } catch (ClassNotFoundException ex) {
                System.getLogger(Komunikacija.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        } catch (IOException ex) {
            System.getLogger(Komunikacija.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return null;
    }
    
    
    public void posaljiZahtev (KlijentskiZahtev zahtev){
        ObjectOutputStream oos; 
        try {
            oos = new ObjectOutputStream(s.getOutputStream());
             oos.writeObject(zahtev);
        } catch (IOException ex) {
            System.getLogger(Komunikacija.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
       
    }
    
    
    
}
