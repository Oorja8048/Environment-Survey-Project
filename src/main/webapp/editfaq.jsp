<%@page import="com.environmentsurvey.model.FAQDAO"%>
<%@page import="com.environmentsurvey.bean.FAQBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="admin.jsp" %>
 <%@ page import="com.environmentsurvey.bean.SurveyStudentBean" %>
 <%@ page import="com.environmentsurvey.model.SurveyStudentDAO" %>
 <%
 FAQBean bean=new FAQBean();
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
  height: 300px;
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
FAQBean bean2=FAQDAO.getRecordbyId(Integer.parseInt(id));
%>

<h1 align="center">Edit FAQs</h1>
<%-- <input  type="hidden" name="id" value="<%=bean2.getId()%>">

<table>
<tr>
<td>Survey Id</td>
<td><input  type="text" name="id" value="<%=bean.getId()%>"></td>
</tr>
<tr>
<td>Question</td>
<td><input type="text" name="question" placeholder="name" value="<%=bean2.getQuestion()%>"></td>
</tr>
<tr>
<td>Answer</td>
<td><input type="text" name="answer" placeholder="answer" value="<%=bean2.getAnswer()%>"></td>
</tr>

<tr>
<td><span style="color:red"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span></td>
</tr>

<tr>
<td><input type="submit" name="Action" value="Edit FAQ"></td>
</tr>
</table>

</form> --%>


<div id="login">
       <!--  <h3 class="text-center text-white pt-5">Restaurant Management System</h3> -->
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12" >
                    
                        <form action="FAQCtrl"  method="post">
                        <input  type="hidden" name="id" value="<%=bean2.getId()%>">
                            <!-- <h3 class="text-center text-info">Login</h3> -->
                            <h6 class="text-center text-red pt-1"><strong><span style="color:red"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span></td>
</strong></h6>
                            <div class="form-group">
                                <label for="username" class="text-info">Question</label><br>
                                <input type="text" name="question" id="username" class="form-control" value="<%=bean2.getQuestion()%>" required="required">
                            </div>
                           
                                
                           
                            <div class="form-group">
                                <label for="password" class="text-info">Answer</label><br>
                                <textarea type="text" name="answer" id="password" class="form-control"  required="required"><%=bean2.getAnswer()%></textarea>
                            </div>
                            
                               
                           
                            
                            <div class="form-group" align="center" >
                               <!--  <label for="remember-me" class="text-info"><span>Remember me</span> <span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br> -->
                              
                                <input type="submit" name="Action" class="btn btn-info btn-md" value="Edit FAQ"> 
                                
                            </div>
                           
                        </form>
                    </div>
                </div>
            </div>
        </div>


</body>
</html>