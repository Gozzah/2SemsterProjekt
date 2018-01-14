<%-- 
    Document   : ShowCarportCustomer
    Created on : Apr 27, 2017, 2:32:15 PM
    Author     : kennethlundh
--%>

<%@page import="presentation.CarportServlet"%>
<%@page import="presentation.UserServlet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.entities.carport.Carport"%>
<%@page contentType="text/html" pageEncoding="latin1"%>
<!DOCTYPE html>


<html>
    <head>
       
        <meta charset="latin1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
     
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
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

                      <style>
        body {
             background-image: url(" https://s-media-cache-ak0.pinimg.com/originals/fe/d3/33/fed333675bef0b7bc9995dfc587b45ca.jpg"); 
             background-attachment: fixed;
             background-repeat: no-repeat;
             background-size: cover;
        }
    </style>
                
                
        <div class="container">
            <table class="table bg-primary" style="background-color: l;">

                <thead>
                    <tr class="bg-info" style="background-color: lightseagreen;">

                        <th style="color:black;">Carport Navn</th>
                        <th style="color:black;">Carport bredde</th>
                        <th style="color:black;">Carport længde</th>
                        <th style="color:black;">Carport højde</th>
                        <th style="color:black;">Taghældning</th>
                        <th style="color:black;">Træsort</th>
                        <th style="color:black;">Farve til træ</th>
                        <th style="color:black;">Tagplade Type</th>
                        <th style="color:black;">Farve til tagplader</th>
                        <th style="color:black;">Totalpris</th>
                        <th style="color:black;">Antal </th>
                        <th></th>




                    </tr>
                </thead>
                <tbody>
                    <%
                        int c = Integer.parseInt(request.getParameter("carportID"));
                        List<Carport> carports = ((ArrayList<Carport>) CarportServlet.getCarportByID(c));
                        for (int i = 0; i < carports.size(); i++) {
                    %>

                    <tr>
                        <td style="color:black;"><%out.print(carports.get(i).getCarportName());%></td>
                        <td style="color:black;"><%out.print(carports.get(i).getCarportWidth());%></td>
                        <td style="color:black;"><%out.print(carports.get(i).getCarportLength());%></td>
                        <td style="color:black;"><%out.print(carports.get(i).getCarportHeight());%></td>
                        <td style="color:black;"><%out.print(carports.get(i).getRoofSlope());%></td>
                        <td style="color:black;"><%out.print(carports.get(i).getWoodType());%></td>
                        <td style="color:black;"><%out.print(carports.get(i).getWoodColor());%></td>
                        <td style="color:black;"><%out.print(carports.get(i).getEaveType());%></td>
                        <td style="color:black;"><%out.print(carports.get(i).getEaveColor());%></td>
                        <td style="color:black;"><%out.print(carports.get(i).getTotalPrice() + " kr");%></td>

<br/>




                        <td>
                         <form action="OrderServlet" method ="POST">
                            <select style="color:black;" name ="quantity">
                                <%for (int g = 1; g <= 10; g++) {

                                %>
                                <option value ="<%out.print(g);%>" ><%out.print(g);%></option>
                                <%} %>
                        </td>
                    </select><br/>


                           
                    <td>
                        <input type ="hidden" name ="valg" value ="Bekræft køb"/>
                        <input type="hidden" name="carportID" value="<%out.print(carports.get(i).getCarportID());%>"/>
                        <input type="hidden" name="customerID" value="<%out.print(session.getAttribute("customerID"));%>"/>
                        <input type="hidden" name="totalPrice" value="<%out.print(carports.get(i).getTotalPrice());%>"/>
                        <button style="background-color: green;" type="submit" class="btn btn-primary" name ="" value ="bekræft">Bekræft køb</button>
    </form>             <img src="https://www.poetschke.de/out/pictures/generated/product/1/256_256_75/281689-00-GPIE.jpg"> 
                    </td>
                    </tr>


                    <% }%>
                </tbody>        
            </table>
        </div>


</body>
</html>
