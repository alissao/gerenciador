package br.com.cotefacil.gerenciador.acoes;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cotefacil.gerenciador.modelos.Empresa;
import br.com.cotefacil.gerenciador.modelos.Banco;

public class ListaEmpresas implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();		
		
		
		request.setAttribute("empresas", lista);


		return "forward:/formAlteraEmpresa.jsp";
		
	}
	

}
