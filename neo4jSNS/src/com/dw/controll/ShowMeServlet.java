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

import com.dw.dao.impl.BlogDaoImpl;
import com.dw.dao.impl.StudentDaoImpl;
import com.dw.model.Blog;
import com.dw.model.Student;

public class ShowMeServlet extends HttpServlet {

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
		String stId = session.getAttribute("userid").toString();
		StudentDaoImpl studao = new StudentDaoImpl();
		BlogDaoImpl blogdao = new BlogDaoImpl();
		Student stu = studao.findStudentByStId(stId);
		Set<Student> stset = studao.findAllFriends(stId);
		List<Blog> bset = blogdao.findAllBlogByBId(stId);
		String mainPage="showMe.jsp";
		req.setAttribute("user", stu);
		req.setAttribute("stset", stset);
		req.setAttribute("bset", bset);
		req.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
		dispatcher.forward(req, res);
	}

}
