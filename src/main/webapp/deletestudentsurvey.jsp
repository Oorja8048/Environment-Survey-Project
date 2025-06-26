<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.environmentsurvey.utility.DBConnect"%>
     
 <%@ page import="com.environmentsurvey.bean.SurveyStudentBean" %>
 <%@ page import="com.environmentsurvey.model.SurveyStudentDAO" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>

<%
		String id = request.getParameter("id");
		if (id != null) {
			int userid = Integer.parseInt(id);

			Connection con = DBConnect.getConn();
			String sql = "DELETE FROM E_SURVEYSTUDENT WHERE ID=" + userid;
			PreparedStatement ps = con.prepareStatement(sql);
			int i = ps.executeUpdate();
			if (i > 0) {
	%>
	<jsp:forward page="/viewsurveyforfaculty.jsp" />
	<%
		} else
	%>
	<jsp:forward page="/viewsurveyforfaculty.jsp" />
	<%
		}
	%>
</body>
</html>