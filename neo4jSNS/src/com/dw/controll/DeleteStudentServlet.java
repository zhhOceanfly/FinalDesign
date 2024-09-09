package com.dw.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.AdminDao;
import com.dw.dao.StudentDao;
import com.dw.dao.impl.AdminDaoImpl;
import com.dw.dao.impl.StudentDaoImpl;
/**
 * ¿ØÖÆ²ã
 * @author DY1101shaoyuxian
 *
 */
public class DeleteStudentServlet extends HttpServlet {

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
		AdminDao admindao = new AdminDaoImpl();
		String id=request.getParameter("sid");
		boolean flag=admindao.delStudent(id);
		if(flag){
			String mainPage="adminStudent";
			request.setAttribute("mainPage", mainPage);
			RequestDispatcher dispatch=request.getRequestDispatcher("adminmain.jsp");
			dispatch.forward(request, response);
		}else{
			 System.out.println("É¾³ýÊ§”¡!!");
		}
	}

}
