<%-- 
    Document   : PurchaseConfirmed
    Created on : 21-05-2017, 21:22:59
    Author     : Runej
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http equiv="refresh" content="3;url=google.com"</meta>
        
        <%if(session.getAttribute("customerID") == null){
            request.getRequestDispatcher("index.html").forward(request, response);
        }%>
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
        
        
        <h1 style="color:blue;">Tillykke med din nye carport, <%out.print(session.getAttribute("firstName"));%>!</h1>
      <style>
        body {
            background-image: url("http://i.imgur.com/am3qXZ1.jpg" ); 
            background-size: 100%;
        }
    </style>
        
       <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    
    </body>
</html>
