package se.kth.iv350.pos.model;

import se.kth.iv350.pos.util.Amount;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import se.kth.iv350.pos.integration.ItemDTO;
import se.kth.iv350.pos.integration.Printer;
import se.kth.iv350.pos.integration.SystemUpdater;

/**
 * Contains all info about the current sale.
 */

public class Sale {
    private final Date saleTime;
    private final Printer printer = new Printer();
    private final SystemUpdater systmUpdater = new SystemUpdater();
    
    private Receipt infoForReceipt;
    private StringBuilder receipt;
    
    private PriceInfo priceInfo;
    //private TotalDTO total;
    private Amount itemVatPrice;
    
    //value updates over times
    private Amount runningPrice = new Amount(0);
    private Amount totalVatPriceForEntireSale = new Amount(0);
    
    private List<ItemAndQuantity> registeredItemsList = new ArrayList<>();
    private List<PaidAmountObserver> paidAmountObservers = new ArrayList<>();
    
   /**
    * Creates new instance Sale. Sets date and time of when sale's started.
    */
    public Sale() {
        saleTime = new Date();
    }
    
    /**
     * Is used for every registered item.
     * @param currentRegisteredItem
     * @param quantity Represents the amount of items the customer wants to buy
     * @return Returns an object with item description, running price and price of registered item
     */
    public TotalDTO currentRegisteredItemInfo(ItemDTO currentRegisteredItem, int quantity){     
            Amount itemPrice = currentRegisteredItem.getPrice();
            String itemDesc = currentRegisteredItem.getItemDesc();
        
            runningPrice = updateRunningPrice(currentRegisteredItem, quantity);
            registeredItemsList = addItemToRegisteredItemList(currentRegisteredItem, quantity);
        
            TotalDTO total = new TotalDTO(itemDesc, runningPrice, itemPrice);
            return total;
        
    }
    
    private Amount updateRunningPrice(ItemDTO currentRegisteredItem, int quantity){
        Amount itemVatRate = currentRegisteredItem.getVAT();
        Amount itemPrice = currentRegisteredItem.getPrice();
        
        Amount itemPriceInculdingVat = calculateVatPrice(itemPrice, itemVatRate);
        //add (items price * quantity of item) to running total 
        for(int i = 0; i < quantity; i++){
            runningPrice = runningPrice.plus(itemPriceInculdingVat);
            totalVatPriceForEntireSale = totalVatPriceForEntireSale.plus(itemVatPrice);
            
        }
        return runningPrice;
    }
    
    private Amount calculateVatPrice(Amount itemPrice, Amount itemVatRate){
        itemVatPrice = itemVatRate.multiply(itemPrice);
        
        Amount itemPriceInculdingVat = itemVatPrice.plus(itemPrice);
        
        return itemPriceInculdingVat;
    }
    
    /* Aware of very long method, explained in report*/
    private List<ItemAndQuantity> addItemToRegisteredItemList(ItemDTO item, int quantity){
        ItemAndQuantity currentIterationItem;
        int itemId = item.getItemId();
        boolean itemAlreadyRegistered = false;
        int updatedQuantity;
        
        if(!registeredItemsList.isEmpty()){
            for(int i = 0; i < registeredItemsList.size(); i++){
                currentIterationItem = registeredItemsList.get(i);
                if(currentIterationItem.getItemId() == itemId) {
                    itemAlreadyRegistered = true;
                    
                    updatedQuantity = increaseQuantity(currentIterationItem.getQuantity(), quantity);
                    registeredItemsList.set(i, new ItemAndQuantity(item, updatedQuantity));
                    //System.out.println("Quantity of item was increased");
                } 
            }
            if(!itemAlreadyRegistered)
                addItem(item, quantity);
        } 
        
        if(registeredItemsList.isEmpty())
            addItem(item, quantity);
        
        return registeredItemsList;
    }
    
    private int increaseQuantity(int currentQuantity, int addedQuantity){
        return currentQuantity + addedQuantity;
    }
    
    private void addItem(ItemDTO item,int quantity){
        //add item to list of registered items
        registeredItemsList.add(new ItemAndQuantity(item, quantity));
        //System.out.println("Item was added");
    }
    
    /**
     * Getter for running total
     * @return running total for entire sale
     */
    public Amount getRunningTotal(){
        return runningPrice;
    }
    
    /**
     * All data about one sale for receipt. Sends receipt to printer.
     * @param totalCost Total price of sale
     * @param amountPaid Amount paid by customer (user input)
     * @param change Amount paid - total price
     */
    
    public void printReceipt(Amount totalCost, Amount amountPaid, Amount change){
        priceInfo = new PriceInfo(totalCost, totalVatPriceForEntireSale, amountPaid, change); 
        infoForReceipt = new Receipt(priceInfo, saleTime, registeredItemsList);
        receipt = infoForReceipt.stringbuilderForReceipt();
        printer.printReceipt(receipt);
    }
    
    /**
     * Updates the external systems with new information. 
     */
    
    public void updateExternalSystems(){
        SaleDTO saleInfo = new SaleDTO(registeredItemsList, priceInfo);
        systmUpdater.updateSystems(saleInfo);
    }
    
}
