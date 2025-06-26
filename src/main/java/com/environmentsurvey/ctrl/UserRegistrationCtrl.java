package com.environmentsurvey.ctrl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.environmentsurvey.bean.UserBean;
import com.environmentsurvey.model.UserRegisterDAO;
import com.environmentsurvey.utility.DataUtility;
import com.environmentsurvey.utility.DataValidator;

/**
 * Servlet implementation class UserRegistrationCtrl
 */

@WebServlet("/UserRegistrationCtrl")
public class UserRegistrationCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("Action").equals("Register"))
		{
		//	int roll=Integer.parseInt(request.getParameter("roll"));
			String uname=request.getParameter("uname");
			String pass=request.getParameter("pass");
			String roll=request.getParameter("roll");
			String specification=request.getParameter("specification");
			String section=request.getParameter("section");
			String classname=request.getParameter("class");
			String dao1=request.getParameter("dao");
			
			
			
			
			
		UserBean bean=new UserBean();
		bean.setName(uname);
		bean.setPassword(pass);
		bean.setRoll(roll);
		//bean.setRoll(DataUtility.getInt(request.getParameter("roll")));
		bean.setSpecification(specification);
		bean.setSection(section);
		bean.setUserclass(classname);
		bean.setDoa(dao1);
		bean.setRoleid(3);
		bean.setStatus(0);
		if(!DataValidator.isName(uname))
		{
			System.out.println("inside validator name");
			request.setAttribute("isname","Please enter Characters" );
			request.getRequestDispatcher("userreg.jsp").forward(request, response);
		}
		else if(!DataValidator.isInteger(roll))
		{
			System.out.println("inside validator name");
			request.setAttribute("isroll","Please enter valid Number" );
			request.getRequestDispatcher("userreg.jsp").forward(request, response);
		}
		else if(!DataValidator.isName(specification))
		{
			System.out.println("inside validator name");
			request.setAttribute("isspecification","Please enter valid Characters" );
			request.getRequestDispatcher("userreg.jsp").forward(request, response);
		}
		else if(!DataValidator.isName(section))
		{
			System.out.println("inside validator name");
			request.setAttribute("issection","Please enter valid Characters" );
			request.getRequestDispatcher("userreg.jsp").forward(request, response);
		}
		else
		{
			
		
		/*bean.setName(request.getParameter("uname"));
		bean.setPassword(request.getParameter("pass"));
		bean.setRoll(Integer.parseInt(request.getParameter("roll")));
		//bean.setRoll(DataUtility.getInt(request.getParameter("roll")));
		bean.setSpecification(request.getParameter("specification"));
		bean.setSection(request.getParameter("section"));
		bean.setUserclass(request.getParameter("class"));
		bean.setDoa(request.getParameter("doa"));*/
		
		
		/*bean.setRoleid(3);
		bean.setStatus(0);*/
		UserRegisterDAO dao=new UserRegisterDAO();
		boolean addedUser=dao.addUser(bean);
		
		System.out.println("wait for admin to accept the registration!!");
		String msg="Wait!!! for admin to accept the registration.";
		request.setAttribute("msg",msg);
		request.getRequestDispatcher("userreg.jsp").forward(request, response);
		System.out.println("done");
		}
		}
		if(request.getParameter("Action").equals("Add"))    //Add faculty
		{
			
			System.out.println("inside add faculty");
			UserBean bean=new UserBean();
			bean.setName(request.getParameter("uname"));
			bean.setPassword(request.getParameter("pass"));
			bean.setRoll((request.getParameter("roll")));
			bean.setSpecification(request.getParameter("specification"));
			bean.setSection(request.getParameter("section"));
			bean.setUserclass(request.getParameter("class"));
			bean.setDoa(request.getParameter("doa"));
			bean.setRoleid(2);
			
			UserRegisterDAO dao=new UserRegisterDAO();
			boolean addedUser=dao.addFaculty(bean);
			System.out.println("added"+addedUser);
			String msg="Successfully Registered";
			request.setAttribute("msg",msg);
			request.getRequestDispatcher("addFaculty.jsp").forward(request, response);
		}
		if(request.getParameter("Action").equals("Edit Profile")) //edit profile bu user
		{
			UserBean bean=new UserBean();
			bean.setId(Integer.parseInt(request.getParameter("id")));
			bean.setName(request.getParameter("uname"));
			bean.setPassword(request.getParameter("pass"));
			bean.setRoll((request.getParameter("roll")));
			bean.setSpecification(request.getParameter("specification"));
			bean.setSection(request.getParameter("section"));
			bean.setUserclass(request.getParameter("class"));
			bean.setDoa(request.getParameter("doa"));
			
			if(!DataValidator.isName(request.getParameter("uname")))
			{
				System.out.println("inside validator name");
				request.setAttribute("isname","Please enter Characters" );
				request.getRequestDispatcher("edit.jsp").forward(request, response);
			}
			else if(!DataValidator.isInteger(request.getParameter("roll")))
			{
				System.out.println("inside validator name");
				request.setAttribute("isroll","Please enter valid Number" );
				request.getRequestDispatcher("edit.jsp").forward(request, response);
			}
			
			else
			{
			UserRegisterDAO dao=new UserRegisterDAO();
			try {
				int i=dao.updateUser(bean);
				System.out.println(i);
				String msg = "Edited";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("edit.jsp").include(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		if(request.getParameter("Action").equals("Accept"))
		{
			UserBean bean=new UserBean();
			bean.setId(Integer.parseInt(request.getParameter("id")));
			bean.setName(request.getParameter("uname"));
			bean.setPassword(request.getParameter("pass"));
			bean.setRoll((request.getParameter("roll")));
			bean.setSpecification(request.getParameter("specification"));
			bean.setSection(request.getParameter("section"));
			bean.setUserclass(request.getParameter("class"));
			bean.setDoa(request.getParameter("doa"));
			bean.setRoleid(3);
			bean.setStatus(1);
			UserRegisterDAO dao=new UserRegisterDAO();
			try {
				int result=dao.updateStatus(bean);
				System.out.println("accepted");
				String msg="Accepted";
				request.setAttribute("msg",msg);
				request.getRequestDispatcher("acceptusers.jsp").forward(request, response);
				System.out.println("done");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(request.getParameter("Action").equals("Edit Student")) //edit profile by admin
		{
			UserBean bean=new UserBean();
			bean.setId(Integer.parseInt(request.getParameter("id")));
			bean.setName(request.getParameter("uname"));
			bean.setPassword(request.getParameter("pass"));
			bean.setRoll((request.getParameter("roll")));
			bean.setSpecification(request.getParameter("specification"));
			bean.setSection(request.getParameter("section"));
			bean.setUserclass(request.getParameter("class"));
			bean.setDoa(request.getParameter("doa"));
			
			
			
			
			
				
			
			UserRegisterDAO dao=new UserRegisterDAO();
			try {
				int i=dao.editStudentByadmin(bean);
				System.out.println(i);
				String msg = "Edited";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("editstudent.jsp").include(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//doGet(request, response);
	}
	
}
