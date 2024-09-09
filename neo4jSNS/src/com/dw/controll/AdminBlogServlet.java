package com.dw.controll;

/**
 * ¿ØÖÆ²ã
 * @author DY1101shaoyuxian
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.impl.AdminDaoImpl;
import com.dw.dao.impl.StudentDaoImpl;
import com.dw.model.Blog;
import com.dw.model.Student;

public class AdminBlogServlet extends HttpServlet {

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
        String id=request.getParameter("searchBId");
        AdminDaoImpl admindao = new AdminDaoImpl();
        Map<Student, Blog> map = new HashMap<Student, Blog>();
        if(id == null){
       	map = admindao.findAllBlog();
        }else{
       	map = admindao.findAllBlogByStId(id);
        }
		String mainPage="adminBlog";
		request.setAttribute("map", map);
		request.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminmain.jsp");
		dispatcher.forward(request, response);
	}

}
