<%-- 
    Document   : CustomerPage
    Created on : Mar 30, 2017, 1:02:49 PM
    Author     : kennethlundh
--%>

<%@page import="java.util.Date"%>
<%@page import="logic.entities.user.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UserPage</title>
        
         <%if(session.getAttribute("customerID") == null){
            request.getRequestDispatcher("index.html").forward(request, response);
        }%>
        
    </head>
    
    <body>
        <style>
        body {
            
            background-image: url("https://www.pensiondanmark.com/globalassets/billeder2/artikelbilleder-1592x800/ejendomme/johannes-fog-1952x800.jpg");
            background-size: 100%;
            background-repeat: no-repeat;
        }
    </style>
        
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
        <h1> Velkommen, <%out.println(session.getAttribute("firstName") + " " + session.getAttribute("lastName"));%></h1>
  
  </div>

  </body>
    
     <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
