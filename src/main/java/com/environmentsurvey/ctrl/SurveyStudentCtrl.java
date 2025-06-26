	package com.environmentsurvey.ctrl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.environmentsurvey.bean.SurveyStudentBean;
import com.environmentsurvey.model.SurveyStudentDAO;
import com.environmentsurvey.utility.DataValidator;

/**
 * Servlet implementation class SurveyStudentCtrl
 */
@WebServlet("/SurveyStudentCtrl")
public class SurveyStudentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SurveyStudentCtrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	
			throws ServletException, IOException {
		System.out.println("inside get");
		/*if (request.getParameter("Action").equals("Delete")) {
			System.out.println("step 1 in");
			SurveyStudentBean bean = new SurveyStudentBean();
			bean.setId(Integer.parseInt(request.getParameter("id")));
			System.out.println("step 2in");
			SurveyStudentDAO dao = new SurveyStudentDAO();
			System.out.println("step 3 in");
			try {
				System.out.println("step 4 in");
				int i = SurveyStudentDAO.delete(bean);
				System.out.println(i);
				if(i!=0)
				{
				request.getRequestDispatcher("viewsurvey.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		// */ response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside dopost");
		if (request.getParameter("Action").equals("Add Survey")) {
			SurveyStudentBean bean = new SurveyStudentBean();
			bean.setName(request.getParameter("sname"));
			bean.setDescription(request.getParameter("description"));
			bean.setVolunteers(request.getParameter("volunteer"));
			bean.setDateofsurvey(request.getParameter("dos"));
			bean.setVenue(request.getParameter("venue"));
			
			if(!DataValidator.isInteger(request.getParameter("volunteer")))
			{
				request.setAttribute("ermsg", "Please enter numbers");
				request.getRequestDispatcher("addsurvey.jsp").forward(request, response);
			}
			else if(!DataValidator.isName(request.getParameter("sname")))
			{
				request.setAttribute("isname", "Please enter Characters");
				request.getRequestDispatcher("addsurvey.jsp").forward(request, response);
			}
			else if(!DataValidator.isName(request.getParameter("description")))
			{
				request.setAttribute("isdesc", "Please enter Characters");
				request.getRequestDispatcher("addsurvey.jsp").forward(request, response);
			}
			else if(!DataValidator.isName(request.getParameter("venue")))
			{
				request.setAttribute("isvenue", "Please enter Characters");
				request.getRequestDispatcher("addsurvey.jsp").forward(request, response);
			}
			else
			{
				
			
			SurveyStudentDAO dao = new SurveyStudentDAO();
			try {
				boolean result = dao.addSurvey(bean);
				String msg = "Survey added for students";

				request.setAttribute("msg", msg);
				request.getRequestDispatcher("addsurvey.jsp").forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}}
		if (request.getParameter("Action").equals("Edit Survey")) {
			SurveyStudentBean bean = new SurveyStudentBean();
			System.out.println("bean called:");
			bean.setId(Integer.parseInt(request.getParameter("id")));
			bean.setName(request.getParameter("sname"));
			bean.setDescription(request.getParameter("description"));
			bean.setVolunteers(request.getParameter("volunteer"));
			bean.setDateofsurvey(request.getParameter("dos"));
			bean.setVenue(request.getParameter("venue"));
			SurveyStudentDAO dao = new SurveyStudentDAO();
			try {
				int result = dao.update(bean);
				System.out.println(result);
				String msg = "Edited";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("editstudentsurvey.jsp").include(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (request.getParameter("Action").equals("Delete Survey")) {
			SurveyStudentBean bean = new SurveyStudentBean();
			//bean.setId(Integer.parseInt(request.getParameter("id")));
			int id=Integer.parseInt(request.getParameter("id"));
			SurveyStudentDAO dao = new SurveyStudentDAO();
			try {
				int i = dao.delete(id);
				System.out.println(i);
				String msg = "Deleted";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("viewsurvey.jsp").include(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// doGet(request, response);
	}

}
