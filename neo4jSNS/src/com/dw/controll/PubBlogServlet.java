package com.dw.controll;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.impl.BlogDaoImpl;
import com.dw.model.Blog;
import com.dw.model.Student;

public class PubBlogServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		this.doPost(req, res);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		String comment = req.getParameter("blogtext");
		String stId = session.getAttribute("userid").toString();
		BlogDaoImpl bdao = new BlogDaoImpl();
		if(bdao.addBlog(comment, stId)){
			req.setAttribute("error", "·¢±íÊ§°Ü£¬Çë¼ì²éÍøÂç...");
			RequestDispatcher requestdispatcher=req.getRequestDispatcher("pubBlog.jsp");
			requestdispatcher.forward(req, res);
		}
		String mainPage="showSpace.jsp"; 
		req.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
		dispatcher.forward(req, res);
	}
}
