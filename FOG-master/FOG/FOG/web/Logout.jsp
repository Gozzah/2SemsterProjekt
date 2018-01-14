<%-- 
    Document   : Logout
    Created on : Apr 10, 2017, 7:38:34 PM
    Author     : kennethlundh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%request.logout();
          session.invalidate();
          response.sendRedirect("index.html");%>
    </body>
</html>
