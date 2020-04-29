/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv350.pos.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv350.pos.controller.Controller;
import se.kth.iv350.pos.integration.ExternalSystemCreator;
import se.kth.iv350.pos.integration.Printer;

/**
 *
 * @author Vera
 */
public class ViewTest {
    ExternalSystemCreator creator;
    Printer printer;
    private View instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;
    
    public ViewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        creator = new ExternalSystemCreator();
        printer = new Printer();
        Controller contr = new Controller(creator);
        instanceToTest = new View(contr);
        
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }
    
    @After
    public void tearDown() {
        creator = null;
        printer = null;
        instanceToTest = null;
        
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void testRunFakeExecution() {
        instanceToTest.runFakeExecution();
        String printout = printoutBuffer.toString();
        String expectedOutput = "start";
        assertTrue(printout.contains(expectedOutput), "UI did not start correctly.");
    }
    
}
