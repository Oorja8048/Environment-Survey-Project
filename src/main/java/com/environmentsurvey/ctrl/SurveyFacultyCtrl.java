package com.environmentsurvey.ctrl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.environmentsurvey.bean.SurveyFacultyBean;
import com.environmentsurvey.bean.SurveyStudentBean;
import com.environmentsurvey.model.SurveyFacultyDAO;
import com.environmentsurvey.model.SurveyStudentDAO;
import com.environmentsurvey.utility.DataValidator;

/**
 * Servlet implementation class SurveyFacultyCtrl
 */
@WebServlet("/SurveyFacultyCtrl")
public class SurveyFacultyCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SurveyFacultyCtrl() {
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
		System.out.println("inside dopost");
		if (request.getParameter("Action").equals("Add Survey")) {
			SurveyFacultyBean bean = new SurveyFacultyBean();
			bean.setName(request.getParameter("sname"));
			bean.setDescription(request.getParameter("description"));
			bean.setVolunteers(request.getParameter("volunteer"));
			bean.setDateofsurvey(request.getParameter("dos"));
			bean.setVenue(request.getParameter("venue"));

			
			if(!DataValidator.isInteger(request.getParameter("volunteer")))
			{
				request.setAttribute("ermsg", "Please enter numbers");
				request.getRequestDispatcher("addSurveyforfaculty.jsp").forward(request, response);
			}
			else if(!DataValidator.isName(request.getParameter("sname")))
			{
				request.setAttribute("isname", "Please enter Characters");
				request.getRequestDispatcher("addSurveyforfaculty.jsp").forward(request, response);
			}
			else if(!DataValidator.isName(request.getParameter("description")))
			{
				request.setAttribute("isdesc", "Please enter Characters");
				request.getRequestDispatcher("addSurveyforfaculty.jsp").forward(request, response);
			}
			else if(!DataValidator.isName(request.getParameter("venue")))
			{
				request.setAttribute("isvenue", "Please enter Characters");
				request.getRequestDispatcher("addSurveyforfaculty.jsp").forward(request, response);
			}
			else
			{
				
			
			SurveyFacultyDAO dao = new SurveyFacultyDAO();
			try {
				boolean result = dao.addSurvey(bean);
				String msg = "Survey added for Faculty";

				request.setAttribute("msg", msg);
				request.getRequestDispatcher("addsurvey.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		if (request.getParameter("Action").equals("Edit Survey")) {
			SurveyFacultyBean bean = new SurveyFacultyBean();
			System.out.println("bean called:");
			bean.setId(Integer.parseInt(request.getParameter("id")));
			bean.setName(request.getParameter("sname"));
			bean.setDescription(request.getParameter("description"));
			bean.setVolunteers(request.getParameter("volunteer"));
			bean.setDateofsurvey(request.getParameter("dos"));
			bean.setVenue(request.getParameter("venue"));
			SurveyFacultyDAO dao = new SurveyFacultyDAO();
			try {
				int result = dao.update(bean);
				System.out.println(result);
				String msg = "Edited";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("editfacultysurvey.jsp").include(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//doGet(request, response);
	}

}
