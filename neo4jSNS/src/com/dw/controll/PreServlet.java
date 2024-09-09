package com.dw.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.StudentDao;
import com.dw.dao.impl.StudentDaoImpl;
import com.dw.model.Student;


/**
 * 逻辑处理及页面跳转
 * @author DY1101shaoyuxian
 * 
 */
public class PreServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = (String) request.getParameter("method");
		if ("updatePassword".equals(method)) {
			updatepwd(request, response);
		} else if ("updateMessage".equals(method)) {
			updatemsg(request, response);
		}else if(method==null){
			HttpSession session=request.getSession();
			String stId = (String)session.getAttribute("userid");
			StudentDao studao = new StudentDaoImpl();
			Student stu = studao.findStudentByStId(stId);
			request.setAttribute("student", stu);
			String mainPage = "update.jsp";
			request.setAttribute("mainPage", mainPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
		}
	}
	/**
	 * 更新学生的信息前-先查询出用户的信息，并实现页面跳转
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updatemsg(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String stId = (String)session.getAttribute("userid");
		String stSex = request.getParameter("sex");
		String stAge = request.getParameter("age");
		String stTel = request.getParameter("tel");
		String stDept = request.getParameter("dept");
		String stAddress = request.getParameter("addr");
		String stIdCard = request.getParameter("idcard");
		Student stu = new Student(stId, stSex, stAge, stTel, stDept, stAddress, stIdCard);
		StudentDao studao = new StudentDaoImpl();
		boolean flag = studao.updateMessage(stu);
		if(flag==true){
			String mainPage = "showMe.jsp";
			request.setAttribute("mainPage", mainPage);
		}else{
			String mainPage = "update.jsp";
			request.setAttribute("mainPage", mainPage);
			request.setAttribute("error", "更新用户信息失败");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * 更改密码
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updatepwd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		 String stId = (String)session.getAttribute("userid");
		 String repassword = request.getParameter("repassword");
		 Student stu = new Student(stId,repassword);
		 StudentDaoImpl userdao = new StudentDaoImpl();
		 boolean a = userdao.updatePassWord(stu);
		 if(a==true){
			 String mainPage = "updatepwdSuccess.jsp";
			 request.setAttribute("mainPage", mainPage);
		 }else{
			 String mainPage = "update.jsp";
			 request.setAttribute("mainPage", mainPage);
			 request.setAttribute("error1", "更新密码失败");
		 }
		 RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		 dispatcher.forward(request, response);
	}
	
	
}
