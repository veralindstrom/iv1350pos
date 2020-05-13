/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv350.pos.model;

import se.kth.iv350.pos.util.Amount;

/**
 *
 * @author Vera
 */
public interface PaidAmountObserver {
    
	/**
         * Method to update the observer, used by subject.
         * @param amountPaid The amount paid for one payment.
         */
	public void newPayment(Amount amountPaid);
}
