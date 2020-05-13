package se.kth.iv350.pos.model;
import se.kth.iv350.pos.util.Address;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Info for one receipt.
 */
public class Receipt {
    private final PriceInfo priceInfo;
    private final Date saletime;
    private final Address address = new Address();
    private final List<ItemAndQuantity> boughtItems;
    
    StringBuilder string = new StringBuilder();
    
 /**
  * Creates new instance. Cannot create new receipt until sale is ended.
  * @param priceInfo Includes total price and total VAT for one entire sale
  * @param saletime Represents time and date of one sale
  * @param boughtItems Represents a list of all bought items (get name and price with getters) and quantity of each item
  */  
    public Receipt(PriceInfo priceInfo, Date saletime, List<ItemAndQuantity> boughtItems) {
        this.priceInfo = priceInfo;
        this.saletime = saletime;
        this.boughtItems = boughtItems;
    }
    
    /**
     * Formatted string with all info for one receipt, that proves one sale, to be printed.
     * @return returns formatted string.
     */
    
    public StringBuilder stringbuilderForReceipt(){
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        
        string.append("RECEIPT\n");
        string.append(address.getStoreName()).append("\n");
        string.append(df.format(saletime)).append("\n\n");
        appendBoughtItems();
        appendPrices(); 
        string.append(getStoreAddress());
        
        return string;
    }
    
    private void appendPrices(){
        string.append("\nTotal price (excl. VAT): ");
        string.append(priceInfo.getTotalPrice().minus(priceInfo.getTotalVatPrice())).append("\n");
        
        string.append("Total VAT: ");
        string.append(priceInfo.getTotalVatPrice()).append("\n");
        string.append("\nTotal price (incl. VAT): ");
        string.append(priceInfo.getTotalPrice()).append("\n");
        
        string.append("\nAmount paid: ");
        string.append(priceInfo.getAmountPaid());
        string.append("\nChange: ");
        string.append(priceInfo.getChange()).append("\n");
    }
    
    private String getStoreAddress(){
        String storeAddress = "\n" +
                              address.getStreet() +
                              "\n" +
                              address.getZipCode() +
                              "\n" +
                              address.getCity() +
                              "\n" +
                              address.getCountry();
        
        return storeAddress;
    }
    
    private void appendBoughtItems(){
        for(int i = 0; i < boughtItems.size(); i++){
            string.append(boughtItems.get(i).getItemName()).append(" ");
            string.append(boughtItems.get(i).getQuantity()).append(" x ");
            string.append(boughtItems.get(i).getPrice()).append("\n");
        }
    }
}
