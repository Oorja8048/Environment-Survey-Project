<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="admin.jsp" %>
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
<%-- Welcome<%String name=(String)session.getAttribute("username");
out.println(name);%> --%>
<!-- <form action="UserRegistrationCtrl" method="POST" > -->
<h1 align="center">Add Faculty for Environment Survey</h1>
<%-- <table id="table-1" align="left" cellpadding="5" cellspacing="10" frame="void">
	<tr>
		<td>Name</td>
		<td><input type="text" name="uname" required="required"></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name="pass" required="required"></td>
	</tr>
	<tr>
		<td>Employee No</td>
		<td><input type="text" name="roll" required="required"></td>
	</tr>
	<tr>
		<td>Specification</td>
		<td><input type="text" name="specification" required="required"></td>
	</tr>
	<tr>
		<td>Section</td>
		<td><input type="text" name="section" required="required"></td>
	</tr>
	<td>Class</td>
	<td><select name="class" required="required">
			<option disabled="disabled" selected="selected">Choose
				option</option>
			<option>FE</option>
			<option>SE</option>
			<option>TE</option>
			<option>BE</option>
	</select></td>
	</tr>
	<tr>
<td>Date of Joining</td>
<td> <input type="text" name="doa" id="datepicker" placaholder="Date of Admission"></td>
</tr>
	<!-- <tr><td>Date of Admission</td>
	<td><input type="date" name="doa" ></td>
	</tr> -->
	<tr>
		<td><input type="submit" name="Action" value="Add" id="button-1"/></td>
	</tr>
	<tr>
		<td><span style="color:red"><%=(request.getAttribute("msg") == null) ? "" : request.getAttribute("msg")%></span></td>
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
                <form action="UserRegistrationCtrl" method="POST" >
                <div class="form-row">
                        <div class="form-group col-md-6">
                          <input id="Full Name" name="uname" placeholder="Name" class="form-control" type="text" required="required">
                           <strong> <span style="color:red"><%=(request.getAttribute("isname") == null) ? "" : request.getAttribute("isname")%></span></strong>
                        </div>
                        <div class="form-group col-md-6">
                          <input type="password" class="form-control" name="pass" id="inputEmail4" placeholder="Password" required="required">
                        </div>
                      </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                         <input id="Mobile No."  name="roll" placeholder="Enter Employee No." class="form-control" required="required" type="text">
                         <strong> <span style="color:red"><%=(request.getAttribute("isroll") == null) ? "" : request.getAttribute("isroll")%></span></strong>
                        </div>
                        <div class="form-group col-md-6">
                          <input type="text" class="form-control" name="specification" id="inputEmail4" placeholder="Specification" required="required">
                           <strong> <span style="color:red"><%=(request.getAttribute("isspecification") == null) ? "" : request.getAttribute("isspecification")%></span></strong>
                        </div>
                      </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <input id="Mobile No." type="text" name=section placeholder="Enter section" class="form-control" required="required" type="text">
                             <strong> <span style="color:red"><%=(request.getAttribute("issection") == null) ? "" : request.getAttribute("issection")%></span></strong>
                        </div>
                        <div class="form-group col-md-6">
                                  
                                  <select id="inputState" name="class" class="form-control" required="required">
                                    <option selected >Choose Class ...</option>
                                    <option> FE</option>
                                    <option> SE</option>
                                    <option> TE</option>
                                    <option> BE</option>
                                  </select>
                        </div>
                        
                        <div class="form-group col-md-12">
                                 
                                  <input id="datepicker" type="text" name="doa"  class="form-control" required="required" placeholder="Enter Date Of Joining">
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
                        <button type="submit" class="btn btn-danger" name="Action" value="Add" >Add Faculty</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>


</body>
</html>