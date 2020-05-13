/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv350.pos.controller;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv350.pos.integration.ExternalSystemCreator;
import se.kth.iv350.pos.integration.InventoryException;
import se.kth.iv350.pos.integration.ItemIdNotFoundException;
import se.kth.iv350.pos.model.TotalDTO;

public class ControllerTest {
    
    @Test
    public void testRegisterNonExistingItem() throws Exception {
        ExternalSystemCreator systmC = new ExternalSystemCreator();
        Controller instance = new Controller(systmC);
        System.out.println("registerItem");
       
        int itemId = 10;
        int quantity = 1;
        
        try{
            TotalDTO expResult = null;
            TotalDTO result = instance.registerItem(itemId, quantity);
            assertEquals("Could register non-existing item", expResult, result);
        } catch(InventoryException | ItemIdNotFoundException exc ){
            assertTrue("Wrong exception message: " + exc.getMessage(), exc.getMessage().contains("not found") || 
                                                                         exc.getMessage().contains("database"));
        }
    }

    
}
