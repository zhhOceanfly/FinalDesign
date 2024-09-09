package com.dw.controll;

/**
 * ¿ØÖÆ²ã
 * @author DY1101shaoyuxian
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.impl.AdminDaoImpl;
import com.dw.dao.impl.StudentDaoImpl;
import com.dw.model.Student;

public class AdminStudentServlet extends HttpServlet {

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
		String id = session.getAttribute("adminid").toString();
		AdminDaoImpl admindao = new AdminDaoImpl();
		List<Student> list = new ArrayList<Student>();
		if(id==null){
			list = admindao.findAllStudent();
		}else{
			list.add(admindao.findStudentBySId(id));
		}
		String mainPage="adminStudent.jsp";
		request.setAttribute("mainPage", mainPage);
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminmain.jsp");
		dispatcher.forward(request, response);
	}

}
