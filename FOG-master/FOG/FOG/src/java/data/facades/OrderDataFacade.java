/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.facades;

import data.OrderMapper;
import data.interfaces.OrderDataFacadeIF;
import java.util.List;
import logic.Exceptions.OrderException;
import logic.entities.order.OrderDetails;
import logic.entities.order.Orders;

/**
 *
 * @author Runej
 */
public class OrderDataFacade implements OrderDataFacadeIF  {
    
    static OrderMapper om = new OrderMapper();
    
        
    @Override
     public void createOrder(Orders o) throws OrderException {
         om.createOrder(o);
     }
     
    @Override
     public List getOrderDetails(int customerID) throws OrderException{
         List<OrderDetails> orderDetails = om.getOrderDetails(customerID);
         return orderDetails;
     }
     
    @Override
       public void deleteOrder (int orderID)throws OrderException{
         om.deleteOrder(orderID);
}
       
    @Override
       public List pendingOrders() throws OrderException{
           
           List<OrderDetails> orderStatus = om.pendingOrders();
           return orderStatus;
       }
       
       @Override
       public List <OrderDetails> rejectedOrders () throws OrderException{
           List<OrderDetails> rejectedOrders = om.rejectedOrders();
           return rejectedOrders;
       }
       
    @Override
        public void confirmOrder(int orderID) throws OrderException{
             om.confirmOrder(orderID);
         }
    @Override
        public void rejectOrder(int orderID) throws OrderException{
             om.rejectOrder(orderID);
         }
}
