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

public class ShowFriendServlet extends HttpServlet {

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
		String stId = req.getParameter("id");
		StudentDaoImpl studao = new StudentDaoImpl();
		Student stu = studao.findStudentByStId(stId);
		Set<Student> set = studao.findAllFriends(stId);
		String mainPage = "showFriend.jsp";
		req.setAttribute("stu", stu);
		req.setAttribute("set", set);
		req.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
		dispatcher.forward(req, res);
	}

}
