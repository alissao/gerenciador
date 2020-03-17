<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.cotefacil.gerenciador.modelos.Empresa,
			br.com.cotefacil.gerenciador.servlet.ListaEmpresasServlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Java Standard TagLib</title>
</head>
	<body>
	
		Usuario Logado: ${usuarioLogado.login }
	
	
		Lista de empresas: <br />
		
		<ul>
			<c:forEach items="${ empresas }" var="empresa">
            	<br />
            	<li>Nome Empresa: ${ empresa.nome } 
            	    Data Abertura: <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
            	</li>
            	<a href="/gerenciador/entrada?acao=mostraEmpresa&id=${empresa.id }">edita</a>
                <a href="/gerenciador/entrada?acao=removeEmpresa&id=${empresa.id }">remove</a>
        	</c:forEach>
		</ul>
		
		<ul>
			<%
				List<Empresa> lista = (List<Empresa>) request.getAttribute("empresas");
				for (Empresa empresa : lista) {
			%>
				<li><%= empresa.getNome() %></li>
			<%
				}
			%>
		</ul>
	</html>
</body>