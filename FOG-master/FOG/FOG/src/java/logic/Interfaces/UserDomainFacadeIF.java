/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.Interfaces;

import java.util.List;
import logic.Exceptions.UserException;
import logic.entities.user.Customer;

/**
 *
 * @author Runej
 */
public interface UserDomainFacadeIF {

    void createCustomer(Customer c) throws UserException;

    void deleteCustomer(int customerID) throws UserException;

    List getAdmin() throws UserException;

    List getCustomers() throws UserException;

    List<Customer> getCustomerByID(int customerID) throws UserException;

    void updateCustomer(Customer c, int ID) throws UserException;
    
    void changePassword( int customerID,String password)throws UserException;
    
}
