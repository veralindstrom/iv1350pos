package se.kth.iv350.pos.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv350.pos.model.Amount;
import se.kth.iv350.pos.model.ItemAndQuantity;
import se.kth.iv350.pos.model.SaleDTO;

/**
 * Inventory containing all items available in store
 * @author Vera
 */
public class Inventory {
    private String name;
    private Amount price;
    private Amount vatRate;
    private String itemDesc;
    
    private final List<ItemAndQuantity> items = new ArrayList<>();
    
    /**
     * Creates new instance. Hardcoded. Adds items and quantity to items list. 
     * This is a temporary solution since there is no external inventory system in this project 
     */
    public Inventory() {
        items.add(new ItemAndQuantity(new ItemDTO("Eco Avocado", 0, new Amount(2.99), new Amount(0.06), "Eco Avocado... VAT: 6%"), 503));
        items.add(new ItemAndQuantity(new ItemDTO("Medium-fat milk", 1, new Amount(5.79), new Amount(0.12), "Medium-fat milk... VAT: 12%"), 213));
        items.add(new ItemAndQuantity(new ItemDTO("Jensons Farm's Potato", 2, new Amount(3.50), new Amount(0.25), "Jensons Farm's Potato... VAT: 25%"), 704));
        items.add(new ItemAndQuantity(new ItemDTO("Crusty breadsticks", 3, new Amount(3.29), new Amount(0.12), "Crusty breadsticks... VAT: 12% "), 150));
        items.add(new ItemAndQuantity(new ItemDTO("Karin's family lasagna", 4, new Amount(6.99), new Amount(0.06), "Karin's family lasagna... VAT: 6%"), 35));
        items.add(new ItemAndQuantity(new ItemDTO("Gazzo's Microwave Pizza", 5, new Amount(4.99), new Amount(0.06), "Gazzo's Microwave Pizza... VAT: 6%"), 16));
    }
    
    /**
     * Checks if one registered item is in inventory.
     * @param itemId Method bases search on this item identifier number
     * @return Returns true if item is in inventory
     */
    
    public boolean findItem(int itemId){
        boolean itemFound = false;
        
        ItemDTO registeredItem = checkForMatchingItemInInventory(itemId);
            
            //compares every items id in list to itemId
            if(registeredItem.getItemId() == itemId) //should use equals() instead
                itemFound = true;
        
        return itemFound;
    }
    
    /**
     * Represents one registered item and it's attributes.
     * @param itemId The represented item is identified with this idetifier number
     * @return Returns item description, wanted quantity, 
     *         price and VAT rate of the registered item
     */
    
    public ItemDTO fetchItem(int itemId){
        ItemDTO foundItem = checkForMatchingItemInInventory(itemId);
        
        if(foundItem != null){
            name = foundItem.getItemName();
            price = foundItem.getPrice();
            vatRate = foundItem.getVAT();
            itemDesc = foundItem.getItemDesc();
        }    
        
        ItemDTO registeredItem = new ItemDTO(name, itemId, price, vatRate, itemDesc);
      
        return registeredItem;
    }
    
    private ItemDTO checkForMatchingItemInInventory(int itemId){
        ItemDTO currentIterationItem = null;
        
        for(int i = 0; i < items.size(); i++){
            currentIterationItem = items.get(i).getItem();
            if(currentIterationItem.getItemId() == itemId) //should use equals() instead?
                break;
        }
        return currentIterationItem;
    }
    
    /**
     * Updates inventory after one sale is completed. Subtract the 
     * quantity bought of each item from inventory items list. 
     * @param saleinfo Contains information about items bought and all prices in one sale.
     */
    public void updateInventory(SaleDTO saleinfo){
        int itemId;
        int itemQuantity;
        List<ItemAndQuantity> registeredItemsList = saleinfo.getRegisteredItems();
        
        ItemDTO currentIterationItem = null;
        
        for(int i = 0; i < registeredItemsList.size(); i++){
            itemId = registeredItemsList.get(i).getItemId();
            itemQuantity = registeredItemsList.get(i).getQuantity();
            
            updateItemsList(currentIterationItem, itemId, itemQuantity);
            
        }
    }
    
    private void updateItemsList(ItemDTO currentIterationItem, int itemId, int itemQuantity){
        for(int j = 0; j < items.size(); j++){
            currentIterationItem = items.get(j).getItem();
            if(currentIterationItem.getItemId() == itemId) //should use equals() instead?
                items.set(j, new ItemAndQuantity(currentIterationItem, itemQuantity));
        }
    }
}