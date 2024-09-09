package com.dw.controll;

import java.io.IOException;
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

/**
 * 控制层-根据ID查询学生信息
 * @author DY1101shaoyuxian
 * 
 */
public class SearchByBIdServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
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
