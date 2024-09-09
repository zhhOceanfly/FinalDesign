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
public class AddFriendServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String stId = (String)session.getAttribute("userid");
		String id = request.getParameter("id");
		StudentDao studao = new StudentDaoImpl();
		boolean flag = studao.addFriend(stId, id);
		if(flag!=true){
			request.setAttribute("error", "添加失败或者已经是好友");
		}else{
			request.setAttribute("error", "添加成功");
		}
		String mainPage = "deepSearch";
		request.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
	}
}