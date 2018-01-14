<%-- 
    Document   : UserCreated
    Created on : May 23, 2017, 8:46:38 PM
    Author     : Peter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        
    <nav class="navbar navbar-light" style="background-color: black;">
        <div class="container-fluid">
            <div class="navbar-header">
            </div>
            <ul class="nav navbar-nav">
                <li><a href="index.html">Log ind</a></li>
                <li><a href="Register.jsp">Opret bruger</a></li>
            </ul>
        </div>
    </nav>    
        
    <style>
        body {
            
            background-image: url("http://www.lyngby-boldklub.dk/gfx/top_images/overfoerslerfragammel/22.10.2015_07.17.41XDgPo.JPG" ); 
            background-size: 100%;
             }
    </style>
    
<style>
.letters { 
    background-color: blue; /* Orange */
    color: #ffffff;
}
</style>
    <div class="letters">
    <h1>Tillykke med din nye profil, <%out.print(session.getAttribute("firstName"));%>!</h1> 
    <h1> Dit brugernavn er: <%out.print(session.getAttribute("username"));%></h1>
    <h1>Og dit password er: <%out.print(session.getAttribute("password"));%></h1>
    </div>
    </body>
</html>
