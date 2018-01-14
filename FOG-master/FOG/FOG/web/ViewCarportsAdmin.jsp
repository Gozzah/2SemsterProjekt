<%-- 
    Document   : ShowCarport
    Created on : 26-03-2017, 01:30:50
    Author     : Runej
--%>

<%@page import="presentation.CarportServlet"%>
<%@page import="presentation.UserServlet"%>
<%@page import="java.util.List"%>
<%@page import="logic.entities.carport.Carport"%>
<%@page contentType="text/html" pageEncoding="latin1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="latin1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
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

            <table class="table table-hover" style="background-color: whitesmoke;">

                <thead>
                    
                    <tr style="background-color: beige;">
                        
                        <th></th>
                        <th style="color:black">CarportID</th>
                        <th style="color:black">Carport navn</th>
                        <th style="color:black">Carport bredde</th>
                        <th style="color:black">Carport længde</th>
                        <th style="color:black">Carport højde</th>
                        <th style="color:black">Taghældning</th>
                        <th style="color:black">Træsort</th>
                        <th style="color:black">Træsort pris</th>
                        <th style="color:black">Planke højde (cm)</th>
                        <th style="color:black">Planke længde (cm)</th>
                        <th style="color:black">træsort farve </th>
                        <th style="color:black">total antal planker</th>
                        <th style="color:black">Planker skrueantal</th>
                        <th style="color:black">Tagplade type </th>
                        <th style="color:black">Tagplade pris </th>
                        <th style="color:black">Tagplade bredde(cm) </th>
                        <th style="color:black">Tagplade længde(cm) </th>
                        <th style="color:black">Tagplade farve </th>
                        <th style="color:black">Tagplade antal </th>
                        <th style="color:black">Tagplade skrueantal</th>
                        <th style="color:black">Total skrueantal</th>
                        <th style="color:black">Totalpris</th>

                    </tr>
                </thead>

                <%
                    List<Carport> carports = CarportServlet.getCarports();
                    for (int i = 0; i < carports.size(); i++) {
                %>
                <tr>
                         <form action="CarportServlet" method="POST">
                <td>
                         <select name ="valg" style="color:black">
                        <Option value = "slet">Slet Carport</Option>
                        <input type ="hidden" name ="carportID" value ="<%out.print(carports.get(i).getCarportID());%>"/>
                        <input style="background-color: green; color:white" class="btn btn-block"  type ="Submit" name ="" value = "bekræft"/>
                   </select><br/>
                        </form>
                         </td>
                    
                    <td style="color:black;"><%out.print(carports.get(i).getCarportID());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getCarportName());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getCarportWidth());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getCarportLength());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getCarportHeight());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getRoofSlope());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getWoodType());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getWoodPrice());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getPlankHeight());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getPlankLength());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getWoodColor());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getTotalPlankAmount());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getPlankScrewAmount());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getEaveType());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getEavePrice());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getEaveWidth());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getEaveLength());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getEaveColor());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getEaveAmount());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getEaveScrewAmount());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getTotalScrewAmount());%></td>
                    <td style="color:black;"><%out.print(carports.get(i).getTotalPrice() + " kr");%></td>
                    
                <br/>    
                </tr>
                <% }%>
        </div>
            </table>
    </body>
</html>
