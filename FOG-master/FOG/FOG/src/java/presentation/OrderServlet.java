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
import logic.Exceptions.OrderException;
import logic.facades.OrderDomainFacade;
import logic.entities.order.OrderDetails;
import logic.entities.order.Orders;

/**
 *
 * @author Peter
 */
@WebServlet(name = "OrderServlet", urlPatterns = {"/OrderServlet"})
public class OrderServlet extends HttpServlet {

    static OrderDomainFacade odf = new OrderDomainFacade();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String valg = request.getParameter("valg");
        switch (valg) {

            case "slet afventende ordre":
                deleteOrder(request, response);
                request.getRequestDispatcher("PendingOrdersAdmin.jsp").forward(request, response);
                break;
                
            case "slet afvist ordre":
                deleteOrder(request, response);
                request.getRequestDispatcher("RejectedOrdersAdmin.jsp").forward(request, response);
                break;
                
            case "Køb":
                request.getRequestDispatcher("ConfirmPurchase.jsp").forward(request, response);
                break;
                
            case "Bekræft køb":
                createOrder(request, response);
                request.getRequestDispatcher("PurchaseConfirmed.jsp").forward(request, response);
                break;

            case "Godkend":
                confirmOrder(request, response);
                request.getRequestDispatcher("PendingOrdersAdmin.jsp").forward(request, response);
                break;
                
            case "Afvis":
                rejectOrder(request, response);
                request.getRequestDispatcher("PendingOrdersAdmin.jsp").forward(request, response);
                break;
                
            default:
                break;
        }

    }

    public List pendingOrders() throws OrderException {
        List<OrderDetails> orderStatus = odf.pendingOrders();
        return orderStatus;
    }

    public void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        if(request.getSession().getAttribute("adminID") == null){
           request.getRequestDispatcher("index.html").forward(request, response);
        }
        
        try {
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            odf.deleteOrder(orderID);

        } catch (OrderException ex) {
            request.getSession().setAttribute("errorMessage", "Der skete en fejl.\n"
                    + "Kontakt venligst en tekniker hvis fejlen gentager sig");
            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
        }

    }

    private void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
           if(request.getSession().getAttribute("customerID") == null){
              request.getRequestDispatcher("index.html").forward(request, response);
           }
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        int carportID = Integer.parseInt(request.getParameter("carportID"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));

        try {
            Orders o = new Orders(customerID, carportID, quantity, totalPrice);
            odf.createOrder(o);

        } catch (OrderException ex) {
            request.getSession().setAttribute("errorMessage", "Der skete en fejl.\n"
                    + "Kontakt venligst en tekniker hvis fejlen gentager sig");
            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
        }
    }

    private void confirmOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        if(request.getSession().getAttribute("adminID") == null){
           request.getRequestDispatcher("index.html").forward(request, response);
        }
        
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        try {
            odf.confirmOrder(orderID);

        } catch (OrderException ex) {
            request.getSession().setAttribute("errorMessage", "Der skete en fejl.\n"
                    + "Kontakt venligst en tekniker hvis fejlen gentager sig");
            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
        }
    }
    
    private void rejectOrder(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
         if(request.getSession().getAttribute("adminID") == null){
            request.getRequestDispatcher("index.html").forward(request, response);
         }
        
          int orderID = Integer.parseInt(request.getParameter("orderID"));
        try {
            odf.rejectOrder(orderID);

        } catch (OrderException ex) {
            request.getSession().setAttribute("errorMessage", "Der skete en fejl.\n"
                    + "Kontakt venligst en tekniker hvis fejlen gentager sig");
            request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
        }
    }
    
    public static List rejectedOrders() throws OrderException {
            List<OrderDetails> rejectedOrders = odf.rejectedOrders();
            return rejectedOrders;
    }

    public static List getOrderDetails(int customerID) throws OrderException {
        List<OrderDetails> orderDetails = odf.getOrderDetails(customerID);
        return orderDetails;
    }
}
