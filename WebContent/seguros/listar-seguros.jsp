<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import = "java.util.List, com.my.entitys.Seguro" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.10.2/css/all.css"
	integrity="sha384-rtJEYb85SiYWgfpCr0jn174XgJTn4rptSOQsMroFBPQSGLdOC5IbubP6lJ35qoM9"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Lista De Seguros</title>
</head>
<body>
<h5 class="card-header text-center bg-dark text-white">
				<a href="/seguros/afterlogin.jsp" class="text-decoration-none text-white"><i
					class="fas fa-arrow-left float-left"></i></a> LISTA DE SEGUROS
			</h5>
<table class="table table-striped table-dark">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Tipo do Seguro</th>
      <th scope="col">Preço</th>
      <th scope="col">Opções</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items ="${seguro}" var ="seguro">
  <tr>
      <th scope="row">${seguro.id_seguro}</th>
      <td>${seguro.identificacao}</td>
      <td>${seguro.valor}</td>
      <td><a class="btn btn-warning btn-sm" href="${pageContext.request.contextPath}/seguros/seguroServlet?acao=updateseguro&id=${seguro.id_seguro}">Editar</a>
  								 	<a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/seguros/seguroServlet?acao=excluirseguro&id=${seguro.id_seguro}">Excluir</a></td>
    </tr>
  </c:forEach>
    
  </tbody>
  
</table>

</body>
</html>