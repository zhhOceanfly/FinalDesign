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

public class ComBlogServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		String comment = req.getParameter("comtext");
		String stId = (String)session.getAttribute("userid");
		String blog_id = req.getParameter("id");
		BlogDaoImpl bdao = new BlogDaoImpl();
		if(!bdao.commentBlog(blog_id, comment, stId)){
			req.setAttribute("error", "ÆÀÂÛÊ§°Ü£¬Çë¼ì²éÍøÂç...");
			RequestDispatcher requestdispatcher=req.getRequestDispatcher("pubBlog.jsp");
			requestdispatcher.forward(req, res);
		}
		String mainPage="showBlog?id="+blog_id; 
		req.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
		dispatcher.forward(req, res);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		String comment = req.getParameter("comtext");
		String name = (String)session.getAttribute("username");
		BlogDaoImpl bdao = new BlogDaoImpl();
		if(bdao.addBlog(comment, name)){
			req.setAttribute("error", "ÆÀÂÛÊ§°Ü£¬Çë¼ì²éÍøÂç...");
			RequestDispatcher requestdispatcher=req.getRequestDispatcher("pubBlog.jsp");
			requestdispatcher.forward(req, res);
		}
		String mainPage="showBlog.jsp"; 
		req.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
		dispatcher.forward(req, res);
	}
}
