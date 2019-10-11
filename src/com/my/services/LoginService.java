package com.my.services;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.jsp.tagext.ValidationMessage;

import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.apache.tomcat.jdbc.pool.Validator;

import com.my.controller.LoginServlet;
import com.my.dao.LoginDAO;
import com.my.entitys.Login;




@Resource
public class LoginService {
	
	 private LoginDAO  dao = new LoginDAO();
	 
	 
	 public String verificarUsuario(Login login) {
		 if(dao.exitesUsuario(login)) {
			return "Login Já Existe";
		 }
		return null;
		 
		 
	 }
	 
	 
	 

}
