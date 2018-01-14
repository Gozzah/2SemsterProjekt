/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.facades;

import logic.Interfaces.UserDomainFacadeIF;
import data.facades.UserDataFacade;
import java.util.List;
import logic.Exceptions.UserException;
import logic.entities.user.Admin;
import logic.entities.user.Customer;

/**
 *
 * @author Runej
 */
public class UserDomainFacade implements UserDomainFacadeIF {
    
    UserDataFacade udf = new UserDataFacade();
    
    @Override
    public List getCustomers() {
        List<Customer> customers = udf.getCustomers();
        return customers;
    }
    
    @Override
    public List<Customer> getCustomerByID(int customerID) throws UserException {
       List<Customer> customer = udf.getCustomerByID(customerID);
        return customer;
    }
    
    @Override
    public List getAdmin(){
       List<Admin> admin = udf.getAdmin();
       return admin;
    }
    
    @Override
    public void createCustomer(Customer c)throws UserException {
            udf.createCustomer(c);
    }
    
    @Override
     public void deleteCustomer(int customerID)throws UserException {
            udf.deleteCustomer(customerID);
    }
     
    @Override
     public void updateCustomer(Customer c, int ID)throws UserException {
            udf.updateCustomer(c,ID);
    } 
         @Override
         public void changePassword( int customerID,String password)throws UserException {
            udf.changePassword(customerID, password);
            
          
    }
    
}
