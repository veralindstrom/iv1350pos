/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv350.pos.integration;

import se.kth.iv350.pos.model.SaleDTO;

/**
 * Used to update the external systems. To keep low coupling.
 * @author Vera
 */
public class SystemUpdater {
    Inventory inv = new Inventory();
    Accounting acc = new Accounting();
    
    public SystemUpdater() {
       
    }
    
    /**
     * Updates external systems.
     * @param saleinfo Information about bought items in sale and all prices,
     *                  ex: total cost, amount paid, change...
     */
    public void updateSystems(SaleDTO saleinfo){
        inv.updateInventory(saleinfo);
        acc.updateAccounting(saleinfo);
    }
}
