<%-- 
    Document   : CustomerSeeOrder
    Created on : 19-04-2017, 16:38:00
    Author     : Runej
--%>


<%@page import="presentation.OrderServlet"%>
<%@page import="logic.entities.order.Orders"%>
<%@page import="logic.entities.order.OrderDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.entities.carport.Carport"%>
<%@page contentType="text/html" pageEncoding="latin1"%>
<!DOCTYPE html>
<!DOCTYPE html>
<%
int cID = (Integer) request.getSession().getAttribute("customerID");
List<OrderDetails> orderDetails = OrderServlet.getOrderDetails(cID);
%>

<html>
    <head>
        <meta charset="latin1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
 
     <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
   
    <body>

<nav class="navbar navbar-light" style="background-color: black;">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="UserPage.jsp"><%out.print(session.getAttribute("firstName"));%>s side</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="ViewCarportsUser.jsp">Vis carporte</a></li>
                    <li><a href="ViewOrderUser.jsp">Mine ordre</a></li>
                    <li><a href = "Logout.jsp">Log ud</a></li>
                </ul>
            </div>
        </nav>
                
        
          <style>
        body {
             background-image: url(" https://s-media-cache-ak0.pinimg.com/originals/fe/d3/33/fed333675bef0b7bc9995dfc587b45ca.jpg"); 
             background-attachment: fixed;
             background-repeat: no-repeat;
             background-size: cover;
        } 
        </style>
                
                
        <div class="container">
            <table class="table bg-primary" style="background-color: l;">
                
                
                <thead>
            <tr class="bg-info" style="background-color: lightseagreen;">
               
                <th>Ordre nummer</th>
                <th>Carport navn</th>
                <th>Stykpris</th>
                <th>Antal</th>
                <th>Totalpris</th>
                <th>Ordre status</th>
                <th>Ordre dato</th>
                
                
            </tr>
                </thead>
                <tbody>
                   
            <%
                    
                    for (int i = 0; i < orderDetails.size(); i++) {
            %>
            
            <tr>
            
            <form method = "post" action="OrderServlet">
            
                <td><%out.print(orderDetails.get(i).getOrderID());%></td>
                <td><%out.print(orderDetails.get(i).getCarportName());%></td>
                <td><%out.print(orderDetails.get(i).getUnitPrice() + " kr");%></td>
                <td><%out.print(orderDetails.get(i).getQuantity());%></td>
                <td><%out.print(orderDetails.get(i).getOrderTotalPrice() + " kr");%></td>
                <td><%out.print(orderDetails.get(i).getOrderStatus());%></td>
                <td><%out.print(orderDetails.get(i).getOrderDate());%></td>
                 <br/>

            </form>
            <td <img class="img-responsive" src=" https://www.poetschke.de/out/pictures/generated/product/1/256_256_75/281689-00-GPIE.jpg">   
            </td>    
                </tr>
        <% }%>
        
            </tbody>
            </table>
            
</body>
</html>