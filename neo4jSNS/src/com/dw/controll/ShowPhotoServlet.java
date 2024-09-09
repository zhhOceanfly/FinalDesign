package com.dw.controll;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.impl.StudentDaoImpl;
import com.dw.model.Student;

public class ShowPhotoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		this.doPost(req, res);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		String stId = session.getAttribute("userid").toString();
		StudentDaoImpl studao = new StudentDaoImpl();
		Student stu = studao.findStudentByStId(stId);
		/*
		 * Í¼Æ¬Âß¼­£¬È¡³ölist<img_url>£¬ÉèÖÃreq.setAttribute("url_list",list);
		 */
		String mainPage="showPhoto.jsp";
		req.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
		dispatcher.forward(req, res);
	}

}
