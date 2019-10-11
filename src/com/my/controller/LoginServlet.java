package com.my.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.LoginDAO;
import com.my.entitys.Login;
import com.my.services.Criptografar;
import com.my.services.LoginService;
import com.my.services.RecaptchaService;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		try {
			LoginService ls = new LoginService();
			Login login = new Login();
			LoginDAO ld = new LoginDAO();

			
			if (ld.exitesUsuario(login)) {
				req.getSession().setAttribute("usuario", login);
				getServletContext().getRequestDispatcher("/seguros/afterlogin.jsp").forward(req, resp);
			} else {
				redirectLogin(req, resp);
			}

		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	private void redirectLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		processRequest(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		processRequest(req, resp);
	}

}
