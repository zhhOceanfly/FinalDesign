package com.dw.controll;

/**
 * ¿ØÖÆ²ã
 * @author DY1101shaoyuxian
 */

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.impl.BlogDaoImpl;
import com.dw.dao.impl.StudentDaoImpl;
import com.dw.model.Student;
import com.dw.model.Blog;

public class ShowSpaceServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		int count = Integer.parseInt(req.getParameter("count"));
		String stId = session.getAttribute("userid").toString();
		BlogDaoImpl bdao = new BlogDaoImpl();
		Map<Student, Blog> map = bdao.findAllFriendAndMeBlog(count, stId);
		String mainPage="showSpace.jsp"; 
		req.setAttribute("map", map);
		req.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
		dispatcher.forward(req, res);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		int count = Integer.parseInt(req.getParameter("count"));
		BlogDaoImpl bdao = new BlogDaoImpl();
		String mainPage="showSpace.jsp"; 
		req.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
		dispatcher.forward(req, res);
	}

}
