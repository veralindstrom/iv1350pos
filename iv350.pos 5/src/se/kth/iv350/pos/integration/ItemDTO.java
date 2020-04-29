package se.kth.iv350.pos.integration;
import se.kth.iv350.pos.model.Amount;
/**
 * Represents one item.
 * @author Vera
 */
public class ItemDTO {
    private final String name;
    private final int itemId;
    private final Amount price;
    private final Amount vatRate;
    private final String itemDesc;
    
    /**
     * Creates new instance item. 
     * @param name name of item
     * @param itemId items identification number
     * @param price items price 
     * @param vatRate items VAT rate
     * @param itemDesc items name and VAT rate
     */
    public ItemDTO(String name, int itemId, Amount price, 
            Amount vatRate, String itemDesc) {
        this.name = name;
        this.itemId = itemId;
        this.price = price;
        this.vatRate = vatRate;
        this.itemDesc = itemDesc;
    }
    
    public String getItemName(){
        return name;
    }
    
    public int getItemId(){
        return itemId;
    }
    
    public Amount getPrice(){
        return price;
    }
    
    public Amount getVAT(){
        return vatRate;
    }
    
    public String getItemDesc(){
        return itemDesc;
    }
}
