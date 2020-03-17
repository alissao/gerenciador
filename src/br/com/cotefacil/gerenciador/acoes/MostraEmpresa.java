package br.com.cotefacil.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostraEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("mostrando dados da empresa");
	
		return "forward:/formAlteraEmpresa.jsp";
	}

}
