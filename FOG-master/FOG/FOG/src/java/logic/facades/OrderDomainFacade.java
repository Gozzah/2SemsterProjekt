/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.facades;

import logic.Interfaces.OrderDomainFacadeIF;
import data.facades.OrderDataFacade;
import java.util.List;
import logic.Exceptions.OrderException;
import logic.entities.order.OrderDetails;
import logic.entities.order.Orders;

/**
 *
 * @author Runej
 */
public class OrderDomainFacade implements OrderDomainFacadeIF {
    
    OrderDataFacade odf = new OrderDataFacade();
    
    @Override
    public void createOrder(Orders o) throws OrderException {
        odf.createOrder(o);
    }
    
    @Override
    public List getOrderDetails(int customerID) throws OrderException{
        List<OrderDetails> orderDetails = odf.getOrderDetails(customerID);
        return orderDetails;
    }
    
    @Override
        public List pendingOrders() throws OrderException{
           List<OrderDetails> orderStatus = odf.pendingOrders();
           return orderStatus;
       }
        
    @Override
       public List <OrderDetails> rejectedOrders () throws OrderException{
           List<OrderDetails> rejectedOrders = odf.rejectedOrders();
           return rejectedOrders;
       }
       
    @Override
         public void deleteOrder(int orderID)throws OrderException {
            odf.deleteOrder(orderID);
        }
    @Override
         public void confirmOrder(int orderID) throws OrderException{
             odf.confirmOrder(orderID);
        }
    @Override
          public void rejectOrder(int orderID) throws OrderException{
             odf.rejectOrder(orderID);
        }
    
}
