package com.my.tests;

import com.my.dao.ClientDAO;
import com.my.dao.LoginDAO;
import com.my.dao.SeguroDAO;
import com.my.entitys.Login;
import com.my.services.Criptografar;

public class Teste {
	
	
	public static void main(String[] args) {
		
		
		LoginDAO ld = new  LoginDAO();
		Login login = new Login();
		
		
		try {
			login.setUsuario("abc");
			login.setSenha("12");
			login.setSenha(Criptografar.encriptografar(login.getSenha()));
			LoginDAO.save(login);
			System.out.println("Gravou" + login);
			
		} catch (Exception e) {
			System.err.println();
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
		
		

}
