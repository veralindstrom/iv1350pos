package se.kth.iv350.pos.controller;

import java.sql.SQLException;
import se.kth.iv350.pos.integration.Accounting;
import se.kth.iv350.pos.integration.ExternalSystemCreator;
import se.kth.iv350.pos.integration.Inventory;
import se.kth.iv350.pos.integration.ItemDTO;
import se.kth.iv350.pos.integration.ItemIdNotFoundException;
import se.kth.iv350.pos.util.Amount;
import se.kth.iv350.pos.model.CashPayment;
import se.kth.iv350.pos.model.PaidAmountObserver;
import se.kth.iv350.pos.model.Sale;
import se.kth.iv350.pos.model.TotalDTO;
import se.kth.iv350.pos.view.TotalRenevueView;

/**
 * This is the applications only controller. All calls to the model passes
 * through here
 */
public class Controller {

    private Sale sale;
    private final Accounting acc;
    private final Inventory inv;
    //private TotalDTO total = null;
    private CashPayment payment;
    private Amount amountPaid;
    private Amount change;
    private Amount totalCost;

    private PaidAmountObserver obs = new TotalRenevueView(new Amount(0));

    /**
     * Creates new instance.
     *
     * @param systmCreator Creates new instance of external systems
     */
    public Controller(ExternalSystemCreator systmCreator) {
        acc = systmCreator.getAccounting();
        inv = systmCreator.getInventory();
    }

    /**
     * Starts a new sale. This method must be called first in sale.
     */
    public void startSale() {
        sale = new Sale();
    }

    /**
     * Registers a new item. This method is called for every registration of
     * each item.
     *
     * @param itemId Identifies the item
     * @param quantity The amount of the specified item
     * @return Returns item description, running price and items price
     * @throws se.kth.iv350.pos.integration.ItemIdNotFoundException
     * @throws se.kth.iv350.pos.integration.InventoryException
     * @throws java.sql.SQLException
     */
    public TotalDTO registerItem(int itemId, int quantity) throws ItemIdNotFoundException,
                                                                  SQLException {
        ItemDTO registeredItem;

        //if quantity is not set, set default value to 1
        if (quantity == 0) {
            quantity = 1;
        }

        if (!inv.findItem(itemId)) {
            throw new ItemIdNotFoundException(itemId);
        }

        registeredItem = inv.fetchItem(itemId);

        TotalDTO total = sale.currentRegisteredItemInfo(registeredItem, quantity);

        return total;
    }

    /**
     * Sale ends when every item is registered. At this point, running total
     * will be the same as total price for entire sale.
     *
     * @return Returns total price for entire sale.
     */
    public Amount endSale() {
        totalCost = sale.getRunningTotal();
        payment = new CashPayment(totalCost);
        return totalCost;
    }

    /**
     * Pays paid amount to payment. Sets value for paid amount in cashpayment so
     * change can be calculated then get calculated change.
     *
     * @param amountPaid The amount customer paid (user input).
     * @return
     */
    public Amount pay(Amount amountPaid) {
        this.amountPaid = amountPaid;
        payment.setAmountPaid(amountPaid);
        obs.newPayment(amountPaid);
        change = payment.getCalculatedChange();

        return change;
    }

    /**
     * Prints receipt and updates external systems.
     */
    public void printReceipt() {
        sale.updateExternalSystems();
        sale.printReceipt(totalCost, amountPaid, change);
        
    }

}
