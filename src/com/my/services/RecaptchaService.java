package com.my.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;


public class RecaptchaService {
	
	public boolean checkRecaptcha(HttpServletRequest request){
		String recap = request.getParameter("g-recaptcha-response");
		try {
			String urlGoogle = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=%s";
			String secretKey = "6LcvYrkUAAAAAC7KZzmQGWvEcV_l0Jed10Ufin0O";
			String urlFormatada = String.format(urlGoogle, secretKey,recap,
					(request.getRemoteAddr() != null ? request.getRemoteAddr() :"0.0.0.0"));
			URL url = new URL(urlFormatada);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			String line, outputString = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while((line = reader.readLine()) != null) {outputString += line;}
			CaptchaResponse capRes = new Gson().fromJson(outputString,CaptchaResponse.class);
			if(capRes.isSucess()) {return true;}else {return false ;} 
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	private class CaptchaResponse{
		private boolean sucess;
		private String [] errorCodes;
		
		public boolean isSucess() {
			return sucess;
		}
		public void setSucecess(boolean sucess) {
			this.sucess = sucess;
		}
		public String[] errorCodes() {
			return errorCodes;
		}
		public String[] getErrorCodes() {
			return errorCodes;
		}
		public void setErrorCodes(String [] errorCodes) {
			this.errorCodes = errorCodes;
		}
	}

}
