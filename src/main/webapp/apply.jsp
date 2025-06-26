<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

input[type=text] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}
</style>
</head>
<body>

<h1 align="center" style="color: maroon;"> Let's take a quick survey</h1>
<form action="QuestionCtrl" method="post" >
<label class="form-control"  style="font-family: inherit; font-variant: small-caps; color: blue; border-bottom: activeborder; font-stretch:expanded; font-size: large;">How Concerned are you about air pollution?</label><br>
<input type="radio" name="concered" value="ex">Extremely Concerned<br/>
<input type="radio" name="concered" value="sl">Slightly Concerned<br/>
<input type="radio" name="concered" value="nc">No Concerned<br/>

<label class="form-control" style="font-family: inherit; font-variant: small-caps; color: blue; border-bottom: activeborder; font-stretch:expanded; font-size: large;">What you have done to reduce air pollution?</label><br>
<input type="radio" name="reduced" value="av">Avoided Vehicles<br/>
<input type="radio" name="reduced" value="sc">Started Smoking<br/>
<input type="radio" name="reduced" value="no">Nothing<br/>

<label class="form-control" style="font-family: inherit; font-variant: small-caps; color: blue; border-bottom: activeborder; font-stretch:expanded; font-size: large;">What is the quality of air in your area?</label><br>
<input type="radio" name="quality" value="gd">Good<br/>
<input type="radio" name="quality" value="po">Poor<br/>
<input type="radio" name="quality" value="nc">No Concerned<br/>
<br><br>
<input type="submit" name="Submit" class="btn btn-info btn-md" value="Submit">

</form>
</body>
</html>