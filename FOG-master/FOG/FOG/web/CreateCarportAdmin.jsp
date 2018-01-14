<%-- 
    Document   : CustomCarport
    Created on : 27-03-2017, 16:47:54
    Author     : Runej
--%>

<%@page import="presentation.CarportServlet"%>
<%@page import="data.ProductsMapper"%>
<%@page import="logic.entities.products.Products"%>
<%@page import="logic.entities.carport.Carport"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="latin1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="latin1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    
     <%if(session.getAttribute("adminID") == null){
      request.getRequestDispatcher("index.html").forward(request, response);
     }%>
    
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
        
        <form method = "post" action="CarportServlet" enctype="multipart/form-data">
            
            <div class="container" style="background-color: whitesmoke; height: 445px; width: 245px;" >
            
            <label style="color: black;"> Carport navn</label> 
            <br/>
            <input type = text name= "carportName" value = "" style="width:160px;" required/>
            <br/>
            
            <label style="color: black;"> Carport Bredde </label>
            <br/>
            <select name ="carportWidth" style="width:160px;">
                    <%for (int i = 100; i <= 500; i += 50) {

                    %>
                    <option value ="<%out.print(i);%>" ><%out.print(i + "cm");%></option>

                    <%} %>


                </select><br/>
                
                
            <label style="color: black;"> Carport længde</label>    
            <br/>
            <select name ="carportLength" style="width:160px;">
                    <%for (int i = 100; i <= 500; i += 50) {

                    %>
                    <option value ="<%out.print(i); %>" ><%out.print(i + "cm"); %></option>

                    <%} %>

                </select><br/>

                <label style="color: black;"> Carport højde</label>      
                <br/>
                <select name ="carportHeight" style="width:160px;">
                    <%for (int i = 100; i <= 500; i += 50) {

                    %>
                    <option value ="<%out.print(i); %>" ><%out.print(i + "cm"); %></option>

                    <%} %>



                </select><br/>

                <label style="color: black;"> Taghældning</label>
                <br/>
                <select name ="roofSlope" style="width:160px;">
                    <%for (int i = 0; i <= 45; i += 5) {

                    %>
                    <option value ="<%out.print(i); %>" ><%out.print(i + "grader"); %></option>

                    <%} %>


                </select><br/>
            <label style="color: black;"> Træ type</label>    
            <br/>
            <select name ="woodID" style="width:160px;">
                    <%for (Products p : CarportServlet.wood()) {

                    %>
                    <option value ="<%out.print(p.getProductID() + "-" + p.getPrice() + "-" + p.getProductHeight() + "-" + p.getProductLength());%>"><%=p.getName()%></option>

                    <%
                        }
                    %>

                </select><br/>



            <label style="color: black;"> Planke farve </label>
            <br/>
                    <select name ="woodColor" style="width:160px;">
                    <%for (Products p : CarportServlet.paint()) {

                    %>
                    <option value ="<%out.print(p.getProductID()); %>"><%out.print(p.getName()); %></option>

                    <%}%>


                </select><br/>

            <label style="color: black;"> Tagplade type </label>
            <br/>
                    <select name ="eaveID" style="width:160px;">
                    <%for (Products e : CarportServlet.eaves()) {

                    %>
                    <option value ="<%out.print(e.getProductID() + "-" + e.getPrice() + "-" + e.getProductHeight() + "-" + e.getProductLength()); %>"><%out.print(e.getName()); %></option>

                    <%}%>


                </select><br/>
                
            <label style="color: black;"> Tagplade farve</label>
            <br/>
            <select name ="eaveColor" style="width:160px;">
                    <%for (Products e : CarportServlet.paint()) {

                    %>
                    <option value ="<%out.print(e.getProductID()); %>"><%out.print(e.getName()); %></option>

                    <%}%>


                </select><br/>
            <input style="background-color: green; color:white;" class="btn btn-md" type ="Submit" name ="Opret" value ="Opret"/>
            <input type="hidden" name="valg" value="add"/>
            </div>
        </form>
    </body>
</html>
