<%-- 
    Document   : AdminChangeUPassword
    Created on : 17-05-2017, 12:42:05
    Author     : Runej
--%>

<%@page import="presentation.UserServlet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.entities.user.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="latin1"%>
<!DOCTYPE html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
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
  
   <div class="imgcontainer">
    <img src="https://ih1.redbubble.net/image.62673928.1824/flat,800x800,075,f-c,0,75,800,331.jpg">
  </div>
<form action="UserServlet" method="POST">

    

        
<% int c = Integer.parseInt(request.getParameter("customerID"));
List<Customer> customer = ((ArrayList <Customer>) UserServlet.getCustomerByID(c));%>
    <%
    for (int i = 0; i < customer.size(); i++) {
    %>
        
  <div class="container">
      <label><b>Fornavn :</b></label><br>
      <label><b><%out.print(customer.get(i).getFirstName());%></b></label><br>
      <label><b>Efternavn</b></label><br>
      <label><b><%out.print(customer.get(i).getLastName());%></b></label><br>
      <label><b>Brugernavn</b></label><br>
      <label><b><%out.print(customer.get(i).getUsername());%></b></label><br>
      <label><b>Password</b></label><br>
    <input class="form-control" type="text" name="password" required value="<%out.print(customer.get(i).getPassword() );%>"/>
      
    <button type="submit" class="btn btn-primary" name ="godkend" value ="bekræft">Bekræft</button>
    <input type ="hidden" name ="customerID" value ="<%out.print(c);%>"/>
    <input type ="hidden" name ="valg" value ="Password skiftet">
  </div>
    
</form>
           <%}%>
 <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
