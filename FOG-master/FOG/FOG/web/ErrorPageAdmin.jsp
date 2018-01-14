<%-- 
    Document   : ErrorPage
    Created on : 17-05-2017, 15:51:10
    Author     : Runej
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            Klik her for at gå til forsiden</h1>
            <a href="AdminPage.jsp" class="btn btn-info" role="button">Tilbage</a>
            
            
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
