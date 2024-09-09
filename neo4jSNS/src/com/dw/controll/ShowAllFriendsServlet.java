package com.dw.controll;

/**
 * ¿ØÖÆ²ã
 * @author DY1101shaoyuxian
 */

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.impl.StudentDaoImpl;
import com.dw.model.Student;

public class ShowAllFriendsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String id = session.getAttribute("userid").toString();
		StudentDaoImpl studao = new StudentDaoImpl();
		int pageIndex = Integer.parseInt(request.getParameter("page"));
		int pageSize = 5;
		Set<Student> set = studao.findAllFriends(id);
		String mainPage="showAllFriends.jsp";
		request.setAttribute("page",pageIndex);
		request.setAttribute("list", set);
		request.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
	}

}
