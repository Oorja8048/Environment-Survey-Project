package com.environmentsurvey.ctrl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.environmentsurvey.bean.CompetitionBean;
import com.environmentsurvey.bean.SurveyStudentBean;
import com.environmentsurvey.model.CompetitionDao;
import com.environmentsurvey.model.SurveyFacultyDAO;
import com.environmentsurvey.utility.DataValidator;

/**
 * Servlet implementation class CompetitionCtrl
 */
@WebServlet("/CompetitionCtrl")
public class CompetitionCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompetitionCtrl() {
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
		if (request.getParameter("Action").equals("Add Competiton")) {
			CompetitionBean bean = new CompetitionBean();
			bean.setName(request.getParameter("sname"));
			bean.setDescription(request.getParameter("description"));
			bean.setVolunteers((request.getParameter("volunteer")));
			bean.setDateofcomp(request.getParameter("dos"));
			bean.setVenue(request.getParameter("venue"));
			if(!DataValidator.isName(request.getParameter("sname")))
			{
				System.out.println("inside validator name");
				request.setAttribute("isname","Please enter Characters" );
				request.getRequestDispatcher("addcompetition.jsp").forward(request, response);
			}
			else if(!DataValidator.isInteger(request.getParameter("volunteer")))
			{
				System.out.println("inside validator integer");
				request.setAttribute("ermsg","Please enter valid Number" );
				request.getRequestDispatcher("addcompetition.jsp").forward(request, response);
			}
			else
			{
				
			
			CompetitionDao dao = new CompetitionDao();
			try {
				boolean result = dao.addComp(bean);
				String msg = "Competition Added Succeesfully";

				request.setAttribute("msg", msg);
				request.getRequestDispatcher("addcompetition.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		if (request.getParameter("Action").equals("Add")) {
			CompetitionBean bean = new CompetitionBean();
			bean.setName(request.getParameter("sname"));
			bean.setDescription(request.getParameter("description"));
			bean.setVolunteers((request.getParameter("volunteer")));
			bean.setDateofcomp(request.getParameter("dos"));
			bean.setVenue(request.getParameter("venue"));

			
			if(!DataValidator.isName(request.getParameter("sname")))
			{
				System.out.println("inside validator name");
				request.setAttribute("isname","Please enter Characters" );
				request.getRequestDispatcher("addcompetitionbyfaculty.jsp").forward(request, response);
			}
			else if(!DataValidator.isInteger(request.getParameter("volunteer")))
			{
				System.out.println("inside validator name");
				request.setAttribute("isvolunteer","Please enter valid Number" );
				request.getRequestDispatcher("addcompetitionbyfaculty.jsp").forward(request, response);
			}
			else
			{
				
			
			CompetitionDao dao = new CompetitionDao();
			try {
				boolean result = dao.addCompByfaculty(bean);
				String msg = "Competition Added Successfully";

				request.setAttribute("msg", msg);
				request.getRequestDispatcher("addcompetitionbyfaculty.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		
		//doGet(request, response);
	}

}
