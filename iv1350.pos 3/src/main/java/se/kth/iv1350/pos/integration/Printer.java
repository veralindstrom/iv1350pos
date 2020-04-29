package se.kth.iv1350.pos.integration;

/**
 * Represents the printer that prints one receipt.
 * @author Vera
 */
public class Printer {
    
    /** 
     * Creates new instance. Should only be initialized once.
     */
    public Printer() {
        System.out.println("Printer is turned on");
    }
  
    /**
     * Prints receipt. This method should be called by a real printer but for 
     * now the receipt is printed to View since no real printer is
     * included in this project.
     * @param receipt Contains a string with all relevant information.
     */
    
    public void printReceipt(StringBuilder receipt){
        System.out.println(receipt);
    }
    
}
