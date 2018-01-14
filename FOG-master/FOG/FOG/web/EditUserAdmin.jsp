<%-- 
    Document   : EditCustomer
    Created on : Apr 10, 2017, 10:44:31 AM
    Author     : kennethlundh
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
    
         <style>
        body {
             background-image: url(" https://s-media-cache-ak0.pinimg.com/originals/fe/d3/33/fed333675bef0b7bc9995dfc587b45ca.jpg"); 
             background-attachment: fixed;
             background-repeat: no-repeat;
             background-size: cover;
        }
            </style>
    
  
<form action="UserServlet" method="POST">

<% int c = Integer.parseInt(request.getParameter("customerID"));
List<Customer> customer = ((ArrayList <Customer>) UserServlet.getCustomerByID(c));%>
    <%
    for (int i = 0; i < customer.size(); i++) {
    %>
    

    
  <div class="container" style="background-color:beige;">
    
    <label style="color:black;"><b>Fornavn</b></label>
    <input class="form-control" type="text" name="firstName" value="<%out.print(customer.get(i).getFirstName());%>" required/>
    
    <label style="color:black;"><b>Efternavn</b></label>
    <input class="form-control" type="text" name="lastName" value="<%out.print(customer.get(i).getLastName());%>" required/>
    
    <label style="color:black;"><b>Username</b></label>
    <input class="form-control" type="text" name="username" value="<%out.print(customer.get(i).getUsername());%>" required/>

    <label style="color:black;"><b>Password</b></label>
    <input class="form-control" type="text" name="password" value="<%out.print(customer.get(i).getPassword());%>" required/>
    
    <label style="color:black;"><b>Adresse</b></label>
    <input class="form-control" type="text" name="address" value="<%out.print(customer.get(i).getAddress());%>" required/>
    
    <label style="color:black;"><b>Postnummer</b></label>
    <input class="form-control" type="text" name="zipcode" value="<%out.print(customer.get(i).getZipcode());%>" required/>
    
    <label style="color:black;"><b>Email</b></label>
    <input class="form-control" type="text" name="email" value="<%out.print(customer.get(i).getEmail());%>" required/>
    
    <label style="color:black;"><b>Mobiltelefon nummer</b></label>
    <input class="form-control" type="text" name="phoneNumber" value="<%out.print(customer.get(i).getPhoneNumber());%>" required/>
     
    
        
    <button type="submit" class="btn btn-primary" name ="godkend" value ="bekræft" style=" background-color:green; color:white;">Bekræft</button>
    <input type ="hidden" name ="customerID" value ="<%out.print(c);%>"/>
    <input type ="hidden" name ="valg" value ="bekræft redigering"
    
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
