package se.kth.iv350.pos.model;

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
public class AmountTest {
    private Amount amtNoArgConstr;
    private Amount amtWithAmtThree;
    
    public AmountTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        amtNoArgConstr = new Amount();
        amtWithAmtThree = new Amount(3);
    }
    
    @After
    public void tearDown() {
        amtNoArgConstr = null;
        amtWithAmtThree = null;
    }
    
    @Test
    public void testMinus() {
        double amountOfOperand1 = 5;
        double amountOfOperand2 = 2;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 - amountOfOperand2);
        Amount result = operand1.minus(operand2);
        assertEquals(expResult.toString(), result, "Wrong subtraction result");
    }

    @Test
    public void testMinusNegeativeResult() {
        double amountOfOperand1 = 2;
        double amountOfOperand2 = 5;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 - amountOfOperand2);
        Amount result = operand1.minus(operand2);
        assertEquals(expResult.toString(), result, "Wrong subtraction result");
    }
    
    @Test
    public void testMinusZeroResultNegativeOperand() {
        double amountOfOperand1 = -5;
        double amountOfOperand2 = -5;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 - amountOfOperand2);
        Amount result = operand1.minus(operand2);
        assertEquals(expResult.toString(), result, "Wrong subtraction result");
    }
    
    @Test
    public void testPlus() {
        double amountOfOperand1 = 5;
        double amountOfOperand2 = 2;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 + amountOfOperand2);
        Amount result = operand1.plus(operand2);
        assertEquals(expResult.toString(), result, "Wrong addition result");
    }

    @Test
    public void testPlusNegeativeResult() {
        double amountOfOperand1 = 2;
        double amountOfOperand2 = -5;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 + amountOfOperand2);
        Amount result = operand1.plus(operand2);
        assertEquals(expResult.toString(), result, "Wrong addition result");
    }
    
    @Test
    public void testPlusZeroResultNegativeOperand() {
        double amountOfOperand1 = -2;
        double amountOfOperand2 = 2;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 + amountOfOperand2);
        Amount result = operand1.plus(operand2);
        assertEquals(expResult.toString(), result, "Wrong addition result");
    }
    
    @Test
    public void testMultiply() {
        double amountOfOperand1 = 5;
        double amountOfOperand2 = 2;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 * amountOfOperand2);
        Amount result = operand1.multiply(operand2);
        assertEquals(expResult.toString(), result, "Wrong multiplication result");
    }

    @Test
    public void toStringPosAmt() {
        double representedAmt = 10;
        Amount amount = new Amount(representedAmt);
        String expResult = Double.toString(representedAmt);
        String result = amount.toString();
        assertEquals(expResult, result, "Wrong string returned by toString");
    }

    @Test
    public void toStringNegAmt() {
        double representedAmt = -10;
        Amount amount = new Amount(representedAmt);
        String expResult = Double.toString(representedAmt);
        String result = amount.toString();
        assertEquals(expResult, result, "Wrong string returned by toString");
    }

    @Test
    public void toStringZeroAmt() {
        double representedAmt = 0;
        Amount amount = new Amount(representedAmt);
        String expResult = Double.toString(representedAmt);
        String result = amount.toString();
        assertEquals(expResult, result, "Wrong string returned by toString");
    }
    
}
