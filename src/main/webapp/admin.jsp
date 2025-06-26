<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
/* body {
  font-family: Arial, Helvetica, sans-serif;
}
@media screen and (max-width: 500px) {
  .navbar a {
    float: none;
    display: block;
  }
}
.navbar {
  overflow: hidden;
  background-color: #333;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px;
  text-decoration: none;
  display: block;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}
.sticky {
  position: fixed;
  top: 0;
  width: 100%;
}

.dropdown:hover .dropdown-content {
  display: block;
} */
</style>

<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<%
	if (request.getSession(false).getAttribute("admin") == null) {
		response.sendRedirect("login.jsp");
	}
%>
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color:#a1887f;">
  <a class="navbar-brand" href="#">Environment Survey Portal</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="home.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
     <!--  <li class="nav-item active">
        <a class="nav-link" href="viewcustomer.jsp">View Customer</a>
      </li> -->
      <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Add Survey
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="addsurvey.jsp">For Students</a>
          <a class="dropdown-item" href="addSurveyforfaculty.jsp">For faculty/Staff</a>
          <!-- <a class="dropdown-item" href="addinsectide.jsp">Add Insecticides</a>
          <a class="dropdown-item" href="addpesticide.jsp">Add Pesticide</a> -->
        </div>
      </li>
      
      
      <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         View Survey
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          
          <a class="dropdown-item" href="viewsurvey.jsp">For Students</a>
          <a class="dropdown-item" href="viewsurveyforfaculty.jsp">For faculty/Staff</a>
          
        </div>
      </li>
      
      <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         Users
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          
          <a class="dropdown-item" href="addFaculty.jsp">Add Faculty/Staff</a>
          <a class="dropdown-item" href="viewusers.jsp">View Users</a>
          
        </div>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="addcompetition.jsp">Add Competition</a>
      </li>
      <li class="nav-item active">
      <a class="nav-link" href="showsubmittedsurveytoadmin.jsp">Show Student Survey</a>
      </li>
      
      <li class="nav-item active">
      <a class="nav-link" href="supportadmin.jsp">Support</a>
      </li>
      
      <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        FAQs
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          
          <a class="dropdown-item" href="addFaqs.jsp">Add FAQ</a>
          <a class="dropdown-item" href="viewFaqs.jsp">View FAQ</a>
          
        </div>
      </li>
      
      <li class="nav-item dropdown active" >
 	
        <a  class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Welcome
		<%=session.getAttribute("admin")%>
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          
          <a class="dropdown-item" href="logout.jsp">Logout</a>
        </div>
      </li>
    </ul>
  </div>
</nav>
<!-- <div class="navbar navbar-expand-lg navbar-light"  >

  <a href="admin.jsp">Home</a>
  
   <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Add Survey
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="addsurvey.jsp">For Students</a>
          <a class="dropdown-item" href="addSurveyforfaculty.jsp">For faculty/Staff</a>
        
        </div>
      </li>
  <div class="dropdown">
    <button class="nav-link dropdown-toggle">Add Survey 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="addsurvey.jsp">For Students</a>
      <a href="addSurveyforfaculty.jsp">For faculty/Staff</a>
     
    </div>
  </div> 
  
  <div class="dropdown">
    <button class="dropbtn">View Survey 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="viewsurvey.jsp">For Students</a>
      <a href="viewsurveyforfaculty.jsp">For faculty/Staff</a>
      
    </div>
  </div> 
  <div class="dropdown">
    <button class="dropbtn">Users 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="addFaculty.jsp">Add Faculty/Staff</a>
     <a href="viewusers.jsp">View Users</a>
      
    </div>
  </div>
  <div class="topnav-right">  
  <a href="addcompetition.jsp">AddCompetition</a> 
  <a href="showsubmittedsurveytoadmin.jsp">Show Student Survey</a>
  <a href="supportadmin.jsp">Support</a>
  <div class="dropdown">
    <button class="dropbtn">FAQ 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="addFaqs.jsp">Add faq</a>
     <a href="viewFaqs.jsp">View Faq</a>
      
    </div>
  </div>
  <a href="logout.jsp">Logout</a>
  
</div>
</div> -->
<%-- <div>
Welcome<%=
request.getAttribute("username")%></div> --%>
<%-- <div align="right" style="color: buttonhighlight; font-style: italic; font-size-adjust: inherit; font-weight: 100; font-variant: normal;">Welcome <%=session.getAttribute("admin") %></div>
<h3></h3>
<p></p> --%>
</body>
<body></body>
</html>
