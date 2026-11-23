/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;
import java.sql.*;
/**
 *
 * @author Dimitrije
 */
public class Konekcija {
    
    private static Konekcija konekcija;
    private Connection connection;

    String url = "jdbc:mysql://localhost:3306/imeBaze";
    
    public Konekcija() {
        
        try {
            connection = DriverManager.getConnection(url,"root","");
            connection.setAutoCommit(false); 
        } catch (SQLException ex) {
            System.getLogger(Konekcija.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }   
    }
    
    
    public static Konekcija getKonekcija(){
        if (konekcija == null) {
            konekcija = new Konekcija();
        }
        return konekcija;
    }

    public Connection getConnection() {
        return connection;
    }
    
    
    
    
    
    
    
}
