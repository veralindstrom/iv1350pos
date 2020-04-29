
package se.kth.iv1350.pos.integration;


/**
 * Creates external systems.
 * @author Vera
 */
public class ExternalSystemCreator {
    private Accounting accounting;
    private Inventory inventory;

    public ExternalSystemCreator() {
        this.accounting = new Accounting();
        this.inventory = new Inventory();
    }
    
    
    public Accounting getAccounting(){
        return accounting;
    }
    
    public Inventory getInventory(){
        return inventory;
    }
    
}
