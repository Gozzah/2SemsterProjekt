package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logic.Exceptions.UserException;
import logic.entities.user.Admin;
import logic.entities.user.Customer;

public class UserMapper {
    

    public void createCustomer(Customer c) throws UserException{
        int userType = 2;
        String firstName = c.getFirstName();
        String lastName = c.getLastName();
        String userName = c.getUsername();
        String passWord = c.getPassword();
        String address = c.getAddress();
        int zipCode = c.getZipcode();
        String email = c.getEmail();
        String phoneNumber = c.getPhoneNumber();

        try {
            
                    PreparedStatement stmt = DBC.preparedStatement("INSERT INTO Customer "
                    + "(userType,firstName,lastName,username,password,address,zipcode,email,phoneNumber) "
                    + "VALUES (?,?,?,?,?,?,?,?,?);");


                        stmt.setInt(1,userType);
                        stmt.setString(2, firstName);
                        stmt.setString(3, lastName);
                        stmt.setString(4, userName);
                        stmt.setString(5, passWord);
                        stmt.setString(6, address);
                        stmt.setInt(7, zipCode);
                        stmt.setString(8, email);
                        stmt.setString(9, phoneNumber);    
                        stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new UserException();
        }
    }
    
    public void deleteCustomer(int customerID)throws UserException {
        
       
         try {
            PreparedStatement stmt = DBC.preparedStatement("DELETE FROM Customer WHERE customerID = " + customerID);      
            stmt.executeUpdate();
    } catch (SQLException | ClassNotFoundException ex){
        throw new UserException();
    }
    }
       
    
    public void updateCustomer(Customer c, int ID)throws UserException {
      
        String firstName = c.getFirstName();
        String lastName = c.getLastName();
        String username = c.getUsername();
        String password = c.getPassword();
        String address = c.getAddress();
        int zipcode = c.getZipcode();
        String email = c.getEmail();
        String phoneNumber = c.getPhoneNumber();
        
        try {
            
        PreparedStatement stmt = DBC.preparedStatement("UPDATE Customer "
                    + "SET firstName = ?,lastName = ?,username = ?,password = ?,address = ?,"
                    + "zipcode = ?,email = ?,phoneNumber = ? "
                    + "WHERE "
                    + "customerID = '" + ID + "';");
        
            
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, username);
            stmt.setString(4, password);
            stmt.setString(5, address);
            stmt.setInt(6, zipcode);
            stmt.setString(7, email);
            stmt.setString(8, phoneNumber);
            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new UserException();
        }
    }
    
      public void changePassword(int customerID,String password) throws UserException{
                  try {
               
              PreparedStatement stmt = DBC.preparedStatement("UPDATE Customer SET password = '" + password + "' WHERE customerID = '" + customerID + "';");
              stmt.executeUpdate();
      }    catch (SQLException | ClassNotFoundException ex) {
            
            throw new UserException();

        }
         
             
}
        
    
    
       public List<Customer> getCustomers(){
        List<Customer> customers = new ArrayList();
           try {
            PreparedStatement stmt = DBC.preparedStatement("SELECT * FROM Customer");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                int customerID = rs.getInt("customerID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String address = rs.getString("address");
                int zipcode = rs.getInt("zipcode");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                customers.add(new Customer(customerID,firstName, lastName, username, password, address, zipcode, email, phoneNumber));
           } 
           }
           catch (SQLException | ClassNotFoundException ex) {
            
                   
                   }
        return customers;
           }

    
            public List<Customer> getCustomerByID(int customerID) throws UserException {
        List<Customer> customer = new ArrayList();
        try {
         PreparedStatement stmt = DBC.preparedStatement( "SELECT * FROM Customer WHERE customerID = " + customerID + ";");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
              
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String address = rs.getString("address");
                int zipcode = rs.getInt("zipcode");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phoneNumber");
                customer.add(new Customer(firstName, lastName, username, password, address, zipcode, email, phoneNumber));

            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new UserException();
        }
        return customer;
    }
            
            
     public List<Admin> getAdmin() {
        List<Admin> admin = new ArrayList();
        try {
         PreparedStatement stmt = DBC.preparedStatement("SELECT * FROM Admin;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                
                String username = rs.getString("username");
                String password = rs.getString("password");
                int adminID = rs.getInt("adminID");
                admin.add(new Admin(username, password, adminID));

            }
        } catch (SQLException | ClassNotFoundException  ex) {
        }
        return admin;
     }
    
}