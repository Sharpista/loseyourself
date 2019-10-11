package com.my.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.dao.ClientDAO;
import com.my.dao.SeguroDAO;
import com.my.entitys.Client;
import com.my.entitys.Seguro;

public class ClientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SeguroDAO sdao = new SeguroDAO();
		ClientDAO dao = new ClientDAO();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");

		try {

			Client client = new Client();
			client.setNome(req.getParameter("nome"));
			client.setCpf(req.getParameter("cpf"));
			client.setRg(req.getParameter("rg"));
			client.setSexo(req.getParameter("sexo"));
			client.setVisitas(req.getParameterValues("visitas"));
			client.setAniversario(formato.parse(req.getParameter("aniversario")));
			client.setDataDeCadastro(new java.util.Date());
			List<Seguro> seguros = new ArrayList<Seguro>();
			for (String idSeguro : req.getParameterValues("seguro")) {
				Seguro seguro = new Seguro();
				seguro.setId_seguro(Integer.valueOf(idSeguro));
				seguros.add(seguro);
			}
			client.setSeguros(seguros);
			if (req.getParameter("id") == null) {
				dao.save(client);
				getServletContext().getRequestDispatcher("/seguros/afterlogin.jsp").forward(req, resp);
			} else {

				String id = req.getParameter("id");
				client.setId(Integer.parseInt(id));
				dao.alterar(client);
				List<Client> listaClient = dao.findAll();
				req.setAttribute("client", listaClient);
				List<Seguro>lista = sdao.findAll();
				req.setAttribute("seguro", lista);
				getServletContext().getRequestDispatcher("/seguros/listar-segurados.jsp").forward(req, resp);
			}

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		processRequest(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Client client = new Client();
		SeguroDAO sdao = new SeguroDAO();
		ClientDAO dao = new ClientDAO();
		String acao = req.getParameter("acao");

		if (acao.equals("abrircadastro")) {
			sdao = new SeguroDAO();
			List<Seguro> lista = sdao.findAll();
			req.setAttribute("seguro", lista);
			getServletContext().getRequestDispatcher("/seguros/cadastrar-segurado.jsp").forward(req, resp);
		}
		if (acao.equals("update")) {
			dao = new ClientDAO();
			String id = req.getParameter("id");
			client = dao.findById(Integer.parseInt(id));
			req.setAttribute("client", client);
			sdao = new SeguroDAO();
			List<Seguro> list = sdao.findAll();
			req.setAttribute("seguro", list);
			getServletContext().getRequestDispatcher("/seguros/update.jsp").forward(req, resp);
		}
		if (acao.equals("listarsegurados")) {
			dao = new ClientDAO();
			List<Client> listaClientes = dao.findAll();
			req.setAttribute("client", listaClientes);
			List<Seguro> lista = sdao.findAll();
			req.setAttribute("seguro", lista);
			getServletContext().getRequestDispatcher("/seguros/listar-segurados.jsp").forward(req, resp);

		}
		if(acao.equals("excluir")) {

			dao = new ClientDAO();
			String id = req.getParameter("id");
			dao.remove(Integer.parseInt(id));
			List<Client> ls = dao.findAll();
			req.setAttribute("client", ls);
			getServletContext().getRequestDispatcher("/seguros/listar-segurados.jsp").forward(req, resp);

		}

	}

}
