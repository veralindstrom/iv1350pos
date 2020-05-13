/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv350.pos.integration;

import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv350.pos.util.Amount;

/**
 *
 * @author Vera
 */
public class InventoryTest {
    
    @Test
    public void testGetExistingItemFromInventory() throws SQLException {
        ItemDTO existingItem = new ItemDTO("Eco Avocado", 0, new Amount(2.99), new Amount(0.06), "Eco Avocado... VAT: 6%");
        Inventory instance = new Inventory();
        try{
            ItemDTO expResult = existingItem;
            ItemDTO result = instance.fetchItem(0);
            assertEquals("Existing item was not found", expResult, result);
        } catch(InventoryException exc){
            assertTrue("Existing item was not found: " + exc.getMessage(), exc.getMessage().contains("database"));
        }
    }
    
    @Test
    public void testGetNonExistingItemFromInventory() throws SQLException {
        ItemDTO nonExistingItem = null;
        Inventory instance = new Inventory();
        try{
            ItemDTO expResult = nonExistingItem;
            ItemDTO result = instance.fetchItem(10);
            assertEquals("Non-existing item was found", expResult, result);
        } catch(InventoryException exc){
            assertTrue("Non-existing item was not found: " + exc.getMessage(), exc.getMessage().contains("database"));
        }
    }
    
}
