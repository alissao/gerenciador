package br.com.cotefacil.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cotefacil.gerenciador.modelos.Banco;
import br.com.cotefacil.gerenciador.modelos.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
//@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovaEmpresaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	System.out.println("Cadastrando nova empresa");

        String nomeEmpresa = req.getParameter("nome");
        String paramDataEmpresa = req.getParameter("data");
        
        Date dataAbertura = null;
        try {
        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
        
        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);
        
        Banco banco = new Banco();
        banco.adiciona(empresa);
        
        resp.sendRedirect("listaEmpresas");
        
//        //chama o jps
//        RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas");
//        req.setAttribute("nomeEmpresa", empresa.getNome());
//        rd.forward(req, resp);
        
    }

}
