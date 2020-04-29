package se.kth.iv350.pos.model;

import java.text.DecimalFormat;


/**
 * Representing an amount of money. Instances are immutable
 * @author Vera
 */
public class Amount {
    private final double amount;
    
    /**
     * Creates a new instance, representing the amount 0.
     */
    public Amount() {
        this(0);
    }
    /**
     * Creates a new instance. Represent the speficied amount
     * @param amount The amount represented by the newly created instance.
     */
    public Amount(double amount) {
        this.amount = amount;
    }
    
    /**
     * Subtracts one amount from another.
     * @param other The amount to subtract
     * @return The result of the subtraction.
     */
    public Amount minus(Amount other) {
        return new Amount(amount - other.amount);
    }
    
    /**
     * Adds one amount to another.
     * @param other The amount to add
     * @return The result of the addition.
     */
    public Amount plus(Amount other) {
        return new Amount(amount + other.amount);
    }
    
    /**
     * Multiplies one amount to another.
     * @param other The amount to multiply
     * @return The result of the multiplication.
     */
    public Amount multiply(Amount other) {
        return new Amount(amount * other.amount);
    }
    
    /**
     * Formatted output for amount.
     * @return Returns a (readble) value of the amount object with 2 decimals
     */
    
    @Override
    public String toString () {
        DecimalFormat df2 = new DecimalFormat("#.##");
	String s = "";
        s += df2.format(amount);
                
	return s;
    }
}
