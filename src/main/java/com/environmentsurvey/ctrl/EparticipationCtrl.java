package com.environmentsurvey.ctrl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.environmentsurvey.bean.EparticipationBean;
import com.environmentsurvey.model.EParticipationDAO;
import com.environmentsurvey.utility.DataValidator;

/**
 * Servlet implementation class EparticipationCtrl
 */
public class EparticipationCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EparticipationCtrl() {
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
		//doGet(request, response);
		EparticipationBean bean=new EparticipationBean();
		bean.setName(request.getParameter("sname"));
		bean.setVenue(request.getParameter("venue"));
		bean.setVoulteers((request.getParameter("volunteers")));
		bean.setDofseminar(request.getParameter("dos"));
		
		
		 
			if(!DataValidator.isInteger(request.getParameter("volunteers")))
			{
				request.setAttribute("ermsg", "Please enter number");
				request.getRequestDispatcher("eparticipation.jsp").forward(request, response);
			}
			else
			{
				
			
		
		EParticipationDAO dao=new EParticipationDAO();
		try {
			int result=dao.addSeminar(bean);
			System.out.println("result of seminar"+result);
			String msg="Participation Added";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("eparticipation.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
