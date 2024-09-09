package com.dw.controll;


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
import com.dw.util.StringUtil;
/**
 * �û�ע��-ҵ���߼�����
 * @author DY1101shaoyuxian
 *
 */
public class RegisterServlet extends HttpServlet {

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
		String userid=req.getParameter("userid").trim();//��ȡuserid��ȥ���ո�
		String username=req.getParameter("username").trim();
		String password=req.getParameter("password").trim();//��ȡpassword��ȥ���ո�
		String imageValue=req.getParameter("imageValue");
	    String sRand=(String) session.getAttribute("sRand");
	    session.setAttribute("username", username);	
	 	if(StringUtil.isEmpty(userid)||StringUtil.isEmpty(password)){
			req.getRequestDispatcher("register.jsp").forward(req, resp);
			return;
		}
	 	if(StringUtil.isEmpty(imageValue)){
	 		req.setAttribute("error", "��������֤�룡");
	 		req.getRequestDispatcher("register.jsp").forward(req,resp);
			return;
		}else if(!imageValue.equals(sRand)){
			req.setAttribute("error", "��֤�����");
			req.getRequestDispatcher("register.jsp").forward(req,resp);
			return;
		}
	 	StudentDaoImpl usersdao=new StudentDaoImpl();
	 	List<Student> list = usersdao.findAllStudent();
	 	for(Student stu: list){
	 		if(userid.equals(stu.getStId())){
	 			req.setAttribute("error","��ѧ��id�Ѿ�ע���!");
	 			RequestDispatcher requestdispatcher=req.getRequestDispatcher("register.jsp");
				requestdispatcher.forward(req, resp);
	 		}
	 	}
		Student stu=new Student(userid, username, password);
		session.setAttribute("userid", userid);	
		if(usersdao.register(stu)){
			resp.sendRedirect("login.jsp");
		}
		else{
			req.setAttribute("error", "ע��ʧ��!");
			RequestDispatcher requestdispatcher=req.getRequestDispatcher("register.jsp");
			requestdispatcher.forward(req, resp);
		}
		
	}

}
