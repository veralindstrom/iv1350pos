package se.kth.iv350.pos.startup;

import java.io.IOException;
import java.sql.SQLException;
import se.kth.iv350.pos.controller.Controller;
import se.kth.iv350.pos.integration.ExternalSystemCreator;
import se.kth.iv350.pos.integration.ItemIdNotFoundException;
import se.kth.iv350.pos.integration.InventoryException;
import se.kth.iv350.pos.view.View;

/**
 * Starts the entire application. 
 */
public class Main {

    /**
     * Main method used to start application
     * @param args The application does not take any command line paramters
     * @throws se.kth.iv350.pos.integration.ItemIdNotFoundException
     * @throws se.kth.iv350.pos.integration.InventoryException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws ItemIdNotFoundException, 
                                                    InventoryException, 
                                                    SQLException,
                                                    IOException{
        ExternalSystemCreator systmCreator = new ExternalSystemCreator();
        Controller contrl = new Controller(systmCreator);
        
        View view = new View(contrl);
        
        int i = 3;
        while(i>0){
            view.runFakeExecution();
            i--;
        }
    }
    
}
