/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logic.Exceptions.OrderException;
import logic.entities.order.OrderDetails;
import logic.entities.order.Orders;

/**
 *
 * @author Runej
 */
public class OrderMapper {
    

         
            public static List<OrderDetails> getOrderDetails(int customerID) throws OrderException {
            List<OrderDetails> orderDetails = new ArrayList();
      
        try {
            PreparedStatement stmt = DBC.preparedStatement(
             "SELECT Carport.carportName,Carport.totalPrice, OrderDetails.quantity,OrderDetails.orderTotalPrice,OrderDetails.orderStatus,"
           + "OrderDetails.orderID,OrderDetails.orderdate " +
             "FROM OrderDetails JOIN Orders ON OrderDetails.orderID = Orders.orderID JOIN Carport ON OrderDetails.carportID = Carport.carportID "
           + "WHERE customerID = " + customerID + " ORDER BY orderID;");
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                  
                    String carportName = rs.getString("carportName");
                    int unitPrice = rs.getInt("totalPrice");
                    int quantity = rs.getInt("quantity");
                    int orderTotalPrice = rs.getInt("orderTotalPrice");
                    int orderID = rs.getInt("orderID");
                    String orderStatus = rs.getString("orderStatus");
                    String orderDate = rs.getString("orderDate");
                    
            
                orderDetails.add(new OrderDetails(carportName,unitPrice,quantity, orderTotalPrice,orderID, orderStatus, orderDate));

            }
        } catch (SQLException | ClassNotFoundException ex) {
          ex.printStackTrace();
        }
        return orderDetails;
    }
            

       public static void createOrder(Orders o) throws OrderException{
       int customerID = o.getCustomerID();
       int carportID = o.getCarportID();
       int quantity = o.getQuantity();
       int totalPrice = o.getTotalPrice();
       int orderTotalPrice =totalPrice *quantity;
       
        try {

            String sql = "INSERT INTO Orders (customerID) VALUES (?);";
            
              PreparedStatement stmt = DBC.prepareKeys(sql, Statement.RETURN_GENERATED_KEYS);
              
            stmt.setInt(1, customerID);
            
            stmt.executeUpdate();
        
            ResultSet rs = stmt.getGeneratedKeys();

             while(rs.next()){
                 
             int orderID = rs.getInt(1);

             PreparedStatement od = DBC.preparedStatement("INSERT INTO OrderDetails (OrderID,carportID, quantity,totalPrice,orderTotalPrice) VALUES (?,?,?,?,?);");
             
             od.setInt(1, orderID);
             od.setInt(2, carportID);
             od.setInt(3, quantity);
             od.setInt(4, totalPrice);
             od.setInt(5, orderTotalPrice);
             
             od.executeUpdate();
             }

            }catch (SQLException | ClassNotFoundException ex) {
             throw new OrderException();   
        }

    }
       
       public List <OrderDetails> pendingOrders () throws OrderException{
           
             List<OrderDetails> orderStatus = new ArrayList();
        try {
            
            PreparedStatement stmt = DBC.preparedStatement(
            "SELECT * FROM OrderDetails where orderStatus = 'afventer' ORDER BY orderID;");
            ResultSet rs = stmt.executeQuery();
            
          while (rs.next()) {
        
                  
                  int orderDetailID = rs.getInt("orderDetailID");
                  int carportID = rs.getInt("carportID");
                  int orderID = rs.getInt("orderID");
                  int quantity = rs.getInt("quantity");
                  int unitPrice = rs.getInt("totalPrice");
                  int orderTotalPrice = rs.getInt("orderTotalPrice");
                  String ordreStatus= rs.getString("orderStatus");
                  String orderDate= rs.getString("orderDate");
                  
                  orderStatus.add(new OrderDetails(orderDetailID,carportID,orderID,quantity,unitPrice,orderTotalPrice,ordreStatus, orderDate));
  }
        }
        catch (SQLException | ClassNotFoundException ex) {
        }
        return orderStatus;
    
}
       
              public List <OrderDetails> rejectedOrders () throws OrderException{
           
             List<OrderDetails> orderStatus = new ArrayList();
        try {
            
            PreparedStatement stmt = DBC.preparedStatement(
            "SELECT * FROM OrderDetails where orderStatus = 'afvist' ORDER BY orderID;");
            ResultSet rs = stmt.executeQuery();
            
          while (rs.next()) {
        
                  
                  int orderDetailID = rs.getInt("orderDetailID");
                  int carportID = rs.getInt("carportID");
                  int orderID = rs.getInt("orderID");
                  int quantity = rs.getInt("quantity");
                  int unitPrice = rs.getInt("totalPrice");
                  int ordertotalPrice = rs.getInt("orderTotalPrice");
                  String ordreStatus= rs.getString("orderStatus");
                  String orderDate= rs.getString("orderDate");
                  
                  orderStatus.add(new OrderDetails(orderDetailID,carportID,orderID,quantity,unitPrice,ordertotalPrice,ordreStatus, orderDate));
  }
        }
        catch (SQLException | ClassNotFoundException ex) {
        }
        return orderStatus;
    
}
              
              
       public static void deleteOrder (int orderID) throws OrderException{
           
           try {
               
              PreparedStatement stmt = DBC.preparedStatement("DELETE FROM Orders WHERE orderID = '" + orderID + "';");
              stmt.executeUpdate();
            }catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException();
        }
           
}
       
              
        public void confirmOrder(int orderID) throws OrderException{
             try {
               
              PreparedStatement stmt = DBC.preparedStatement("UPDATE OrderDetails SET orderStatus = 'godkendt' WHERE orderID = '" + orderID + " ';");
              stmt.executeUpdate();
      }    catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException();
        }
        }
             
        public void rejectOrder(int orderID) throws OrderException{
             try{
               
              PreparedStatement stmt = DBC.preparedStatement("UPDATE OrderDetails SET orderStatus = 'afvist' WHERE orderID = '" + orderID + " ';");
              stmt.executeUpdate();
            }catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException();
        }
}
}
