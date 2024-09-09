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

import com.dw.dao.impl.AdminDaoImpl;
import com.dw.dao.impl.StudentDaoImpl;
import com.dw.model.Admin;
import com.dw.model.Student;
import com.dw.util.StringUtil;
/**
 * �û���¼-ҵ���߼�����
 * @author DY1101shaoyuxian
 *
 */
public class AdminLoginServlet extends HttpServlet {

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
		req.setCharacterEncoding("utf-8");//�����������
		String adminid=req.getParameter("adminid").trim();//��ȡuserid��ȥ���ո�
		String adpassword=req.getParameter("adpassword").trim();//��ȡpassword��ȥ���ո�
		String imageValue=req.getParameter("imageValue");
		String remember=req.getParameter("remember");
		req.setAttribute("adminid", adminid);
		req.setAttribute("adpassword", adpassword);
		req.setAttribute("imageValue", imageValue);
	    String sRand=(String) session.getAttribute("sRand");
	 	if(StringUtil.isEmpty(adminid)||StringUtil.isEmpty(adpassword)){
			req.getRequestDispatcher("adminlogin.jsp").forward(req, resp);
			return;
		}
	 	if(StringUtil.isEmpty(imageValue)){
	 		req.setAttribute("error", "��������֤�룡");
	 		req.getRequestDispatcher("adminlogin.jsp").forward(req,resp);
			return;
		}else if(!imageValue.equals(sRand)){
			req.setAttribute("error", "��֤�����");
			req.getRequestDispatcher("adminlogin.jsp").forward(req,resp);
			return;
		}
		Admin admin = new Admin(adminid, adpassword);
		AdminDaoImpl admindao=new AdminDaoImpl();
		session.setAttribute("adminid", adminid);	
		if(admindao.isLogin(admin)){
			if("remember-me".equals(remember)){
				rememberMe(adminid,adpassword,resp);
			}
			resp.sendRedirect("adminmain.jsp");
		}
		else{
			req.setAttribute("error", "�û������������!");
			RequestDispatcher requestdispatcher=req.getRequestDispatcher("adminlogin.jsp");
			requestdispatcher.forward(req, resp);
		}
		
	}
	
	private void rememberMe(String adminid,String adpassword,HttpServletResponse response){
		Cookie admin;
		try {
			admin = new Cookie("admin",URLEncoder.encode(adminid,"UTF-8")+"-"+URLEncoder.encode(adpassword,"UTF-8"));
			admin.setMaxAge(1*60*60*24*7);
			response.addCookie(admin);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
