
package se.kth.iv350.pos.model;

/**
 * Represents one payment for one sale. 
 * @author Vera
 */
public class CashPayment {
    Amount amountPaid;
    Amount totalCost;
    Amount change;
    
    /**
     * Creates new instance of payment.
     * @param totalCost total cost for entire sale
     */
    public CashPayment(Amount totalCost) {
        this.totalCost = totalCost;
    }
    
    public void setAmountPaid(Amount amountPaid){
        this.amountPaid = amountPaid;
    }
    
    public Amount getAmountPaid(){
        return amountPaid;
    }
    
    public Amount getTotalCost(){
        return totalCost;
    }
    
    public Amount getCalculatedChange(){
        change = amountPaid.minus(totalCost);
        return change;
    }
    
    
}
