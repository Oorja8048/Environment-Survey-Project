<%@page import="com.environmentsurvey.utility.DBConnect"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
/*  for ne w form*/
/* body {
  margin: 0;
  padding: 0;
  background-color: #17a2b8;
  height: 100vh;
} */
#login .container #login-row #login-column #login-box {
  margin-top: 5px;
  max-width: 600px;
  height: 450px;
  border: 1px solid #9C9C9C;
  background-color: #EAEAEA;
}
#login .container #login-row #login-column #login-box #login-form {
  padding: 20px;
}
#login .container #login-row #login-column #login-box #login-form #register-link {
  margin-top: -85px;
}



* {box-sizing: border-box;}

body { 
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
 
   background-image: url(images/comp1.jpg);
  background-repeat: no-repeat;
  background-size: cover;
}


.header {
  overflow: hidden;
  background-color: #f1f1f1;
  padding: 20px 10px;
}

.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
}

.header a.logo {
  font-size: 25px;
  font-weight: bold;
}

.header a:hover {
  background-color: #ddd;
  color: black;
}

.header a.active {
  background-color: dodgerblue;
  color: white;
}

.header-right {
  float: right;
}

@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }
  
  .header-right {
    float: none;
  }
}
</style>
</head>
<body><br>
<h1 align="center">Seminar Conducted by Student</h1>
<%-- <h1 align="center">Seminar Conducted by Student</h1><div class="card">
  <div class="card-body " style="max-width: 18rem">
    
<form action="EparticipationCtrl" method="post">
<strong><center><span style="color:red"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span><br>
  </strong></center>
  <label for="sname">Survey Name:</label><br>
  <input type="text" id="sname" name="sname" placeholder="Survey Name" required ><br>
  <label for="venue">Venue</label><br>
  <input type="text" id="venue" name="venue" placeholder="Venue" required><br>
  <label for="volunteers">Volunteers</label><br>
  <input type="text" id="volunteers" name="volunteers" placeholder="Volunteers" required><br>
  <label for="date">Date</label><br>
  <input type="text" id="datepicker" name="dos" placeholder="Date" required><br><br>
  
  <input type="submit" value="Add Participation" name="Action" class="btn-success">
</form></div></div> --%>

<div id="login">
       <!--  <h3 class="text-center text-white pt-5">Restaurant Management System</h3> -->
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12" >
                    
                        <form action="EparticipationCtrl" method="post">

                            <h6 class="text-center text-red pt-1"><strong><span style="color:red"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span></td>
</strong></h6>
                            <div class="form-group">
                                <label for="username" class="text-info">Survey Name:</label><br>
                                <input type="text" name="sname" id="username" class="form-control" required="required" >
      <strong><span style="color:red"><%=(request.getAttribute("isname") == null) ? "" : request.getAttribute("isname")%></span>
</strong>                       
                            
                           
                                
                           
                                                 
                               <div class="form-group">
                                <label for="username" class="text-info">Volunteer</label><br>
                                <input type="text" name="volunteers" id="username" class="form-control" required="required" >
                           <strong><span style="color:red"><%=(request.getAttribute("ermsg") == null) ? "" : request.getAttribute("ermsg")%></span>
</strong></div>
                            </div>
                            
                               <div class="form-group">
                                <label for="username" class="text-info">Date</label><br>
                                <input type="text" name="dos" id="datepicker" class="form-control" required="required" >
                            </div>
                            
                            <div class="form-group">
                                <label for="username" class="text-info">Venue</label><br>
                                <input type="text" name="venue"  class="form-control" required="required" >
                           <strong><span style="color:red"><%=(request.getAttribute("isvenue") == null) ? "" : request.getAttribute("isvenue")%></span>
</strong>
                            </div>
                            
                            <div class="form-group" align="center" >
                               <!--  <label for="remember-me" class="text-info"><span>Remember me</span> <span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br> -->
                                <input type="submit" name="Action" class="btn btn-info btn-md" value="Add Participation"> 
                                
                            </div>
                           
                        </form>
                    </div>
                </div>
            </div>
        </div>



<h1 align="center" style="color: maroon;">Participation List</h1>
<table border="1" align="center" cellpadding="5" class="table" style="color: maroon;">
      <tr>
<!-- <th>Id</th> -->
<th>Name</th>
<th>Venue</th>
<th>Volunteers</th>
<th>Date</th>
</tr>
<%
Connection con=DBConnect.getConn();
Statement statement=con.createStatement();
ResultSet rs=statement.executeQuery("SELECT * FROM e_paticipation");
while(rs.next())
{
%>
<tr>
<%-- <td><%=rs.getInt(1) %>
</td> --%>
<td><%=rs.getString(2) %>
</td>
<td><%=rs.getString(3) %>
</td>
<td><%=rs.getString(4) %>
</td>
<td><%=rs.getString(5) %>
</td>
</tr>
<%} %>
</table>
</body>
</html>