/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.integration.ExternalSystemCreator;
import se.kth.iv1350.pos.integration.Printer;
import se.kth.iv1350.pos.integration.SystemUpdater;
import se.kth.iv1350.pos.model.Address;
import se.kth.iv1350.pos.view.View;

/**
 * Starts the entire application. 
 */
public class Main {

    /**
     * Main method used to start application
     * @param args The application does not take any command line paramters
     */
    public static void main(String[] args){
        ExternalSystemCreator systmCreator = new ExternalSystemCreator();
        Controller contrl = new Controller(systmCreator);
        
        View view = new View(contrl);
        view.runFakeExecution();
    }
    
}
