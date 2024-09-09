package com.dw.controll;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.impl.StudentDaoImpl;
import com.dw.model.Student;
import com.dw.util.StringUtil;
/**
 * 用户登录-业务逻辑处理
 * @author DY1101shaoyuxian
 *
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		req.setCharacterEncoding("utf-8");//解决乱码问题
		String userid=req.getParameter("userid").trim();//获取userid并去掉空格
		String password=req.getParameter("password").trim();//获取password并去掉空格
		String imageValue=req.getParameter("imageValue");
		String remember=req.getParameter("remember");
		req.setAttribute("userid", userid);
		req.setAttribute("password", password);
		req.setAttribute("imageValue", imageValue);
	    String sRand=(String) session.getAttribute("sRand");
	 	if(StringUtil.isEmpty(userid)||StringUtil.isEmpty(password)){
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
	 	if(StringUtil.isEmpty(imageValue)){
	 		req.setAttribute("error", "请输入验证码！");
	 		req.getRequestDispatcher("login.jsp").forward(req,resp);
			return;
		}else if(!imageValue.equals(sRand)){
			req.setAttribute("error", "验证码错误！");
			req.getRequestDispatcher("login.jsp").forward(req,resp);
			return;
		}
		Student stu=new Student(userid, password);
		StudentDaoImpl usersdao=new StudentDaoImpl();
		session.setAttribute("userid", userid);	
		if(usersdao.isLogin(stu)){
			if("remember-me".equals(remember)){
				rememberMe(userid,password,resp);
			}
			resp.sendRedirect("main.jsp");
		}
		else{
			req.setAttribute("error", "用户名或密码错误!");
			RequestDispatcher requestdispatcher=req.getRequestDispatcher("login.jsp");
			requestdispatcher.forward(req, resp);
		}
		
	}

	
	private void rememberMe(String userid,String password,HttpServletResponse response){
		Cookie user;
		try {
			user = new Cookie("user",URLEncoder.encode(userid,"UTF-8")+"-"+URLEncoder.encode(password,"UTF-8"));
			user.setMaxAge(1*60*60*24*7);
			response.addCookie(user);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
