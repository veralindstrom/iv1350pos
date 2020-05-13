
package se.kth.iv350.pos.integration;


/**
 * Creates external systems.
 * @author Vera
 */
public class ExternalSystemCreator {
    private final Accounting accounting;
    private final Inventory inventory;

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
