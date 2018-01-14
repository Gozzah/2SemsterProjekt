package data.interfaces;

import java.util.List;
import logic.Exceptions.UserException;
import logic.entities.user.Admin;
import logic.entities.user.Customer;

/**
 *
 * @author kennethlundh
 */
public interface UserDataFacadeIF {

    void createCustomer(Customer c) throws UserException;

    void deleteCustomer(int customerID) throws UserException;

    List<Admin> getAdmin() throws UserException;

    List<Customer> getCustomers() throws UserException;

    List<Customer> getCustomerByID(int customerID) throws UserException;

    void updateCustomer(Customer c, int ID) throws UserException;
    
    void changePassword(int customerID, String password) throws UserException;
    
}
