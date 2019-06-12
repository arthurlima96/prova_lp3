package com.br.lp3.prova.principal;

import java.text.ParseException;

import com.br.lp3.prova.banco.CrudBD;

public class Principal {

	public static void main(String[] args) {
//		SplashScreen splash = new SplashScreen(4000);
//		splash.showSplash();
//		try {
//			Login login = new Login();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		CrudBD bd = new CrudBD();
		bd.mysqlConnect();
		bd.gerarTabelas();
		bd.closeConnection();
		
		new Home();
	}

}
