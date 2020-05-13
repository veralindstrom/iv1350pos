package se.kth.iv350.pos.model;

import se.kth.iv350.pos.util.Amount;

/**
 * Contains item description, running total and item price of the registered item.
 */
public class TotalDTO {
    
    private final String itemDesc;
    private final Amount runningTotal;
    private final Amount price;
     
    /**
     * Creates a new instance with the specified attributes
     * @param itemDesc describes the item
     * @param runningTotal running price of the total sale
     * @param price price of specified item
     */
    public TotalDTO(String itemDesc, Amount runningTotal, Amount price) {
        this.itemDesc = itemDesc;
        this.runningTotal = runningTotal;
        this.price = price;
    }
    
    public String getItemDesc(){
        return itemDesc;
    }
    
    public Amount getRunningTotal(){
        return runningTotal;
    }
    
    public Amount getPrice(){
        return price;
    }
            
    
}
