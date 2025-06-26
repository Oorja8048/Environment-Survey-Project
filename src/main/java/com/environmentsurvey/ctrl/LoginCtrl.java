package com.environmentsurvey.ctrl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.environmentsurvey.bean.LoginBean;
import com.environmentsurvey.model.LoginDao;

/**
 * Servlet implementation class LoginCtrl
 */
@WebServlet("/LoginCtrl")
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		System.out.println("in login");
		String username=request.getParameter("uname");
		String password=request.getParameter("pass");
		
		LoginBean bean=new LoginBean();
		//System.out.println("after bean");
		bean.setUserName(username);
		bean.setPassword(password);
		
		
		
		
		
		LoginDao dao=new LoginDao();
		System.out.println("after calling dao");
		
		String authenticate_user;
		try {
			authenticate_user = dao.authenticate(bean);
			System.out.println(authenticate_user);
			if(authenticate_user.equals("Admin_Role"))
			{
				System.out.println("admin");
				HttpSession httpSession=request.getSession();
				httpSession.setAttribute("admin", username);
				request.setAttribute("username", username);
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			else if(authenticate_user.equals("Student_Role"))
			{
				System.out.println("student");
				HttpSession httpSession=request.getSession();
				httpSession.setAttribute("student", username);
				//httpSession.setAttribute("roll", );
				request.setAttribute("student", username);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else if(authenticate_user.equals("Faculty_Role"))
			{
				System.out.println("faculty");
				HttpSession httpSession=request.getSession();
				httpSession.setAttribute("faculty", username);
				request.setAttribute("faculty", username);
				request.getRequestDispatcher("indexpageforfaculty.jsp").forward(request, response);
			}
			else 
			{
				String ermsg="Please enter valid username or password";
				request.setAttribute("ermsg", ermsg);
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
	            rd.forward(request, response); 
				System.out.println("invalid");
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end");
		
	}

}
