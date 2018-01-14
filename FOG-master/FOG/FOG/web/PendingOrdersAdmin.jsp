<%-- 
    Document   : AdminPendingOrders
    Created on : 09-05-2017, 18:25:07
    Author     : Runej
--%>

<%@page import="presentation.OrderServlet"%>
<%@page import="logic.entities.order.OrderDetails"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
     
              
<%@page import="presentation.UserServlet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="latin1"%>
<!DOCTYPE html>


<html>
    <head>
  <meta charset="latin1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <%if(session.getAttribute("adminID") == null){
      request.getRequestDispatcher("index.html").forward(request, response);
  }%>  
    </head>
    <body>

<nav class="navbar navbar-light" style="background-color: black;">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="AdminPage.jsp">Administrator</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="AdminPage.jsp">Home</a></li>
      <li><a href="ViewCarportsAdmin.jsp">Vis carporte</a></li>
      <li><a href="CreateCarportAdmin.jsp">Opret ny carport</a></li>
      <li><a href="ViewUsersAdmin.jsp">Vis kunder</a></li>
      <li><a href="PendingOrdersAdmin.jsp">Afventende ordre</a></li>
      <li><a href="RejectedOrdersAdmin.jsp">Afviste ordre</a></li>
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
             margin:0px;
        }
    </style>
  
        <div class="container">
        <table class="table table-hover" style="background-color: whitesmoke;">
        
            <thead>
                    <tr>
                        <th>OrdreDetalje ID</th>
                        <th>Ordre ID</th>
                        <th>Carport ID</th>
                        <th>antal</th>
                        <th>enhedspris</th>
                        <th>Total pris ordre</th>
                        <th>Ordre status</th>
                        <th>Ordre dato</th>
                    </tr>
             
                </thead>
                <%  OrderServlet orderServlet = new OrderServlet();
                    List<OrderDetails> orderDetails = orderServlet.pendingOrders();
                    for (int i = 0; i < orderDetails.size(); i++) {
                %>
                <tr style="background-color: beige">
                    
                    <td><%out.print(orderDetails.get(i).getOrderDetailID());%></td>
                    <td><%out.print(orderDetails.get(i).getOrderID());%></td>
                    <td><%out.print(orderDetails.get(i).getCarportID());%></td>
                    <td><%out.print(orderDetails.get(i).getQuantity());%></td>
                    <td><%out.print(orderDetails.get(i).getUnitPrice() + " kr");%></td>
                    <td><%out.print(orderDetails.get(i).getOrderTotalPrice() + " kr");%></td>
                    <td><%out.print(orderDetails.get(i).getOrderStatus());%></td>
                    <td><%out.print(orderDetails.get(i).getOrderDate());%></td>
                             
                     
               
                       <td>
                            <form action="OrderServlet" method="POST">
                                    <select name ="valg">
                        <Option value = "Godkend">Godkend Ordre</Option>
                        <Option value = "Afvis">Afvis Ordre</Option>
                        <Option value = "slet afventende ordre">Slet Ordre</Option>
                        <input type ="hidden" name ="orderID" value ="<%out.print(orderDetails.get(i).getOrderID());%>"/>
                        <input style="background-color: green; color:white;" class="btn btn-md" type ="Submit" name ="Opret" value ="bekræft"/>
                        </select><br/>
        </form>
                </td>
                    </tr>
        <%}%>
        </table>
</body>

</html>
