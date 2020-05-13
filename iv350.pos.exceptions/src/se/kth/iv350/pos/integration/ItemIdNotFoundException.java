/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv350.pos.integration;

/**
 * Handles error when inventory could not find the registered item id.
 */
public class ItemIdNotFoundException extends Exception {
    private final int itemIdThatWasNotFound;
    
    /**
     * Creates new instance with a message specifying which item was not found.
     * @param itemIdThatWasNotFound Item that was registered but not found in inventory.
     */
    public ItemIdNotFoundException(int itemIdThatWasNotFound){
        super("ItemID " + itemIdThatWasNotFound + " was not found in Inventory");
        this.itemIdThatWasNotFound = itemIdThatWasNotFound;
    }
    
    public int getItemIdThatWasNotFound(){
        return itemIdThatWasNotFound;
    }
}
