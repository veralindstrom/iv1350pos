package se.kth.iv350.pos.model;

import java.text.DecimalFormat;
import se.kth.iv350.pos.util.Amount;
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
    DecimalFormat df = new DecimalFormat("#.##");
    
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
        assertEquals("Wrong subtraction result", expResult.toString(), result.toString());
    }

    @Test
    public void testMinusNegeativeResult() {
        double amountOfOperand1 = 2;
        double amountOfOperand2 = 5;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 - amountOfOperand2);
        Amount result = operand1.minus(operand2);
        assertEquals("Wrong subtraction result", expResult.toString(), result.toString());
    }
    
    @Test
    public void testMinusZeroResultNegativeOperand() {
        double amountOfOperand1 = -5;
        double amountOfOperand2 = -5;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 - amountOfOperand2);
        Amount result = operand1.minus(operand2);
        assertEquals("Wrong subtraction result", expResult.toString(), result.toString());
    }
    
    @Test
    public void testPlus() {
        double amountOfOperand1 = 5;
        double amountOfOperand2 = 2;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 + amountOfOperand2);
        Amount result = operand1.plus(operand2);
        assertEquals("Wrong addition result", expResult.toString(), result.toString());
    }

    @Test
    public void testPlusNegeativeResult() {
        double amountOfOperand1 = 2;
        double amountOfOperand2 = -5;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 + amountOfOperand2);
        Amount result = operand1.plus(operand2);
        assertEquals("Wrong addition result", expResult.toString(), result.toString());
    }
    
    @Test
    public void testPlusZeroResultNegativeOperand() {
        double amountOfOperand1 = -2;
        double amountOfOperand2 = 2;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 + amountOfOperand2);
        Amount result = operand1.plus(operand2);
        assertEquals("Wrong addition result", expResult.toString(), result.toString());
    }
    
    @Test
    public void testMultiply() {
        double amountOfOperand1 = 5;
        double amountOfOperand2 = 2;
        Amount operand1 = new Amount(amountOfOperand1);
        Amount operand2 = new Amount(amountOfOperand2);
        Amount expResult = new Amount(amountOfOperand1 * amountOfOperand2);
        Amount result = operand1.multiply(operand2);
        assertEquals("Wrong multiplication result", expResult.toString(), result.toString());
    }

    @Test
    public void toStringPosAmt() {
        double representedAmt = 10;
        Amount amount = new Amount(representedAmt);
        String expResult = Double.toString(representedAmt);
        String result = amount.toString();
        assertEquals("Wrong string returned by toString", expResult, result);
    }

    @Test
    public void toStringNegAmt() {
        double representedAmt = -10;
        Amount amount = new Amount(representedAmt);
        String expResult = Double.toString(representedAmt);
        String result = amount.toString();
        assertEquals( "Wrong string returned by toString", expResult, result);
    }

    @Test
    public void toStringZeroAmt() {
        double representedAmt = 0;
        Amount amount = new Amount(representedAmt);
        String expResult = Double.toString(representedAmt);
        String result = amount.toString();
        assertEquals("Wrong string returned by toString", expResult, result);
    }
    
}
