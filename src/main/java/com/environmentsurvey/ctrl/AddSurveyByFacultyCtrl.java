package com.environmentsurvey.ctrl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.environmentsurvey.bean.SurveyStudentBean;
import com.environmentsurvey.model.SurveyByFacultyDAO;
import com.environmentsurvey.model.SurveyStudentDAO;
import com.environmentsurvey.utility.DataValidator;

/**
 * Servlet implementation class AddSurveyByFacultyCtrl
 */
@WebServlet("/AddSurveyByFacultyCtrl")
public class AddSurveyByFacultyCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSurveyByFacultyCtrl() {
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
				request.getRequestDispatcher("addsurveybyfaculty.jsp").forward(request, response);
			}else if(!DataValidator.isName(request.getParameter("sname")))
			{
				request.setAttribute("isname", "Please enter Characters");
				request.getRequestDispatcher("addsurveybyfaculty.jsp").forward(request, response);
			}
			
			else
			{
				
			
			SurveyByFacultyDAO dao = new SurveyByFacultyDAO();
			try {
				boolean result = dao.addSurvey(bean);
				String msg = "Survey added for students";

				request.setAttribute("msg", msg);
				request.getRequestDispatcher("addsurveybyfaculty.jsp").forward(request, response);

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
			SurveyByFacultyDAO dao = new SurveyByFacultyDAO();
			try {
				int result = dao.update(bean);
				System.out.println(result);
				String msg = "Edited";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("editsurvey.jsp").include(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		/*if (request.getParameter("Action").equals("Delete Survey")) {
			SurveyStudentBean bean = new SurveyStudentBean();
			//bean.setId(Integer.parseInt(request.getParameter("id")));
			int id=Integer.parseInt(request.getParameter("id"));
			SurveyByFacultyDAO dao = new SurveyByFacultyDAO();
			try {
				int i = dao.delete(id);
				System.out.println(i);
				String msg = "Deleted";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("viewsurveyforfaculty.jsp").include(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		//doGet(request, response);
	}

}
