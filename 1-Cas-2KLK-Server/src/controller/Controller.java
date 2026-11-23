/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.Dbbroker;

/**
 *
 * @author Dimitrije
 */
public class Controller {
    
    private static Controller instance;
    private Dbbroker dbb;

    public Controller() {
        dbb = new Dbbroker();
    }
    
    
    public static Controller getInstance(){
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }
    
    
    
    
}
