<%-- 
    Document   : RegisterPage
    Created on : Apr 8, 2017, 2:21:30 PM
    Author     : Desktop
--%>

<%@page contentType="text/html" pageEncoding="latin1"%>
<!DOCTYPE html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
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
    

<form action="UserServlet" method="POST">

  <div class="container">
      
    <input class="form-control" type="text" name="firstName" placeholder="Fornavn" required/>
    
    <input class="form-control" type="text" name="lastName" placeholder="Efternavn" required />

    <input class="form-control" type="text" name="username" placeholder="Brugernavn" required/>
    
    <input class="form-control" type="text" name="password" placeholder="Password" required/>
    
    <input class="form-control" type="text" name="address" placeholder="Adresse" required/>
    
    <input class="form-control" type="text" name="zipcode" placeholder="Postnummer" required/>
    
    <input class="form-control" type="text" name="email" placeholder="Email" required/>
    
    <input class="form-control" type="text" name="phoneNumber" placeholder="Telefon nummer" required/>
    
        
    <button type="submit" class="btn btn-primary" name = "valg" value = "opret kunde" style="background-color:green; color:white;">Opret bruger</button><br/>
    
  
  </div>
</form>
 <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>