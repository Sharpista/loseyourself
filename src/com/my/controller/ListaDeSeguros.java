package com.my.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.SeguroDAO;
import com.my.entitys.Seguro;

public class ListaDeSeguros extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SeguroDAO  sdao = new SeguroDAO();
		
		List<Seguro> listaSeguros = sdao.findAll();
		req.setAttribute("seguro", listaSeguros);
		getServletContext().getRequestDispatcher("/seguros/listar-seguros.jsp").forward(req, resp);
		
		
	}

}
