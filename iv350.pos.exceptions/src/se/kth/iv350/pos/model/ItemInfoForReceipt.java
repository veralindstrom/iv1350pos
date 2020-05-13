package se.kth.iv350.pos.model;

import se.kth.iv350.pos.util.Amount;

/**
 * Represent the name, quantity and price of each bought item. For list in receipt.
 * @author Vera
 */
public class ItemInfoForReceipt {
    private final String name;
    private final int quantity;
    private final Amount price;
    
    /**
     * Creates new instance. All info about one item to be printed on receipt.
     * @param name name of item, ex. tomato
     * @param quantity how many of that specific item
     * @param price price for that (one) item
     */
    public ItemInfoForReceipt(String name, int quantity, Amount price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    public String getItemName(){
        return name;
    }
    
    public int getItemQuantity(){
        return quantity;
    }
    
    public Amount getItemPrice(){
        return price;
    }
    
    /**
     * Format when printing whole list. This is not used in the program since
     * each element is printed (added to stringbuilder) seperatly.
     * @return 
     */
    @Override
    public String toString () {
	String s = "";
        s += name + " ";
        s += quantity + " x ";
        s += price;
                
	return s;
    }
}
