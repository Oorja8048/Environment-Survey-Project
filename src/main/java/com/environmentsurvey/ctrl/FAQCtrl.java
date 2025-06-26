package com.environmentsurvey.ctrl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.environmentsurvey.bean.FAQBean;
import com.environmentsurvey.model.FAQDAO;

/**
 * Servlet implementation class FAQCtrl
 */
@WebServlet("/FAQCtrl")
public class FAQCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQCtrl() {
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
		if(request.getParameter("Action").equals("Add FAQ"))
		{
			System.out.println("in faq");
			FAQBean bean=new FAQBean();
			bean.setQuestion(request.getParameter("question"));
			bean.setAnswer(request.getParameter("answer"));
			FAQDAO faqdao=new FAQDAO();
			try {
				int result=faqdao.addFaq(bean);
				String msg="FAQ added";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("addFaqs.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("Action").equals("Edit FAQ"))
		{
			System.out.println("in EDIT faq");
			FAQBean bean=new FAQBean();
			bean.setId(Integer.parseInt(request.getParameter("id")));
			bean.setQuestion(request.getParameter("question"));
			bean.setAnswer(request.getParameter("answer"));
			FAQDAO faqdao=new FAQDAO();
			String msg="FAQ Edited";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("editfaq.jsp").forward(request, response);
			try {
				int result=faqdao.editFaq(bean);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	

}
