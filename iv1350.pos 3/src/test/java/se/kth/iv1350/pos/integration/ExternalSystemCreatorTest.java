package se.kth.iv1350.pos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class ExternalSystemCreatorTest {
    ExternalSystemCreator instance;
    
    @BeforeEach
    public void createInstanceOfExternalSystemCreator() {
        instance = new ExternalSystemCreator();
    }
    
    @AfterEach
    public void destoryInstanceOfExternalSystemCreator() {
        instance = null;
    }
    
    @Test
    public void testExternalSystemCreator() {
        Inventory result = instance.getInventory();
        assertTrue(result instanceof Inventory, "ExternalSystemCreator"
                + "did not create an instance of Inventory");
    }
    
}
