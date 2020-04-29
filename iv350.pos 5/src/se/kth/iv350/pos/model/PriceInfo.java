package se.kth.iv350.pos.model;

/**
 * Represent all info about different prices relevant for receipt. 
 * @author Vera
 */

public class PriceInfo {
    private final Amount totalPrice;
    private final Amount totalVatPrice;
    private final Amount amountPaid;
    private final Amount change;
    
    
    /**
     * Creates new instance. Is used to improve encapsulation, cohesion, coupling.
     * @param totalPrice the total cost for one sale
     * @param totalVatPrice the total vat price for one sale
     * @param amountPaid the amount customer paid (from user input)
     * @param change amount paid - total price
     */
    public PriceInfo(Amount totalPrice, Amount totalVatPrice, Amount amountPaid, Amount change) {
        this.totalPrice = totalPrice;
        this.totalVatPrice = totalVatPrice;
        this.amountPaid = amountPaid;
        this.change = change;
    }
    
    public Amount getTotalPrice(){
        return totalPrice;
    }
    
    public Amount getTotalVatPrice(){
        return totalVatPrice;
    }
    
    public Amount getAmountPaid(){
        return amountPaid;
    }
    
    public Amount getChange(){
        return change;
    }
    
}       
