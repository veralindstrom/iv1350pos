package se.kth.iv350.pos.model;

import java.util.List;

/**
 *Contatins info about one sale. Is used to update inventory and accounting system.
 */
public class SaleDTO {
    private PriceInfo priceInfo;
    private List<ItemAndQuantity> registeredItems;
    /**
     * Creates new instance. Contains all information that is needed to update inventory and 
     * accounting system.
     * @param registeredItems Contains every bit of information about each item bought in one sale.
     * @param priceInfo Contains every bit of information about every price in one sale neccessary for accouting.
     */
    public SaleDTO(List<ItemAndQuantity> registeredItems, PriceInfo priceInfo) {
        this.registeredItems = registeredItems;
        this.priceInfo = priceInfo;
    }
    
    public List<ItemAndQuantity> getRegisteredItems(){
        return registeredItems;
    }
    
    public PriceInfo getPriceInfo(){
        return priceInfo;
    }
    
}
