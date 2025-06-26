package com.environmentsurvey.ctrl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.environmentsurvey.bean.SupportBean;
import com.environmentsurvey.model.SupportDAO;

/**
 * Servlet implementation class SupportCtrl
 */
@WebServlet("/SupportCtrl")
public class SupportCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupportCtrl() {
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
		SupportBean bean=new SupportBean();
		bean.setFirst_name(request.getParameter("firstname"));
		bean.setLast_name(request.getParameter("lastname"));
		bean.setRole(request.getParameter("role"));
		bean.setSubject(request.getParameter("subject"));
		SupportDAO dao=new SupportDAO();
		try {
			boolean i=dao.addIssue(bean);
			if(i==true)
			{
				request.setAttribute("msg", "Message send..");
				request.getRequestDispatcher("support.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
