<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header3.jsp" %>
 <%@ page import="com.environmentsurvey.bean.SurveyStudentBean" %>
 <%@ page import="com.environmentsurvey.model.SurveyByFacultyDAO" %>
 <%
 SurveyStudentBean bean=new SurveyStudentBean();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>
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
  height: 500px;
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

   background-image: url(images/sur.jpg);
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
<body>
<%
String id=request.getParameter("id");
SurveyStudentBean bean2=SurveyByFacultyDAO.getRecordById(Integer.parseInt(id));
%>
<h1 align="center" style="color: maroon;">Edit Survey</h1>
<%-- <form action="AddSurveyByFacultyCtrl"  method="post">

<input  type="hidden" name="id" value="<%=bean2.getId()%>">

<table>
<tr>
<td>Survey Id</td>
<td><input  type="text" name="id" value="<%=bean.getId()%>"></td>
</tr>
<tr>
<td>Survey Name</td>
<td><input type="text" name="sname" placeholder="name" value="<%=bean2.getName()%>"></td>
</tr>
<tr>
<td>Description</td>
<td><input type="text" name="description" placeholder="Description" value="<%=bean2.getDescription()%>"></td>
</tr>
<tr>
<td>Volunteer</td>
<td><input type="text" name="volunteer" placeholder="Volunteer" value="<%=bean2.getVolunteers()%>"></td>
</tr>
<tr>
<td>Date</td>
<td> <input type="text" name="dos" id="datepicker" placaholder="dos" value="<%=bean2.getDateofsurvey()%>"></td>
</tr>


<tr>
<td>Venue</td>
<td><input type="text" name="venue" placaholder="venue" value="<%=bean2.getVenue()%>"></td>
</tr>

<tr>
<td><span style="color:red"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span></td>
</tr>

<tr>
<td><input type="submit" name="Action" value="Edit Survey"></td>
</tr>
</table>

</form> --%>

<div id="login">
       <!--  <h3 class="text-center text-white pt-5">Restaurant Management System</h3> -->
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12" >
                    
                        <form action="AddSurveyByFacultyCtrl"  method="post">
<!-- <h1 align="center">Edit Survey</h1> -->
<input  type="hidden" name="id" value="<%=bean2.getId()%>">
                            <!-- <h3 class="text-center text-info">Login</h3> -->
                            <h6 class="text-center text-red pt-1"><strong><span style="color:red"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span></td>
</strong></h6>
                            <div class="form-group">
                                <label for="username" class="text-info">Survey Name:</label><br>
                                <input type="text" name="sname" id="username" class="form-control" required="required" value="<%=bean2.getName()%>">
                            </div>
                           
                                
                           
                            <div class="form-group">
                                <label for="password" class="text-info">Description</label><br>
                                <input type="text" name="description" id="password" class="form-control" required="required" value="<%=bean2.getDescription()%>">
                            </div>
                            
                               <div class="form-group">
                                <label for="username" class="text-info">Volunteer</label><br>
                                <input type="text" name="volunteer" id="username" class="form-control" required="required" value="<%=bean2.getVolunteers()%>">
                           <strong><span style="color:red"><%=(request.getAttribute("ermsg") == null) ? "" : request.getAttribute("ermsg")%></span>
</strong>
                            </div>
                            
                               <div class="form-group">
                                <label for="username" class="text-info">Date</label><br>
                                <input type="text" name="dos" id="datepicker" class="form-control" required="required" value="<%=bean2.getDateofsurvey()%>">
                            </div>
                            
                            <div class="form-group">
                                <label for="username" class="text-info">Venue</label><br>
                                <input type="text" name="venue"  class="form-control" required="required" value="<%=bean2.getVenue()%>">
                            </div>
                            
                            <div class="form-group" align="center" >
                               <!--  <label for="remember-me" class="text-info"><span>Remember me</span> <span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br> -->
                                <input type="submit" name="Action" class="btn btn-info btn-md" value="Edit Survey"> 
                                
                            </div>
                           
                        </form>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>