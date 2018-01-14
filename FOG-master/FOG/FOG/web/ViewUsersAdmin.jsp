<%-- 
    Document   : ShowCustomers
    Created on : Mar 27, 2017, 2:47:12 PM
    Author     : kennethlundh
--%>
<%@page import="presentation.UserServlet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="logic.entities.user.Customer"%>
<!DOCTYPE html>
<html lang="en">
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
        <th>Kunde ID</th>
        <th>Fornavn</th>
        <th>Efternavn</th>
        <th>Brugernavn</th>
        <th>Password</th>
        <th>Adresse</th>
        <th>Postnummer</th>
        <th>Email</th>
        <th>Telefon nummer</th>
      </tr>
    </thead>
        
        <%
            List <Customer> customer = ((ArrayList<Customer>)UserServlet.getCustomers());
            for (int c = 0; c < customer.size(); c++) {
        %>
        
      <tr style="background-color: beige">
        <td><%out.print(customer.get(c).getCustomerID());%></td>
        <td><%out.print(customer.get(c).getFirstName());%></td>
        <td><%out.print(customer.get(c).getLastName());%></td>
        <td><%out.print(customer.get(c).getUsername());%></td>
        <td><%out.print(customer.get(c).getPassword());%></td>
        <td><%out.print(customer.get(c).getAddress());%></td>
        <td><%out.print(customer.get(c).getZipcode());%></td>
        <td><%out.print(customer.get(c).getEmail());%></td>
        <td><%out.print(customer.get(c).getPhoneNumber());%></td>
       
        <td>
              <form action="UserServlet" method="POST">
                  <select name="valg">
    <Option value ="rediger kunde">Rediger kunde</Option>
    <Option value ="slet kunde">Slet kunde</Option>
    <Option value ="vis kundes bestillinger">Vis kundes bestillinger</Option>
    <Option value ="Skift password">Skift password</Option>
    <input type ="hidden" name ="customerID" value ="<%out.print(customer.get(c).getCustomerID());%>"/>
    <input style="background-color: green; color:white;" class="btn btn-md" type ="Submit" name ="Opret" value ="bekræft"/>
                  </select></br>
   
        </form>
  </td>
      </tr>
      <% } %>
  </table>
    
</body>
</html>