package com.dw.controll;

/**
 * ¿ØÖÆ²ã
 * @author DY1101shaoyuxian
 */

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.StudentDao;
import com.dw.dao.impl.StudentDaoImpl;
import com.dw.model.Student;

public class DeepSearchServlet extends HttpServlet {

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
		String stId = (String)session.getAttribute("userid");
		StudentDao studao = new StudentDaoImpl();
		int deepth = Integer.parseInt(request.getParameter("deepth"));
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String dept = request.getParameter("dept");
		String id = request.getParameter("id");
		Set<Student> set = new HashSet<Student>();
		if(id == null){
			set = studao.findStudentByDeepSearch(stId, deepth, name, age, dept);
		}else{
			set.add(studao.findStudentByStId(id));
		}
		request.setAttribute("list", set);
		String mainPage="deepSearch.jsp";
		request.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
	}

}