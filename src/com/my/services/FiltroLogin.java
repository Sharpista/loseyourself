package com.my.services;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.entitys.Login;
import com.sun.xml.internal.ws.api.policy.PolicyResolver.ServerContext;

public class FiltroLogin implements  Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest)req).getSession();
		
		Login login = (Login)session.getAttribute("usuario");
		
		if(login == null) {
			
			session.setAttribute("usuario", login);
			
		 req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, res);
		
			
		}else {
			chain.doFilter(req, res);
		}
		
	}
	
	public void destroy(){
		
	}

	
	

}
