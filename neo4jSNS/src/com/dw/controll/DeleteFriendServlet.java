package com.dw.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.StudentDao;
import com.dw.dao.impl.StudentDaoImpl;
/**
 * ¿ØÖÆ²ã
 * @author DY1101shaoyuxian
 *
 */
public class DeleteFriendServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String id = session.getAttribute("userid").toString();
		StudentDao studao = new StudentDaoImpl();
		String stId=request.getParameter("id");
		boolean flag=studao.delFriendByStId(id, stId);
		if(flag){
			String mainPage="showAllFriends";
			request.setAttribute("mainPage", mainPage);
			RequestDispatcher dispatch=request.getRequestDispatcher("main.jsp");
			dispatch.forward(request, response);
		}else{
			 System.out.println("É¾³ýÊ§”¡!!");
		}
	}

}
