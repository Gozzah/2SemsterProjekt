
package data.facades;

import data.UserMapper;
import data.interfaces.UserDataFacadeIF;
import java.util.List;
import logic.Exceptions.UserException;
import logic.entities.user.Admin;
import logic.entities.user.Customer;

/**
 *
 * @author Runej
 */
public class UserDataFacade implements UserDataFacadeIF {
    
    UserMapper um = new UserMapper();
    
    @Override
    public void createCustomer(Customer c)throws UserException {
        um.createCustomer(c);
    }
    
    @Override
    public void deleteCustomer(int customerID)throws UserException {
        um.deleteCustomer(customerID);
    }
    
    @Override
    public void updateCustomer(Customer c, int ID)throws UserException {
        um.updateCustomer(c, ID);
    }
    @Override
    public void changePassword( int customerID, String password) throws UserException{
         um.changePassword(customerID, password);
        
    }
    @Override
    public List<Customer> getCustomers(){
       List<Customer> customer = um.getCustomers();
        return customer;
    }
      
    @Override
    public List<Customer> getCustomerByID(int customerID) throws UserException {
       List<Customer> customer = um.getCustomerByID(customerID);
        return customer;
    }
    
    @Override
    public List <Admin> getAdmin()  {
       List<Admin> admin = um.getAdmin();
        return admin;
    }
}


