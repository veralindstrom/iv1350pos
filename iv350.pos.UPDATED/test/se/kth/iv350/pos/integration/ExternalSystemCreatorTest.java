/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv350.pos.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vera
 */
public class ExternalSystemCreatorTest {
    ExternalSystemCreator instance;
    
    @Before
    public void createInstanceOfExternalSystemCreator() {
        instance = new ExternalSystemCreator();
    }
    
    @After
    public void destoryInstanceOfExternalSystemCreator() {
        instance = null;
    }

    @Test
    public void testGetAccounting() {
        System.out.println("getAccounting");
        ExternalSystemCreator instance = new ExternalSystemCreator();
        Accounting result = instance.getAccounting();
        assertNotNull(result);
    }

    @Test
    public void testGetInventory() {
        System.out.println("getInventory");
        ExternalSystemCreator instance = new ExternalSystemCreator();
        Inventory result = instance.getInventory();
        assertNotNull(result);
    }
    
}
