/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv350.pos.view;

import java.util.Scanner;
import se.kth.iv350.pos.controller.Controller;
import se.kth.iv350.pos.model.Amount;
import se.kth.iv350.pos.model.TotalDTO;

/**
 * @author Vera
 * This is a placeholder for the real view. It contains hardcoded execution 
 * with calls to all system operation in controller.
 */
public class View {
    private final Controller contrl;
    private final Scanner in = new Scanner(System.in); //for user input
    /**
     * Creates new instance. that uses specified controller for all calls to other layers.
     * 
     * @param contrl The controller to use for all calls to other layers
     */
    public View (Controller contrl){
        this.contrl = contrl;
    }
    
    /**
     * Performs a fake sale by calling all system operations in the controller.
     */
    
    public void runFakeExecution(){ 
        contrl.startSale();
        System.out.println("New sale has been started");
        
        /*HARDCODED INPUT*/
        TotalDTO total = contrl.registerItem(2, 2);
        String itemDesc = total.getItemDesc();
        Amount price = total.getPrice();
        Amount runningTotal = total.getRunningTotal();
        System.out.println("Item: " + itemDesc + 
                           "\nPrice: " + price + 
                           "\nRunning Total: " + runningTotal);
        
        System.out.println("");
        
        total = contrl.registerItem(1, 2);
        itemDesc = total.getItemDesc();
        price = total.getPrice();
        runningTotal = total.getRunningTotal();
        System.out.println("Item: " + itemDesc + 
                           "\nPrice: " + price + 
                           "\nRunning total: " + runningTotal);
        
        System.out.println("");
        
        total = contrl.registerItem(2, 1);
        itemDesc = total.getItemDesc();
        price = total.getPrice();
        runningTotal = total.getRunningTotal();
        System.out.println("Item: " + itemDesc + 
                           "\nPrice: " + price + 
                           "\nRunning total: " + runningTotal);
        
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
        
    }
    
}
