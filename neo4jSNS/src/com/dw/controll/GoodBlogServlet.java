package com.dw.controll;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.impl.BlogDaoImpl;
import com.dw.dao.impl.StudentDaoImpl;
import com.dw.model.Blog;
import com.dw.model.Comment;
import com.dw.model.Student;

public class GoodBlogServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String blog_id = req.getParameter("id");
		int count = Integer.parseInt(req.getParameter("count"));
		BlogDaoImpl blogdao = new BlogDaoImpl();
		blogdao.goodBlog(blog_id);
		String mainPage="showSpace?"+count;
		req.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
		dispatcher.forward(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
	}
}
