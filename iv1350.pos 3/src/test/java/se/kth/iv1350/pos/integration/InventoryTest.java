package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.pos.model.Amount;

/**
 * TODO: Add more tests
 */
public class InventoryTest {

    @Test
    public void testGetExistingItemFromInventory() {
        
        ItemDTO existingItem = new ItemDTO("Eco Avocado", 0, new Amount(2.99), new Amount(0.06), "Eco Avocado... VAT: 6%");
        Inventory instance = new Inventory();
        ItemDTO expResult = existingItem;
        ItemDTO result = instance.fetchItem(0);
        assertEquals(expResult, result, "Existing item was not found");
    }
    
    @Test
    public void testGetNonExistingItemFromInventory() {
        ItemDTO expResult = null;
        Inventory instance = new Inventory();
        ItemDTO result = instance.fetchItem(0);
        assertEquals(expResult, result, "Non-existing item was found");
    }
}
