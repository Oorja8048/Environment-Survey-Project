<%@page import="com.environmentsurvey.model.UserRegisterDAO"%>
<%@page import="com.environmentsurvey.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="admin.jsp" %>
 <%@ page import="com.environmentsurvey.bean.SurveyStudentBean" %>
 <%@ page import="com.environmentsurvey.model.SurveyStudentDAO" %>
 <%
 UserBean bean=new UserBean();
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
  height: 505px;
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
UserBean bean2=UserRegisterDAO.getRecordbyId(Integer.parseInt(id));
%>
<%-- <form action="UserRegistrationCtrl"  method="post">
<h1>Accept Users</h1>
<input  type="hidden" name="id" value="<%=bean2.getId()%>">

<table>
<tr>
<td>Survey Id</td>
<td><input  type="text" name="id" value="<%=bean.getId()%>"></td>
</tr>
<tr>
<td>Name</td>
<td><input type="text" name="uname" placeholder="name" value="<%=bean2.getName()%>"></td>
</tr>
<tr>
<td>ROll No</td>
<td><input type="text" name="roll" placeholder="Description" value="<%=bean2.getRoll()%>"></td>
</tr>
<tr>
<td>Class</td>
<td><input type="text" name="class" placeholder="Volunteer" value="<%=bean2.getUserclass()%>"></td>
</tr>
<tr>
<td>Specification</td>
<td> <input type="text" name="specification" id="datepicker" placaholder="dos" value="<%=bean2.getSpecification()%>"></td>
</tr>


<tr>
<td>Section</td>
<td><input type="text" name="section" placaholder="venue" value="<%=bean2.getSection()%>"></td>
</tr>

<tr>
<td>password</td>
<td><input type="text" name="pass" placaholder="venue" value="<%=bean2.getPassword()%>"></td>
</tr>
<tr>
<td>Date of Admission</td>
<td><input type="text" name="doa" id="datepicker" placaholder="venue" value="<%=bean2.getDoa()%>"></td>
</tr>
<tr>
<td><span style="color:red"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span></td>
</tr>

<tr>
<td><input type="submit" name="Action" value="Accept"></td>
</tr>
</table>

</form> --%>
<section class="testimonial py-5" id="testimonial">
    <div class="container">
        <div class="row ">
            <div class="col-md-4 py-5 bg-primary text-white text-center ">
                <div class=" ">
                    <div class="card-body">
                        <!-- <img src="http://www.ansonika.com/mavia/img/registration_bg.svg" style="width:30%"> -->
                        <img src="images/teacher.png" style="width:30%">
                        <h2 class="py-3">Registration</h2>
                        <p>Register Faculty/Staff of the institute.

</p>
                    </div>
                </div>
            </div>
            <div class="col-md-8 py-5 border">
                <h4 class="pb-4">Please fill with your details</h4>
               <strong> <span style="color:red"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span></strong>
                <form action="UserRegistrationCtrl"  method="post">
                <input  type="hidden" name="id" value="<%=bean2.getId()%>">
                <div class="form-row">
                        <div class="form-group col-md-6">
                          <input id="Full Name" name="uname" placeholder="Name" class="form-control" type="text" value="<%=bean2.getName()%>" required="required">
                           <strong> <span style="color:red"><%=(request.getAttribute("isname") == null) ? "" : request.getAttribute("isname")%></span></strong>
                        </div>
                        <div class="form-group col-md-6">
                          <input type="password" class="form-control" name="pass" id="inputEmail4" value="<%=bean2.getPassword()%>" placeholder="Password" required="required">
                        </div>
                      </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                         <input id="Mobile No."  name="roll" placeholder="Enter Employee No." class="form-control" value="<%=bean2.getRoll()%>" required="required" type="text">
                         <strong> <span style="color:red"><%=(request.getAttribute("isroll") == null) ? "" : request.getAttribute("isroll")%></span></strong>
                        </div>
                        <div class="form-group col-md-6">
                          <input type="text" class="form-control" name="specification"  value="<%=bean2.getSpecification()%>" id="inputEmail4" placeholder="Specification" required="required">
                           <strong> <span style="color:red"><%=(request.getAttribute("isspecification") == null) ? "" : request.getAttribute("isspecification")%></span></strong>
                        </div>
                      </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <input id="Mobile No." type="text" name="section" placeholder="Enter section"  value="<%=bean2.getSection()%>" class="form-control" required="required" type="text">
                             <strong> <span style="color:red"><%=(request.getAttribute("issection") == null) ? "" : request.getAttribute("issection")%></span></strong>
                        </div>
                        <div class="form-group col-md-6">
                             <input id="Mobile No." type="text" name="class" placeholder="Enter section"  value="<%=bean2.getUserclass()%>" class="form-control" required="required" type="text">     
                                  
                        </div>
                        
                        <div class="form-group col-md-12">
                                 
                                  <input id="datepicker" value="<%=bean2.getDoa()%>" type="text" name="doa"  class="form-control" required="required" placeholder="Enter Date Of Joining">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <div class="form-group">
                                <!-- <div class="form-check">
                                  <input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>
                                  <label class="form-check-label" for="invalidCheck2">
                                    <small>By clicking Submit, you agree to our Terms & Conditions, Visitor Agreement and Privacy Policy.</small>
                                  </label>
                                </div> -->
                              </div>
                    
                          </div>
                    </div>
                    
                    <div class="form-row">
                        <button type="submit" class="btn btn-danger" name="Action" value="Accept" >Accept</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>