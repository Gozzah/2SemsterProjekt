<%-- 
    Document   : AdminPage
    Created on : Mar 27, 2017, 9:18:19 PM
    Author     : kennethlundh
--%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
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
             background-image: url("https://media.giphy.com/media/Q9aBxHn9fTqKs/giphy.gif"); 
             background-attachment: fixed;
             background-repeat: no-repeat;
             background-size: cover;
        }
    </style>
    
  
<div class="container">
   
</div>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
