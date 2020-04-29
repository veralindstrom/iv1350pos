/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.pos.model;

/**
 * Represents one specific retail stores address info
 * @author Vera
 */
public class Address {
    private final String storeName;
    private final String street; 
    private final String zipCode;
    private final String city;
    private final String country;

    /**
     * Hardcoded address info
     */
    public Address() {
        storeName = "Veras Retail Store";
        street = "Strandvägen 1";
        zipCode = "114 51";
        city = "Stockholm";
        country = "Sweden";
    }
    
    public String getStoreName(){
        return storeName;
    }
    
    public String getStreet(){
        return street;
    }
    
    public String getZipCode(){
        return zipCode;
    }
    
    public String getCity(){
        return city;
    }
    
    public String getCountry(){
        return country;
    }
}
