/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.entities.order;

/**
 *
 * @author Runej
 */
public class Orders {
    
    private int orderID;
    private int customerID;
    private int carportID;
    private int quantity;
    private int totalPrice;
    

    public Orders(int orderID, int customerID) {
        this.orderID = orderID;
        this.customerID = customerID;
    }
    
        public Orders(int customerID, int carportID, int quantity, int totalPrice) {
        this.carportID = carportID;
        this.customerID = customerID;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    /**
     * @return the orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * @return the customerID
     */
    public int getCustomerID() {
        return customerID;
    }

    public int getCarportID() {
        return carportID;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
    


    
}
