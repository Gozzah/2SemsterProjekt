/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.entities.carport;

/**
 *
 * @author Runej
 */
public class Carport{
    
    
    private int carportID;
    private String carportName;
    private int carportWidth;
    private int carportLength;
    private int carportHeight;
    private int roofSlope;
    private String woodType;
    private int woodPrice;
    private int plankHeight;
    private int plankLength;
    private String woodColor;
    private int totalPlankAmount;
    private int plankScrewAmount;
    private String eaveType;
    private int eavePrice;
    private int eaveWidth;
    private int eaveLength;
    private String eaveColor;
    private int eaveAmount;
    private int eaveScrewAmount;
    private int totalScrewAmount;
    private int woodID;
    private int woodColorID;
    private int eaveID;
    private int eaveColorID;
    private int totalPrice;
   
    
    

    public Carport(int carportID,String carportName,int carportWidth,int carportLength,int carportHeight,int roofSlope,String woodType,int woodPrice,int plankHeight, int plankLength,String woodColor,int totalPlankAmount,int plankScrewAmount, String eaveType, int eavePrice,int eaveWidth, int eaveLength,String eaveColor,int eaveAmount,int eaveScrewAmount, int totalScrewAmount, int totalPrice) {
       
        // Constructor til CarportMapper (getCarport)
        
        this.carportID = carportID;
        this.carportName = carportName;
        this.carportWidth = carportWidth;
        this.carportLength = carportLength;
        this.carportHeight = carportHeight;
        this.roofSlope = roofSlope;
        this.woodType = woodType;
        this.woodPrice = woodPrice;
        this.plankHeight = plankHeight;
        this.plankLength = plankLength;
        this.woodColor = woodColor;
        this.totalPlankAmount = totalPlankAmount;
        this.plankScrewAmount = plankScrewAmount;
        this.eaveType = eaveType;
        this.eavePrice = eavePrice;
        this.eaveWidth = eaveWidth;
        this.eaveLength = eaveLength;
        this.eaveColor = eaveColor;
        this.eaveAmount = eaveAmount;
        this.eaveScrewAmount = eaveScrewAmount;
        this.totalScrewAmount = totalScrewAmount;
        this.totalPrice = totalPrice;
    }
    
        public Carport(String carportName,int carportWidth,int carportLength,int carportHeight,int roofSlope,int woodID,int woodPrice,int plankHeight, int plankLength,int woodColorID,int totalPlankAmount,int plankScrewAmount, int eaveID, int eavePrice,int eaveWidth, int eaveLength,int eaveColorID,int eaveAmount,int eaveScrewAmount, int totalScrewAmount, int totalPrice) {
       
        //Constructor til Calculator-metoden i logik-lag (beregn antal planker, skruer, tagplader, samlet pris etc...)
        this.carportName = carportName; 
        this.carportWidth = carportWidth;
        this.carportLength = carportLength;
        this.carportHeight = carportHeight;
        this.roofSlope = roofSlope;
        this.woodID = woodID;
        this.woodPrice = woodPrice;
        this.plankHeight = plankHeight;
        this.plankLength = plankLength;
        this.woodColorID = woodColorID;
        this.totalPlankAmount = totalPlankAmount;
        this.plankScrewAmount = plankScrewAmount;
        this.eaveID = eaveID;
        this.eavePrice = eavePrice;
        this.eaveWidth = eaveWidth;
        this.eaveLength = eaveLength;
        this.eaveColorID = eaveColorID;
        this.eaveAmount = eaveAmount;
        this.eaveScrewAmount = eaveScrewAmount;
        this.totalScrewAmount = totalScrewAmount;
        this.totalPrice = totalPrice;
    }
        


    public Carport(String carportName, int carportWidth, int carportLength, int carportHeight, int roofSlope, int woodID, int woodPrice, int plankHeight, int plankLength, int woodColorID, int eaveID, int eavePrice, int eaveWidth, int eaveLength, int eaveColorID, int totalPrice) {
        
        // Constructor create carport i CarportServlet
        this.carportName = carportName;
        this.carportWidth = carportWidth;
        this.carportLength = carportLength;
        this.carportHeight = carportHeight;
        this.roofSlope = roofSlope;
        this.woodID = woodID;
        this.woodPrice = woodPrice;
        this.plankHeight = plankHeight;
        this.plankLength = plankLength;
        this.woodColorID = woodColorID;
        this.eaveID = eaveID;
        this.eavePrice = eavePrice;
        this.eaveWidth = eaveWidth;
        this.eaveLength = eaveLength;
        this.eaveColorID = eaveColorID;
        this.totalPrice = totalPrice;
        
    }


    
    public int getWoodColorID() {
        return woodColorID;
    }

    public int getEaveColorID() {
        return eaveColorID;
    }

    public int getPlankLength() {
        return plankLength;
    }

    public int getPlankHeight() {
        return plankHeight;
    }

    public int getEaveLength() {
        return eaveLength;
    }

    public int getEaveWidth() {
        return eaveWidth;
    }

    public int getTotalPlankAmount() {
        return totalPlankAmount;
    }

    public int getRoofSlope() {
        return roofSlope;
    }

    public int getEaveAmount() {
        return eaveAmount;
    }

    public int getPlankScrewAmount() {
        return plankScrewAmount;
    }

    public int getEaveScrewAmount() {
        return eaveScrewAmount;
    }

    public int getTotalScrewAmount() {
        return totalScrewAmount;
    }

    /**
     * @return the carportWidth
     */
    public int getCarportWidth() {
        return carportWidth;
    }

    /**
     * @return the carportLength
     */
    public int getCarportLength() {
        return carportLength;
    }

    /**
     * @return the carportHeight
     */
    public int getCarportHeight() {
        return carportHeight;
    }

    /**
     * @return the carportID
     */
    public int getCarportID() {
        return carportID;
    }

    /**
     * @return the customerID
     */
  

    public String getCarportName() {
        return carportName;
    }

    /**
     * @return the woodID
     */
    public int getWoodID() {
        return woodID;
    }

    /**
     * @return the woodType
     */
    public String getWoodType() {
        return woodType;
    }

    /**
     * @return the woodColor
     */
    public String getWoodColor() {
        return woodColor;
    }

    /**
     * @return the eaveID
     */
    public int getEaveID() {
        return eaveID;
    }

    /**
     * @return the eaveType
     */
    public String getEaveType() {
        return eaveType;
    }

    /**
     * @return the eaveColor
     */
    public String getEaveColor() {
        return eaveColor;
    }

    /**
     * @return the totalPrice
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    public int getWoodPrice() {
        return woodPrice;
    }

    public void setWoodPrice(int woodPrice) {
        this.woodPrice = woodPrice;
    }

    public int getEavePrice() {
        return eavePrice;
    }

    public void setEavePrice(int eavePrice) {
        this.eavePrice = eavePrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    



}

