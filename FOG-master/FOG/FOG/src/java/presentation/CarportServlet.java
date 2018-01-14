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
import logic.Calculator.Calculator;
import logic.facades.CarportDomainFacade;
import logic.Exceptions.CarportException;
import logic.Exceptions.ProductsException;
import logic.entities.carport.Carport;
import logic.entities.products.Products;
import logic.facades.ProductsDomainFacade;

/**
 *
 * @author Runej
 */
@WebServlet(name = "CarportServlet", urlPatterns = {"/CarportServlet"})
public class CarportServlet extends HttpServlet {
    
    static CarportDomainFacade cdf = new CarportDomainFacade();
    static ProductsDomainFacade pdf = new ProductsDomainFacade();
    Calculator cal  = new Calculator();
    
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String valg = request.getParameter("valg");
            switch (valg) {

                case "add":
                    createCarport(request, response);
                    request.getRequestDispatcher("ViewCarportsAdmin.jsp").forward(request, response);
                    break;

                case "slet":
                    removeCarport(request, response);
                    request.getRequestDispatcher("ViewCarportsAdmin.jsp").forward(request, response);
                    break;
                    
                default:
                    break;
        }
    }

    private void createCarport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         if(request.getSession().getAttribute("adminID") == null){
                    request.getRequestDispatcher("index.html").forward(request, response);
         }
        
            String carportName = request.getParameter("carportName");
            int carportWidth = Integer.parseInt(request.getParameter("carportWidth"));
            int carportLength = Integer.parseInt(request.getParameter("carportLength"));
            int carportHeight = Integer.parseInt(request.getParameter("carportHeight"));
            int roofSlope = Integer.parseInt(request.getParameter("roofSlope"));
            String woodTemp = request.getParameter("woodID");
            int woodID = Integer.parseInt(woodTemp.split("-")[0]);
            int woodPrice = Integer.parseInt(woodTemp.split("-")[1]);
            int plankHeight = Integer.parseInt(woodTemp.split("-")[2]);
            int plankLength = Integer.parseInt(woodTemp.split("-")[3]);
            int woodColorID = Integer.parseInt(request.getParameter("woodColor"));
            String eaveTemp = request.getParameter("eaveID");
            int eaveID = Integer.parseInt(eaveTemp.split("-")[0]);
            int eavePrice = Integer.parseInt(eaveTemp.split("-")[1]);
            int eaveWidth = Integer.parseInt(eaveTemp.split("-")[2]);
            int eaveLength = Integer.parseInt(eaveTemp.split("-")[3]);
            int eaveColorID = Integer.parseInt(request.getParameter("eaveColor"));
            int totalPrice = 0;
            
         try {
             
                 
             
            Carport c = new Carport(carportName,carportWidth,carportLength,carportHeight,roofSlope,woodID, woodPrice,plankHeight, plankLength, woodColorID, eaveID, eavePrice,eaveWidth, eaveLength, eaveColorID,totalPrice);
            cal.calculator(c);
            
            List<Carport> carports = cdf.getCarports();
            request.getSession().setAttribute("carports", carports);
            
        } catch (CarportException ex) {
            request.getSession().setAttribute("errorMessage", "Der skete en fejl.\n"
                                               + "Kontakt venligst en tekniker hvis fejlen gentager sig");
            request.getRequestDispatcher("ErrorPageAdmin.jsp").forward(request, response);
        }
    }
    
    private void removeCarport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
                 if(request.getSession().getAttribute("adminID") == null){
                    request.getRequestDispatcher("index.html").forward(request, response);
                 }
        try {
            int carportID = Integer.parseInt(request.getParameter("carportID"));
            cdf.deleteCarport(carportID);

         }catch (CarportException ex) {
            request.getSession().setAttribute("errorMessage", "Hov! Carporten du forsøgte at slette er stadigvæk knyttet"
                    + " til en kundes ordre, og kunne derfor ikke slettes..\n");
            request.getRequestDispatcher("ErrorPageAdmin.jsp").forward(request, response);
        }
       }
    
     public static List getCarports() throws CarportException {
        List<Carport> carports = cdf.getCarports();
        return carports;
    }
     
     public static List<Carport> getCarportByID(int carportID) throws CarportException {
        List<Carport> carport = cdf.getCarportByID(carportID);
        return carport;
     }  
     public static List<Products> wood() throws ProductsException {
         List<Products> wood = pdf.wood();
         return wood;
     }
     
     public static List<Products> paint() throws ProductsException {
         List<Products> paint = pdf.paint();
         return paint;
     }
     public static List<Products> eaves() throws ProductsException {
         List<Products> eaves = pdf.eaves();
         return eaves;
     }      
           
    }
    

