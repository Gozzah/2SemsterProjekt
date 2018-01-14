/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;


import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Exceptions.UserException;
import logic.facades.UserDomainFacade;
import logic.entities.user.Admin;
import logic.entities.user.Customer;

/**
 *
 * @author Peter
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {
    
    static UserDomainFacade udf = new UserDomainFacade();
    
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         List<Admin> admin = udf.getAdmin();
            List<Customer> customers = udf.getCustomers();
                
            String username = request.getParameter("username");        
            String password = request.getParameter("password");
            HttpSession session = request.getSession();
           
                for (Admin adminUser : admin){
                    if (adminUser.getUsername().toLowerCase().equals(username.toLowerCase()) && adminUser.getPassword().equals(password)) {
                        session.setAttribute("username", username);
                        session.setAttribute("adminID", adminUser.getID());
                        request.getRequestDispatcher("AdminPage.jsp").forward(request, response);
                    }

                }
                  
                      for (Customer customerUser : customers){
                        if (customerUser.getUsername().toLowerCase().equals(username.toLowerCase()) && customerUser.getPassword().equals(password)) {
                        session.setAttribute("customerID", customerUser.getCustomerID());
                        session.setAttribute("firstName", customerUser.getFirstName());
                        session.setAttribute("lastName", customerUser.getLastName());
                        request.getRequestDispatcher("UserPage.jsp").forward(request, response);
                        }  
                    } 
                      
              request.getSession().setAttribute("errorMessage", "Password og Brugernavn, stemmer desværre ikke overens."
                       + " Prøv venligst igen, eller kontakt vores support\n såfremt de skulle have glemt deres personlige informationer");
                        request.getRequestDispatcher("ErrorPageLogin.jsp").forward(request, response);
            
    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String valg = request.getParameter("valg");
            
            switch(valg){
                
                case "opret kunde":
                registerCustomer(request,response);
                request.getRequestDispatcher("UserCreated.jsp").forward(request, response);
                break;
                
                case "rediger kunde":
                request.getRequestDispatcher("EditUserAdmin.jsp").forward(request, response);
                break;
                
                case "bekræft redigering":
                updateCustomer(request,response);
                request.getRequestDispatcher("ViewUsersAdmin.jsp").forward(request, response);
                break;

                case "vis kundes bestillinger":
                request.getRequestDispatcher("ViewOrdersAdmin.jsp").forward(request, response);
                break;

                case "slet kunde":
                deleteCustomer(request,response);
                request.getRequestDispatcher("ViewUsersAdmin.jsp").forward(request, response);
                break;
                
                case "Skift password":
                    request.getRequestDispatcher("AdminChangeUPassword.jsp").forward(request, response);
                    break;
                    
                case "Password skiftet":
                    changePassword(request,response);
                    request.getRequestDispatcher("ViewUsersAdmin.jsp").forward(request, response);
                    break;
                        
                default:
                break;
            }
    }
    
    
        protected void registerCustomer(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        
           try{
            int userType = 2;
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String address = request.getParameter("address");
            int zipcode = Integer.parseInt(request.getParameter("zipcode"));
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            
            Customer customer = new Customer(userType,firstName,lastName,username,password,address,zipcode,email,phoneNumber);
            udf.createCustomer(customer);
            request.getSession().setAttribute("firstName", firstName);
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password", password);
            
            }catch (NumberFormatException ex) {
            
            request.getSession().setAttribute("errorMessage", "Det lader til du har indtastet bogstaver i dit postnummer.");
            request.getRequestDispatcher("ErrorPageRegister.jsp").forward(request, response);
        
            }catch  (UserException ex){
               
            request.getSession().setAttribute("errorMessage", "Det lader til nogle nisser har lavet rod i vores database. 340 teknikere har fået inddraget deres fridag og er på vej for at udbedre fejlen. Vi beklager.!!.");
            request.getRequestDispatcher("ErrorPageRegister.jsp").forward(request, response);
               
           }
       
        }
            
 
    protected void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{   
            
         if(request.getSession().getAttribute("adminID") == null){
            request.getRequestDispatcher("index.html").forward(request, response);
         }
        
        try{
            int customerID = Integer.parseInt(request.getParameter("customerID")); 
            String username = request.getParameter("username");                     
            String password = request.getParameter("password");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String address = request.getParameter("address");
            int zipcode = Integer.parseInt(request.getParameter("zipcode"));
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            
            Customer customer = new Customer(customerID,firstName,lastName,username,password,address,zipcode,email,phoneNumber);
            udf.updateCustomer(customer, customerID);
        }catch (NumberFormatException ex) {
            
             request.getSession().setAttribute("errorMessage", "Det lader til du har indtastet bogstaver i dit postnummer, eller har ladet nogle felter stå blanke. Dette er ikke tilladt, forsøg venligst igen.");
            request.getRequestDispatcher("ErrorPageAdmin.jsp").forward(request, response);
        } catch (UserException ex){
             request.getSession().setAttribute("errorMessage", "Du har en fejl i din database, eller klassen findes ikke..");
            request.getRequestDispatcher("ErrorPageAdmin.jsp").forward(request, response);
            
        }
        catch (NullPointerException ex){
             request.getSession().setAttribute("errorMessage", "Jeg er en nullpointer exception.");
            request.getRequestDispatcher("ErrorPageAdmin.jsp").forward(request, response);
        }
      }
    
     protected void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
         
         if(request.getSession().getAttribute("adminID") == null){
            request.getRequestDispatcher("index.html").forward(request, response);
         }
         
         int customerID = Integer.parseInt(request.getParameter("customerID"));
         String password = request.getParameter("password");
                 try {
                    
                     udf.changePassword(customerID,password);
                     
        } catch (UserException ex) {
            request.getSession().setAttribute("errorMessage", "Der skete en fejl.\n"
                    + "Kontakt venligst en tekniker hvis fejlen gentager sig");
            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
        }
    }
             
             
    
  
    
    protected void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
         if(request.getSession().getAttribute("adminID") == null){
            request.getRequestDispatcher("index.html").forward(request, response);
         }
        
        try {
                    
            int customerID = Integer.parseInt(request.getParameter("customerID"));
            udf.deleteCustomer(customerID);
            
            }catch (UserException ex) {
            request.getSession().setAttribute("errorMessage", "Der skete en fejl.\n"
                                               + "Kontakt venligst kundeservice hvis fejlen gentager sig");
            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
        }
       }
    
    public static List getCustomers()throws UserException{
        List<Customer> customers = udf.getCustomers();
        return customers;

    }
    
    
      public static List getCustomerByID(int customerID) throws UserException{
        List<Customer> customer = udf.getCustomerByID(customerID);
        return customer;
    }
}

