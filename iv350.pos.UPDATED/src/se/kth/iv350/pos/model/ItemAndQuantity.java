package se.kth.iv350.pos.model;

import se.kth.iv350.pos.integration.ItemDTO;

/**
 * Represents one item and the quantity for that registered item.
 * @author Vera
 */

public class ItemAndQuantity {
    private final ItemDTO item;
    private final int quantity; 
    
    /**
     * Creates new instance of item and it's quantity.
     * @param item The item registered
     * @param quantity Quantity of that registered item
     */
    public ItemAndQuantity(ItemDTO item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    
    public ItemDTO getItem(){
        return item;
    }
    
    public String getItemName(){
        return item.getItemName();
    }
    
    public int getItemId(){
       return item.getItemId();
    }
    
    public String getItemDesc(){
        return item.getItemDesc();
    }
    
    public Amount getPrice(){
        return item.getPrice();
    }
    
    public int getQuantity(){
        return quantity;
    }
}
