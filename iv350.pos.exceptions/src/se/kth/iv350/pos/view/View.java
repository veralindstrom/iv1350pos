/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv350.pos.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import se.kth.iv350.pos.controller.Controller;
import se.kth.iv350.pos.integration.ItemIdNotFoundException;
import se.kth.iv350.pos.integration.InventoryException;
import se.kth.iv350.pos.util.Amount;
import se.kth.iv350.pos.model.TotalDTO;
import se.kth.iv350.pos.util.LogHandler;

/**
 * @author Vera
 * This is a placeholder for the real view. It contains hardcoded execution 
 * with calls to all system operation in controller.
 */
public class View {
    private final Controller contrl;
    private final Scanner in = new Scanner(System.in); //for user input
    
    private final ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler();
    private final LogHandler logger;
    /**
     * Creates new instance. that uses specified controller for all calls to other layers.
     * 
     * @param contrl The controller to use for all calls to other layers
     * @throws java.io.IOException
     */
    public View (Controller contrl) throws IOException{
        this.contrl = contrl;
        this.logger = new LogHandler();
    }
    
    /**
     * Performs a fake sale by calling all system operations in the controller.
     * @throws se.kth.iv350.pos.integration.ItemIdNotFoundException
     * @throws se.kth.iv350.pos.integration.InventoryException
     * @throws java.sql.SQLException
     */
    
    public void runFakeExecution() throws ItemIdNotFoundException, InventoryException, SQLException { 
       try{
        TotalDTO total;
        String itemDesc;
        Amount price;
        Amount runningTotal;
        
        contrl.startSale();
        System.out.println("New sale has been started");
        
        /*HARDCODED INPUT*/
        try{
        total = contrl.registerItem(2, 2);
        itemDesc = total.getItemDesc();
        price = total.getPrice();
        runningTotal = total.getRunningTotal();
        System.out.println("Item: " + itemDesc + 
                           "\nPrice: " + price + 
                           "\nRunning Total: " + runningTotal);
        
        System.out.println("");
        } catch(InventoryException exc){
            handleException("Correctly failed to register item", exc);
        }
       
        //Try to register item that is not in inventory
        try{
        total = contrl.registerItem(7, 2);
        itemDesc = total.getItemDesc();
        price = total.getPrice();
        runningTotal = total.getRunningTotal();
        System.out.println("Item: " + itemDesc + 
                           "\nPrice: " + price + 
                           "\nRunning total: " + runningTotal);
        
        System.out.println(""); 
        } catch(InventoryException | ItemIdNotFoundException exc){
            handleException("Correctly failed to find exsiting item-id in inventory", exc);
        }
        System.out.println("");
        
        Amount totalPrice = contrl.endSale();
        System.out.println("Total price: " + totalPrice);
        
        System.out.println("");
        
        System.out.println("Enter amount paid: ");
        double amountPaidInput = in.nextDouble();
        Amount amountPaid = new Amount(amountPaidInput);
        
        Amount change = contrl.pay(amountPaid);
        System.out.println("Change: " + change);
        
        System.out.print("\n");
        
        /*PRINTS RECEIPT FOR FUN BC NO EXTERNAL PRINTER IS USED*/
        contrl.printReceipt();
        
       } catch(SQLException | ItemIdNotFoundException exc){
           handleException("Failed to register item, please try again.", exc);
       }
    }
    private void handleException(String uiMsg, Exception exc) {
        errorMsgHandler.showErrorMsg(uiMsg);
        logger.logException(exc);
    }
    
}
