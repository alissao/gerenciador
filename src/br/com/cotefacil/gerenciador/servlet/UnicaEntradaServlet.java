package br.com.cotefacil.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cotefacil.gerenciador.acoes.Acao;
import br.com.cotefacil.gerenciador.acoes.AlteraEmpresa;
import br.com.cotefacil.gerenciador.acoes.ListaEmpresas;
import br.com.cotefacil.gerenciador.acoes.MostraEmpresa;
import br.com.cotefacil.gerenciador.acoes.NovaEmpresa;
import br.com.cotefacil.gerenciador.acoes.NovaEmpresaForm;
import br.com.cotefacil.gerenciador.acoes.RemoveEmpresa;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		
		String nomeDeClasse = "br.com.cotefacil.gerenciador.acoes." + paramAcao;
		
		Class classe;
		String nome = null;
		try {
			classe = Class.forName(nomeDeClasse);//carrega a classe com o nome passado por parâmetro
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		String[] tipoDeEndereco = nome.split(":");
		if (tipoDeEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views" + tipoDeEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoDeEndereco[1]);
		}

		
//		String nome = null;
//		if (paramAcao.equals("listaEmpresa")) {
//			System.out.println("listando empresas");
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);
//		}else if (paramAcao.equals("removeEmpresa")) {
//			System.out.println("removendo empresas");
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executa(request, response);
//		}else if (paramAcao.equals("mostraEmpresa")) {
//			System.out.println("mostrando dados da empresas");
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request, response);
//		}else if (paramAcao.equals("alteraEmpresa")) {
//			System.out.println("alterando empresas");
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//		}else if (paramAcao.equals("novaEmpresa")) {
//			System.out.println("criando empresas");
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);
//		}else if (paramAcao.equals("novaEmpresaForm")) {
//			System.out.println("criando empresas");
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request, response);
//		} 
		
	}

}
