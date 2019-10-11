package com.my.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.ClientDAO;
import com.my.dao.SeguroDAO;
import com.my.entitys.Client;
import com.my.entitys.Seguro;

public class SeguroServlet extends HttpServlet {

	private void ProcessRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SeguroDAO sdao = new SeguroDAO();

		try {
			Seguro seguro = new Seguro();
			seguro.setIdentificacao(req.getParameter("identificacao"));
			seguro.setValor(Double.parseDouble(req.getParameter("valor")));

			if (req.getParameter("id") == null) {
				sdao.save(seguro);
				getServletContext().getRequestDispatcher("/seguros/afterlogin.jsp").forward(req, resp);

			} else {
				String id = req.getParameter("id");
				seguro.setId_seguro(Integer.parseInt(id));
				SeguroDAO.save(seguro);
				List<Seguro> listaSeguro = sdao.findAll();
				req.setAttribute("seguro", listaSeguro);
				getServletContext().getRequestDispatcher("/seguros/listar-seguros.jsp").forward(req, resp);
			}

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProcessRequest(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Seguro seguro = new Seguro();
		SeguroDAO sdao = new SeguroDAO();
		String acao = req.getParameter("acao");
		
		if(acao.equals("cadastrarseguro")) {
			getServletContext().getRequestDispatcher("/seguros/cadastrar-seguro.jsp").forward(req, resp);
		}
		if(acao.equals("updateseguro")) {
			sdao = new SeguroDAO();
			String id = req.getParameter("id");
			seguro = sdao.findById(Integer.parseInt(id));
			req.setAttribute("seguro", seguro);
			getServletContext().getRequestDispatcher("/seguros/update-seguro.jsp").forward(req, resp);
		}
		if (acao.equals("listarseguros")) {
			List<Seguro> lista = sdao.findAll();
			req.setAttribute("seguro", lista);
			getServletContext().getRequestDispatcher("/seguros/listar-seguros.jsp").forward(req, resp);
		}
		if(acao.equals("excluirseguro")) {
			sdao = new SeguroDAO();
			String id = req.getParameter("id");
			seguro = sdao.remove(Integer.parseInt(id));
			List<Seguro> segurolist = sdao.findAll();
			req.setAttribute("seguro", segurolist);
			getServletContext().getRequestDispatcher("/seguros/listar-seguros.jsp").forward(req, resp);
		}
	}
}	
