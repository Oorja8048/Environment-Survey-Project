<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="admin.jsp" %>
 <%@ page import="com.environmentsurvey.bean.SurveyStudentBean" %>
 <%@ page import="com.environmentsurvey.model.SurveyStudentDAO" %>
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
</head>
<body>
<%
String id=request.getParameter("id");
SurveyStudentBean bean2=SurveyStudentDAO.getRecordById(Integer.parseInt(id));
%>
<form action="SurveyStudentCtrl"  method="post">
<h1>Edit Survey</h1>
<input  type="hidden" name="id" value="<%=bean2.getId()%>">

<table>
<tr>
<%-- <td>Survey Id</td>
<td><input  type="text" name="id" value="<%=bean.getId()%>"></td>
</tr> --%>
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

</form>
</body>
</html>