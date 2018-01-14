/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;
import logic.entities.user.Customer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Runej
 */
public class UserMapperTest {
    
    
    public UserMapperTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createCustomer method, of class UserMapper.
     * @throws logic.Exceptions.UserException
     */
//    @Test
//    public void testCreateCustomer() throws UserException {
//        System.out.println("createCustomer");
//        UserMapper instance = new UserMapper();
//        List<Customer>customers = instance.getCustomers();
//        int testBefore = instance.getCustomers().size();
//        System.out.println("Størrelse før createUserTest : " + testBefore);
//        Customer customer = new Customer(0,"Kim", "Andersen", "test","1234","gade", 3500,"mail","12345678");
//        instance.createCustomer(customer);
//        customers = instance.getCustomers();
//        int testAfter = instance.getCustomers().size();
//        System.out.println("Størrelse efter createUserTest : " + testAfter);
//        assertTrue(testBefore<testAfter);
//        assertFalse(testAfter<testBefore);
//        
//      
//        
//        
//       
//        
//        
//       
//    
//    }

    
      // Test of deleteCustomer method, of class UserMapper.  
   @Test
   public void testDeleteCustomer() throws Exception {
     System.out.println("DeleteCustomer"); 
        UserMapper instance = new UserMapper();
        List<Customer>customers = instance.getCustomers();
        System.out.println("Antal brugere i databasen : " + customers.size());
        for (int i = 0; i < customers.size(); i++) {
            System.out.println("Id : "+customers.get(i).getFirstName() + "" + customers.get(i).getCustomerID());
           
       }
        

        
     
   }
       
      
     
//       if (customers.size()> 0) {
//           System.out.println(" Antal brugere før slet :" + customers.size());
//           instance.deleteCustomer(13);
//          
//           
//       }
//       customers = instance.getCustomers();
//       System.out.println("Antal brugere efter slet :" + customers.size());
//       
       
      
        

   
   
   
   
   
   
   
//
//    /**
//     * Test of updateCustomer method, of class UserMapper.
//     */
//    @Test
//    public void testUpdateCustomer() throws Exception {
//        System.out.println("updateCustomer");
//        Customer c = null;
//        int ID = 0;
//        UserMapper instance = new UserMapper();
//        instance.updateCustomer(c, ID);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of changePassword method, of class UserMapper.
//     */
//    @Test
//    public void testChangePassword() throws Exception {
//        System.out.println("changePassword");
//        int customerID = 0;
//        String password = "";
//        UserMapper instance = new UserMapper();
//        instance.changePassword(customerID, password);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCustomers method, of class UserMapper.
//     */
//    @Test
//    public void testGetCustomers() throws Exception {
//        System.out.println("getCustomers");
//        UserMapper instance = new UserMapper();
//        List<Customer> expResult = null;
//        List<Customer> result = instance.getCustomers();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCustomerByID method, of class UserMapper.
//     */
//    @Test
//    public void testGetCustomerByID() throws Exception {
//        System.out.println("getCustomerByID");
//        int customerID = 0;
//        UserMapper instance = new UserMapper();
//        List<Customer> expResult = null;
//        List<Customer> result = instance.getCustomerByID(customerID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAdmin method, of class UserMapper.
//     */
//    @Test
//    public void testGetAdmin() throws Exception {
//        System.out.println("getAdmin");
//        UserMapper instance = new UserMapper();
//        List<Admin> expResult = null;
//        List<Admin> result = instance.getAdmin();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
