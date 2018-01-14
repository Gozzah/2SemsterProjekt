/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.Interfaces;

import java.util.List;
import logic.Exceptions.OrderException;
import logic.entities.order.Orders;

/**
 *
 * @author Runej
 */
public interface OrderDomainFacadeIF {

    void createOrder(Orders o) throws OrderException;

    void deleteOrder(int orderID) throws OrderException;

    List getOrderDetails(int customerID) throws OrderException;

    List pendingOrders() throws OrderException;
    
    void confirmOrder(int orderID) throws OrderException;
    
    void rejectOrder(int orderID) throws OrderException;
    
    List rejectedOrders () throws OrderException;
    
    
}
