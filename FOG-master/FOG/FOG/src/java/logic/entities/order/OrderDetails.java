/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.entities.order;

/**
 *
 * @author kennethlundh
 */
public class OrderDetails {
    private int carportID;
    
    private int orderID;
    private String carportName;
    private int productID;
    private int orderDetailID;
    private int quantity;
    private int price;
    private int unitPrice;
    private String orderStatus;
    private int orderTotalPrice;
   String orderDate;
    
    //Constructor til vis ordrestatus/admin
    
    public OrderDetails(int orderDetailID,int carportID,int orderID,int quantity,int unitPrice,int orderTotalPrice,String orderStatus,String orderDate) {
        this.orderDetailID = orderDetailID;
        this.carportID = carportID;
        this.orderID = orderID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.orderTotalPrice = orderTotalPrice;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }

    public OrderDetails(String carportName, int totalPrice, int quantity, int orderTotalPrice, int orderID, String orderStatus, String orderDate) {
        this.carportName = carportName;
        this.unitPrice = totalPrice;
        this.quantity = quantity;
        this.orderTotalPrice = orderTotalPrice;
        this.orderID = orderID;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
     
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getCarportName() {
        return carportName;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getCarportID() {
        return carportID;
    }

    public int getOrderTotalPrice() {
        return orderTotalPrice;
    }



    
    
}
