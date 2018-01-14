
package logic.entities.user;

/**
 *
 * @author Peter
 */
public class Customer{
    private int customerID;
    private int userType;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String address;
    private int zipcode;
    private String email;
    private String phoneNumber;

    public Customer(int customerID,String firstName, String lastName, String username, String password, String address, int zipcode, String email, String phoneNumber){
        //bruges til updateCustomer i userServlet
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.address = address;
        this.zipcode = zipcode;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
      public Customer(String firstName, String lastName, String username, String password, String address, int zipcode, String email, String phoneNumber){
        //bruges til getCustomerByID i UserMapper
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.address = address;
        this.zipcode = zipcode;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
   
    
    public int getCustomerID(){
        return customerID;
    }
    
    public int getUserType(){
        return userType;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getAddress(){
        return address;
    }

    public int getZipcode(){
        return zipcode;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

}

