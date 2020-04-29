/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv350.pos.integration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vera
 */
public class ExternalSystemCreatorTest {
    ExternalSystemsCreator instance;
    
    @BeforeEach
    public void createInstanceOfExternalSystemCreator() {
        instance = new ExternalSystemCreator();
    }
    
    @AfterEach
    public void destoryInstanceOfExternalSystemCreator() {
        instance = null;
    }
    

    @Test
    public void testCreateInventory() {
        System.out.println("createInventory");
        ExternalSystemCreator instance = new ExternalSystemCreator();
        instance.createInventory();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateAccounting() {
        System.out.println("createAccounting");
        ExternalSystemCreator instance = new ExternalSystemCreator();
        instance.createAccounting();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAccounting() {
        System.out.println("getAccounting");
        ExternalSystemCreator instance = new ExternalSystemCreator();
        Accounting expResult = null;
        Accounting result = instance.getAccounting();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetInventory() {
        System.out.println("getInventory");
        ExternalSystemCreator instance = new ExternalSystemCreator();
        Inventory expResult = null;
        Inventory result = instance.getInventory();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
