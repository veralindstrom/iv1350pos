package se.kth.iv350.pos.view;

import se.kth.iv350.pos.util.Amount;
import se.kth.iv350.pos.model.PaidAmountObserver;


/**
 * The total amount paid for purchases since program started.
 * @author Vera
 */
public class TotalRenevueView implements PaidAmountObserver {
	private Amount amntPaid;
	
        /**
         * Creates new instance. Should be called once when program starts
         * @param startAmount Amount paid should be set to 0 when instance is created.
         */
	public TotalRenevueView(Amount startAmount){
            this.amntPaid = startAmount;
	}
        
	@Override
	public void newPayment(Amount amountPaid) {
            amntPaid = amntPaid.plus(amountPaid);
            System.out.println("\nTotal amount paid since program started: " + amntPaid);
	}
}
