<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="linkEntradaServlet"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastre sua empresa aqui</title>
</head>
<body>

	<form action="${ linkServletNovaEmpresa }" method="post">
		
		Nome: <input type="text" name="nome" value="${ empresa.nome }"/>
		Data de Abertura: <input type="text" name="data" value="${ empresa.dataAbertura }" />
		<input type="hidden" name="id" value="${empresa }">
		<input type="hidden" name="acao" value="AlteraEmpresa">
		<input type="submit"/>
		
	</form>

</body>
</html>