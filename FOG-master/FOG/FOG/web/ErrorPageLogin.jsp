<%-- 
    Document   : ErrorPageLogin
    Created on : May 22, 2017, 6:03:12 PM
    Author     : kennethlundh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
           <style>
        body {
            
            background-image: url("http://www.lucernevet.com/blog/wp-content/uploads/2015/02/Lucerne_iStock_000045727868_Large.jpg" ); 
            background-size: 1000px 800px;
            background-repeat: no-repeat;
        }
          </style>
        
        
        <h1><%out.print(session.getAttribute("errorMessage") + "\n");%>
            Klik her for at gå til login-siden igen</h1>
            <a href="index.html" class="btn btn-info" role="button">Tilbage</a>
            
            
            
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
