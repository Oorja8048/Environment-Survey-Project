package com.environmentsurvey.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.environmentsurvey.model.QuestionDAO;
import com.environmentsurvey.utility.DBConnect;
import com.mysql.cj.exceptions.StatementIsClosedException;

/**
 * Servlet implementation class QuestionCtrl
 */
@WebServlet("/QuestionCtrl")
public class QuestionCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionCtrl() {
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
		response.setContentType("text/html");
		int t_count=0;
		PrintWriter printWriter=response.getWriter();
		request.getRequestDispatcher("apply.jsp").include(request, response);
		int count=0,result;
		
		HttpSession httpSession=request.getSession();
		//String id=(String)httpSession.getAttribute("id");
		//System.out.println(id);
		String name=(String)httpSession.getAttribute("student");
		//int roll=(Integer)httpSession.getAttribute("roll");
		System.out.println(name);
		//System.out.println(roll);
		String concerned=request.getParameter("concered");
		String reduced=request.getParameter("reduced");
		String quality=request.getParameter("quality");
		printWriter.print("<html><body>");
		printWriter.print("<table><tr>");
		t_count++;
		if(concerned.equals("ex"))
		{
			printWriter.println("<h5>1.Correct<br></tr></h5>");
			count++;
		}
		else
		{
			printWriter.println("<h5>1.The correct answer is Extremely Concerned</h5>");
		}
		
		if(reduced.equals("av"))
		{
			printWriter.println("<h5>2.Correct<br></h5>");
			count++;
		}
		else
		{
			printWriter.println("<h5>2.The correct answer is Avoided Vehicle</h5>");
		}
		
		if(quality.equals("gd"))
		{
			printWriter.println("<h5>3.Correct<br></h5>");
			count++;
		}
		else
		{
			printWriter.println("<h5>3.The correct answer is Good</h5>");
		}
		if(count==3)
		{
			printWriter.print("<tr><h1>Congratulation!!You completed survey with flying colors</h1></tr>");
		}
		else
		{
			printWriter.print("<h1>Your Score<h1>"+count+"</h1>");
		}
		
		System.out.println(t_count);
		QuestionDAO dao=new QuestionDAO();
		 try {
			result=dao.addCompletedSurveyinDb(name, t_count);
			System.out.println("result");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printWriter.print("</table></body></html>");
		//request.getRequestDispatcher("apply.jsp").include(request, response);
		//response.sendRedirect("answer.jsp");
		//doGet(request, response);
		/*Connection con=DBConnect.getConn();
		String sql="INSERT INTO E_SUBMITTED (ID,NAME,TOTALSURVEY) VALUES(NULL,?,?))";
		try {
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, result);
	int i=	preparedStatement.executeUpdate();
	System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
